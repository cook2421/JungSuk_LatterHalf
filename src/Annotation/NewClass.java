package Annotation;

@TestInfo(
        count = 3, testedBy = "Cook",
        testTools = {"JUnit", "AutoTester"},
        testType = TestType.FIRST,
        testDate = @DateTime(yymmdd = "210809", hhmmss = "223940")
)

// 애너테이션 요소가 오직 하나뿐이고 이름이 value인 경우, 애너테이션을 적용할 때 요소의 이름을 생략하고 값만 적어도 된다.
@MadeBy("COOK SEUNG HYUN")
public class NewClass {
}



/*
애너테이션을 적용할 때 이 요소들의 값을 빠짐없이 지정해주어야 한다.
요소의 이름도 같이 적어주므로 순서는 상관없다.

요소의 타입이 배열인 경우, 괄호{}를 사용해서 여러 개의 값을 지정할 수 있다.
@Test(testTools = {"JUnit", "AutoTester"})      // 값이 여러 개인 경우
@Test(testTools = "JUnit")                      // 값이 하나일 때는 괄호{} 생략 가능
@Test(testTools = {})                           // 값이 없을 때는 괄호 {}가 반드시 필요

요소의 타입이 배열일 때도 요소의 이름이 value이면, 요소의 이름을 생략할 수 있다.
@SuppressWarnings({"deprecation", "unchecked"})
*/