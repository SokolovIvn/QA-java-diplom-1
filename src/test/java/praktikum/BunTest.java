package praktikum;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;

    private final float price;
    private final String name;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunParam() {
        return new Object[][]{
                {"654321", 15f},
                {"bun for black mamba", 100f},
                {"", 50.5f},
                {"sdafasdfsdfasasdfadsf bun", 200.0f},
                {"^&)", -6.5f},
                {"ноль булок", 0f},
                {"булки", -1f},
                {"really expensive", 1000000f},
                {null, -0.01f}

        };
    }
    @Before
    public void setUp() {

        bun = new Bun(name, price);
    }
    @Test
    public void bunNameTest() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void bunPriceTest() {
        assertEquals(price, bun.getPrice(), 0.1);
    }
}
