package jp.co.planaria.sample.motocatalog.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import jp.co.planaria.sample.motocatalog.beans.Motorcycle;
import jp.co.planaria.sample.motocatalog.beans.SearchCondition;

@SpringBootTest
public class MotosServiceTest {

  //処理の時間差でassertFailになる為、分までを確認
  DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
  
  @Autowired
  MotosService service;

//   @Test
//   void バイク情報を全件検索できる() {
//     SearchCondition condition =  new SearchCondition();
//     List<Motorcycle> motos = service.getMotos(condition);
//     //検索結果の件数確認
//     assertThat(motos.size()).isEqualTo(2);
//     //検索結果の各項目の確認
//     Motorcycle moto = motos.get(0);
//     assertThat(moto.getMotoNo()).isEqualTo(1);
//     assertThat(moto.getMotoName()).isEqualTo("GB350");
//     assertThat(moto.getPrice()).isEqualTo(550000);
//     assertThat(moto.getBrand().getBrandName()).isEqualTo("Honda");
//   }

  @DisplayName("バイク一覧取得 条件： ブランドID")
  @ParameterizedTest //テストメソッドに引数を与えてテストしたい時に付けるアノテーション
  @CsvSource({"01, Honda", "02, Kawasaki", "03, Yamaha"})//""で囲われた値がメソッドの引数として渡されて、この例では3回テストメソッドが実行されるアノテーション
  void test001(String brandId, String brandName) {
      SearchCondition condition = new SearchCondition();
      condition.setBrandId(brandId);

      List<Motorcycle> motos = service.getMotos(condition);//テスト対象
      //本来は「Assertions.assertThat()」と書くが、import static でAssertions.assertThatメソッドを静的インポートしているので、「Assertions.」を省略して書ける
      assertThat(motos.size()).isGreaterThanOrEqualTo(1);//1以上
      //assertThat(motos.size()).isGreaterThan(0);0より大きい　↑と同じ意味
      for (Motorcycle moto : motos) {
        Assertions.assertThat(moto.getBrand().getBrandName()).isEqualTo(brandName);
      }
    }

  @DisplayName("バイク一覧取得 条件： ブランドID 該当なし")
  @Test
  void test002() {
    SearchCondition condition = new SearchCondition();
    condition.setBrandId("99");

    List<Motorcycle> motos = service.getMotos(condition);//テスト対象
    Assertions.assertThat(motos.size()).isEqualTo(0);//該当なしなので0件
  }

  @DisplayName("バイク一覧取得 条件： バイク名-完全一致")
  @ParameterizedTest
  @CsvSource({"GB350", "Z900RS CAFE", "W800 CAFE"})
  void test003(String motoName) {
      SearchCondition condition = new SearchCondition();
      condition.setKeyword(motoName);

      List<Motorcycle> motos = service.getMotos(condition);//テスト対象
      assertThat(motos.size()).isGreaterThanOrEqualTo(1);//1以上
      for (Motorcycle moto : motos) {
        Assertions.assertThat(moto.getMotoName()).isEqualTo(motoName);
      }
    }

  //バイク一覧取得  条件：  バイク名-前方一致
  //バイク一覧取得　条件：  バイク名-後方一致
  //バイク一覧取得  条件：　バイク名-部分一致
    @DisplayName("バイク一覧取得 条件：バイク名-部分一致")
    @ParameterizedTest
    @CsvSource({"GB35, GB350", "900RS CAFE, Z900RS CAFE", "0 CAF, W800 CAFE"})
    void test004(String keyword, String motoName) {
      SearchCondition condition = new SearchCondition();
      condition.setKeyword(keyword);

      List<Motorcycle> motos = service.getMotos(condition);//テスト対象
      Assertions.assertThat(motos.size()).isGreaterThanOrEqualTo(1);//1以上
      for (Motorcycle moto : motos) {
        Assertions.assertThat(moto.getMotoName()).isEqualTo(motoName);
      }
    }
  
