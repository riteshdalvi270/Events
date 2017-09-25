package events.perform;

import events.response.EventResponse;
import events.retriever.RetrieveEventsInformation;

/**
 * Displays events data depending on the option selected.
 * @author Ritesh Dalvi
 **/
public class DisplayEventsData {

    private RetrieveEventsInformation retrieveEventsInformation;

    /**
     * Constructor to create instance of {@link DisplayEventsData}. Also creates a singleton instance of {@link RetrieveEventsInformation}.
     */
    public DisplayEventsData() {

       retrieveEventsInformation = RetrieveEventsInformation.getInstance();
    }

    /**
     * Performs the operation of generating information about the event.
     * @param choice The choice selected by the user.
     * @return possibly null {@link EventResponse}.
     */
    public EventResponse perform(int choice) {

        switch (choice) {

            case 1:
            case 2:
            case 3:
            case 4:
                   return retrieveEventsInformation.retrieveEventsData(choice);

            case 5:
                System.exit(0);
            default:
                System.out.println("Choice not supported");
        }

        return null;
    }
}
