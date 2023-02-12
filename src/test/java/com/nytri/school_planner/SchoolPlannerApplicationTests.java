package com.nytri.school_planner;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SchoolPlannerApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class SchoolPlannerApplicationTests {

    @Value(value = "${local.server.port}")
    private int port;

}
