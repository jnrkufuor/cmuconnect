package com.example.cmuconnect.Model;

import com.example.cmuconnect.entities.Community;

import java.util.LinkedHashMap;

public interface CommunityModel {

    public boolean createCommunity(String community_name, String user_id, String description, boolean isDefault, boolean isPublic);

    public LinkedHashMap loadCommunity(String community_id);

    public LinkedHashMap loadMembers(String community_id);

}
