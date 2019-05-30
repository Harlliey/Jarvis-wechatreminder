package com.practice;

import com.sun.tools.hat.internal.server.RefsByTypeQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by administer on 11/5/19.
 */
@RestController
public class hello {
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello SpringBoot!";
    }
}