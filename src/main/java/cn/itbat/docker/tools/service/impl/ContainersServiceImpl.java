package cn.itbat.docker.tools.service.impl;

import cn.itbat.docker.tools.model.docker.CmContainer;
import cn.itbat.docker.tools.service.ContainersService;
import cn.itbat.docker.tools.utils.docker.ContainersUtil;
import com.github.dockerjava.api.model.Container;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-09 上午9:37
 **/
@Service
public class ContainersServiceImpl implements ContainersService {


    @Override
    public List<CmContainer> listAllContainer() {
        List<Container> containers = ContainersUtil.getContainers();

        List<CmContainer> list = new ArrayList<>();
        containers.forEach(container -> {
            CmContainer cmContainer = new CmContainer();
            BeanUtils.copyProperties(container, cmContainer);
            cmContainer.setCreated(DateFormatUtils.format(container.getCreated() * 1000, "yyyy-MM-dd HH:mm:ss"));
            list.add(cmContainer);
        });

        return list;
    }
}
