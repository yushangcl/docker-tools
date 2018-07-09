package cn.itbat.docker.tools.utils.docker;

import cn.itbat.docker.tools.utils.DockerUtils;
import cn.itbat.docker.tools.utils.docker.emuns.ContainerStatus;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Statistics;
import com.github.dockerjava.api.model.Volume;
import com.github.dockerjava.core.async.ResultCallbackTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * docker container utils
 *
 * @author huahui.wu
 * @date 2018/7/6 13:41
 * @description
 */
public class ContainersUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContainersUtil.class);

    private static DockerClient dockerClient = DockerUtils.getDockerClient();

    public static List<Container> getContainers() {
        return dockerClient.listContainersCmd().exec();
    }


    public static List<Container> getContainers(String status) {
        return dockerClient.listContainersCmd().withStatusFilter(Collections.singletonList(status)).exec();
    }

    public static CreateContainerResponse createContainer(String imageName, String containerName) {
        return dockerClient.createContainerCmd(imageName).withName(containerName).withCmd("env").exec();
    }

    public static CreateContainerResponse createContainer(String imageName, String containerName, String volumePath) {
        Volume volume = new Volume(volumePath);
        return dockerClient.createContainerCmd(imageName).withName(containerName)
                .withCmd("true")
                .withVolumes(volume)
                .exec();
    }

    /**
     * 启动容器，返回检查信息
     *
     * @param containerId 容器id
     * @return InspectContainerResponse
     */
    public static InspectContainerResponse startContainer(String containerId) {
        dockerClient.startContainerCmd(containerId).exec();
        return dockerClient.inspectContainerCmd(containerId).exec();
    }

    /**
     * 启动容器，返回检查信息
     *
     * @param containerName 容器名称
     * @return InspectContainerResponse
     * @throws Exception
     */
    public static InspectContainerResponse startContainerByName(String containerName, ContainerStatus status) throws Exception {
        List<Container> containers = dockerClient.listContainersCmd()
                .withNameFilter(Collections.singletonList(containerName))
                .withStatusFilter(Collections.singletonList(status.getCode()))
                .exec();
        if (CollectionUtils.isEmpty(containers)) {
            throw new Exception();
        }

        if (containers.size() > 1) {
            throw new Exception();
        }

        dockerClient.startContainerCmd(containers.get(0).getId()).exec();
        return dockerClient.inspectContainerCmd(containers.get(0).getId()).exec();

    }

    /**
     * 停止容器
     *
     * @param containerId 容器id
     * @return InspectContainerResponse
     */
    public static InspectContainerResponse stopContainer(String containerId) {
        dockerClient.stopContainerCmd(containerId);
        return dockerClient.inspectContainerCmd(containerId).exec();
    }

    /**
     * 停止容器
     *
     * @param containerName 容器名称
     * @return InspectContainerResponse
     * @throws Exception
     */
    public static InspectContainerResponse stopContainerByName(String containerName) throws Exception {
        List<Container> containers = dockerClient.listContainersCmd()
                .withNameFilter(Collections.singletonList(containerName))
                .withStatusFilter(Collections.singletonList(ContainerStatus.RUNNING.getCode()))
                .exec();

        if (CollectionUtils.isEmpty(containers)) {
            throw new Exception();
        }

        if (containers.size() > 1) {
            throw new Exception();
        }

        dockerClient.stopContainerCmd(containers.get(0).getId()).exec();
        return dockerClient.inspectContainerCmd(containers.get(0).getId()).exec();
    }

    /**
     * 删除容器
     *
     * @param containerId 容器id
     */
    public static void removeContainer(String containerId) {
        dockerClient.removeContainerCmd(containerId).exec();
    }

    /**
     * 强制删除容器
     *
     * @param containerId 容器id
     */
    public static void removeContainerForce(String containerId) {
        InspectContainerResponse response = dockerClient.inspectContainerCmd(containerId).exec();
        if (ContainerStatus.RUNNING.getCode().equals(response.getState().getStatus())) {
            dockerClient.stopContainerCmd(containerId).exec();
        }
        dockerClient.removeContainerCmd(containerId).exec();
    }

    /**
     * 重启容器
     *
     * @param containerId 容器id
     * @return
     */
    public static InspectContainerResponse restartContainer(String containerId) {
        dockerClient.restartContainerCmd(containerId).exec();
        return dockerClient.inspectContainerCmd(containerId).exec();
    }

    /**
     * 重启容器
     *
     * @param containerName 容器id
     * @return
     */
    public static InspectContainerResponse restartContainerByName(String containerName) throws Exception{
        List<Container> containers = dockerClient.listContainersCmd()
                .withNameFilter(Collections.singletonList(containerName))
                .withStatusFilter(Collections.singletonList(ContainerStatus.RUNNING.getCode()))
                .exec();

        if (CollectionUtils.isEmpty(containers)) {
            throw new Exception();
        }

        if (containers.size() > 1) {
            throw new Exception();
        }
        dockerClient.restartContainerCmd(containers.get(0).getId()).exec();
        return dockerClient.inspectContainerCmd(containers.get(0).getId()).exec();
    }

    public static void getContainerStats(String containerId) {
        CountDownLatch countDownLatch = new CountDownLatch(5);


        dockerClient.statsCmd(containerId).exec(
                new ResultCallback<Statistics>() {
                    @Override
                    public void onStart(Closeable closeable) {

                    }

                    @Override
                    public void onNext(Statistics object) {

                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void close() throws IOException {

                    }
                }
        );

    }


    public static void main(String[] args) throws Exception{
//        ImagesUtil.searchImage("hello-world:latest");
//        ContainersUtil.createContainer("hello-world", "hello-world");
//        ContainersUtil.startContainerByName("mysql", ContainerStatus.EXITED);

//        ContainersUtil.stopContainerByName("mysql");

//        ContainersUtil.restartContainer("mysql");
        getContainerStats("0c7634b26b98");
    }



}
