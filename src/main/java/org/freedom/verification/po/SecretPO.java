package org.freedom.verification.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: freedom
 * @date: 2025/5/8
 */
@EqualsAndHashCode(callSuper = true)
@TableName("free_secret")
@Data
public class SecretPO extends BasicObject implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * secretKey
     */
    private String secretKey;

}
