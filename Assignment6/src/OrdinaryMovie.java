public class OrdinaryMovie extends Movie{
    private int ticket;

    public OrdinaryMovie(int type, String name, Time startTime, int hallNumber, int runtime, double price) {
        super(type, name, startTime, hallNumber, runtime, price);
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public double purchase(int arg) {
        if (arg < getTicketsLeft()) {
            ticket += arg;
            setTicketsLeft(getTicketsLeft() - arg);
            return getPrice() * arg;
        }
        else {
            ticket += getTicketsLeft();
            int ticketTemp = getTicketsLeft();
            setTicketsLeft(0);
            return ticketTemp * getPrice();
        }
    }

    @Override
    public String toString() {
        return "id=" + getId() +
                ", name='" + getName() +
                "', startTime:" + getStartTime() +
                ", runtime=" + getRuntime() +
                ", price=" + getPrice() +
                ", ticketsLeft=" + ticketsLeft +
                " OrdinaryMovie";
    }
}
