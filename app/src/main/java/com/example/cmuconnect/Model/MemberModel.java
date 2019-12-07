package com.example.cmuconnect.Model;

public interface MemberModel {

    public boolean removeMember(String user_id, String community_id);

    public boolean addMember(String user_id, String community_id);

    public boolean deleteMember(String user_id, String community_id);

}
