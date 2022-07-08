package Creatures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanoidTest {

    Humanoid h = new Humanoid(5,10,2,0,0,"temp");

    @Test
    void isDeadTrue() {
        h.setHp(0);
        assertTrue(h.isDead());
    }

    @Test
    void isDeadFalse() {
        h.setHp(10);
        assertFalse(h.isDead());
    }

    @Test
    void dealDamageCorrectValue() {
        h.setStrength(5);
        assertEquals(h.dealDamage(),5);
    }

    @Test
    void dealDamageIncorrectValue() {
        h.setStrength(5);
        assertNotEquals(h.dealDamage(),8);
    }


    @Test
    void displayStatsCorrect() {
        String generated = h.displayStats();
        String expected = "Humanoid|Health: "+10+"|Armor: "+2+"|";
        assertEquals(generated,expected);
    }

    @Test
    void displayStatsIncorrect() {
        String generated = h.displayStats();
        String expected = "Humanoid|Health: "+333+"|Armor: "+900+"|";
        assertNotEquals(generated,expected);
    }
}