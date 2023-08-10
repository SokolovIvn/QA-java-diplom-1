package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngrTypeTest {

    @Test
    public void ingrTypeFillingTest() {
        assertEquals(FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test
    public void ingrTypeSauceTest() {
        assertEquals(SAUCE, IngredientType.valueOf("SAUCE"));
    }
}