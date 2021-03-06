# 端口号  
8761 eureka_one  
8762 eureka_two  
8763,8764,8765 eureka 高可用集群   
1110 provider-user  
1111 provider-user-one  
8081 sso  
8082 ribbon-without-eureka ribbon 脱离eureka使用   
8083 hystrix-dashboard Hystrix-Dashboard仪表盘 以6666 consumer-user-fegin-hystrix爲例 http://localhost:6666/actuator/hystrix.stream,调用turbine:http://localhost:8084/turbine.stream   
8084 hystrix-turbine Hystrix Turbine将每个服务Hystrix Dashboard数据进行了整合  
8085 file-upload文件下载 文件上传命令;curl -F "file=@C:\Users\y\Desktop\sql.txt" http://localhost:7771/file-upload/upload zuul上传大文件绕过spring文件上传限制(uri前面加/zuul/):http://localhost:7771/zuul/file-upload/upload   
6661 consumer-user  ribbon+restTemplate调用服务提供者,实现客户端负载均衡  
6662 consumer-user-feign |feign调用服务提供者
6663 consumer-user-feign-customizing |自定义配置fegin      
6664 consumer-user-hystrix |ribbon整合hystrix  
6665 consumer-user-hystrix-propagation |自定义Hystrix隔离策略  
6666 consumer-user-fegin-hystrix |fegin整合Hystrix 解决hystrix.stream404 
6667 consumer-user-feign-without-hystrix   
6668 consumer-user-feign-with-hystrix-hystrix-factory feign整合Hystrix記錄錯誤日志    
7771 gateway-zuul  
7772 gateway-zuul-reg-exp  
7773 gateway-zuul-fallback  
7774 gateway-zuul-filter    
# SpringCloud注解汇总  
## eureka   
@EnableEurekaServer 开启Eureka Server,加在SpringBoot启动类上  
@EnableDiscoveryClient 服务发现,支持多种注册中心(eureka、consul、zookeeper..),基于spring-cloud-commons依赖,加在SpringBoot启动类上   
@EnableEurekaClient 服务发现,只能为eureka使用,基于spring-cloud-netflix依赖,加在SpringBoot启动类上  
## Ribbon
@LoadBalanced 加在restTemplate的Bean配置上,使restTemplate具有负载均衡的能力,默认的负载均衡策略为轮循方式  
@RibbonClient(name = "RibbonConfig", configuration = RibbonConfiguration.class) 配置Ribbon自定义负载均衡策略 ,配置类应该放到启动类扫描范围之外,或使用@ComponentScan,,加在SpringBoot启动类上  
## Feign
@FeignClient(name="provider-user") 加在FeignClient接口上,完成对服务提供方的接口绑定  
@FeignClient(name = "fegin-customizing",url="http://localhost:8761/",configuration = FeginConfiguration.class)只配置name则name的值为注册在eureka中的Application.如果配置url,configuration则name仅是一个FeignClient名,没实际意义.  
@EnableFeignClients 加在SpringBoot启动类上,不加此注解FeginClient不能注入   
## Hystrix
@EnableCircuitBreaker 项目使用Hystrix,加在SpringBoot启动类上  
@HystrixCommand(fallbackMethod = "") 加在需要容错保护的方法上(controller/service) fallbackMethod 的值为连接超时执行的回调函数  
Hystrix的隔离策略两种： 分别是线程隔离和信号量隔离。
THREAD(线程隔离）：使用该方式，HystrixCommand将会在单独的线程上执行，并发请求受线程池中线程数量的限制。
SEMAPHORE（信号量隔离）：使用该方式，HystrixCommand将会在调用线程上执行，开销相对较小，并发请求受到信号量个数的限制。 
Hystrix中默认并且推荐使用线程隔离（THREAD)，因为这种方式有一个除网络超时以外的额外保护。 
一般来说，只有当调用负载异常高时（例如每个实例每秒调用数百次）才需要信号量隔离，因为这种场景下使用THREAD开销会比较高。信号量隔离一般仅适用于非网络调用的隔离。 
可以使用execution.isolation.strategy属性指定隔离策略。  
配置信号量隔离:@HystrixCommand(fallbackMethod = "getUserFallback" , commandProperties = @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"))   
@FeignClient(name= "provider-user" ,fallback = HystrixClientFallback.class,fallbackFactory = HystrixClientFactory.class) feign整合Hystrix 如果需要回退方法打印错误信息，可以使用fallbackFactory（fallback和fallbackFactory只能使用其中一种   
@EnableHystrixDashboard 声明为一个HystrixDashboard客户端,加在SpringBoot启动类上 访问路径http://localhost:8083/hystrix
@EnableTurbine 声明为一个Turbine客户端 默认调用路径 IP:host/actuator/hystrix.stream  
## Zuul 
@EnableZuulProxy
声明为一个zuul客户端,加在SpringBoot启动类上,完成服务发现不需添加@EnableDiscoveryClient注解.zuul没有内置EurekaClient,所以要添加eureka依赖.
使用方法:如:ApplicationName是PROVIDER-USER,URL是user/getUser/1,则zuul路径:http://localhost:7771/provider-user/user/getUser/1.(注意区分ApplicationName的大小写,以spring.application.name为准)
zuul会默认反向代理所有注册在eureka上的服务

 

 
  

  
  
 








