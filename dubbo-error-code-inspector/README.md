[中文](README.zh.md)

This module is the detailed implementation of mechanism that checks (document links of) error code in logger invocations.

# Features
1. Error code extraction. ('All Error Codes' in screenshot)
2. Link testing of document of error codes. ('Error codes which document links are not reachable' in screenshot)
3. Hint of logger method invocations which don't use error code. ('Illegal logger method invocations' in screenshot)
4. Automatic checking in GitHub Actions. (Currently it does not throw exception. It will upload result to artifacts in GitHub Actions.)

# Screenshot in GitHub Actions
![eci-1](https://user-images.githubusercontent.com/4351489/192001227-36315550-60e4-4846-9550-d4cd1e2363c5.jpg)

# Run
## Run locally
0. **Prerequisite (Run before execution)**

   (a) Clone Apache Dubbo's source code. <br />
   (b) Execute `mvn -DskipTests clean install` to compile the entire project.

1. Method 1

   Change directory to dubbo-error-code-inspector and execute `mvn exec:java -Ddubbo.eci.path=<Path to Dubbo Source>`.


2. Method 2

   (a) Change directory to `dubbo-error-code-inspector` and execute `mvn package`. <br />
   (b) In the `target` directory, execute `java -jar dubbo-error-code-inspector-1.0.0-SNAPSHOT.jar <Path to Dubbo Source>`

# Related Pull Requests in 'dubbo' repository
Legacy PR: https://github.com/apache/dubbo/pull/10663

PR about GitHub Actions configuration: https://github.com/apache/dubbo/pull/10680

PR about 'Another Changes' in https://github.com/apache/dubbo/pull/10663: https://github.com/apache/dubbo/pull/10678
