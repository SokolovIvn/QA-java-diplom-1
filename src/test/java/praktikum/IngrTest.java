package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngrTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;


    public IngrTest(IngredientType type, String name, float price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData(){
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
        };
    }

    @Before
    public void setUp(){
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getTypeTest(){
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void getPriceTest(){
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest(){
        assertEquals(name, ingredient.getName());
    }
}