package com.example.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

  @GetMapping("/filtering")
  public SomeBean retrieveSomeBean() {
    return new SomeBean("value 1", "value 2", "value 3");
  }

  @GetMapping("/filtering-list")
  public List<SomeBean> retrieveListOfSomeBeans() {
    return Arrays.asList(new SomeBean("value 1", "value 2", "value 3"),
        new SomeBean("value 4", "value 5", "value 6"));
  }
}
