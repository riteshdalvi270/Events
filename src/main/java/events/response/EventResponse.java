package events.response;

/**
 * The response of the event selected. Contains information about the event.
 * @author Ritesh Dalvi
 **/
public class EventResponse {

    /**
     * The occasion of the event.
     */
    private String occasion;

    /**
     *  The invite count of the event.
     */
    private int invitedCount;

    /**
     * The year of the event.
     */
    private int year;

    /**
     * The month of the event.
     */
    private int month;

    /**
     * The day of the event.
     */
    private int day;

    /**
     * @return the occasion of the event.
     */
    public String getOccasion() {
        return occasion;
    }

    /**
     * Sets the occasion for the event.
     * @param occasion The occasion to be set.
     */
    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    /**
     * @return the invite count of the event.
     */
    public int getInvitedCount() {
        return invitedCount;
    }

    /**
     * Sets the invite count for the event.
     * @param invitedCount The invite count to be set.
     */
    public void setInvitedCount(int invitedCount) {
        this.invitedCount = invitedCount;
    }


    /**
     * @return the year of the event.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of the event.
     * @param year The year to be set.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the month of the event.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Sets the month of the event.
     * @param month The year to be set.
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the day of the event.
     */
    public int getDay() {
        return day;
    }

    /**
     * Sets the day of the event.
     * @param day The day to be set.
     */
    public void setDay(int day) {
        this.day = day;
    }
}
