package com.demo.cicdpipeline.demoservice1.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public interface DemoService {

    int getNewAccountId();
}
