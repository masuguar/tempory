package com.masuguar.foolish.controller;

import com.masuguar.foolish.resposity.entity.UserInfo;
import com.masuguar.foolish.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class FoolishController {

    @Autowired
    private UserInfoService userInfoServiceImpl;

    @RequestMapping("/")
    @ResponseBody
    public String hi(){
        log.info("测试日志");
        log.info("abc");
        try {
            UserInfo idiot = new UserInfo();
            idiot.setName("maxiuguo");
            idiot.setCtime(new Date());
            idiot.setMtime(new Date());
            userInfoServiceImpl.insert(idiot);
            List<UserInfo> list =  userInfoServiceImpl.findAll();
            log.info("userinfos = {}",list);
        }catch (Exception e){
            log.error("occur error, ",e);
        }
        return "Hi, idiot";
    }
}
