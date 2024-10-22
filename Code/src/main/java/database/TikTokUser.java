package database;

import java.io.Serializable;

public class TikTokUser implements Serializable {
    private String username;
    private String userId;
    private String profileImage;
    private String following;
    private String followers;
    private String totalVideos;
    private String totalHeart;
    private String verified;
    private String description;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getTotalVideos() {
        return totalVideos;
    }

    public void setTotalVideos(String totalVideos) {
        this.totalVideos = totalVideos;
    }

    public String getTotalHeart() {
        return totalHeart;
    }

    public void setTotalHeart(String totalHeart) {
        this.totalHeart = totalHeart;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
