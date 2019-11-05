package com.xs.blong.index.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xs.blong.index.entity.ActivityInviteCode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActivityInviteCodeDao extends BaseMapper<ActivityInviteCode> {

    /**
     * 获取一个手机号为空的记录
     * @return
     */
    ActivityInviteCode get1stWhenPhoneNull();

}
