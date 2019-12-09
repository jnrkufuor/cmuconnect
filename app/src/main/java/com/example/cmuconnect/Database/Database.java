

package com.example.cmuconnect.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cmuconnect.entities.Community;
import com.example.cmuconnect.entities.Member;
import com.example.cmuconnect.entities.Post;
import com.example.cmuconnect.entities.User;

import java.util.ArrayList;
import java.util.HashMap;


public class Database extends SQLiteOpenHelper
{
    SQLiteDatabase mydatabase;
    private static final String DB_NAME = "CMUConnect";
    private HashMap<String,Object> resultSet= new HashMap<String,Object>();

    private static final int DB_VERSION = 1;

    public Database(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query4 = "CREATE TABLE action_types ("+
        "type_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "type_name TEXT NOT NULL"+ ")";

        String query5 = "CREATE TABLE community ("+
                "c_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "community_name TEXT DEFAULT NULL,"+
                "user_id TEXT DEFAULT NULL,"+
                "description TEXT DEFAULT NULL,"+
                "isDefault TEXT DEFAULT NULL,"+
                "isPublic TEXT DEFAULT NULL)";

        String query1 = "CREATE TABLE community_members ("+
                "id INTEGER NOT NULL PRIMARY KEY  AUTOINCREMENT,"+
                "user_id TEXT NOT NULL,"+
                "c_id INTEGER NOT NULL,"+
                "isAdmin TEXT NOT NULL)";

        String query2 = "CREATE TABLE interactions ("+
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
                "action_type INTEGER NOT NULL,"+
                "user_id TEXT NOT NULL,"+
                "post_id INTEGER NOT NULL)";

        String query3 = "CREATE TABLE posts ("+
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
                "comm_member_id INTEGER DEFAULT NULL,"+
                "parent_post_id INTEGER DEFAULT NULL,"+
                "is_anonymous TEXT,"+
                "content TEXT DEFAULT NULL)";

        String query6 = "CREATE TABLE users ("+
                "user_id TEXT NOT NULL PRIMARY KEY ,"+
                "password TEXT DEFAULT NULL,"+
                "first_name TEXT DEFAULT NULL,"+
                "last_name TEXT DEFAULT NULL,"+
                "profile_pic TEXT DEFAULT NULL)";
        try
        {
            db.execSQL(query1);
            db.execSQL(query2);
            db.execSQL(query3);
            db.execSQL(query4);
            db.execSQL(query5);
            db.execSQL(query6);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        try
        {
            db.execSQL("DROP TABLE IF EXISTS users");
            db.execSQL("DROP TABLE IF EXISTS posts");
            db.execSQL("DROP TABLE IF EXISTS interactions");
            db.execSQL("DROP TABLE IF EXISTS community_members");
            db.execSQL("DROP TABLE IF EXISTS community");
            db.execSQL("DROP TABLE IF EXISTS action_types");
            onCreate(db);
        }
        catch(SQLException e)
        {

        }
    }

    public HashMap createCommunity (Community commm)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("community_name", commm.getCommunity_name());
        values.put("user_id", commm.getUser_id());
        values.put("description", commm.getDescription());
        values.put("isPublic", commm.isPublic());
        values.put("isDefault",  commm.isDefault());


