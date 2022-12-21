[English](README.md)

这个模块是 Dubbo 错误码文档链接指向的检查机制的具体实现。

# 功能
1. 代码中全部错误码的提取 （见下述截图中的 All Error Codes 部分）
2. 错误码文档链接失效的判定 （见下述截图中的 Error codes which document links are not reachable 部分）
3. 未用错误码的 Logger 方法的提示 （见下述截图中的 Illegal logger method invocations 部分）
4. GitHub Actions 的自动检查。（目前不会抛出异常。其会将结果上传到 GitHub 的 Artifacts。）

# Actions 的运行截图
![eci-1](https://user-images.githubusercontent.com/4351489/192001227-36315550-60e4-4846-9550-d4cd1e2363c5.jpg)

# 运行
## 本地运行
### 中文
0. **运行该项目之前请务必执行**

   a. 克隆 Apache Dubbo 的源代码（如有则略）<br />
   b. 执行 `mvn -DskipTests clean install` 以编译整个 Dubbo 项目。

1. 方式 1

   切换到 dubbo-error-code-inspector 目录下执行 `mvn exec:java -Ddubbo.eci.path=<Dubbo 源码路径>` 即可。


2. 方式 2

   a. 切换到 dubbo-error-code-inspector 目录下执行 `mvn package` 打包。<br /><br />
   b. 之后在 `target` 目录下运行 `java -jar dubbo-error-code-inspector-1.0.0-SNAPSHOT.jar <Dubbo 源码路径>` 即可。

# 原先在 dubbo 仓库的关于此的 PR
请参考 https://github.com/apache/dubbo/pull/10663 。

关于这一功能的 GitHub Actions 配置的 PR，请参考 https://github.com/apache/dubbo/pull/10680 。

关于 https://github.com/apache/dubbo/pull/10663 这一 PR “另外的修改” 这一部分，请参考 https://github.com/apache/dubbo/pull/10678 。
