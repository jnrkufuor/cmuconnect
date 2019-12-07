package com.example.cmuconnect.entities;

public class Member {

    private String user_id;
    private String community_id;
    private boolean isAdmin;


    public Member(String user_id, String community_id, boolean isAdmin)
    {
        this.user_id = user_id;
        this.community_id = community_id;
        this.isAdmin = isAdmin;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = admin;
    }

    public String getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(String community_id) {
        this.community_id = community_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
