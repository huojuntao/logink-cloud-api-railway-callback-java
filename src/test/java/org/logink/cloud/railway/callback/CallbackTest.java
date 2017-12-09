package org.logink.cloud.railway.callback;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.logink.cloud.railway.callback.controller.ReceiverController;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
@WebAppConfiguration
public class CallbackTest {
	
	private final static String CALLBACK_URL = "/receive";
	
	private final static String REQUEST_BODY = "{"
			+ "\"taskId\":\"4028830b5f512c68015f512f2\","
			+ "\"freightTransportStationName\":\"黄陵\","
			+ "\"dateTime\":\"2017-11-30 21:25:00\""
			+ "}";
	
	private final static String EXPECTED_CONTENT = "{"
			+ "\"resultCode\":\"200\","
			+ "\"resultMsg\":\"成功【接收回调成功】\""
			+ "}";
	
	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new ReceiverController()).build();
	}
    @Test
    public void receive() throws Exception {
    	mvc.perform(post(CALLBACK_URL)  
    	            .contentType(MediaType.APPLICATION_JSON).content(REQUEST_BODY)  
    	            .accept("application/json;charset=UTF-8")) //执行请求  
    	        .andExpect(content().contentType("application/json;charset=UTF-8")) //验证响应contentType  
    	        .andExpect(content().string(EXPECTED_CONTENT))
    	        .andExpect(status().isOk());   
    }

    @Test
    public void receive2() throws Exception {
    	mvc.perform(post("/receive2")  
    	            .contentType(MediaType.APPLICATION_JSON).content(REQUEST_BODY)  
    	            .accept("application/json;charset=UTF-8")) //执行请求  
    	        .andExpect(content().contentType("application/json;charset=UTF-8")) //验证响应contentType  
    	        .andExpect(content().string(EXPECTED_CONTENT))
    	        .andExpect(status().isOk());   
    }
}
