package by.IvkoS.web.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component("reCaptchaFilter")
@PropertySource("classpath:reCAPTCHA.properties")
public class ReCaptchaFilter extends UsernamePasswordAuthenticationFilter {

    public static final Logger logger = LoggerFactory.getLogger(ReCaptchaFilter.class);

    @Value("${google.recaptcha.key.secret}")
    private String secretKey;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (getUsernameParameter() == null) {
            //throw new RecaptchaAuthenticationException(singletonList(MISSING_USERNAME_REQUEST_PARAMETER));
        }
        Map parameterMap = request.getParameterMap();
        String recaptchaResponse = request.getParameter("g-recaptcha-response");

        return super.attemptAuthentication(request, response);
    }

    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler successHandler) {
        AuthenticationSuccessHandler customSuccessHandler = new ForwardAuthenticationSuccessHandler("/home");
        super.setAuthenticationSuccessHandler(customSuccessHandler);
    }
}
