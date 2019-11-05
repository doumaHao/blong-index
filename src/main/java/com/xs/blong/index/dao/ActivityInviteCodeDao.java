package com.xs.blong.index.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xs.blong.index.entity.ActivityInviteCode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityInviteCodeDao extends BaseMapper<ActivityInviteCode> {

    List<ActivityInviteCode> get1stWhenPhoneNull();

}
