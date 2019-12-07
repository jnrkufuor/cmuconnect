package com.example.cmuconnect.entities;

public class Post {

    private String member_id;
    private String parent_post_id;
    private String content;

    public Post(String member_id, String parent_post_id, String content)
    {
        this.member_id = member_id;
        this.parent_post_id = parent_post_id;
        this.content = content;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
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
