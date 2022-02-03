CREATE DATABASE music;
use music;
CREATE TABLE `admin`
(
    `id`          int unsigned                            NOT NULL AUTO_INCREMENT,
    `is_delete`   tinyint unsigned                        NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
    `name`        varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '管理员名称',
    `password`    varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '管理员密码',
    `create_time` datetime                                         DEFAULT CURRENT_TIMESTAMP COMMENT '创建字段的时间',
    `update_time` datetime                                         DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改字段的时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='管理员';

CREATE TABLE `user`
(
    `id`           int unsigned                            NOT NULL AUTO_INCREMENT,
    `is_delete`    tinyint unsigned                        NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
    `username`     varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
    `password`     varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
    `gender`       tinyint unsigned                        NOT NULL COMMENT '0女 1男',
    `phone_num`    char(1) COLLATE utf8mb4_unicode_ci      NOT NULL COMMENT '电话号码',
    `email`        char(1) COLLATE utf8mb4_unicode_ci      NOT NULL COMMENT '电子邮件',
    `birth`        datetime                                NOT NULL COMMENT '生日',
    `location`     varchar(255) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '地区',
    `introduction` varchar(255) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '个性签名',
    `avator`       varchar(255) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '头像',
    `create_time`  datetime                                         DEFAULT CURRENT_TIMESTAMP COMMENT '创建字段的时间',
    `update_time`  datetime                                         DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改字段的时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='用户';

CREATE TABLE `song_list`
(
    `id`           int unsigned                            NOT NULL AUTO_INCREMENT,
    `is_delete`    tinyint unsigned                        NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
    `title`        varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
    `style`        varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '风格',
    `introduction` varchar(255) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '歌单简介',
    `picture`      varchar(255) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '图片',
    `create_time`  datetime                                         DEFAULT CURRENT_TIMESTAMP COMMENT '创建字段的时间',
    `update_time`  datetime                                         DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改字段的时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='歌单';

CREATE TABLE `song`
(
    `id`           int unsigned                            NOT NULL AUTO_INCREMENT,
    `is_delete`    tinyint unsigned                        NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
    `singer_id`    int unsigned                            NOT NULL COMMENT '歌手id',
    `name`         varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '歌名',
    `introduction` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '歌曲简介',
    `url`          varchar(255) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '歌曲地址',
    `picture`      varchar(255) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '图片',
    `lyric`        text COLLATE utf8mb4_unicode_ci COMMENT '歌词',
    `create_time`  datetime                                         DEFAULT CURRENT_TIMESTAMP COMMENT '创建字段的时间',
    `update_time`  datetime                                         DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改字段的时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='歌曲';

CREATE TABLE `singer`
(
    `id`           int unsigned                            NOT NULL AUTO_INCREMENT,
    `is_delete`    tinyint unsigned                        NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
    `name`         varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '歌手艺名',
    `gender`       tinyint unsigned                        NOT NULL COMMENT '0女 1男',
    `birth`        datetime                                NOT NULL COMMENT '生日',
    `location`     varchar(255) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '地区',
    `introduction` varchar(255) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '个性签名',
    `avator`       varchar(255) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '头像',
    `create_time`  datetime                                         DEFAULT CURRENT_TIMESTAMP COMMENT '创建字段的时间',
    `update_time`  datetime                                         DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改字段的时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='歌手';

CREATE TABLE `rank`
(
    `id`           int unsigned     NOT NULL AUTO_INCREMENT,
    `is_delete`    tinyint unsigned NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
    `score`        int unsigned              DEFAULT NULL COMMENT '评分',
    `song_list_id` int unsigned              DEFAULT NULL COMMENT '歌单id',
    `consumer_id`  int unsigned              DEFAULT NULL COMMENT '用户id',
    `create_time`  datetime                  DEFAULT CURRENT_TIMESTAMP COMMENT '创建字段的时间',
    `update_time`  datetime                  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改字段的时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='评价';

CREATE TABLE `list_contain_song`
(
    `id`            int unsigned     NOT NULL AUTO_INCREMENT,
    `is_delete`     tinyint unsigned NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
    `song_id`       int unsigned     NOT NULL COMMENT '歌曲id',
    `songe_list_id` int unsigned     NOT NULL COMMENT '歌单id',
    `create_time`   datetime                  DEFAULT CURRENT_TIMESTAMP COMMENT '创建字段的时间',
    `update_time`   datetime                  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改字段的时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='歌单包含的歌曲';

CREATE TABLE `collect`
(
    `id`           int unsigned     NOT NULL AUTO_INCREMENT,
    `is_delete`    tinyint unsigned NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
    `user_id`      int unsigned     NOT NULL COMMENT '用户id',
    `type`         tinyint unsigned NOT NULL COMMENT '收藏类型 0歌曲 1歌单',
    `song_id`      int unsigned              DEFAULT NULL COMMENT '歌曲id',
    `song_list_id` int unsigned              DEFAULT NULL COMMENT '歌单id',
    `create_time`  datetime                  DEFAULT CURRENT_TIMESTAMP COMMENT '创建字段的时间',
    `update_time`  datetime                  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改字段的时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='收藏';

CREATE TABLE `comment`
(
    `id`           int unsigned     NOT NULL AUTO_INCREMENT,
    `is_delete`    tinyint unsigned NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
    `user_id`      int unsigned     NOT NULL COMMENT '用户id',
    `type`         tinyint unsigned NOT NULL COMMENT '评论类型 0歌曲 1歌单',
    `song_id`      int unsigned              DEFAULT NULL COMMENT '歌曲id',
    `song_list_id` int unsigned              DEFAULT NULL COMMENT '歌单id',
    `up`           int unsigned              DEFAULT '0' COMMENT '评论点赞数',
    `create_time`  datetime                  DEFAULT CURRENT_TIMESTAMP COMMENT '创建字段的时间',
    `update_time`  datetime                  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改字段的时间',
    `content`      text COLLATE utf8mb4_unicode_ci COMMENT '评论内容',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='评论';