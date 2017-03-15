package by.IvkoS.db.service;

import by.IvkoS.db.entity.clients.security.UserProfile;

import java.util.List;

public interface UserProfileService {

    List<UserProfile> getAllList();
    UserProfile findById(int id);
}
