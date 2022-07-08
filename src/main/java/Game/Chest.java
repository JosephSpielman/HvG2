package Game;

import Creatures.Knight;
import Inventory.Item;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Chest extends Land {
    Item equipment;
    int chestRow;
    int chestColumn;
    public Chest(){
        super();
        this.chestRow=0;
        this.chestColumn=0;
        this.displayValue = "\uD83C\uDF81";
        generateEquipment();
    }
    public Chest(String name, String displayValue) {
        super(name, displayValue);
        generateEquipment();
    }

    public void generateChestLocation(int row,int col){
        Random rnd = new Random();
        this.setChestRow(rnd.nextInt(row));
        this.setChestColumn(rnd.nextInt(col));
    }

    public int getChestRow() {
        return chestRow;
    }

    public void setChestRow(int chestRow) {
        this.chestRow = chestRow;
    }

    public int getChestColumn() {
        return chestColumn;
    }

    public void setChestColumn(int chestColumn) {
        this.chestColumn = chestColumn;
    }

    public Item getEquipment() {
        return equipment;
    }

    public void setEquipment(Item equipment) {
        this.equipment = equipment;
    }

    public void generateEquipment() {
        Random rnd = new Random();
        int roll = rnd.nextInt(6);
        if (roll <= 1) {
            this.equipment = new Item("Sharp Dagger", 2, 0, "A quicker alternative.", "buffs");
            return;
        }
        if (roll == 2) {
            this.equipment = new Item("Steel Sword", 3, 0, "Stronger than a standard broadsword.", "buffs");
            return;
        }
        if (roll == 3) {
            this.equipment = new Item("Cursed Amulet", 0, 2, "Lowers your strength. Does it have a use?", "curse");
            return;
        }
        if (roll == 4) {
            this.equipment = new Item("Great Axe", 5, 0, "The goblins won't know what hit them.", "buffs");
            return;
        }
        this.equipment = new Item("Golden Sword", 0, 0, "It's not very powerful but it is SHINY!", "buffs");
    }
    public void lootChest(Knight k){
        Scanner sc = new Scanner(System.in);
        System.out.println("The chest contains: "+this.equipment.cleanDescription());
        boolean valid = false;
        do {
            try {
                System.out.println("Would you like to replace your " + k.getEquipmentSlot1().cleanDescription() + "? Y/N");
                String input = sc.nextLine();

                if (input.equalsIgnoreCase("y")) {
                    k.setEquipmentSlot1(this.equipment);
                    k.calcItemStats(k.getEquipmentSlot1());
                    valid = true;
                } else if (input.equalsIgnoreCase("n")) {
                    valid = true;
                }
            } catch (InputMismatchException e){
                System.out.println("Invalid Entry!");
            }
        }while(!valid);
    }
    public  String toString(){
       return this.displayValue;
    }
}
