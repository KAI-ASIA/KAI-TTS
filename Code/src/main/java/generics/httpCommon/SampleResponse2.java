package generics.httpCommon;

public class SampleResponse2 {
    private String username;
    private String profile_image;
    private String following;
    private String followers;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
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

    @Override
    public String toString() {
        return "SampleResponse2{" +
                "username='" + username + '\'' +
                ", profile_image='" + profile_image + '\'' +
                ", following='" + following + '\'' +
                ", followers='" + followers + '\'' +
                '}';
    }
}
