package com.aurelius.spring.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.aurelius.spring.advice.GlobalExceptionAdviceTest;
import com.aurelius.spring.util.MockResourceUtilTest;

/**
 * This suite should only group test classes that has no dependency on on any
 * Spring Context and actual HTTP calls, or the like. Only mocks
 * 
 * @author kim.loong.tan
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ GlobalExceptionAdviceTest.class, MockResourceUtilTest.class })
public class MockSuite {

}
