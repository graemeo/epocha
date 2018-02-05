package epocha.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.hamcrest.Matchers.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import epocha.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class DateControllerTest
{
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getDates() throws Exception {
        // given
        // when
        // then
        mockMvc.perform(get("/dates"))
                  .andExpect(status().isOk())
                  .andExpect(jsonPath("$.dates", hasSize(3)))
                  .andExpect(jsonPath("$.dates[0].firstDate", is("11 12 2009")))
                  .andExpect(jsonPath("$.dates[0].secondDate", is("12 12 2010")))
                  .andExpect(jsonPath("$.dates[0].differencesInDays", is("366")));
                  
    }
}
