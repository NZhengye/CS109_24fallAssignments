public class Land {
    private House house;
    private LandColor color;

    public Land(LandColor color) {
        this.color = color;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public LandColor getColor() {
        return color;
    }

    public void setColor(LandColor color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Land %s: %s", this.color, house != null ? house.toString() : "");
    }
}
