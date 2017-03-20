package by.IvkoS.web.filters;

import by.IvkoS.web.validation.ValidationResult;
import by.IvkoS.web.exceptions.RecaptchaAuthenticationException;
import by.IvkoS.web.exceptions.RecaptchaValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("reCaptchaFilter")
@PropertySource("classpath:reCAPTCHA.properties")
public class ReCaptchaFilter extends UsernamePasswordAuthenticationFilter {

    public static final Logger logger = LoggerFactory.getLogger(ReCaptchaFilter.class);

    @Value("${google.recaptcha.key.secret}")
    private String secretKey;

    @Value("${google.recaptcha.URL}")
    private String reCaptchaUrl;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        if (getUsernameParameter() == null) {
            throw new RecaptchaAuthenticationException("Username empty");
        }
        String recaptchaResponse = request.getParameter("g-recaptcha-response");
        logger.info(String.format("g-recaptcha-response : %s", recaptchaResponse));
        if (!validation(recaptchaResponse, request.getRemoteAddr())) {
            throw new RecaptchaAuthenticationException(
                    String.format("Error validating reCAPTCHA \nUser: %s\nPassword: %s",
                            getUsernameParameter(), getPasswordParameter()));
        }
        return super.attemptAuthentication(request, response);
    }

    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    @Autowired
    public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler successHandler) {
        super.setAuthenticationSuccessHandler(successHandler);
    }

    @Override
    @Autowired
    public void setAuthenticationFailureHandler(AuthenticationFailureHandler failureHandler) {
        super.setAuthenticationFailureHandler(failureHandler);
    }

    private boolean validation(String userResponse, String ipAddress) {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<>();
        parameters.add("secret", this.secretKey);
        parameters.add("response", userResponse);
        parameters.add("remoteip", ipAddress);
        logger.info(String.format("ReCaptcha validation. response: %s\n remoteip %s", userResponse, ipAddress));
        try {
            ValidationResult result = restTemplate.postForEntity(reCaptchaUrl, parameters, ValidationResult.class).getBody();
            logger.info(String.format("Response from ReCaptcha\n%s", result.toString()));
            return result.isSuccess();
        } catch (RestClientException ex) {
            throw new RecaptchaValidationException(ex);
        }

    }
}
