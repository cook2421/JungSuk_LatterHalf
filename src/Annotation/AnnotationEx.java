package Annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@SuppressWarnings("1111")       // 유효하지 않은 애너테이션은 무시된다.
@TestInfo2(
        testedBy = "Cook",
        testTools = {"Java", "intelliJ"},
        testType = TestType2.FINAL,
        testDate = @DateTime2(yymmdd="210810", hhmmss="155600")
)
public class AnnotationEx {
    public static void main(String[] args) {
        // AnnotationEx의 Class 객체를 얻는다.
        Class<AnnotationEx> cls = AnnotationEx.class;

        TestInfo2 anno = (TestInfo2)cls.getAnnotation(TestInfo2.class);
        System.out.println("anno.testedBy() = " + anno.testedBy());
        System.out.println("anno.testDate().yymmdd() = " + anno.testDate().yymmdd());
        System.out.println("anno.testDate().hhmmss() = " + anno.testDate().hhmmss());

        for (String str : anno.testTools()) {
            System.out.println("testTools = " + str);
        }

        System.out.println();

        // AnnotationEx에 적용된 모든 애너테이션을 가져온다.
        Annotation[] annoArr = cls.getAnnotations();

        for (Annotation a : annoArr) {
            System.out.println("anno = " + a);
        }
    }   // main의 끝
}


@Retention(RetentionPolicy.RUNTIME)     // 실행 시에 사용가능하도록 설정
@interface TestInfo2 {
    int         count()         default 1;
    String      testedBy();
    String[]    testTools()     default "JUnit";
    TestType2   testType()      default TestType2.FIRST;
    DateTime2   testDate();
}


@Retention(RetentionPolicy.RUNTIME)     // 실행 시에 사용가능하도록 설정
@interface DateTime2 {
    String yymmdd();
    String hhmmss();
}

enum TestType2 { FIRST, FINAL }
