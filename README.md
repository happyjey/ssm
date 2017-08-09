# ssm
Spring+SpringMVC+Mybatis框架整合最佳实践
 

## 说明

* 数据连接池为druid
* 日志 logback
 
## Shiro解析
 
* SimpleCredentialsMatcher
* 不对密码做加密直接明文匹配，用户输入的密码直接与数据库中的密码对比，意思是数据库中存储的是明文密码。
