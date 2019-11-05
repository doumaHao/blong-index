package com.xs.blong.index.web.rest;

import com.xs.blong.index.dao.ActivityInviteCodeDao;
import com.xs.blong.index.entity.ActivityInviteCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("ALL")
@Slf4j
@RestController
public class ApiController {

    @Autowired
    private ActivityInviteCodeDao activityInviteCodeDao;

    @GetMapping("/ok")
    public String ok() {
        return "ok";
    }

    @GetMapping("/testMybatisPlus")
    public void testMybatisPlus() {
        List<ActivityInviteCode> activityInviteCodeList = activityInviteCodeDao.selectList(null);
        log.info("{}", activityInviteCodeList);
    }

}
