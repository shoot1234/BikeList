package jp.co.planaria.sample.motocatalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.planaria.sample.motocatalog.beans.Brand;
import jp.co.planaria.sample.motocatalog.beans.Motorcycle;
import jp.co.planaria.sample.motocatalog.beans.SearchCondition;
import jp.co.planaria.sample.motocatalog.services.MotosService;
import lombok.extern.slf4j.Slf4j;

@Slf4j//ログ部品を使えるようになる
@Controller
public class MotosController {

  @Autowired
  MotosService service;

  @RequestMapping("/hello")
  //SpringBoot2系は＠RequestParamの()の省略が可能だが、3系は省略は出来ない。
  public String hello(@RequestParam(name="nameA") String nameA, Model model) {
    model.addAttribute("name", nameA);
      return "test";
  }
  
  @GetMapping("/motos")
  public String motos(Model model) {
    //ブランド
    List<Brand> brands = service.getBrands();

    //バイク
    SearchCondition condition = new SearchCondition();
    List<Motorcycle> motos = service.getMotos(condition);

    model.addAttribute("brands", brands);
    model.addAttribute("motos", motos);

    log.debug("motos: {}", motos);

    return "moto_list";
  }
  
}
