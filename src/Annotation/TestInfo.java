package Annotation;


enum TestType {
    FIRST, FINAL
}


/*
'@'기호를 붙이는 것을 제외하면 인터페이스를 정의하는 것과 동일하다.
애너테이션의 요소는 반환값이 있고 매개변수는 없는 추상 메소드의 형태를 가지며, 상속을 통해 구현하지 않아도 된다.
애너테이션의 각 요소는 기본값을 가질 수 있으며, 기본값이 있는 요소는 애너테이션을 적용할 때 값을 지정하지 않으면 기본값이 사용된다.
*/
public @interface TestInfo {
    int count() default 1;
    String testedBy();
    String[] testTools();
    TestType testType();
    DateTime testDate();    // 자신이 아닌 다른 애너테이션(@DateTime)을 포함할 수 있다.
}


@interface DateTime {
    String yymmdd();
    String hhmmss();
}


