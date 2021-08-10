package Annotation;

enum TestType {
    FIRST, FINAL
}

public @interface TestInfo {
    int count() default 1;
    String testedBy();
    String[] testTools();
    TestType testType();
    DateTime testDate();        // 자신이 아닌 다른 애니테이션(@DateTime)을 포함할 수 있다.
}

@interface DateTime {
    String yymmdd();
    String hhmmss();
}