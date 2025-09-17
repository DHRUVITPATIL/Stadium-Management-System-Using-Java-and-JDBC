import java.sql.Date;
import java.sql.Time;

public class Ev {
    private int eventId;
    private String name;
    private Date date;
    private Time time;
    

    // Constructors, getters, and setters
    public Ev() {
    }

    public Ev(String name, Date date, Time time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

   
}
