package cn.itbat.docker.tools.service;

import cn.itbat.docker.tools.model.docker.CmContainer;

import java.util.List;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-09 上午9:37
 **/
public interface ContainersService {
    List<CmContainer> listAllContainer();
}
