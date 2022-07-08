package Inventory;

public class Loot {
    String name;
    int value;
    String description;

    public Loot() {
    }
    public Loot(String name, int value, String description) {
        this.name = name;
        this.value = value;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Loot{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", description='" + description + '\'' +
                '}';
    }
    public String cleanDescription(){
        return "[Name: "+this.name+" |Value: "+this.value+" |Description: "+this.description+"]";
    }

    public String lootSummary(){
        return "";
    }
}
