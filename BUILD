java_library(
    name = "main",
    srcs = glob(["main/java/**/*.java"]),
    resources = glob(["main/resources/**"]),
    resource_strip_prefix = "main/resources/",
    deps = [
        "@maven//:org_slf4j_slf4j_api"
    ]
)

# bazel run //:calculator
# or:
# bazel build //:calculator_deploy.jar
# java -jar bazel-bin/calculator_deploy.jar
java_binary(
    name = "calculator",
    main_class = "com.example.Application",
    runtime_deps = [
        ":main",
        "@maven//:org_slf4j_slf4j_jdk14",
    ],
)

# bazel test //:calculator-test
# or:
# bazel build //:calculator-test_deploy.jar
# java -Dbazel.test_suite=com.example.CalculatorTest -jar bazel-bin/calculator-test_deploy.jar
java_test(
    name = "calculator-test",
    srcs = [
        "test/java/com/example/CalculatorTest.java"
    ],
    resources = glob(["test/resources/**"]),
    resource_strip_prefix = "test/resources/",
    test_class = "com.example.CalculatorTest",
    deps = [
        ":main",
        "@maven//:junit_junit",
        "@maven//:commons_codec_commons_codec",
        "@maven//:javax_xml_bind_jaxb_api",
        "@maven//:org_hamcrest_hamcrest",
        "@maven//:org_slf4j_slf4j_api",
    ],
    runtime_deps = [
        "@maven//:org_slf4j_slf4j_simple",
    ]
)

# bazel test //:http-client-test
# or:
# bazel build //:http-client-test_deploy.jar
# java -Dbazel.test_suite=com.example.HttpClientTest -jar bazel-bin/http-client-test_deploy.jar
java_test(
    name = "http-client-test",
    srcs = [
        "test/java/com/example/HttpClientTest.java"
    ],
    resources = glob(["test/resources/**"]),
    resource_strip_prefix = "test/resources/",
    test_class = "com.example.HttpClientTest",
    deps = [
        "@maven//:junit_junit",
        "@maven//:org_apache_httpcomponents_httpclient",
        "@maven//:org_apache_httpcomponents_httpcore",
        "@maven//:org_hamcrest_hamcrest",
    ],
    runtime_deps = [
        "@maven//:org_slf4j_slf4j_simple",
    ]
)

# bazel test //:logging-test
# or:
# bazel build //:logging-test_deploy.jar
# java -Dbazel.test_suite=com.example.LoggingTest -jar bazel-bin/logging-test_deploy.jar
java_test(
    name = "logging-test",
    srcs = [
        "test/java/com/example/LoggingTest.java"
    ],
    resources = glob(["test/resources/**"]),
    resource_strip_prefix = "test/resources/",
    test_class = "com.example.LoggingTest",
    deps = [
        "@maven//:junit_junit",
        "@maven//:log4j_log4j",
    ],
    runtime_deps = [
        "@maven//:org_slf4j_slf4j_simple",
    ]
)

load(
    "@bazel_tools//tools/jdk:default_java_toolchain.bzl",
    "default_java_toolchain",
)
default_java_toolchain(
    name = "toolchain_java17",
    forcibly_disable_header_compilation = True,
    javabuilder = ["@bazel_tools//tools/jdk:vanillajavabuilder"],
    jvm_opts = [],
    source_version = "17",
    target_version = "17",
)
