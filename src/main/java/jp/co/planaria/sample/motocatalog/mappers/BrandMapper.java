package jp.co.planaria.sample.motocatalog.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.planaria.sample.motocatalog.beans.Brand;

@Mapper
public interface BrandMapper {
  public List<Brand> selectAll();
}
