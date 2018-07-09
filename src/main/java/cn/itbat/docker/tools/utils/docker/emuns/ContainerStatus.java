package cn.itbat.docker.tools.utils.docker.emuns;

import lombok.Getter;

/**
 *  容器的状态
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-06 下午4:30
 **/
public enum ContainerStatus {
    PAUSED("paused", "暂停"),
    CREATED("created", "创建"),
    RUNNING("running", "运行"),
    EXITED("exited", "退出"),;

    @Getter
    private String code;
    @Getter
    private String desc;

    ContainerStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