    @DisplayName("バイク一覧取得 条件：バイク名 該当なし")
    @Test
    void test005() {
      SearchCondition condition = new SearchCondition();
      condition.setKeyword("存在しないバイク名");

      List<Motorcycle> motos = service.getMotos(condition);//テスト対象
      assertThat(motos.size()).isEqualTo(0);
    }

  @DisplayName("バイク一覧取得 条件： ブランドID, バイク名")
  @ParameterizedTest
  @CsvSource({"02, Z900, Z900RS", "03, R1, YZF-R1", "01, bel, Rebel"})
  void test006(String brandId, String keyword, String motoName) {
    SearchCondition condition = new SearchCondition();
    condition.setBrandId(brandId);
    condition.setKeyword(keyword);

    List<Motorcycle> motos = service.getMotos(condition);//テスト対象
    Assertions.assertThat(motos.size()).isGreaterThanOrEqualTo(1);//1以上
    for (Motorcycle moto : motos) {
      Assertions.assertThat(moto.getMotoName()).startsWith(motoName);//バイク名を前方一致で比較(Z900RSとZ900RS CAFEの2つのmotoインスタンスが取得される為)
    }
  }


  @DisplayName("バイク一覧取得 条件： ブランドID, バイク名 該当なし")
  @ParameterizedTest
  @CsvSource({"03, Z900", "03, aaYZF-R1"})
  void test007(String brandId, String keyword) {
    SearchCondition condition = new SearchCondition();
    condition.setBrandId(brandId);
    condition.setKeyword(keyword);

    List<Motorcycle> motos = service.getMotos(condition);//テスト対象
    Assertions.assertThat(motos.size()).isEqualTo(0);
  }

  @DisplayName("バイク一覧取得 条件： なし 全検該当")
  @Test
  void test008() {
    SearchCondition condition = new SearchCondition();

    List<Motorcycle> motos = service.getMotos(condition);//テスト対象
    Assertions.assertThat(motos.size()).isEqualTo(9);
  }

  @DisplayName("バイク情報取得 条件： バイク番号")
  @ParameterizedTest
  @CsvSource({"1, GB350", "3, W800 CAFE"})
  void test009(int motoNo, String motoName) {
    Motorcycle moto = service.getMotos(motoNo);//テスト対象
    assertThat(moto.getMotoName()).isEqualTo(motoName);
  }

  @DisplayName("バイク情報取得 条件： バイク番号 全項目確認")
  @Test
  void test010() {
    Motorcycle moto = service.getMotos(1);//テスト対象
    assertThat(moto.getMotoNo()).isEqualTo(1);
    assertThat(moto.getMotoName()).isEqualTo("GB350");
    assertThat(moto.getSeatHeight()).isEqualTo(800);
    assertThat(moto.getCylinder()).isEqualTo(1);
    assertThat(moto.getCooling()).isEqualTo("空冷");
    assertThat(moto.getPrice()).isEqualTo(550000);
    assertThat(moto.getComment()).isEqualTo("エンジンのトコトコ音がいい。");
    assertThat(moto.getBrand().getBrandId()).isEqualTo("01");
    assertThat(moto.getVersion()).isEqualTo(1);
    assertThat(moto.getInsDt().format(dtFormatter)).isEqualTo(LocalDateTime.now().format(dtFormatter));
    assertThat(moto.getUpdDt()).isNull();
  }
  

  @DisplayName("バイク情報更新")
  @Test
  @Transactional
  @Rollback
  void test011() {
    Motorcycle before = service.getMotos(1);
    before.setMotoName("motomoto");

    service.save(before);//更新（保存）

    Motorcycle after = service.getMotos(1);//変更後のバイク情報取得
    assertThat(after.getMotoName()).isEqualTo("motomoto");
    assertThat(after.getVersion()).isEqualTo(before.getVersion() + 1);    
  }
}