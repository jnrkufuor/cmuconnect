package com.example.cmuconnect.Model;

import com.example.cmuconnect.entities.Post;

import java.util.LinkedHashMap;

public interface PostModel {

    public boolean createPost(String user_id, String community_id, String parent_post_id, String content);

    public LinkedHashMap loadPosts(String community_id);

}
