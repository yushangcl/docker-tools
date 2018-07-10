package cn.itbat.docker.tools.utils.docker.emuns;


import jdk.nashorn.internal.objects.annotations.Getter;

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

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    ContainerStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
