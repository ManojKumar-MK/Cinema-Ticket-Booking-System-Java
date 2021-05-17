package CinemaTicket;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainPage {

    public static void main(String arg[]) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        int login_choice,admin_choice,customer_choice;
        ArrayList<Movie> list = new ArrayList<>();
        ArrayList<User> userList = new ArrayList<>();
        ArrayList<Booking> bookingList = new ArrayList<>();


        Random random = new Random();
        do {

            System.out.println("Module Select");

            System.out.println("1.Admin Module");

            System.out.println("2.Customer Module");

            System.out.println("0.Exit");

            System.out.println("Enter the Choice :");
            login_choice  = scan.nextInt();

            switch (login_choice) {
                case 1:
                    System.out.println("You are in admin Module");
                    do {
                        System.out.println("1.Add New Movie");
                        System.out.println("2.View List");
                        System.out.println("3.Delete Movie");
                        System.out.println("4.Back");
                        System.out.println("0.Exit");

                        System.out.println("Enter the Choice");
                        admin_choice = scan.nextInt();


                        switch (admin_choice) {
                            case 1:
                                System.out.println("You are in Add New Movie");
                                list.add(new Movie("Bigil", 100, 300));

                                list.add(new Movie("Mersal", 50, 400));

                                list.add(new Movie("Sarkar", 200, 800));

                                System.out.println("Movie Added Successfully");

                                admin_choice = 9;

                                break;

                            case 2:

                                System.out.println("You are in View Movie");
                                if (list.size() <= 0) {
                                    System.out.println("No Movies Added ");
                                    admin_choice = 9;
                                } else {
                                    System.out.println("\t\t\t-----------------------------------------------------------------------------");
                                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t" + "Cinema Ticket Booking" + "\t\t\t\t\t\t\t\t\t");
                                    System.out.println("\t\t\t-----------------------------------------------------------------------------");
                                    System.out.println("\t\t\t\t" + "Movies" + "\t\t\t\t | " + "\t\t\t\t" + "Tickets" + "\t\t\t |" + "\t\t\t" + "Price" + "\t\t\t");
                                    System.out.println("\t\t\t-----------------------------------------------------------------------------");
                                    for (Movie m : list) {
                                        System.out.print("\t\t\t\t" + m.movie_name + "\t\t\t\t | " + "\t\t\t\t" + m.ticket_count + "\t\t\t\t |" + "\t\t\t" + "Rs. " + m.price + "\t\t\t");
                                        System.out.println();

                                    }
                                }
                                admin_choice = 9;
                                break;

                            case 3:

                                System.out.println("Enter the Movie name To Delete ");
                                String m_name = scan.next();
                                for (int i = 0; i < list.size(); i++) {
                                    if (list.get(i).getMovie_name().equals(m_name)) {
                                        list.remove(i);
                                        System.out.println("Movie Deleted From list");
                                    }

                                    admin_choice = 9;
                                }
                                break;
                            case 4:
                                break;

                            case 0:
                                System.out.println("Thank You For Using");

                                return;

                            default:
                                System.out.println("Enter Valid Key Choice");
                                admin_choice = 9;

                        }

                        if (admin_choice == 4) {
                            login_choice = 9;
                            break;
                        }


                    } while (admin_choice == 9);
                    break;

                case 2:
                    System.out.println("You are in Customer module");


                        do {
                            System.out.println("1.Ticket Booking");
                            System.out.println("2.Show Movie List");
                            System.out.println("3.Show My Ticket");
                            System.out.println("4.Cancel Ticket");
                            System.out.println("5.Back");
                            System.out.println("6.Exit");

                            System.out.println("Enter the Choice : ");
                            customer_choice = scan.nextInt();
                            switch (customer_choice) {
                                case 1:

                                    int user_id = random.nextInt(1000);
                                    System.out.println("Enter the Name For User ID :"+user_id );
                                    String name = scan.next();
                                    //System.out.println("Enter the Password For User ID :"+user_id );
                                    int password = 2000;
                                    System.out.println("Enter the Phone For User ID :"+user_id );
                                    String phone = scan.next();
                                    System.out.println("Enter the Movie Name  :" );
                                    String movie_name = scan.next();
                                    for (int i = 0; i < list.size(); i++) {
                                        Movie m = list.get(i);

                                        if (m.movie_name.equals(movie_name)) {
                                            int booking_id = random.nextInt(1000);
                                            System.out.println("Enter How Many Tickets Want : ");
                                            int ticket_count = scan.nextInt();
                                            if (m.ticket_count > ticket_count) {
                                                int amount = ticket_count * m.price;
                                                int remains = m.ticket_count - ticket_count;
                                                m.setTicket_count(remains);

                                                list.set(i, m);
                                                String status = "paid";
                                                userList.add(new User(user_id, phone, name,password));
                                                bookingList.add(new Booking(booking_id, user_id, name, movie_name, ticket_count, amount,status));
                                                printTicket(booking_id, user_id, name, movie_name, ticket_count, amount,status);
                                                System.out.println("\t\t\t\t---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                                System.out.println("\t\t\t\t------------------------------------------------ THANK YOU FOR BOOKING ------------------------------------------- \t\t\t\t");
                                                System.out.println("\t\t\t\t---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                                                customer_choice = 9;

                                            } else if (m.ticket_count < ticket_count) {
                                                System.out.println("Low Number of Tickets available For That Show");
                                                customer_choice = 9;
                                            } else if (m.ticket_count == 0) {
                                                System.out.println("No Tickets available For That Show");
                                                customer_choice = 9;
                                            }


                                        }
                                    }
                                    break;


                                case 2:
                                    //ArrayList<String> movie_name_list = new ArrayList<>();

                                    if (list.size() <= 0) {
                                        System.out.println("\t\t\t\t------------------------------------------------------------------------");
                                        System.out.println("\t\t\t\t-------------------- No Movies Premiering Now ----------------- \t\t\t\t");
                                        System.out.println("\t\t\t\t------------------------------------------------------------------------");
                                    } else {
                                        System.out.println("\t\t\t-----------------------------------------------------------------------------");
                                        System.out.println("\t\t\t\t\t\t\t\t ------------ Movies Premiering Now ----------- \t\t\t\t");
                                        System.out.println("\t\t\t-----------------------------------------------------------------------------");
                                        System.out.println("\t\t\t\t" + "Movies" + "\t\t\t\t | " + "\t\t\t\t" + "Tickets" + "\t\t\t |" + "\t\t\t" + "Price" + "\t\t\t");
                                        System.out.println("\t\t\t-----------------------------------------------------------------------------");
                                        for (Movie m : list) {

                                            System.out.print("\t\t\t\t " + m.movie_name + " \t\t\t\t | \t\t\t\t " + m.ticket_count + " \t\t\t\t | \t\t\t\t " + "Rs." + m.price + " \t\t\t\t");

                                            System.out.println();
                                        }
                                    }
                                    customer_choice = 9;


                                case 3:
                                    // SHOW MY Ticket
                                    System.out.println("Enter the Name : ");
                                    String enterName = scan.next();
                                    for(Booking b : bookingList)
                                    {
                                        if(b.name.equals(enterName))
                                            printTicket(b.id, b.user_id, b.name, b.movie_name, b.ticket_count, b.total_amount,b.status);
                                    }

                                    System.out.println("\t\t\t\t---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println("\t\t\t\t------------------------------------------------ THANK YOU FOR BOOKING ------------------------------------------- \t\t\t\t");
                                    System.out.println("\t\t\t\t---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                                    customer_choice = 9;

                                    break;


                                case 4:
                                    System.out.println("Enter the Name : ");
                                    String cancelName = scan.next();
                                    for(int i=0;i<bookingList.size();i++)
                                    {
                                        Booking b = bookingList.get(i);
                                        if(b.name.equals(cancelName)) {
                                            printTicket(b.id, b.user_id, b.name, b.movie_name, b.ticket_count, b.total_amount,b.status);
                                            System.out.println("Enter the Booking id to Cancel : ");
                                            int cancel_id = scan.nextInt();

                                             if(b.id == cancel_id)
                                            {
                                                bookingList.get(i).setStatus("Canceled");
                                            }
                                             else
                                             {
                                                 System.out.println("No Tickets in that id");
                                             }
                                        }
                                        else {
                                            System.out.println("No Name in Booking List ");
                                        }
                                    }
                                    customer_choice=9;
                                    break;



                                case 5:
                                    break;
                                case 6:
                                    System.out.println("Thank You For Using ");
                                    return;

                                default:
                                    System.out.println("Enter the Valid Choice");
                                    customer_choice = 9;
                            }
                            if (customer_choice == 5) {
                                login_choice = 9;
                                break;
                            }

                        } while (customer_choice == 9);




                    break;

                case 0:
                    System.out.println("Thank You For Using Exit---->");
                    return;
                default:
                    System.out.println("Enter Valid Key Choice");
                    login_choice=9;

            }



        }while (login_choice==9);

    }



    private static void printTicket(int booking_id, int user_id, String name, String movie_name, int ticket_count, int amount,String status) {
        System.out.println("\t\t\t\t---------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t------------------------------------------ Cinema Ticket ------------------------------------------- \t\t\t\t");
        System.out.println("\t\t\t\t---------------------------------------------------------------------------------------------------------------------");
        System.out.println(" \t\t ID \t\t | \t\t USER_ID \t\t | \t\t NAME \t\t | \t\t MOVIE \t\t | \t\t TICKETS \t\t |  \t\t AMOUNT \t\t |  \t\t STATUS \t\t ");
        System.out.println(" \t\t "+booking_id+" \t\t | \t\t "+user_id+" \t\t | \t\t "+name+" \t\t | \t\t "+movie_name+" \t\t | \t\t "+ticket_count+" \t\t\t |  \t\t "+"Rs."+amount+" \t\t | \t\t "+status+" \t\t");
    }


}
