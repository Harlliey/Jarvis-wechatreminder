package com.practice.web;

import com.practice.entity.UserInfo;
import com.practice.utils.JSONChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by administer on 28/5/19.
 */
@RestController
public class LoginController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public Map<String, Object> userLogin(String code) {
        Map<String, Object> modelMap = new HashMap<>();
        String uri = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={code}&grant_type={grant_type}";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("appid", "wxe1cda1fd308919d4");
        paramMap.put("secret", "440c809060138792717bbec252f45b25");
        paramMap.put("code", code);
        paramMap.put("grant_type", "authorization_code");
        String json = restTemplate.getForObject(uri, String.class, paramMap);
        UserInfo userInfo = (UserInfo) JSONChange.jsonToObj(new UserInfo(), json);
        if (userInfo != null) {
            String openId = userInfo.getOpenid();
            modelMap.put("openId", openId);
        } else {
            modelMap.put("success", "no user info!");
        }
        return modelMap;
    }
}
