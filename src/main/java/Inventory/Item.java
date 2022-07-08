package Inventory;
public class Item {
    String name;
    int bonus;
    int curse;
    String description;
    String applyTo;

    public Item(String name, int bonus, int curse, String description, String applyTo) {
        this.name = name;
        this.bonus = bonus;
        this.curse = curse;
        this.description = description;
        this.applyTo = applyTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getCurse() {
        return curse;
    }

    public void setCurse(int curse) {
        this.curse = curse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApplyTo() {
        return applyTo;
    }

    public void setApplyTo(String applyTo) {
        this.applyTo = applyTo;
    }
    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", bonus=" + bonus +
                ", curse=" + curse +
                ", description='" + description + '\'' +
                ", applyTo='" + applyTo + '\'' +
                '}';
    }
    public String cleanDescription(){
        return "[Name: "+this.name+" |Bonus: "+(this.bonus-this.curse)+" |Description: "+this.description+"]";
    }
}
