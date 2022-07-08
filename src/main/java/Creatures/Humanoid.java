package Creatures;

import java.util.Random;

public class Humanoid {
    int strength;
    int hp;
    int armorClass;
    int posRow;
    int posColumn;
    String displayValue;

    public Humanoid(int strength, int hp, int armorClass,int posRow, int posColumn,String displayValue) {
        this.strength = strength;
        this.hp = hp;
        this.armorClass = armorClass;
        this.posRow = posRow;
        this.posColumn = posColumn;
        this.displayValue = displayValue;
    }

    public Humanoid(){}

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getPosRow() {
        return posRow;
    }

    public void setPosRow(int posRow) {
        this.posRow = posRow;
    }

    public int getPosColumn() {
        return posColumn;
    }

    public void setPosColumn(int posColumn) {
        this.posColumn = posColumn;
    }

    public String getDisplayValue(){return displayValue;}

    public void setDisplayValue(String displayValue){this.displayValue =displayValue;}


    public void attack(Humanoid h) {
        Random rnd = new Random();
        int accuracy = rnd.nextInt(21);
        if(accuracy>h.getArmorClass()){
            System.out.println("The "+this.getClass().getSimpleName()+" strikes the "+h.getClass().getSimpleName()+"!");
            System.out.println("It deals "+dealDamage()+ " points of damage.");
            h.setHp(h.getHp()-dealDamage());
            return;
        } else if (accuracy ==0) {
            System.out.println("Critical miss! "+this.getClass().getSimpleName()+" hurts itself for "+this.strength+" points of damage.");
            this.hp -= this.strength;
            return;
        }
        System.out.println("The "+h.getClass().getSimpleName()+" deftly dodges the strike.");
    }

    public boolean isDead(){
        return this.getHp() <= 0;
    }

    public int dealDamage(){
         return this.strength;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" {" +
                "strength=" + strength +
                ", hp=" + hp +
                ", armorClass=" + armorClass +
                ", posRow=" + posRow +
                ", posColumn=" + posColumn +
                '}';
    }

    public String displayStats(){
        return this.getClass().getSimpleName()+"|Health: "+this.hp+"|Armor: "+this.armorClass+"|";
    }
}
