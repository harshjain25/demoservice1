package com.demo.cicdpipeline.demoservice1.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DemoService {


    public int getNewAccountNo() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }
}
