package jp.co.planaria.sample.motocatalog.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.planaria.sample.motocatalog.beans.Motorcycle;

@SpringBootTest
public class MotosServiceTest {
  
  @Autowired
  MotosService service;

  @Test
  void バイク情報を全件検索できる() {
    List<Motorcycle> motos = service.getMotos();
    //検索結果の件数確認
    assertThat(motos.size()).isEqualTo(2);
    //検索結果の各項目の確認
    Motorcycle moto = motos.get(0);
    assertThat(moto.getMotoNo()).isEqualTo(1);
    assertThat(moto.getMotoName()).isEqualTo("GB350");
    assertThat(moto.getPrice()).isEqualTo(550000);
    assertThat(moto.getBrand().getBrandName()).isEqualTo("Honda");
  }
}
