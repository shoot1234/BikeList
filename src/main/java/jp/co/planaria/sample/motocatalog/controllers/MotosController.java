package jp.co.planaria.sample.motocatalog.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.planaria.sample.motocatalog.beans.Brand;
import jp.co.planaria.sample.motocatalog.beans.Motorcycle;
import jp.co.planaria.sample.motocatalog.beans.SearchForm;
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
  /**
   * バイク一覧を検索する。
   * @param searchForm 検索条件
   * @param model Model
   * @return 遷移先
   */
  
  @GetMapping("/motos")
  //moto_list.htmlのフォームから送信される値のname属性の値と、引数のsearchFomのフィールド名でマッピングして、value属性の値やinputタグの入力欄の値を自動で代入する
  public String motos(@Validated SearchForm searchForm, BindingResult result, Model model) {
    log.info("検索条件；{}", searchForm);
    if (result.hasErrors()) {
      //入力チェックエラーがある場合
      return "moto_list";      
    }

    //ブランドリストを準備
    this.setBrands(model);

    //バイク
    List<Motorcycle> motos = service.getMotos(searchForm);
    model.addAttribute("motos", motos);
    model.addAttribute("datetime", LocalDateTime.now());

    log.debug("motos: {}", motos);

    return "moto_list";
  }

  //
  /**
   * 検索条件をクリアする。
   * motos_list.htmlのリセットボタンを押した時に入力欄を空にする為に、引数searchFormをnullにして画面に再アクセスして入力欄を空にする
   * @param searchForm 検索条件
   * @param model Model
   * @return 遷移先
   */
  @GetMapping("/motos/reset")
  public String reset(SearchForm searchForm, Model model) {
    //ブランドリストを準備
    this.setBrands(model);
    //検索条件のクリア
    searchForm = new SearchForm();
    return "moto_list";
  }

  /**
   * ブランドリストをModelにセットする。
   * @param model Model
   */
  private void setBrands(Model model) {
    //ブランド
    List<Brand> brands = service.getBrands();
    model.addAttribute("brands", brands);
  }
}
