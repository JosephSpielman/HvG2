package Game;
//String grass = "\u2F8B";
public class Land {
    String name;
    String displayValue;

    public Land(){
        this.name = "Grass";
        this.displayValue = "\u2F8B";
    }
    public Land(String name, String displayValue) {
        this.name = name;
        this.displayValue = displayValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    @Override
    public String toString() {
        return displayValue;
    }
}
