import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JavaScript", "TypeScript"})
    void testCase1(String arg){
        Assertions.assertFalse(arg.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {3,6,9,11})
    void testCase2(int number){
        Assertions.assertEquals(0,number%3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JavaScript", "TypeScript"})
   // @EmptySource   //""
 //   @NullSource
    @NullAndEmptySource
    void testCase3(String arg){
        Assertions.assertFalse(arg.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase4(String arg){
        Assertions.assertFalse(arg.isEmpty());
    }

    public static String[] stringProvider (){

       return new String[]{"Java", "JavaScript", "TypeScript"};
    }

    @ParameterizedTest
    @CsvSource({
            "10,20,30",
            "200,300,500",
            "30,20,100"
    })
    void testCase5(int num1, int num2, int result){
        Assertions.assertEquals(result,Calculator.add(num1,num2));
    }

    @ParameterizedTest
    @DisplayName("JustForFun :)")
    @CsvFileSource(resources = "/sampleData.csv", numLinesToSkip = 1)
    void testCase6(int num1, int num2, int result){
        Assertions.assertEquals(result,Calculator.add(num1,num2));
    }


}
