package com.price.search.howmuchisit.monitor;

import com.price.search.howmuchisit.common.dto.CommonResponse;
import com.price.search.howmuchisit.common.enums.CommonResultCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MonitorController.class)
public class MonitorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MonitorController monitorController;

    @Test
    public void testPing() throws Exception {
        String expectedResponse = "I'm Alive!";
        when(monitorController.ping()).thenReturn(CommonResponse.success(CommonResultCode.SUCCESS, expectedResponse));

        mockMvc.perform(MockMvcRequestBuilders.get("/monitor/v1/ping")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.statusCode").value(CommonResultCode.SUCCESS.getStatus()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").value(expectedResponse));
    }
}