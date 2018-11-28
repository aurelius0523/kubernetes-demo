package com.aurelius.spring.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.aurelius.spring.exception.MockResourceException;
import com.aurelius.spring.service.body.TodoBody;

public class MockResourceUtilTest {
    @Test(expected = MockResourceException.class)
    public void givenFileDoesNotExist_ThenThrowMockResourceException() {
	MockResourceUtil.fetchMockJson("doesNotExist.json", Object.class);
    }

    @Test(expected = MockResourceException.class)
    public void givenWrongClazz_ThenThrowMockResourceException() {
	MockResourceUtil.fetchMockJson("doesNotExist.json", null);
    }

    @Test
    public void givenFileExists_ThenReturnJson() {
	// TODO find out how to create mock json in classpath folder, then use that
	// instead since getFirstTodo.json might be deleted
	TodoBody todoBody = MockResourceUtil.fetchMockJson("getFirstTodo.json", TodoBody.class);
	assertNotNull(todoBody);
	assertEquals(todoBody.getTitle(), "This is a mock todo");
    }
}
