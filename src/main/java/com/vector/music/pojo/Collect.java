package com.vector.music.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 收藏
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@ApiModel(value = "Collect对象", description = "收藏")
public class Collect implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("0未删除 1已删除")
    private Integer isDelete;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("收藏类型 0歌曲 1歌单")
    private Integer type;

    @ApiModelProperty("歌曲id")
    private Integer songId;

    @ApiModelProperty("歌单id")
    private Integer songListId;

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
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }
    public Integer getSongListId() {
        return songListId;
    }

    public void setSongListId(Integer songListId) {
        this.songListId = songListId;
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
        return "Collect{" +
            "id=" + id +
            ", isDelete=" + isDelete +
            ", userId=" + userId +
            ", type=" + type +
            ", songId=" + songId +
            ", songListId=" + songListId +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
