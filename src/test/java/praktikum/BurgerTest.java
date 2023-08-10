package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient topping;
    @Mock
    Ingredient sauce;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(topping);
        assertTrue(burger.ingredients.contains(topping));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(sauce);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(topping);
        List<Ingredient> ingredient = new ArrayList<>();
        ingredient.add(topping);
        ingredient.add(sauce);
        burger.moveIngredient(0, 1);
        assertEquals(burger.ingredients, ingredient);
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(topping);
        burger.addIngredient(sauce);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(sauce.getPrice()).thenReturn(200f);
        Mockito.when(topping.getPrice()).thenReturn(100f);
        assertEquals(burger.getPrice(), 500, 1);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(topping);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(sauce.getName()).thenReturn("hot sauce");
        Mockito.when(topping.getName()).thenReturn("cutlet");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(topping.getPrice()).thenReturn(100f);
        Mockito.when(sauce.getPrice()).thenReturn(100f);
        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(topping.getType()).thenReturn(IngredientType.FILLING);
        String receipt = String.format("(==== %s ====)%n", bun.getName())
                + String.format("= %s %s =%n", sauce.getType().toString().toLowerCase(),
                sauce.getName())
                + String.format("= %s %s =%n",
                topping.getType().toString().toLowerCase(),
                topping.getName())
                + String.format("(==== %s ====)%n",
                bun.getName())
                + String.format("%nPrice: %f%n",
                (bun.getPrice() * 2 + topping.getPrice() + sauce.getPrice()));
        assertEquals(receipt, burger.getReceipt());
    }


}