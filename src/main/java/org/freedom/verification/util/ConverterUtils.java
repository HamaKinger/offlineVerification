package org.freedom.verification.util;

import org.modelmapper.ModelMapper;

/**
 * @description:
 * @author: freedom
 * @date: 2025/5/9
 */
public class ConverterUtils {
    private static final ModelMapper modelMapper = new ModelMapper();
    public static <T> T convert(Object source, Class<T> targetType) {
        return modelMapper.map(source, targetType);
    }

}
