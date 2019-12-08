package com.example.cmuconnect.Model;

import com.example.cmuconnect.entities.Community;
import com.example.cmuconnect.entities.Member;
import com.example.cmuconnect.entities.Post;
import com.google.firebase.FirebaseException;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedHashMap;

public abstract class API{

    public boolean createCommunity(String community_name, String user_id, String description, boolean isDefault, boolean isPublic){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("community");
        myRef.push().setValue(new Community(community_name, user_id, description, isDefault, isPublic), new DatabaseReference.CompletionListener() {
            boolean status;
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
//                    System.out.println("Data could not be saved " + databaseError.getMessage());
                    status = false;
                } else {
//                    System.out.println("Data saved successfully.");
                    status = true;
                }
            }
        });
        return true;
    }

    public LinkedHashMap loadCommunity(String community_id) {
        return null;
    }

    public LinkedHashMap loadMembers(String community_id) {
        return null;
    }

    public boolean removeMember(String user_id, String community_id) {
        return false;
    }

    public boolean addMember(String user_id, String community_id, boolean isAdmin) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("member");
        myRef.push().setValue(new Member(user_id, community_id, isAdmin), new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    System.out.println("Data could not be saved " + databaseError.getMessage());
                } else {
                    System.out.println("Data saved successfully.");
                }
            }
        });
        return true;
    }

    public boolean deleteMember(String user_id, String community_id) {
        return false;
    }

    public LinkedHashMap signUp(String user_id, String password, String first_name, String last_name, String profile_pic) {
        return null;
    }

    public LinkedHashMap login(String user_id, String password) {
        return null;
    }

    public boolean createPost(String user_id, String community_id, String parent_post_id, String content) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("post");
        myRef.push().setValue(new Post(user_id, community_id, parent_post_id, content), new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    System.out.println("Data could not be saved " + databaseError.getMessage());
                } else {
                    System.out.println("Data saved successfully.");
                }
            }
        });
        return true;
    }

    public LinkedHashMap loadPosts(String community_id) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("post");

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                Post newPost = dataSnapshot.getValue(Post.class);
                System.out.println("User id: " + newPost.getUser_id());
                System.out.println("Community id: " + newPost.getCommunity_id());
                System.out.println("Previous Post ID: " + prevChildKey);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });

        return null;
    }

}
