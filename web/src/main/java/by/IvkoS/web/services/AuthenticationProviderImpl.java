package by.IvkoS.web.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("provider")
public class AuthenticationProviderImpl implements AuthenticationProvider {

    static private final Logger logger = (Logger) LoggerFactory.getLogger(AuthenticationProviderImpl.class);


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(login.equals("admin") && password.equals("$2a$06$XfeV999gbJ3Y2LfX5IbWwuW1MV0hxj6/IRBBPyeWCMsN8flyjbfOK")){
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            logger.info("AUTHENTICATION");
            return new UsernamePasswordAuthenticationToken(login, password, authorities);
        }else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
