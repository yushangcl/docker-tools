package cn.itbat.docker.tools.controller;

import cn.itbat.docker.tools.model.docker.CmContainer;
import cn.itbat.docker.tools.service.ContainersService;
import cn.itbat.docker.tools.utils.AbsResponse;
import com.github.dockerjava.api.model.Container;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-10 上午11:38
 **/

@RestController
@RequestMapping("/docker")
public class DockerController {

    @Resource
    private ContainersService containersService;

    @RequestMapping(value = "/listContainers" )
    public AbsResponse getAllContainers() {
        AbsResponse<List<CmContainer>> absResponse = new AbsResponse<>();
        absResponse.setData(containersService.listAllContainer());
        return absResponse;
    }


}
