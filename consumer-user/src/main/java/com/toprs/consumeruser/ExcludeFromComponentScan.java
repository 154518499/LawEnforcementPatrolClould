package com.toprs.consumeruser;

/**
 * 自定义注解,配合@ComponentScan使用,
 * SpringBoot启动类排除扫描标注该注解的类
 */
public @interface ExcludeFromComponentScan {

}
