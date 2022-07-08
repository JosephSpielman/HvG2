package Creatures;
import Inventory.Item;
import Inventory.Loot;

import java.util.ArrayList;
import java.util.Scanner;

public class Knight extends Humanoid{
    int buffs;
    Item equipmentSlot1;

    ArrayList<Loot> loot = new ArrayList<>();

    public Knight(){
        super(5,25,10,5,3,"\uD83D\uDDE1");
        this.buffs =0;
        this.equipmentSlot1 = new Item("Iron Sword",1,0,"Standard Issue Knight's sword","buffs");
        calcItemStats(equipmentSlot1);
    }

    public Item getEquipmentSlot1() {
        return equipmentSlot1;
    }

    public void setEquipmentSlot1(Item equipmentSlot1) {
        this.equipmentSlot1 = equipmentSlot1;
    }


    public ArrayList<Loot> getLoot() {
        return loot;
    }

    public void setLoot(ArrayList<Loot> loot) {
        this.loot = loot;
    }

    public int getBuffs() {
        return buffs;
    }

    public void setBuffs(int buffs) {
        this.buffs = buffs;
    }


    @Override
    public int dealDamage() {

        return this.strength+this.buffs;
    }
    public void healForBoss(){
        System.out.println("The knight catches his breath for the battle! |HP+5|");
        this.hp +=5;

    }
    public void calcItemStats(Item in){
        this.buffs =0;
        if(in.getApplyTo().equals("buffs")){
            this.buffs +=in.getBonus();
        }
        if(in.getApplyTo().equals("curse")){
            this.buffs -= in.getCurse();
        }
    }
    public void getPlayerMove(){
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        do{
            try{
                System.out.println("Which direction do you move? (N,E,S,W)");
                String input = sc.nextLine();
                if(input.matches("[NnEeSsWw]")){
                    input =input.toLowerCase();
                    switch (input){
                        case"n":
                            this.setPosRow((this.getPosRow()-1));
                            break;
                        case"s":
                            this.setPosRow((this.getPosRow()+1));
                            break;
                        case"w":
                            this.setPosColumn((this.getPosColumn()-1));
                            break;
                        default:
                            this.setPosColumn((this.getPosColumn()+1));
                            break;
                    }
                    valid = true;
                }
            }catch(Exception e){
                System.out.println("Invalid Entry!");
            }
        }while(!valid);
    }
     @Override
     public String toString(){
         return this.displayValue;
    }
    public void displayLoot(){
         int sum = 0;
        System.out.println("The knight collected:");
        for (Loot l: this.loot){
            System.out.println(l.getName()+". "+l.getDescription());
            sum += l.getValue();
        }
        if(this.equipmentSlot1.getName().equals("Golden Sword")){
            System.out.println("Golden Sword. It didn't help in life but at least it can be smelted down.");
            sum+= 300;
        }
        System.out.println("For a total of "+sum+" gold!");
    }
    @Override
    public String displayStats(){
         return super.displayStats()+"|Buffs: "+this.buffs;
    }
}
