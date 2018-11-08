package com.caesar.aptsample;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * author : yangshaopeng.
 * Description:.....
 * 2018/11/8 22:10
 * email : yangshaopeng_it@163.com
 */
@Retention(CLASS)
@Target(FIELD)
public @interface TestAnno {


}
