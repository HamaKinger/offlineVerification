package org.freedom.verification.management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.freedom.verification.po.UserPO;

/**
 * @description: 用户
 * @author: freedom
 * @date: 2025/5/8
 */
@Mapper
public interface UserMapper extends BaseMapper<UserPO> {
}
