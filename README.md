# java-learning
java语言学习

## 适合学习人群
1. 有一定java语言基础
2. 有一定maven框架了解
3. 有一定shell脚本了解
4. 有一定服务器了解（比如知道get、post、req、res）

## 代码执行环境
- jdk 17+
- maven 3.9.9+
- tomcat 10.1+ (servlet测试用)
- win11(其他windows版本未知，写的都是linux脚本，理论上支持linux)
- git 2.37.3(代码运行脚本都是linux脚本，所以windows上需git bash支持。wsl那逼java非得是java.exe，跨平台差)
- vs code(代码编辑器，不依赖啥插件，需要代码提示的下java插件即可)

## 测试代码运行
基本每个测试都有run命令行脚本，测试模块执行先编译后运行，基本都是`./run cp`编译，`./run run`执行主类

## 打包
普通javase打包成jar包，javaee打包war包。先编译代码，后运行`./run pkg`打包

## 部署
javase的jar包复制到服务器，运行java -jar执行即可
javaee的war复制到tomcat的webapps目录下，通过`http://localhost:8080/test/hello`访问(比如test.war包)

## 环境变量依赖
MAVEN_HOME
CATALINA_HOME
JAVA_HOME