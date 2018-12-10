# 端口号  
8761 eureka_one  
8762 eureka_two  
1110 provider-user  
1111 provider-user-one  
8081 sso  
8081 ribbon-without-eureka ribbon 脱离eureka使用  
6661 consumer-user  ribbon+restTemplate调用服务提供者,实现客户端负载均衡  
6662 consumer-user-feign  
6663 consumer-user-feign-customizing  自定义配置fegin  


#SpringCloud注解汇总      
@EnableEurekaServer 开启Eureka Server,加在SpringBoot启动类上
@EnableDiscoveryClient 服务发现,支持多种注册中心(eureka、consul、zookeeper..),基于spring-cloud-commons依赖,加在SpringBoot启动类上   
@EnableEurekaClient 服务发现,只能为eureka使用,基于spring-cloud-netflix依赖,加在SpringBoot启动类上  
@LoadBalanced 加在restTemplate的Bean配置上,使restTemplate具有负载均衡的能力,默认的负载均衡策略为轮循方式  
@RibbonClient(name = "RibbonConfig", configuration = RibbonConfiguration.class) 配置Ribbon自定义负载均衡策略 ,配置类应该放到启动类扫描范围之外,或使用@ComponentScan,,加在SpringBoot启动类上  
@FeignClient(name="provider-user") 加在FeignClient接口上,完成对服务提供方的接口绑定  
@FeignClient(name = "fegin-customizing",url="http://localhost:8761/",configuration = FeginConfiguration.class)只配置name则name的值为注册在eureka中的Application.如果配置url,configuration则name仅是一个FeignClient名,没实际意义.  
@EnableFeignClients 加在SpringBoot启动类上,不加此注解FeginClient不能注入

  

  
  
 








