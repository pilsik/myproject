package by.IvkoS.db.service;

import by.IvkoS.db.dao.UserProfileDao;
import by.IvkoS.db.entity.clients.security.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private static final Logger logger = LoggerFactory.getLogger(UserProfileService.class);

    @Autowired
    private UserProfileDao userProfileDao;

    @Override
    public List<UserProfile> getAllList() {
        return userProfileDao.readList();
    }

    @Override
    public UserProfile findById(int id) {
        return userProfileDao.readById(id);
    }
}
