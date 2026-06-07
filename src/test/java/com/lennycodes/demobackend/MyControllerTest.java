package com.lennycodes.demobackend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MyControllerTest {

  @Test
  public void testHello() {
    MyController controller = new MyController();

    String result = controller.hello();

    assertEquals("Hello World!", result);
  }
}