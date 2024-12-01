<img src="https://youlan-boot-doc.kensenzhao.com/assets/img/banner.jpg" height="200px" width="100%" alt="">

<h2 align="center" style="font-weight: bold;">
基于SpringBoot的轻量级业务开发框架
</h2>

<p align="center">
    <a href="https://github.com/kensenzhao/youlan-boot" style="text-decoration: none">
      <img src="https://img.shields.io/github/stars/dgxdks/youlan-boot.svg?style=social&label=Stars" alt="">
    </a>    
    <a href="https://gitee.com/kensenzhao/youlan-boot" style="text-decoration: none">
      <img src="https://gitee.com/kensenzhao/youlan-boot/badge/star.svg?theme=blue" alt="">
    </a>
    <a style="text-decoration: none">
        <img src="https://img.shields.io/badge/License-MIT-blue.svg" alt="">
    </a>
    <a style="text-decoration: none">
        <img src="https://img.shields.io/badge/Spring_Boot-2.7-blue.svg" alt="">
    </a>
    <a style="text-decoration: none">
        <img src="https://img.shields.io/badge/youlan--boot-1.1.0-success.svg" alt="">
    </a>
    <a href="https://gitee.com/kensenzhao/youlan-boot" style="text-decoration: none">
        <img src="https://img.shields.io/badge/JDK-8-green.svg" alt="">
    </a>
    <a style="text-decoration: none">
        <img src="https://img.shields.io/badge/OpenJDK-11-green.svg" alt="">
    </a>
</p>

<p align="center">
    <a href="https://youlan-boot-doc.kensenzhao.com">项目文档 | </a>
    <a href="https://youlan-boot-doc.kensenzhao.com/#/docs/home/system-demo">系统演示 | </a>
    <a href="https://gitee.com/kensenzhao/youlan-boot">Gitee地址 | </a>
    <a href="https://github.com/kensenzhao/youlan-boot">GitHub地址</a>
</p>


> 本人日常开发中，针对一些中小型项目经常会基于开源后台权限管理框架进行业务开发，因为这类框架一般不包含常见的业务模块需要自行解决，所以有了自己动手的想法。在此想通过这个项目，作为对自己过往经验的总结，是自己的“技术笔记”，也可能是帮助到别人的“开发利器”。

- 使用和学习优先拉取主线分支master，代码保持GitHub和Gitee同步，**日常使用优先访问Gitee**
- 感兴趣的小伙伴点个⭐️Star⭐️鼓励一下吧！

## 功能简介

### 系统管理

| 功能名称 | 功能描述                                                      |
|------|-----------------------------------------------------------|
| 用户管理 | 支持用户增删改查、导入导出、分配角色等功能                                     |
| 角色管理 | 支持角色增删改查、导出、数据权限、分配用户，刷新缓存等功能                             |
| 菜单管理 | 支持菜单增删改查等功能                                               |
| 部门管理 | 支持部门增删改查等功能                                               |
| 岗位管理 | 支持岗位增删改查等功能                                               |
| 字典管理 | 支持字典类型&字典值增删改查、导出、刷新缓存等功能                                 |
| 系统参数 | 支持系统参数增删改查、导出等功能                                          |
| 通知公告 | 支持通知和公告增删改查等功能                                            |
| 日志管理 | 支持用户操作日志记录、查询、删除、清空、导出等功能<br/>支持用户登录日志记录、查询、导出、清空、账户解锁等功能 |
| 存储管理 | 支持存储配置增删改查、导出、缓存刷新等功能<br/>支持存储记录、删除、清空、文件&图片上传等功能         |
| 短信管理 | 支持短信厂商增删改查、导出、缓存刷新等功能<br/>支持短信记录、删除、清空等功能                 |

### 支付管理

