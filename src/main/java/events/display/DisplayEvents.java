package events.display;

import events.perform.DisplayEventsData;
import events.response.EventResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * Display events depending on the selection of the user.
 * @author Ritesh Dalvi
 **/
public class DisplayEvents {

    public static void main(String args[]) {

        while(true) {

            System.out.println("Select enter the number of the event you want to go to:");
            System.out.println("1. Birthday party");
            System.out.println("2. Technical discussion");
            System.out.println("3. Press release");
            System.out.println("4. New year party");
            System.out.println("5: Exist the program");

            final Scanner scanner = new Scanner(System.in);

            System.out.println();
            System.out.print("Punch in your choice: ");
            String choice = scanner.next();

            System.out.println();

            final DisplayEventsData displayEventsData = new DisplayEventsData();

            if (StringUtils.isNumeric(choice)) {

                final EventResponse response = displayEventsData.perform(Integer.valueOf(choice));

                if(response!=null) {

                    System.out.println("Ocassion: "+ response.getOccasion());
                    System.out.println("Invite Count: "+ response.getInvitedCount());
                    System.out.println("Year: "+ response.getYear());
                    System.out.println("Month: "+ response.getMonth());
                    System.out.println("Day: "+ response.getDay());
                }

            } else {

                System.out.println("Please enter a valid choice");
            }

            System.out.println();
        }
    }
}
