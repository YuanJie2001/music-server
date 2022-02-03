package com.vector.music.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 管理员
 * </p>
 *
 * @author YuanJie
 * @since 2022-01-31
 */
@ApiModel(value = "Admin对象", description = "管理员")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("0未删除 1已删除")
    private Byte isDelete;

    @ApiModelProperty("管理员名称")
    private String name;

    @ApiModelProperty("管理员密码")
    private String password;

    @ApiModelProperty("创建字段的时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改字段的时间")
    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Admin{" +
            "id=" + id +
            ", isDelete=" + isDelete +
            ", name=" + name +
            ", password=" + password +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
