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

    public static void main(String[] args) {
        DockerClient dockerClient = DockerClientBuilder.getInstance().build();
//        Info info = dockerClient.infoCmd().exec();
//        System.out.println(info);

        List<Image> images = dockerClient.listImagesCmd().exec();
        images.forEach(System.out::println);

//        List<Container> containers = dockerClient.listContainersCmd().exec();
//
//        containers.forEach(System.out::println);


        List<Container> containers = dockerClient.listContainersCmd().withStatusFilter(singletonList("exited")).exec();
        containers.forEach(System.out::println);
    }

}
