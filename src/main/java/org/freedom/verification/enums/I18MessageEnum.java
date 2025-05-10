package org.freedom.verification.enums;

/**
 * @description:
 * @author: freedom
 * @date: 2025/5/10
 */
public enum I18MessageEnum {
   F1001("1","2");

    private final String zh;
    private final String en;

    I18MessageEnum (String zh,String en) {
        this.zh = zh;
        this.en = en;
    }

    @Override
    public String toString () {
        return "I18MessageEnum{" + "zh='" + zh + '\'' + ", en='" + en + '\'' + '}';
    }

}
