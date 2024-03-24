package jp.co.planaria.sample.motocatalog.beans;

import jakarta.validation.constraints.NotBlank;
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

  // ブランドID
  @NotBlank
  private String brandId;
  // ブランド名
  private String brandName;

}