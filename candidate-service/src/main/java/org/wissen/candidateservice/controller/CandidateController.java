package org.wissen.candidateservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/test")
    public String test() {
        System.out.println();
        return "Response from Candidate Instance : " + port;
    }

    @Value("${eureka.instance.hostname:NOT_FOUND}")
    private String hostname;

    @GetMapping("/config")
    public String config() {
//        System.out.println();
        return hostname;
    }
}
