#workspace(
#    name = "bazel-example"
#)

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "3.3"
RULES_JVM_EXTERNAL_SHA = "d85951a92c0908c80bd8551002d66cb23c3434409c814179c0ff026b53544dab"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install", "artifact")
load("@rules_jvm_external//:specs.bzl", "maven")

# NOTE anytime you update artifacts or repositories, you need to run `bazel run @unpinned_maven//:pin` to regenerate maven_install.json
maven_install(
    name = "maven",
    artifacts = [
        "commons-codec:commons-codec:jar:1.14",
        "javax.xml.bind:jaxb-api:2.3.1",
        "org.slf4j:slf4j-simple:1.7.30",
        maven.artifact("junit", "junit", "4.13", testonly = True),
        maven.artifact("org.hamcrest", "hamcrest", "2.2", testonly = True),
        maven.artifact("org.hamcrest", "hamcrest-core", "2.2", testonly = True),
        maven.artifact("org.hamcrest", "hamcrest-library", "2.2", testonly = True),
    ],
    repositories = [
        "https://jcenter.bintray.com/",
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
    fetch_sources = True,
    maven_install_json = "//:maven_install.json",
)

load("@maven//:defs.bzl", "pinned_maven_install")
pinned_maven_install()

# Java tools javac14
http_archive(
    name = "remote_java_tools_darwin",
    sha256 = "e20f002ceb3f3353d64c022e1f3400d8539ee56ffcfd4a6680d73d6a2cac938b",
    urls = [
        "https://mirror.bazel.build/bazel_java_tools/releases/javac14/v1.0/java_tools_javac14_darwin-v1.0.zip",
        "https://github.com/bazelbuild/java_tools/releases/download/javac14-v1.0/java_tools_javac14_darwin-v1.0.zip",
    ],
)

# Zulu OpenJDK
http_archive(
    name = "openjdk14_darwin_archive",
    build_file_content = """
java_runtime(name = 'runtime', srcs =  glob(['**']), visibility = ['//visibility:public'])
exports_files(["WORKSPACE"], visibility = ["//visibility:public"])
""",
    sha256 = "8f15f435c3e8d8a4bb1de441b1d7601fe64e1bafdcf0862e2962ae429ea9e6b2",
    strip_prefix = "zulu14.29.23-ca-jdk14.0.2-macosx_x64",
    urls = ["https://cdn.azul.com/zulu/bin/zulu14.29.23-ca-jdk14.0.2-macosx_x64.tar.gz"],
)
