package events.retriever;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import events.response.EventResponse;


import java.io.*;
import java.util.Map;

/**
 * Retrieves events information for the choice selected. Parses the Json and populates the appropriate {@link EventResponse}.
 * @author Ritesh Dalvi
 **/

public class RetrieveEventsInformation {

    private static RetrieveEventsInformation retrieveEventsInformation = null;
    private final Map<Integer,String> choiceByEvent = ImmutableMap.of(1,"Birthday party", 2, "Technical discussion", 3, "Press release",4,"New year party");

    /**
     * Creates a singleton instance of {@link RetrieveEventsInformation}.
     * @return non-null instance of {@link RetrieveEventsInformation}.
     */
    public static RetrieveEventsInformation getInstance() {

        if(retrieveEventsInformation == null) {

            retrieveEventsInformation = new RetrieveEventsInformation();
        }

        return retrieveEventsInformation;
    }
    /**
     * Constructor. Private to avoid direct instantiation.
     */
    private RetrieveEventsInformation() {

    }

    /**
     * Parses the Json information about the event and populates the response depending on the choice of the event.
     * @param choice The choice of the event.
     * @return possibly null {@link EventResponse}.
     */
    public EventResponse retrieveEventsData(int choice) {

        final File directory = new File("./");

        try {

            final FileReader fileReader = new FileReader(directory.getAbsolutePath() + "/src/main/resources/events.json");
            JsonParser jsonParser = new JsonParser();

            JsonElement eventsTree = jsonParser.parse(fileReader);

            final JsonObject eventsArray = eventsTree.getAsJsonObject();
            JsonArray events = eventsArray.getAsJsonArray("events");
            JsonArray informationOfEvents = events.getAsJsonArray();

            EventResponse eventResponse = null;
            for (final Object informationOfEvent : informationOfEvents) {

                JsonObject info = (JsonObject) informationOfEvent;

                final String ocassion = info.get("occasion").getAsString();

                if (ocassion.equals(choiceByEvent.get(choice))) {

                    int inviteCount = info.get("invited_count").getAsInt();
                    int year = info.get("year").getAsInt();
                    int month = info.get("month").getAsInt();
                    int day = info.get("day").getAsInt();

                    eventResponse = new EventResponse();
                    eventResponse.setOccasion(ocassion);
                    eventResponse.setInvitedCount(inviteCount);
                    eventResponse.setYear(year);
                    eventResponse.setMonth(month);
                    eventResponse.setDay(day);

                    break;
                }
            }

            fileReader.close();

            return eventResponse;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
