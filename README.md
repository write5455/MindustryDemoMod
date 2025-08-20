# Mindustry Java 模版项目
这是一个适用于 Android 和 PC 的 Mindustry Java 模组模板。此模组的 Kotlin 版本可以[在此处查看](https://github.com/Anuken/MindustryKotlinModTemplate)。

## 构建桌面版进行测试

1.  安装 JDK **17**。
2.  运行 `gradlew jar` [1]。
3.  你的模组 jar 文件将位于 `build/libs` 目录中。**此版本仅用于桌面测试，不适用于 Android。**
要构建与 Android 兼容的版本，你需要 Android SDK。你可以让 Github Actions 处理此事，或者自行设置。请参阅以下步骤。

## 通过 Github Actions 构建

此仓库已设置 Github Actions CI，以便在每次提交时自动为你构建模组。这显然需要一个 Github 仓库。
要获取一个适用于所有平台的 jar 文件，请执行以下操作：
1.  创建一个与你的模组同名的 Github 仓库，并将此仓库的内容上传到其中。执行任何必要的修改，然后提交并推送。
2.  检查你仓库页面上的 "Actions" 标签。在列表中选择最近的提交。如果构建成功完成，"Artifacts" 部分应该会有一个下载链接。
3.  点击下载链接（应该是你的仓库名称）。这将下载一个**压缩后的 jar 文件** —— **而不是** jar 文件本身 [2]！解压此文件，并将其中的 jar 文件导入 Mindustry。此版本应同时适用于 Android 和桌面平台。

## 本地构建

本地构建需要更多的设置时间，但如果你以前做过 Android 开发，应该不成问题。
1.  下载 Android SDK，解压，并将 `ANDROID_HOME` 环境变量设置为其位置。
2.  确保已安装 API 级别 30 以及任何近期版本的构建工具（例如 30.0.1）。
3.  将构建工具（build-tools）文件夹添加到你的 PATH 中。例如，如果你安装了 `30.0.1`，那么路径将是 `$ANDROID_HOME/build-tools/30.0.1`。
4.  运行 `gradlew deploy`。如果你一切都设置正确，这将在 `build/libs` 目录中创建一个可同时运行于 Android 和桌面的 jar 文件。

## 添加依赖

请注意，所有对 Mindustry、Arc 或其子模块的依赖**必须在 Gradle 中声明为 compileOnly**。切勿对核心的 Mindustry 或 Arc 依赖使用 `implementation`。

-   `implementation` **会将整个依赖项打包进 jar 中**，这对于大多数模组依赖来说是非常不可取的。你肯定不希望 Mindustry API 的全部内容都打包进你的模组里。
-   `compileOnly` 意味着该依赖仅在编译时可用，不会包含在最终的 jar 中。

仅当你想要将另一个 Java 库*与你的模组一起打包*，并且该库在 Mindustry 中不存在时，才使用 `implementation`。

---

*[1]：在 Linux/Mac 上是 `./gradlew`，但如果你在使用 Linux，我想你知道如何正确运行可执行文件。*
*[2]：是的，我知道这很蠢。这是 Github UI 的限制——虽然 jar 本身是未压缩上传的，但目前无法将其作为单个文件下载。*