        try {
            long result = db.insertOrThrow("community", null, values);
            if (result > -1)
                resultSet.put("status","true");
            else
                resultSet.put("status","false");
            return resultSet;
        }
        catch(SQLiteConstraintException e)
        {
           System.out.println(e.getMessage());
        }
        db.close();
        return null;
    }


    public HashMap signUp (User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_id", user.getUser_id());
        values.put("password", user.getPassword());
        values.put("first_name", user.getFirst_name());
        values.put("last_name", user.getLast_name());
        values.put("profile_pic",  user.getProfile_pic());


        try {
            long result = db.insertOrThrow("users", null, values);
            if (result > -1)
                resultSet.put("status","true");
            else
                resultSet.put("status","false");
            return resultSet;
        }
        catch(SQLiteConstraintException e)
        {
            System.out.println(e.getMessage());
        }
        db.close();
        return null;
    }

    String query3 = "CREATE TABLE posts ("+
            "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
            "comm_member_id INTEGER DEFAULT NULL,"+
            "parent_post_id INTEGER DEFAULT NULL,"+
            "is_anonymous TEXT,"+
            "content TEXT DEFAULT NULL)";

    public HashMap createPost (Post post)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("parent_post_id", post.getParent_post_id());
        values.put("comm_member_id", post.getMember_id());
        values.put("is_anonymous", post.getAnonimity());
        values.put("content",  post.getContent());
        try {
            long result = db.insertOrThrow("users", null, values);
            if (result > -1)
                resultSet.put("status","true");
            else
                resultSet.put("status","false");
            return resultSet;
        }
        catch(SQLiteConstraintException e)
        {
            System.out.println(e.getMessage());
        }
        db.close();
        return null;
    }

    public HashMap addMemeber (Member commm)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_id", commm.getUser_id());
        values.put("c_id", commm.getCommunity_id());
        values.put("isAdmin", commm.getIsAdmin());

        try {
            long result = db.insertOrThrow("community_members", null, values);
            if (result > -1)
                resultSet.put("status","true");
            else
                resultSet.put("status","false");
            return resultSet;
        }
        catch(SQLiteConstraintException e)
        {
            System.out.println(e.getMessage());
        }
        db.close();
        return null;
    }

    public HashMap loadCommunity(int community_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query ="SELECT * FROM community WHERE community.id = '"+community_id+ "'";
        Cursor cursor = db.rawQuery(query, null);
        ArrayList <Object[]> obj = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Object [] rows = new Object [6];
                rows[0] =cursor.getInt(cursor.getColumnIndex("c_id"));
                rows[1] =cursor.getString(cursor.getColumnIndex("description"));
                rows[2] =cursor.getString(cursor.getColumnIndex("user_id"));
                rows[3] =cursor.getString(cursor.getColumnIndex("isPublic"));
                rows[4] =cursor.getString(cursor.getColumnIndex("isDefault"));
                obj.add(rows);
            } while (cursor.moveToNext());
        }
        resultSet.put("Result",obj);
        db.close();
        return null;
    }

    public HashMap loadCommunities(String user_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query ="SELECT * FROM community,community_members WHERE community_members.user_id = '"+user_id+ "' and community_members.c_id=community.id";
        Cursor cursor = db.rawQuery(query, null);
        ArrayList <Object[]> obj = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Object [] rows = new Object [2];
                rows[0] =cursor.getInt(cursor.getColumnIndex("c_id"));
                rows[1] =cursor.getString(cursor.getColumnIndex("community_name"));
                obj.add(rows);
            } while (cursor.moveToNext());
        }
        resultSet.put("Result",obj);
        db.close();
        return resultSet;
    }

    public HashMap loadMembers(String community_id) {

        SQLiteDatabase db = this.getWritableDatabase();
        String query ="select count(*) members_count \n" +
                "from community_members cm\n" +
                "where cm.community_id ="+ community_id;
        Cursor cursor = db.rawQuery(query, null);
        ArrayList <Object[]> obj = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Object [] rows = new Object [2];
                rows[0] =cursor.getInt(cursor.getColumnIndex("members_count"));
                obj.add(rows);
            } while (cursor.moveToNext());
        }
        resultSet.put("Result",obj);
        db.close();
        return resultSet;
    }

    public int removeMember(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("community_members",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public int removePost(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("posts",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public int removeCommunity(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("community",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

//
//    public  ArrayList <Object[]>  fetchGrades(String name)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        String query ="SELECT * FROM COURSE_HAS_STUDENT,COURSE WHERE COURSE.CNAME = '"+name+ "' AND COURSE_HAS_STUDENT.CID = COURSE.ID ";
//        Cursor cursor = db.rawQuery(query, null);
//        ArrayList <Object[]> obj = new ArrayList<>();
//        if (cursor.moveToFirst()) {
//            do {
//                Object [] grades = new Object [6];
//                grades[0] =cursor.getInt(cursor.getColumnIndex("SID"));
//                grades[1] =cursor.getInt(cursor.getColumnIndex("Q1"));
//                grades[2] =cursor.getInt(cursor.getColumnIndex("Q2"));
//                grades[3] =cursor.getInt(cursor.getColumnIndex("Q3"));
//                grades[4] =cursor.getInt(cursor.getColumnIndex("Q4"));
//                grades[5] =cursor.getInt(cursor.getColumnIndex("Q5"));
//                obj.add(grades);
//            } while (cursor.moveToNext());
//        }
//        db.close();
//        return obj;
//    }
//
//    public ArrayList <String> fetchCourses()
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        String query ="SELECT * FROM COURSE";
//        Cursor cursor = db.rawQuery(query, null);
//        ArrayList <String> course = new ArrayList<String>();
//        if (cursor.moveToFirst()) {
//            do {
//                course.add(cursor.getString(cursor.getColumnIndex("CNAME")));
//            } while (cursor.moveToNext());
//        }
//        db.close();
//        return course;
//    }
}
