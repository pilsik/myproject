package by.IvkoS.db.dao;

import by.IvkoS.db.entity.clients.security.UserProfile;

public interface UserProfileDao extends GenericDao<UserProfile,Integer>{
    UserProfile findTypeByName(String type);
}
