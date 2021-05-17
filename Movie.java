package CinemaTicket;

public class Movie {
    public String movie_name;
    public int ticket_count;
    public int price;

    public Movie(String movie_name, int ticket_count, int price) {
        this.movie_name = movie_name;
        this.ticket_count = ticket_count;
        this.price = price;
    }

    public Movie() {

    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public int getTicket_count() {
        return ticket_count;
    }

    public void setTicket_count(int ticket_count) {
        this.ticket_count = ticket_count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
