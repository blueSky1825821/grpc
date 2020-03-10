package com.sky.grpc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author WangMin
 * @since 2019/12/19 7:27 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = {GrpcApplication.class})
@PropertySource(value = "classpath*:application.yml")
@ComponentScan(basePackages = { "com.sky.grpc"})
public class TestControllerTest {
    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    private static String path;

    @Before
    public void setup() {
        path = TestControllerTest.class.getResource("/").getPath();
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).dispatchOptions(true).build();
    }

    @Test
    public void queryIntentionCustomerPageInfo() throws Exception {
        String url = "/grpc";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("message", "message");
        //准备参数
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON).params(params)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();

        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("=====客户端获得反馈数据:" + result);
    }
}
