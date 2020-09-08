java_library(
    name = "main",
    srcs = glob(["main/java/**/*.java"]),
    resources = glob(["main/resources/**"]),
    resource_strip_prefix = "main/resources/",
    deps = [
        "@maven//:org_slf4j_slf4j_api"
    ]
)

java_binary(
    name = "calculator",
    main_class = "com.example.Application",
    runtime_deps = [
        ":main",
        "@maven//:org_slf4j_slf4j_simple",
    ],
)

java_test(
    name = "test",
    srcs = glob(["test/java/**/*.java"]),
    resources = glob(["test/resources/**"]),
    test_class = "com.example.CalculatorTest",
    deps = [
        ":main",
        "@maven//:junit_junit",
        #"@maven//:com_googlecode_junit_toolbox_junit_toolbox",
        "@maven//:commons_codec_commons_codec",
        "@maven//:javax_xml_bind_jaxb_api",
        "@maven//:org_hamcrest_hamcrest",
        "@maven//:org_slf4j_slf4j_api",
    ],
    runtime_deps = [
        "@maven//:org_slf4j_slf4j_simple",
    ]
)