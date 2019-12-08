package com.example.cmuconnect.Model;

import java.util.LinkedHashMap;

public interface UserModel {

    public LinkedHashMap signUp(String user_id, String password, String first_name, String last_name, String profile_pic);

    public LinkedHashMap login(String user_id, String password);

}
