package org.freedom.verification.po;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: freedom
 * @date: 2025/5/8
 */
@Data
public class BasicObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer state;

    public void setId(String id){
        this.id = id;
        this.createTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
        this.state = 1;
    }
}
