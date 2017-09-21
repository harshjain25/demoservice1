package com.demo.cicdpipeline.demoservice1.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DemoServiceImpl implements DemoService{

    public int getNewAccountId() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 10000000 + r.nextInt(10000000));
    }
}
