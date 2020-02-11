1.Start project: spring-cloud-eureka

2.Test the rpc service:
  Start project: spring-cloud-service
  Start project:spring-cloud-domain1
  Open: http://localhost:8763/domain/domainService?name=2
  
3.Test gateway
  Start project:spring-cloud-gateway
  Use: zuul
  Open: http://localhost:8765/apigateway/base/baseService?name=2
  
4.Datebase
Use:mybatis-plus
Need update the pom.xml of spring-cloud-domain1 to open the remark of spring-cloud-domain1.

5.Fuse out
Use: sentinel

6.Soft load
Use: feign

7.Maven settings:
File：settings.xml

8.Other tools
Look project: tool

Look simple:
1)design pattern
2)thread
eg.

