package com.xs.blong.index.web.rest;

import com.xs.blong.index.dao.ActivityInviteCodeDao;
import com.xs.blong.index.resp.BaseResp;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

@SuppressWarnings("ALL")
@Slf4j
@RestController
public class ApiController {

    private static String POINT = "\\.";

    @Autowired
    private ActivityInviteCodeDao activityInviteCodeDao;

    @Autowired
    private ApplicationContext applicationContext;

    @ApiOperation(value = "健康检查", notes = "健康检查")
    @ApiResponse(code = 1002, response = String.class, message = "返回ok表示正常")
    @GetMapping("/ok")
    public String ok() {
        return "ok";
    }

    @ResponseBody
    @PostMapping("/invoke")
    public Object invoke(@RequestParam("api") String api, @RequestParam("param") String param) {

        if (StringUtils.isEmpty(api) || StringUtils.isEmpty(param)) {
            log.info("入参为空");
            return BaseResp.fastFail();
        }

        String[] apis = api.split(POINT);
        if (apis.length != 2) {
            log.info("入参为空");
            return BaseResp.fastFail();
        }
        String apiName = apis[0];
        String apiMethod = apis[1];

        Object bean = applicationContext.getBean(apiName);

        Object resp = "";

        try {
            Method method = bean.getClass().getDeclaredMethod(apiMethod, String.class);
            resp = method.invoke(bean, param);
        } catch (Exception e) {
            log.info("api反射调用异常,api={}", api);
            return BaseResp.fastFail();
        }

        return resp;

    }

}
