package jp.co.planaria.sample.motocatalog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MotosController {

  @GetMapping("/hello")
  //SpringBoot2系は＠RequestParamの()の省略が可能だが、3系は省略は出来ない。
  public String hello(@RequestParam(name="nameA") String nameA, Model model) {
    model.addAttribute("name", nameA);
      return "test";
  }
  
  
}
