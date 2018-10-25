# ZYOnlinePlayer

关键词：音乐播放器，html音乐播放器

MKOnlinePlayer后台更改为JAVA，偷懒缩减了音乐源，只保留了网易云音乐部分。只是为了个人使用，php部署相对麻烦一些，所以抽时间写了这个简陋的java后台。入手学习java后台部署的小伙伴们可以使用该工程进行快速上手。 



**原作者信息即工程地址：**

**详细介绍** <http://mkblog.cn/1060/>

**GitHub** <https://github.com/mengkunsoft/MKOnlineMusicPlayer>

还是多多感谢原作大佬



### 说明

------

#### 一.开发组件及运行环境

​	JAVA 1.8 , HTTPClient(java端最基本的爬虫包),Spring MVC 4.3.0

​	包管理工具：MAVEN

​	POM.xml 关键依赖如下

```java
 		<!-- jackson -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>${jackson-version}</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>${jackson-version}</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
            <version>${jackson-version}</version>
        </dependency>
        <!-- end of jackson -->
            
        <!--爬虫组件HTTPCLICENT-->
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpclient</artifactId>
            <version>4.5.2</version>
        </dependency>
        <!--爬虫组件HTTPclient结束-->
```

​	部署环境：nginx+Tomcat9

