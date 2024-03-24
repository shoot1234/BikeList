package jp.co.planaria.sample.motocatalog.mappers;

import org.apache.ibatis.annotations.Mapper;

import jp.co.planaria.sample.motocatalog.beans.User;

@Mapper
public interface UserMapper {
  public User selectByUsername(String username);
}