| 功能名称 | 功能描述                                       |
|------|--------------------------------------------|
| 支付配置 | 支持微信、支付宝相关支付配置增删改查                         |
| 支付通道 | 支持支付通道增删改查等功能<br/> 支付通道可绑定多种支付配置从而支持多种交易类型 |
| 支付订单 | 支持支付订单查询、删除，支付记录查询、支付订单同步、发起退款等功能          |
| 退款订单 | 支持退款订单查询、删除，退款订单同步等功能                      |
| 支付回调 | 支持支付回调查询，支付回调记录查询等功能                       |

### 基础功能

| 功能名称 | 功能描述                     |
|------|--------------------------|
| 在线用户 | 支持在线用户查询、强踢等功能           |
| 缓存监控 | 支持Redis运维指标图表展示等功能       |
| 系统接口 | 通过iframe展示knife4j生成的接口文档 |
| 代码生成 | 支持根据数据库表生成框架配套的前后端代码     |

## 目录结构

~~~
youlan-boot
├─ db                                   // 数据库目录
├─ docker                               // Docker目录
├─ youlan-admin                         // 后端服务
├─ youlan-common                        // 公共模块
│  └─ youlan-common-api                 // 接口模块
│  └─ youlan-common-captcha             // 验证码模块
│  └─ youlan-common-core                // 核心模块
│  └─ youlan-common-crypto              // 加密模块
│  └─ youlan-common-db                  // 数据库模块
│  └─ youlan-common-excel               // Excel模块
│  └─ youlan-common-http                // Http模块
│  └─ youlan-common-redis               // Redis模块
│  └─ youlan-common-region              // IP定位模块
│  └─ youlan-common-validator           // 校验模块
├─ youlan-plugin                        // 插件模块
│  └─ youlan-plugin-mini                // 小程序模块
│  └─ youlan-plugin-pay                 // 支付模块
│  └─ youlan-plugin-sms                 // 短信模块
│  └─ youlan-plugin-storage             // 存储模块
├─ youlan-system                        // 系统模块
├─ youlan-tools                         // 工具模块
├─ youlan-web                           // 前端服务【Vue2】
~~~

## 技术选型

