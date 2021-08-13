# 用户授权表
create table meme.user_auth
(
    id char(32) not null
        primary key,
    user_id char(32) default '' not null comment '用户id',
    identify_type tinyint unsigned not null comment '唯一标识类型（1手机号，2邮箱，3用户名，4微信）',
    identify varchar(64) default '' not null comment '唯一标识',
    credential varchar(128) default '' not null comment '凭证',
    is_third_party tinyint unsigned not null comment '是否是第三方凭证',
    create_time timestamp default CURRENT_TIMESTAMP not null,
    update_time timestamp default CURRENT_TIMESTAMP not null,
    is_delete tinyint unsigned default 0 not null,
    constraint uk_identify
        unique (identify)
)
    comment '用户授权';

create index idx_user_id
    on meme.user_auth (user_id);

