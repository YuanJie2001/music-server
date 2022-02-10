package com.vector.music.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author YuanJie
 * @since 2022-02-03
 */
@ApiModel(value = "User对象", description = "用户")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("0未删除 1已删除")
    private Integer isDelete;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("0女 1男")
    private Integer gender;

    @ApiModelProperty("电话号码")
    private String phoneNum;

    @ApiModelProperty("电子邮件")
    private String email;

    @ApiModelProperty("生日")
    private String birth;

    @ApiModelProperty("地区")
    private String location;

    @ApiModelProperty("个性签名")
    private String introduction;

    @ApiModelProperty("头像")
    private String avator;

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
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
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
        return "User{" +
            "id=" + id +
            ", isDelete=" + isDelete +
            ", username=" + username +
            ", password=" + password +
            ", gender=" + gender +
            ", phoneNum=" + phoneNum +
            ", email=" + email +
            ", birth=" + birth +
            ", location=" + location +
            ", introduction=" + introduction +
            ", avator=" + avator +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
