package com.demo.cicdpipeline.demoservice1.controller;


import com.demo.cicdpipeline.demoservice1.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @RequestMapping(value = "/get/test", method = RequestMethod.GET)
    public ResponseEntity test() {

        return new ResponseEntity("{  \n" +
                "   \"status\":\"success\"\n" +
                "}", HttpStatus.OK);
    }

    @RequestMapping(value = "/generate/accountno", method = RequestMethod.GET)
    public ResponseEntity getRandomAccountNo() {

        int newAccountNo = demoService.getNewAccountNo();

        return new ResponseEntity("{  \n" +
                "   \"accountno\": " + "\""+ String.valueOf(newAccountNo) + "\"\n" +
                "}", HttpStatus.OK);
    }
}
