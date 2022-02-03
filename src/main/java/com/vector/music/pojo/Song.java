package com.vector.music.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 歌曲
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@ApiModel(value = "Song对象", description = "歌曲")
public class Song implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("0未删除 1已删除")
    private Integer isDelete;

    @ApiModelProperty("歌手id")
    private Integer singerId;

    @ApiModelProperty("歌名")
    private String name;

    @ApiModelProperty("歌曲简介")
    private String introduction;

    @ApiModelProperty("歌曲地址")
    private String url;

    @ApiModelProperty("图片")
    private String picture;

    @ApiModelProperty("歌词")
    private String lyric;

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
    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
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
        return "Song{" +
            "id=" + id +
            ", isDelete=" + isDelete +
            ", singerId=" + singerId +
            ", name=" + name +
            ", introduction=" + introduction +
            ", url=" + url +
            ", picture=" + picture +
            ", lyric=" + lyric +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
