package app.ravi.com.myapp.model;

import java.util.List;

/**
 * Created by root on 16/2/18.
 */

public class Feed {

    private String id;
    private String userId;
    private String userName;
    private String userProfilePicUrl;
    private String feedUrl;
    private String feedText;
    private long likeCout;
    private long commentCount;
    private long shareCount;
    private List<String> likedBy;
    private List<String> commentedBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFeedUrl() {
        return feedUrl;
    }

    public void setFeedUrl(String feedUrl) {
        this.feedUrl = feedUrl;
    }

    public String getFeedText() {
        return feedText;
    }

    public void setFeedText(String feedText) {
        this.feedText = feedText;
    }

    public long getLikeCout() {
        return likeCout;
    }

    public void setLikeCout(long likeCout) {
        this.likeCout = likeCout;
    }

    public long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }

    public String getUserProfilePicUrl() {
        return userProfilePicUrl;
    }

    public void setUserProfilePicUrl(String userProfilePicUrl) {
        this.userProfilePicUrl = userProfilePicUrl;
    }

    public long getShareCount() {
        return shareCount;
    }

    public void setShareCount(long shareCount) {
        this.shareCount = shareCount;
    }

    public List<String> getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(List<String> likedBy) {
        this.likedBy = likedBy;
    }

    public List<String> getCommentedBy() {
        return commentedBy;
    }

    public void setCommentedBy(List<String> commentedBy) {
        this.commentedBy = commentedBy;
    }
}
