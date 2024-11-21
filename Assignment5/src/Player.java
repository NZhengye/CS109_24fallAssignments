public class Player {
    private int id;
    private double money;
    private boolean isActive;
    private int location;

    public Player(int id) {
        this.id = id;
        this.location = 0;
        this.money = 100.;
        this.isActive = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    @Override
    public String toString() {
        if (isActive)
            return "Player " + id + ": at " + location + ", has " + money;
        else
            return "Player " + id + ": Failed";
    }

    public double payRent(int housePrice) {
        if (isActive) {
            if (money >= 0.5 * housePrice){
                money -= 0.5 * housePrice;
                return 0.5 * housePrice;
            }
            else {
                isActive = false;
                return money;
            }
        }
        return 0.;
    }

    public void collectRent(double rentPrice) {
        money += rentPrice;
    }

    public boolean buildHouse(Land land, int housePrice) {
        if(land.getHouse() != null || housePrice == 0 || money < housePrice)
            return false;
        else{
            money -= housePrice;
            House newHouse = new House(this, housePrice);
            land.setHouse(newHouse);
            return true;
        }
    }
}
