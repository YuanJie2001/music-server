package com.vector.music.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 歌单包含的歌曲
 * </p>
 *
 * @author YuanJie
 * @since 2022-01-31
 */
@TableName("list_contain_song")
@ApiModel(value = "ListContainSong对象", description = "歌单包含的歌曲")
public class ListContainSong implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("0未删除 1已删除")
    private Integer isDelete;

    @ApiModelProperty("歌曲id")
    private Integer songId;

    @ApiModelProperty("歌单id")
    private Integer songeListId;

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
    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }
    public Integer getSongeListId() {
        return songeListId;
    }

    public void setSongeListId(Integer songeListId) {
        this.songeListId = songeListId;
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
        return "ListContainSong{" +
            "id=" + id +
            ", isDelete=" + isDelete +
            ", songId=" + songId +
            ", songeListId=" + songeListId +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
