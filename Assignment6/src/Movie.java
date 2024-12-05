abstract class Movie {
    private static int count = 0;
    private int id;
    private int type;
    private String name;
    private Time startTime;
    private int hallNumber;
    private int runtime;
    private double price;
    protected int ticketsLeft;
    private int startTimeInMinutes;
    private int endTimeInMinutes;

    public Movie(int type, String name, Time startTime, int hallNumber, int runtime, double price) {
        this.id = ++count;
        this.type = type;
        this.name = name;
        this.startTime = startTime;
        this.hallNumber = hallNumber;
        this.runtime = runtime;
        this.price = price;
        this.startTimeInMinutes = startTime.timeInMinutes();
        this.endTimeInMinutes = this.startTimeInMinutes + runtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTicketsLeft() {
        return ticketsLeft;
    }

    public void setTicketsLeft(int ticketsLeft) {
        this.ticketsLeft = ticketsLeft;
    }

    public int getEndTimeInMinutes() {
        return endTimeInMinutes;
    }

    public void setEndTimeInMinutes(int endTimeInMinutes) {
        this.endTimeInMinutes = endTimeInMinutes;
    }

    public int getStartTimeInMinutes() {
        return startTimeInMinutes;
    }

    public void setStartTimeInMinutes(int startTimeInMinutes) {
        this.startTimeInMinutes = startTimeInMinutes;
    }

    public abstract double purchase(int arg);

    @Override
    public String toString() {
        return
                "id=" + id + ", name='" + name +
                        "', startTime:" + startTime +
                        ", runtime=" + runtime +
                        ", price=" + price +
                        ", ticketsLeft=" + ticketsLeft;
    }
}
