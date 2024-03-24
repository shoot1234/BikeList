package jp.co.planaria.sample.motocatalog.forms;

import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 検索条件
 */
@Data
public class SearchForm {
  
  //ブランドID
  private String brandId;
  //キーワード
  @Size(min = 2, max = 10)
  private String keyword;

}
