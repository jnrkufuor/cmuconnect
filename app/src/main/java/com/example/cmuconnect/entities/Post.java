package com.example.cmuconnect.entities;

public class Post {

    private String member_id;
    private String user_id;
    private String community_id;
    private String parent_post_id;
    private String content;

    public Post(String user_id, String community_id, String parent_post_id, String content)
    {
        this.user_id = user_id;
        this.community_id = community_id;
        this.parent_post_id = parent_post_id;
        this.content = content;
    }

    public Post()
    {

    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(String community_id) {
        this.community_id = community_id;
    }

    public String getParent_post_id() {
        return parent_post_id;
    }

    public void setParent_post_id(String parent_post_id) {
        this.parent_post_id = parent_post_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
