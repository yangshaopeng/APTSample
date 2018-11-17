package com.caesar.aptannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * author : yangshaopeng.
 * Description:.....
 * 2018/11/17 22:46
 * email : yangshaopeng_it@163.com
 */
@Target(TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface TestAnno {
}
