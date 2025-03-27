# spring 测试

## 代码运行
./run cp
./run pkg
./run deploy
启动tomcat，`http://localhost:8080/test/`访问

## 学习目标
spring入门，能构建一个java+jsp的全栈框架
homecontroller的第一个路由是mvc路由，响应jsp页面，return的值是jsp的文件名，通过`http://localhost:8080/test/hello`访问
homecontroller的第二个路由是一个get接口，通过ResponseBody修饰，响应string数据，通过`http://localhost:8080/test/user/121`访问
