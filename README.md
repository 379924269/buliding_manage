# manage 1.0

项目框架：springboot + mybaits +　swaggerUI + shiro实现一个简单的权限控制系统

# 
* 代码通过generator自动生成。

* 日志用的logback.xml

* 我知道的shiro权限处理有2种：
 *         1、通过注解配置：直接在controller加上@permission（权限key），注意配置要多些一个
     
 *          2、通过数据库配置：项目初始化的时候加载上去（我想选这种，感觉简洁点），把查询出来的permission的key和value先注入ini.selecion中，然后在登陆授权的时候把权限赋给用户，然后就交给shiro了。（不好的地方就是不好区分请求一样的但是请求方法不一样的请求.如：“/deviceh方法get”和"/device方法post"）