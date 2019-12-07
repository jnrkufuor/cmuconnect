package com.example.cmuconnect.Model;

import com.example.cmuconnect.entities.Post;

import java.util.LinkedHashMap;

public interface PostModel {

    public boolean createPost(String member_id, String parent_post_id, String content);

}
