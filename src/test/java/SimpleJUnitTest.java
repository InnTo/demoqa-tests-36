import org.junit.jupiter.api.*;


public class SimpleJUnitTest {

    int result;

    private int getResult(){
        return 3;
    }

    @BeforeAll
    static void beforeAll(){  //аннотация BeforeAll должна идти с методом static
        System.out.println("Before all\n");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Before each\n");
        result = getResult();
    }

    @AfterEach
    void afterEach(){
        System.out.println("After each\n");
        result = 0;
    }

    @Test
    void firstTest() {
        System.out.println("- first test");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondTest() {
        System.out.println("- second test");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest() {
        System.out.println("- third test");
        Assertions.assertTrue(result > 2);
    }

    @AfterAll
    static void afterAll(){  //аннотация BeforeAll должна идти с методом static
        System.out.println("After all\n");
    }
}
