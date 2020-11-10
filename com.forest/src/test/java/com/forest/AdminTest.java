package com.forest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.forest.controller.AdminController;

@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
public class AdminTest {
	@Autowired
	private MockMvc mockmvc;
	
	@InjectMocks
	private AdminController adminController;
	
	@Before
	void setUp() throws Exception{
		mockmvc= MockMvcBuilders.standaloneSetup(adminController).build();
	}
	@Test
	public void getAdminByIdtest() throws Exception
	{
		mockmvc.perform(MockMvcRequestBuilders.get("/Admin/{id}").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.adminName").exists()).andExpect(MockMvcResultMatchers.jsonPath("$.adminPassword").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty());
	}
	


}
