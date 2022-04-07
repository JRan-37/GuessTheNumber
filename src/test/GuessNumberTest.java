import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class GuessNumberTest {

    //Object and input vars
    GuessNumber gn;
    InputStream sysBackup;

    @BeforeEach
    void setUp() {
        sysBackup = System.in;
    }

    @Test
    void setName() {
        //Replace user input with test data
        ByteArrayInputStream newIn = new ByteArrayInputStream("Jackson".getBytes());
        System.setIn(newIn);
        //Instantiate GuessNumber class
        gn = new GuessNumber();
        gn.setName();
        //Assert correct input is retrieved
        assertEquals("Jackson", gn.name);
    }

    @Test
    void guess() {
        //Replace user input with test data
        ByteArrayInputStream newIn = new ByteArrayInputStream("Jackson\n5".getBytes());
        System.setIn(newIn);
        //Instantiate GuessNumber class
        gn = new GuessNumber();
        gn.setName();
        //Assert correct input is retrieved
        assertEquals(gn.randomNum == 5, gn.guess());
    }

    @Test
    void replay() {
        //Replace user input with test data
        ByteArrayInputStream newIn = new ByteArrayInputStream("Yes".getBytes());
        System.setIn(newIn);
        //Instantiate GuessNumber class
        gn = new GuessNumber();
        gn.guessCount = 12;
        //Assert correct input is retrieved
        assertTrue(gn.replay());
        //Assert guess count has been reset
        assertEquals(0, gn.guessCount);
    }

    @AfterEach
    void tearDown() {
        //Restore original system inputstream
        System.setIn(sysBackup);
    }
}