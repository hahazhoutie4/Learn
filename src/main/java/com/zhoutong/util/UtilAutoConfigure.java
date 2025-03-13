package com.zhoutong.util;


import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import({com.zhoutong.util.UtilConfigure.class})
public @interface UtilAutoConfigure {}
