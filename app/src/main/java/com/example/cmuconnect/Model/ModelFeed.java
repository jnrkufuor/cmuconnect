package com.example.cmuconnect.Model;

public class ModelFeed {

    private int pid,cid, proPic, statusPic, likes, comments, upvotes;
    private String name;
    private String status;
    private String timestamp;
    private String community;


    public ModelFeed(int pid, int cid, int proPic, int statusPic, int likes, int comments, int upvotes, String name, String status, String timestamp, String community) {
        this.pid = pid;
        this.cid = cid;
        this.proPic = proPic;
        this.statusPic = statusPic;
        this.likes = likes;
        this.comments = comments;
        this.upvotes = upvotes;
        this.name = name;
        this.status = status;
        this.timestamp = timestamp;
        this.community = community;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getProPic() {
        return proPic;
    }

    public void setProPic(int proPic) {
        this.proPic = proPic;
    }

    public int getStatusPic() {
        return statusPic;
    }

    public void setStatusPic(int statusPic) {
        this.statusPic = statusPic;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }
}
