#workspace(
#    name = "bazel-example"
#)

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "4.0"
RULES_JVM_EXTERNAL_SHA = "31701ad93dbfe544d597dbe62c9a1fdd76d81d8a9150c2bf1ecf928ecdf97169"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "artifact", "maven_install")
load("@rules_jvm_external//:specs.bzl", "maven")

# NOTE anytime you update artifacts or repositories, you need to run `bazel run @unpinned_maven//:pin` to regenerate maven_install.json
maven_install(
    name = "maven",
    artifacts = [
        "commons-codec:commons-codec:jar:1.14",
        "javax.xml.bind:jaxb-api:2.3.1",
        "log4j:log4j:1.2.17",
        "org.slf4j:jcl-over-slf4j:1.7.30",
        "org.slf4j:log4j-over-slf4j:1.7.30",
        "org.slf4j:slf4j-jdk14:1.7.30",
        "org.slf4j:slf4j-simple:1.7.30",
        maven.artifact(
            "org.apache.httpcomponents",
            "httpclient",
            "4.5.12",
        ),
        maven.artifact(
            "junit",
            "junit",
            "4.13",
            testonly = True,
        ),
        maven.artifact(
            "org.hamcrest",
            "hamcrest",
            "2.2",
            testonly = True,
        ),
        maven.artifact(
            "org.hamcrest",
            "hamcrest-core",
            "2.2",
            testonly = True,
        ),
        maven.artifact(
            "org.hamcrest",
            "hamcrest-library",
            "2.2",
            testonly = True,
        ),
    ],
    fetch_sources = True,
    maven_install_json = "//:maven_install.json",
    repositories = [
        "https://jcenter.bintray.com/",
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
    override_targets = {
        "commons-logging:commons-logging": "@maven//:org_slf4j_jcl_over_slf4j",
        "log4j:log4j": "@maven//:org_slf4j_log4j_over_slf4j",
        "org.hamcrest:hamcrest-core": "@maven//:org_hamcrest_hamcrest",
    }
)

load("@maven//:defs.bzl", "pinned_maven_install")

pinned_maven_install()

# Java tools javac11 v10.7
http_archive(
    name = "remote_java_tools_linux",
    sha256 = "cf57fc238ed5c24c718436ab4178ade5eb838fe56e7c32c4fafe0b6fbdaec51f",
    urls = [
        "https://mirror.bazel.build/bazel_java_tools/releases/javac11/v10.7/java_tools_javac11_linux-v10.7.zip",
        "https://github.com/bazelbuild/java_tools/releases/download/javac11_v10.7/java_tools_javac11_linux-v10.7.zip",
    ],
)

http_archive(
    name = "remote_java_tools_darwin",
    sha256 = "51a4cf424d3b26d6c42703cf2d80002f1489ba0d28c939519c3bb9c3d6ee3720",
    urls = [
        "https://mirror.bazel.build/bazel_java_tools/releases/javac11/v10.7/java_tools_javac11_darwin-v10.7.zip",
        "https://github.com/bazelbuild/java_tools/releases/download/javac11_v10.7/java_tools_javac11_darwin-v10.7.zip",
    ],
)

# Zulu OpenJDK
http_archive(
    name = "openjdk17_linux_archive",
    build_file_content = """
java_runtime(name = 'runtime', srcs =  glob(['**']), visibility = ['//visibility:public'])
exports_files(["WORKSPACE"], visibility = ["//visibility:public"])
""",
    sha256 = "9b8e4d1e47b02b9c2392462ee82988c189357471de3224c37173fa58e2b25112",
    strip_prefix = "zulu17.30.15-ca-jdk17.0.1-linux_x64",
    urls = ["https://cdn.azul.com/zulu/bin/zulu17.30.15-ca-jdk17.0.1-linux_x64.tar.gz"],
)

http_archive(
    name = "openjdk17_darwin_archive",
    build_file_content = """
java_runtime(name = 'runtime', srcs =  glob(['**']), visibility = ['//visibility:public'])
exports_files(["WORKSPACE"], visibility = ["//visibility:public"])
""",
    sha256 = "09d64fe576373b4314422811bc8402fbb7700176822b0e1e2bf2ff8a6cad10eb",
    strip_prefix = "zulu17.30.15-ca-jdk17.0.1-macosx_x64",
    urls = ["https://cdn.azul.com/zulu/bin/zulu17.30.15-ca-jdk17.0.1-macosx_x64.tar.gz"],
)
