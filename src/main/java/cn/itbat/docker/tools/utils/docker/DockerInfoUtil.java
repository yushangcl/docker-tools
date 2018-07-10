package cn.itbat.docker.tools.utils.docker;

import cn.itbat.docker.tools.utils.DockerUtils;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * docker info
 *
 * @author huahui.wu
 * @date 2018/7/6 13:42
 * @description
 */
public class DockerInfoUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(DockerInfoUtil.class);

    private static DockerClient dockerClient = DockerUtils.getDockerClient();


    public static void getDockerInfo() {
        Info info = dockerClient.infoCmd().exec();
        System.out.println(info.getSystemStatus());
    }




}
