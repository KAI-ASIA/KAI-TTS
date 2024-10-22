package generics.httpCommon;

import java.io.Serializable;
import java.util.List;

public class SampleResponse1 implements Serializable {
    private String username;
    private List<Video> videos;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "SampleResponse1{" +
                "username='" + username + '\'' +
                ", videos=" + videos +
                '}';
    }
}
