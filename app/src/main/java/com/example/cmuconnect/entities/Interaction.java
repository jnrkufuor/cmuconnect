package com.example.cmuconnect.entities;

public class Interaction {

    private String action;
    private String user_id;
    private String post_id;

    public Interaction(String action, String user_id, String post_id)
    {
        this.action = action;
        this.user_id = user_id;
        this.post_id = post_id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }
}
