package com.kostya_ubutnu.usersapp.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "Post_table")
public class Post {

    @PrimaryKey(autoGenerate = true)
    private int postId;

    public Post(String userId, String id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getPostId() {
        return postId;
    }

    @SerializedName("userId")
    @ColumnInfo(name = "userId")
    private String userId;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private String id;

    @SerializedName("title")
    @ColumnInfo(name = "title")
    private String title;

    @SerializedName("body")
    @ColumnInfo(name = "body")
    private String body;

    public Post() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
