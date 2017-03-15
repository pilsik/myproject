package by.IvkoS.web.convertor;

import by.IvkoS.db.entity.clients.security.UserProfile;
import by.IvkoS.db.service.UserProfileService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile> {

    @Autowired
    UserProfileService userProfileService;

    @Override
    public UserProfile convert(Object o) {
        Integer id = Integer.parseInt((String) o);
        UserProfile profile = userProfileService.findById(id);
        System.out.println("Profile : " + profile);
        return profile;
    }
}
