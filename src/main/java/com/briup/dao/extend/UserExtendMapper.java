package com.briup.dao.extend;

import com.briup.bean.User;
import com.briup.bean.UserExample;
import com.briup.bean.extend.UserExtend;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserExtendMapper {
   public List<UserExtend> cascadeRoleFindAll();
   public void saveOrUpdate(UserExtend userExtends);
   public UserExtend findById(Integer id);
}