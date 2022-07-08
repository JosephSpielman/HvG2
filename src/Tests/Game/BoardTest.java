package Game;

import Creatures.Goblin;
import Creatures.Knight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Knight k = new Knight();
    Goblin g = new Goblin();

    @Test
    void startBattleFalse(){
        assertFalse(Board.startBattle(k,g));
    }
    @Test
    void startBattleTrue() {
        k.setPosColumn(0);
        k.setPosRow(0);
        g.setPosColumn(0);
        g.setPosRow(0);
        assertTrue(Board.startBattle(k,g));
    }

    @Test
    void openTreasureChestFalse() {
        Chest c = new Chest();
        c.setChestRow(5);
        c.setChestRow(5);
        k.setPosColumn(0);
        k.setPosRow(0);
        assertFalse(Board.openTreasureChest(k,c));
    }
}