package jp.co.planaria.sample.motocatalog.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import jp.co.planaria.sample.motocatalog.beans.Motorcycle;
import jp.co.planaria.sample.motocatalog.beans.SearchForm;

@Mapper
public interface MotorcycleMapper {

  /**
   * バイク情報を検索条件で検索する。
   * @param condition 検索条件
   * @return バイク情報リスト
   */
  public List<Motorcycle> selectByCondition(SearchForm condition);

  /**
   * バイク情報を主キーで検索する。
   * @param motoNo バイク番号
   * @return バイク情報
   */
  public Motorcycle selectByPK(int motoNo);

  /**
   * バイク情報を更新する。
   * @param moto バイク情報
   * @return 更新件数
   */
  @Update("DELETE FROM m_motorcycle WHERE moto_no = #{motoNo} AND version = #{version}")
  public int delete(Motorcycle moto);

  /**
   * バイク情報を削除する。
   * @param moto バイク情報
   * @return 削除件数
   */
  @Delete("UPDATE m_motorcycle SET moto_name = #{motoName} , seat_height = #{seatHeight}, cylinder = #{cylinder}, cooling = #{cooling}, price = #{price}, comment = #{comment}, brand_id = #{brand.brandId}, version = version + 1, ins_dt = #{insDt}, upd_dt = #{updDt} WHERE moto_no = #{motoNo} AND version = #{version}")
  public int update(Motorcycle moto);
  
  /**
   * 新しいバイク番号を採番する。
   * @return　バイク番号
   */
  public Integer selectNewMotoNo();

  /**
   * バイク情報を登録する。
   * @param moto　バイク情報
   * @return　登録件数
   */
  public int insert(Motorcycle moto);

}
