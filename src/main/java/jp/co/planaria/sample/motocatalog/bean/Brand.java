package jp.co.planaria.sample.motocatalog.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * バイクメーカー(ブランド)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

  //ブランドID
  private String brandId;
  //ブランド名
  private String brandName;
  
}
