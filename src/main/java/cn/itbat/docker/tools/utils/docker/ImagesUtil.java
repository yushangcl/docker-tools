package cn.itbat.docker.tools.utils.docker;

import cn.itbat.docker.tools.utils.DockerUtils;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;
import org.glassfish.hk2.utilities.PerThreadScopeModule;

import java.util.Collection;
import java.util.List;

/**
 * docker images utils
 *
 * @author huahui.wu
 * @date 2018/7/6 13:40
 * @description
 */
public class ImagesUtil {
    DockerClient dockerClient = DockerUtils.getDockerClient();

    public List<Image> getImages() {
       return dockerClient.listImagesCmd().exec();
    }

    public List<Image> getImages(String imageName) {
        return  dockerClient.listImagesCmd().withImageNameFilter(imageName).exec();
    }






}
