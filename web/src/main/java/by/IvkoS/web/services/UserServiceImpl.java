package by.IvkoS.web.services;

import by.IvkoS.db.entity.clients.Client;
import by.IvkoS.db.entity.clients.security.UserProfile;
import by.IvkoS.db.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service("customUserDetailsService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Client client = userService.findClientByLogin(login);

        if (client == Client.EMPTY_CLIENT) {
            logger.info(String.format("User not found with login: %s", login));
            throw new UsernameNotFoundException("Username not found");
        }

        return new org.springframework.security.core.userdetails.User(client.getLogin(),client.getPassword(),
                true, true, true, true, getGrantedAuthorities(client));
    }

    private List<GrantedAuthority> getGrantedAuthorities(Client client){
        List<GrantedAuthority> authorities = new ArrayList<>();
        Set<UserProfile> userProfiles = client.getUserProfiles();
        for(UserProfile userProfile : userProfiles){
            logger.info(userProfile.getType());
            authorities.add(new SimpleGrantedAuthority(userProfile.getType()));
        }
        logger.info(authorities.toString());
        return authorities;
    }
}
