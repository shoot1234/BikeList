package jp.co.planaria.sample.motocatalog.forms;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jp.co.planaria.sample.motocatalog.beans.Brand;
import lombok.Data;

/**
 * 更新画面の入力内容
 */
@Data
public class MotoForm {
  // バイク番号
  private Integer motoNo;
  // バイク名
  @NotBlank
  private String motoName;
  // シート高
  @Min(0)
  @Max(1000)
  private Integer seatHeight;
  // シリンダー
  @Min(1)
  @Max(4)
  private Integer cylinder;
  // 冷却
  private String cooling;
  // 価格
  @Min(100000)
  private Integer price;
  // コメント
  private String comment;
  // ブランド
  @Valid
  private Brand brand;
  // バージョン
  private Integer version;

}
