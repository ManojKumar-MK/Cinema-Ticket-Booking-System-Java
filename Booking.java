package CinemaTicket;

import java.util.concurrent.Callable;

public class Booking implements Callable<Boolean> {
    public int id;
    public int user_id;
    public String name;
    public String movie_name;
    public int ticket_count;
    public int total_amount;
    public String status;

    public Booking() {
    }

    public Booking(int id, int user_id, String name, String movie_name, int ticket_count, int total_amount,String status) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.movie_name = movie_name;
        this.ticket_count = ticket_count;
        this.total_amount = total_amount;
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    @Override
    public Boolean call() throws Exception {

        return true;
    }
}
