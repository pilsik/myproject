package by.IvkoS.db.entity.clients.security;

public enum UserProfileType {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    String userProfileType;

    private UserProfileType(String userProfileType){
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType(){
        return userProfileType;
    }
}
