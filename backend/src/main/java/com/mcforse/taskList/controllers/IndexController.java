package com.mcforse.taskList.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {
    // Forwards all routes to FrontEnd except: '/', '/index.html', '/api', '/api/**'
    // Required because of 'mode: history' usage in frontend routing
    @RequestMapping("{?:(?:(?!api|static|\\.).)*}/**")
    public String redirect() {
        log.info("URL entered directly into the Browser, so we need to redirect...");
        return "forward:/";
    }
}
