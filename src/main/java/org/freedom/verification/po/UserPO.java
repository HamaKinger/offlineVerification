package org.freedom.verification.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("free_user")
@Data
public class UserPO extends BasicObject implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * userName
     */
    private String userName;

    /**
     * passWord
     */
    private String passWord;

    /**
     * twoAuth
     */
    private String twoAuth;

    /**
     * email
     */
    private String email;

    /**
     * address
     */
    private String address;

    /**
     * identity
     */
    private String identity;

}
