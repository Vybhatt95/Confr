package com.ex.service.test;

import com.ex.Objects.User;
import com.ex.services.UserService;
import com.ex.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by jeremy on 9/8/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    private User testUser;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        testUser = new User();
        testUser.setfirstName("Joe");
        testUser.setlastName("Schmoe");
        testUser.setEmail("jschmoe@example.com");
        testUser.setuserName("jschmoe");
        testUser.setPassWord("pass123");
        testUser.setuserId(44);

        when(userService.findOne(testUser)).thenReturn(testUser);
    }

//    @Test
//    public void returnsAGoodUser() throws Exception{
//        mockMvc.perform(get("/users/user/44"))
//        .andExpect(status().isOk())
//        .andExpect(jsonPath("$.firstName"), is(testUser.getfirstName()))
//    }
}
