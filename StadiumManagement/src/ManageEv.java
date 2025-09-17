import java.sql.*;
import java.util.*;

public class ManageEv {
    public void addEvent(Ev event) {
        
        String query = "{ call addev(?,?,?)}";
        
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {
            cs.setString(1, event.getName());
            cs.setDate(2, event.getDate());
            cs.setTime(3, event.getTime());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ev> getAllEvents() {
        List<Ev> events = new ArrayList<>();
        String query = "{ call getview()}";

        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement cs = conn.prepareCall(query);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                Ev event = new Ev();
                event.setEventId(rs.getInt("event_id"));
                event.setName(rs.getString("name"));
                event.setDate(rs.getDate("date"));
                event.setTime(rs.getTime("time"));
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    public void updateEvent(Ev event) {
        String query = "UPDATE events SET name = ?, date = ?, time = ? WHERE event_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, event.getName());
            ps.setDate(2, event.getDate());
            ps.setTime(3, event.getTime());
            ps.setInt(4, event.getEventId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEvent(int eventId) {
        String query = "DELETE FROM events WHERE event_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, eventId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
