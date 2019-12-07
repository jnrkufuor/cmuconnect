package com.example.cmuconnect.entities;

public class Community {

    private String community_name;
    private String user_id;
    private String description;
    private boolean isDefault;
    private boolean isPublic;

    public Community(String community_name, String user_id, String description, boolean isDefault, boolean isPublic)
    {
        this.community_name = community_name;
        this.user_id = user_id;
        this.description = description;
        this.isDefault = isDefault;
        this.isPublic = isPublic;
    }

    public String getCommunity_name() {
        return community_name;
    }

    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
