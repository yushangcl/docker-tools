package cn.itbat.docker.tools.model.docker;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dockerjava.api.model.ContainerPort;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-10 下午2:29
 **/
public class CmContainer implements Serializable {

    private String created;

    private String id;

    private String image;

    private String imageId;

    private String[] names;

    private String status;

    private String state;

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CmContainer{" +
                "created=" + created +
                ", id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", imageId='" + imageId + '\'' +
                ", names=" + Arrays.toString(names) +
                ", status='" + status + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
