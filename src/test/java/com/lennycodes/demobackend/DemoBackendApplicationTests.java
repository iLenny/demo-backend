package com.lennycodes.demobackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoBackendApplicationTests {

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  void contextLoads() {
    assertNotNull(applicationContext, "Application context should not be null");
  }

  @Test
  void applicationContextContainsMainBean() {
    assertTrue(
        applicationContext.containsBean("demoBackendApplication"),
        "Application context should contain the main application bean"
    );
  }

  @Test
  void mainBeanIsCorrectType() {
    Object bean = applicationContext.getBean("demoBackendApplication");
    assertInstanceOf(DemoBackendApplication.class, bean);
  }

  @Test
  void mainMethodRunsWithoutException() {
    assertDoesNotThrow(() -> DemoBackendApplication.main(new String[]{}));
  }

  @Test
  void applicationContextHasExpectedEnvironment() {
    assertNotNull(applicationContext.getEnvironment(), "Environment should not be null");
    assertNotNull(applicationContext.getId(), "Application context ID should not be null");
  }

}
