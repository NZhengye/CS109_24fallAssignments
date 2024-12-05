public class ThreeDMovie extends Movie{
    private final int GLASS_PRICE = 20;
    private int ticketWithGlass;
    private int ticketWithoutGlass;

    public ThreeDMovie(int type, String name, Time startTime, int hallNumber, int runtime, double price) {
        super(type, name, startTime, hallNumber, runtime, price);
    }

    public int getGLASS_PRICE() {
        return GLASS_PRICE;
    }

    public int getTicketWithGlass() {
        return ticketWithGlass;
    }

    public void setTicketWithGlass(int ticketWithGlass) {
        this.ticketWithGlass = ticketWithGlass;
    }

    public int getTicketWithoutGlass() {
        return ticketWithoutGlass;
    }

    public void setTicketWithoutGlass(int ticketWithoutGlass) {
        this.ticketWithoutGlass = ticketWithoutGlass;
    }

    @Override
    public double purchase(int arg) {
        if (getTicketsLeft() > 0) {
            switch (arg) {
                case 1:
                    ticketWithGlass++;
                    setTicketsLeft(getTicketsLeft() - 1);
                    return getPrice() + GLASS_PRICE;
                case 0:
                    ticketWithoutGlass++;
                    setTicketsLeft(getTicketsLeft() - 1);
                    return getPrice();
                default:
                    return 0;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "id=" + getId() +
                ", name='" + getName() +
                "', startTime:" + getStartTime() +
                ", runtime=" + getRuntime() +
                ", price=" + getPrice() +
                ", ticketsLeft=" + ticketsLeft +
                " ThreeDMovie";
    }
}
