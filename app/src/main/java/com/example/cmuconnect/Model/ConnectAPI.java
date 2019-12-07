package com.example.cmuconnect.Model;

import java.util.LinkedHashMap;

public class ConnectAPI  extends API implements UserModel, CommunityModel, MemberModel {

    @Override
    public boolean createCommunity(String community_name, String user_id, String description, boolean isDefault, boolean isPublic) {
        return false;
    }

    @Override
    public LinkedHashMap loadCommunity(String community_id) {
        return null;
    }

    @Override
    public LinkedHashMap loadMembers(String community_id) {
        return null;
    }

    @Override
    public boolean removeMember(String user_id, String community_id) {
        return false;
    }

    @Override
    public boolean addMember(String user_id, String community_id) {
        return false;
    }

    @Override
    public boolean deleteMember(String user_id, String community_id) {
        return false;
    }

    @Override
    public LinkedHashMap signUp(String user_id, String password, String first_name, String last_name, String profile_pic) {
        return null;
    }

    @Override
    public LinkedHashMap login(String user_id, String password) {
        return null;
    }
}
