package com.zhoutong.util;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class UtilConfigure implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String[] s = new String[]{JWTUtil.class.getName(),ImageConveter.class.getName()};   //声明需要交给IOC容器管理的bean名称
        return s;
    }
}