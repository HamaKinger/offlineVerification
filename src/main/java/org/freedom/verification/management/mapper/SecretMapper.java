package org.freedom.verification.management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.freedom.verification.po.SecretPO;

/**
 * @description: 签名密钥
 * @version: 1.0
 * @author: freedom
 * @date: 2025/5/10
 */
@Mapper
public interface SecretMapper extends BaseMapper<SecretPO> {
}
