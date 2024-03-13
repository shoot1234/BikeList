package jp.co.planaria.sample.motocatalog.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.planaria.sample.motocatalog.bean.Brand;
import jp.co.planaria.sample.motocatalog.bean.Motorcycle;
import lombok.extern.slf4j.Slf4j;

@Slf4j//ログ部品を使えるようになる
@Controller
public class MotosController {

  @RequestMapping("/hello")
  //SpringBoot2系は＠RequestParamの()の省略が可能だが、3系は省略は出来ない。
  public String hello(@RequestParam(name="nameA") String nameA, Model model) {
    model.addAttribute("name", nameA);
      return "test";
  }
  
  @GetMapping("/motos")
  public String motos(Model model) {
    //ブランド
    List<Brand> brands = new ArrayList<>();
    brands.add(new Brand("01","HONDA"));
    brands.add(new Brand("02", "KAWASAKI"));

    //バイク
    List<Motorcycle> motos = new ArrayList<>();
    motos.add(new Motorcycle(1, "GB350", 800, 1, "空冷", 500000, "いい音", new Brand("01", "HONDA"), 1, null, null));
    motos.add(new Motorcycle(2, "Ninja", 800, 2, "水冷", 1000000, "すいすい", new Brand("02", "KAWASAKI"), 1, null, null));

    model.addAttribute("brands", brands);
    model.addAttribute("motos", motos);

    log.debug("motos: {}", motos);

    return "moto_list";
  }
  
}
