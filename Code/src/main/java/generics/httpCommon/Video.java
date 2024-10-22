package generics.httpCommon;

import java.io.Serializable;

public class Video implements Serializable {
    private String video_id;
    private String description;
    private String create_time;

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Video{" +
                "video_id='" + video_id + '\'' +
                ", description='" + description + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
