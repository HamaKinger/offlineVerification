package org.freedom.verification.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.freedom.verification.po.BasicObject;

import java.io.Serializable;

/**
 * @description:
 * @author: freedom
 * @date: 2025/5/8
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserVO extends BasicObject implements Serializable {
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
