这个模块是 Dubbo 错误码文档链接指向的检查机制的具体实现。

This module is the detailed implementation of mechanism that checks (document links of) error code in logger invocations.

# 功能 / Features
## 中文
1. 代码中全部错误码的提取 （见下述截图中的 All Error Codes 部分）
2. 错误码文档链接失效的判定 （见下述截图中的 Error codes which document links are not reachable 部分）
3. 未用错误码的 Logger 方法的提示 （见下述截图中的 Illegal logger method invocations 部分）
4. GitHub Actions 的自动检查。（目前不会抛出异常。其会将结果上传到 GitHub 的 Artifacts。）

## English
1. Error code extraction. ('All Error Codes' in screenshot)
2. Link testing of document of error codes. ('Error codes which document links are not reachable' in screenshot)
3. Hint of logger method invocations which don't use error code. ('Illegal logger method invocations' in screenshot)
4. Automatic checking in GitHub Actions. (Currently it does not throw exception. It will upload result to artifacts in GitHub Actions.)

# Actions 的运行截图 / Screenshot in GitHub Actions
![eci-1](https://user-images.githubusercontent.com/4351489/192001227-36315550-60e4-4846-9550-d4cd1e2363c5.jpg)

# 运行 / Run
## 本地运行 / Run locally
### 中文
1. 方式 1
   切换到 dubbo-error-code-inspector 目录下执行 `mvn exec:java -Ddubbo.eci.path=<Dubbo 源码路径>` 即可。

2. 方式 2
   切换到 dubbo-error-code-inspector 目录下执行 `mvn package` 打包。
   之后在 `target` 目录下运行 `java -jar dubbo-error-code-inspector-1.0.0-SNAPSHOT.jar <Dubbo 源码路径>` 即可。

### English
1. Method 1
   Change directory to dubbo-error-code-inspector and execute `mvn exec:java -Ddubbo.eci.path=<Path to Dubbo Source>`.

2. Method 2
   (a). Change directory to dubbo-error-code-inspector and execute `mvn package`.
   (b). In the `target` directory, execute `java -jar dubbo-error-code-inspector-1.0.0-SNAPSHOT.jar <Path to Dubbo Source>`

# 原先在 dubbo 仓库的关于此的 PR / Related PR in 'dubbo' repository
## 中文
请参考 https://github.com/apache/dubbo/pull/10663 。

关于这一功能的 GitHub Actions 配置的 PR，请参考 https://github.com/apache/dubbo/pull/10680 。

关于这一 PR “另外的修改” 这一部分，请参考 https://github.com/apache/dubbo/pull/10678 。

## English
Legacy PR: https://github.com/apache/dubbo/pull/10663

PR about GitHub Actions configuration: https://github.com/apache/dubbo/pull/10680

PR about 'Another Changes': https://github.com/apache/dubbo/pull/10678
