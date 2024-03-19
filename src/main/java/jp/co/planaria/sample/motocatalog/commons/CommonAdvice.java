package jp.co.planaria.sample.motocatalog.commons;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * リクエストの空白文字をnullに変換する共通処理。入力欄フォームを空欄にして全件検索したい時に
 * 送信されたリクエストの空文字をnullに変換する。
 */
@ControllerAdvice
public class CommonAdvice {
  
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
  }
}
