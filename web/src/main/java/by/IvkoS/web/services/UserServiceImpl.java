package by.IvkoS.web.services;

import by.IvkoS.web.controller.MainController;
import com.sun.javafx.binding.StringFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailsService")
public class UserServiceImpl implements UserDetailsService {

    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
        // User user = userService.findBySso(ssoId);
       /* System.out.println("User : "+user);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }*/
       /* return new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getPassword(),
                user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));*/

        if (!ssoId.equals("admin")) {
            logger.info(String.format("User not found with login: %s", ssoId));
            throw new UsernameNotFoundException("Username not found");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new org.springframework.security.core.userdetails.User("admin", "$2a$06$XfeV999gbJ3Y2LfX5IbWwuW1MV0hxj6/IRBBPyeWCMsN8flyjbfOK",
                true, true, true, true, authorities);
    }

   /* private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(UserProfile userProfile : user.getUserProfiles()){
            System.out.println("UserProfile : "+userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }*/
}
