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

# Java tools javac11 v10.6
http_archive(
    name = "remote_java_tools_linux",
    sha256 = "085c0ba53ba764e81d4c195524f3c596085cbf9cdc01dd8e6d2ae677e726af35",
    urls = [
        "https://mirror.bazel.build/bazel_java_tools/releases/javac11/v10.6/java_tools_javac11_linux-v10.6.zip",
        "https://github.com/bazelbuild/java_tools/releases/download/javac11_v10.6/java_tools_javac11_linux-v10.6.zip",
    ],
)

http_archive(
    name = "remote_java_tools_darwin",
    sha256 = "d15b05d2061382748f779dc566537ea567a46bcba6fa34b56d7cb6e6d668adab",
    urls = [
        "https://mirror.bazel.build/bazel_java_tools/releases/javac11/v10.6/java_tools_javac11_darwin-v10.6.zip",
        "https://github.com/bazelbuild/java_tools/releases/download/javac11_v10.6/java_tools_javac11_darwin-v10.6.zip",
    ],
)

# Zulu OpenJDK
http_archive(
    name = "openjdk15_linux_archive",
    build_file_content = """
java_runtime(name = 'runtime', srcs =  glob(['**']), visibility = ['//visibility:public'])
exports_files(["WORKSPACE"], visibility = ["//visibility:public"])
""",
    sha256 = "0f52b2d057d388ec7d659fc52e5d58634c39e05d511f48af650671adba9ca334",
    strip_prefix = "zulu15.32.15-ca-jdk15.0.3-linux_x64",
    urls = ["https://cdn.azul.com/zulu/bin/zulu15.32.15-ca-jdk15.0.3-linux_x64.tar.gz"],
)

http_archive(
    name = "openjdk15_darwin_archive",
    build_file_content = """
java_runtime(name = 'runtime', srcs =  glob(['**']), visibility = ['//visibility:public'])
exports_files(["WORKSPACE"], visibility = ["//visibility:public"])
""",
    sha256 = "87df2e9adc1e27c2ffe9a1f8b88d0ba3eeb4cc81c77fc6a3a02788e22484d07b",
    strip_prefix = "zulu15.32.15-ca-jdk15.0.3-macosx_x64",
    urls = ["https://cdn.azul.com/zulu/bin/zulu15.32.15-ca-jdk15.0.3-macosx_x64.tar.gz"],
)
