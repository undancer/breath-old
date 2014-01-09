package com.undancer.breath.core

import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

/**
 * Created by undancer on 14-1-4.
 */
class RequestFilterTest extends GroovyTestCase {

    void testGetRequest() {
        List list = mock(List)

        when(list.add("1")).thenReturn(false).thenReturn(true)

        assertFalse(list.add("1"))
        assertTrue(list.add("1"))

    }
}
