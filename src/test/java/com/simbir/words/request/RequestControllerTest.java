package com.simbir.words.request;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RequestControllerTest extends AbstractRequestControllerTest {
    @Test
    void getFirstPage() throws Exception {
        perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andDo(print());
     }
    @Test
    void getSecondPage() throws Exception {
        perform(MockMvcRequestBuilders.get("/realization"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
