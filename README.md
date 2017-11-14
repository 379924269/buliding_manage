#manage 1.0
------------------------------------------------------------------
###一、项目框架：
    springboot + mybaits +　swaggerUI + shiro实现一个简单的权限控制系统
###二、代码通过generator自动生成
###三、日志用的logback.xml
*   为什么用lockback参考地址：[http://www.cnblogs.com/warking/p/5710303.html](http://www.cnblogs.com/warking/p/5710303.html)
###四、我知道的shiro权限处理有2种：
    1、通过注解配置：直接在controller加上@permission（权限key），注意配置要多些一个；
    2、通过数据库配置：项目初始化的时候加载上去（我想选这种，感觉简洁点），把查询出来的permission的key和value先注入ini.selecion中，然后在登陆授权的时候把权限赋给用户，
    然后就交给shiro了。（不好的地方就是不好区分请求一样的但是请求方法不一样的请求.如：“/deviceh方法get”和"/device方法post"）
###五、用到shiro的主要功能：[参考地址点击链接](http://jinnianshilongnian.iteye.com/blog/2018398)
    1、权限控制（权限缓存还没有搞定，参考的张开涛的博客，我理解和测试，用哪个方法只是对当前用户，不是所有，问题有待解决）
    2、登陆次数限制
    3、密码加密
    4、并发登录人数控制（前后者都可以提出）
###六、管理端请求日志:
    通过aop(面向切面编程)来记录日志, 详见common.systenLog.SysLogAspect.java。
 