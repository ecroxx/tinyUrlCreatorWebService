package com.testRestWebService.testrestfulwebservice.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class HomePageTest {
    HomePage homePage;
    @Before
    public void setUp(){
        homePage = new HomePage();
    }

    @Test
    public void getId() throws Exception {
        Long idValue = 4L;

        homePage.setId(idValue);

        assertEquals(idValue, homePage.getId());
    }

}
