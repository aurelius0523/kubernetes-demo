package com.aurelius.spring.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.aurelius.spring.app.SpringApiApplicationTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({ SpringApiApplicationTests.class })
public class SpringSuite {

}