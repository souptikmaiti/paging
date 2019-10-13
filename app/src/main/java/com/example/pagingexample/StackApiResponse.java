package com.example.pagingexample;

import com.google.gson.annotations.SerializedName;

import java.util.List;



public class StackApiResponse {
    private List<Item> items;
    @SerializedName("has_more")
    private boolean hasMore;
    @SerializedName("quota_max")
    private Integer quotaMax;
    @SerializedName("quota_remaining")
    private Integer quotaRemaining;

    public List<Item> getItems() {
        return items;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public Integer getQuotaMax() {
        return quotaMax;
    }

    public Integer getQuotaRemaining() {
        return quotaRemaining;
    }
}

class Item{
    private Owner owner;
    @SerializedName("is_accepted")
    private boolean isAccepted;
    private Integer score;
    @SerializedName("last_activity_date")
    private  Long lastActivityDate;
    @SerializedName("creation_date")
    private  Long creationDate;
    @SerializedName("answer_id")
    private  Long answerId;
    @SerializedName("question_id")
    private  Long questionId;

    public Owner getOwner() {
        return owner;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public Integer getScore() {
        return score;
    }

    public Long getLastActivityDate() {
        return lastActivityDate;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public Long getQuestionId() {
        return questionId;
    }

}

class Owner{
    private Long reputation;
    @SerializedName("user_id")
    private Long userId;
    @SerializedName("user_type")
    private String userType;
    @SerializedName("profile_image")
    private String profileImage;
    @SerializedName("display_name")
    private String displayName;
    private String link;

    public Long getReputation() {
        return reputation;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserType() {
        return userType;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getLink() {
        return link;
    }
}