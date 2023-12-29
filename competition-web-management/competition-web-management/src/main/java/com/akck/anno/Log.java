package com.akck.anno;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)// 指定注解 运行时有效
@Target(ElementType.METHOD)// 指定作用的位置 方法
public @interface Log {
}
