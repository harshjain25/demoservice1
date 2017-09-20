package com.demo.cicdpipeline.demoservice1.service;

import org.hamcrest.core.AnyOf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DemoServiceTest {

    @InjectMocks
    private DemoService demoService;

    @Test
    public void testShouldGenerateRandomFiveDigitAccNo(){

        int actualAccountNo = demoService.getNewAccountNo();
        assertThat(demoService.getNewAccountNo(), is(not(nullValue())));
        assertThat(String.valueOf(actualAccountNo).length(), is(5));
        assertThat(String.valueOf(actualAccountNo).charAt(0)+"",
                is(AnyOf.anyOf(is("1"), is("2"))));
    }

}