| 名称                                                                          | 组件                                                                   | 描述                                                                                                                   |
|-----------------------------------------------------------------------------|----------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------|
| [后台前端项目(Vue2)](https://gitee.com/kensenzhao/youlan-boot/tree/master/youlan-web) | Vue2、ElementUI、JavaScript                                            | 基于[ruoyi-ui](https://gitee.com/y_project/RuoYi-Vue/tree/master/ruoyi-ui)重写Vue2版本的后台管理前端项目                            |
| 权限框架                                                                        | [sa-token](https://gitee.com/dromara/sa-token)                       | 使用SaToken替代配置相对反锁的SpringSecurity，足够满足大部分场景。[官方文档](https://sa-token.cc/)                                              |
| ORM框架                                                                       | [mybatis-plus](https://github.com/baomidou/mybatis-plus)             | 简单查询基本不用写SQL，内置各种拦截器插件，数据库操作更省心。[官方文档](https://baomidou.com/)                                                        |
| 多数据源                                                                        | [dynamic-datasource](https://github.com/baomidou/dynamic-datasource) | 结合mybatis-plus可应对大部分多数据源场景，功能丰富使用灵活。[官方文档](https://www.kancloud.cn/tracy5546/dynamic-datasource/2264611)             |
| Redis客户端                                                                    | [redisson](https://github.com/redisson/redisson)                     | 高性能Redis客户端，除了满足对redis的操作，还内置了分布式场景下的锁、限流、原子操作等功能。[官方文档](https://github.com/redisson/redisson/wiki/Table-of-Content) |
| 文件存储                                                                        | [x-file-storage](https://gitee.com/dromara/x-file-storage)           | 支持市面上常见的各种对象存储服务商，兼容S3协议，同时还支持本地、FTP、SFTP、WebDAV等存储方法。[官方文档](https://spring-file-storage.xuyanwu.cn/)                |
| 短信发送                                                                        | [sms4j](https://gitee.com/dromara/sms4j)                             | 支持市面上常见的各种短信服务商。[官方文档](https://wind.kim/)                                                                            |
| Excel工具                                                                     | [EasyExcel](https://gitee.com/easyexcel/easyexcel)                   | 高效的Excel处理工具，使用方便简捷。[官方文档](https://easyexcel.opensource.alibaba.com/)                                                |
| 接口文档                                                                        | [Knife4j](https://github.com/xiaoymin/knife4j)                       | 集Swagger2+OpenApi3为一体的增强解决方案，knife4j生成的接口文档页面支持文档自定义以及更加灵活的调试功能，是开发调试利器。[官方文档](https://doc.xiaominfo.com/)           |
| IP离线定位                                                                      | [ip2region](https://gitee.com/lionsoul/ip2region)                    | 离线IP地址定位库和IP定位数据管理框架，10微秒级别的查询效率。[官方文档](https://gitee.com/lionsoul/ip2region/tree/master/binding/java)               |
| JVM诊断                                                                       | [Arthas](https://github.com/alibaba/arthas)                          | 可以快速定位线上问题，监控JVM性能指标，项目中内置了arthas-spring-boot-starter。[官方文档](https://arthas.aliyun.com/)                             |
| 辅助工具                                                                        | [Hutool](https://www.hutool.cn/)、Lombok                              | Hutool是一个小而全的Java工具类库，更贴近国人使用习惯，避免重复定义很多相似的工具类。                                                                      |
| 数据库连接池                                                                      | HikariCP                                                             | SpringBoot内置数据库连接池，请永远相信官方的技术选型                                                                                      |
| 校验框架                                                                        | Validation                                                           | SpringBoot内置校验框架spring-boot-starter-validation，支持自定义校验，足够满足常见校验场景                                                    |
| Json序列化                                                                     | Jackson                                                              | SpringBoot内置Json序列化框架，请永远相信官方的技术选型                                                                                   |

## 演示图例

### 系统管理

| 图例                                                                                           | 图例                                                                                                  |
|----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/index.png)          | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/user.png)                  |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/user-edit.png)      | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/role.png)                  |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/role-edit.png)      | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/menu.png)                  |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/menu-edit.png)      | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/dept.png)                  |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/dept-edit.png)      | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/dict.png)                  |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/dict-edit.png)      | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/dict-data.png)             |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/config.png)         | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/config-edit.png)           |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/notice.png)         | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/notice-edit.png)           |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/log-operation.png)  | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/log-login.png)             |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/storage-config.png) | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/storage-config-edit.png)   |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/storage-record.png) | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/storage-record-upload.png) |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/sms.png)            | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/sms-edit.png)              |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/system/sms-record.png)     |                                                                                                     |

### 支付管理

| 图例                                                                                            | 图例                                                                                             |
|-----------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------|
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/pay/pay-config.png)         | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/pay/pay-config-edit.png)     |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/pay/pay-channel.png)        | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/pay/pay-channel-edit-1.png)  |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/pay/pay-channel-edit-2.png) | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/pay/pay-order.png)           |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/pay/pay-order-detail.png)   | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/pay/pay-record.png)          |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/pay/refund-order.png)       | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/pay/refund-order-detail.png) |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/pay/pay-notify.png)         | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/pay/pay-notify-record.png)   |

### 基础功能

| 图例                                                                                      | 图例                                                                                           |
|-----------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------|
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/base/generator.png)   | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/base/generator-import.png) |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/base/online-user.png) | ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/base/redis-monitor.png)    |
| ![](https://youlan-boot-doc.kensenzhao.com/assets/img/demo-image/base/swagger.png)     |                                                                                              |

## 特别鸣谢

* 感谢优秀开源项目[RuoYi](https://gitee.com/y_project/RuoYi)、[RuoYi-Vue-Plus](https://gitee.com/dromara/RuoYi-Vue-Plus)、[ruoyi-vue-pro](https://gitee.com/zhijiantianya/ruoyi-vue-pro)
  及其作者，这个项目在设计开发时有借鉴过上述开源项目。
