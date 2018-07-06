package cn.itbat.docker.tools.utils;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.ListImagesCmd;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.api.model.Service;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonList;

/**
 * @author huahui.wu
 * @date 2018/7/6 10:51
 * @description
 */
public class DockerUtils {
    private static DockerClient dockerClient;

    DockerUtils() {
    }

    public static DockerClient getDockerClient() {
        if (dockerClient == null) {
            synchronized (DockerUtils.class) {
                if (dockerClient == null) {
                    dockerClient = DockerClientBuilder.getInstance().build();
                }
            }
        }
        return dockerClient;
    }
}
