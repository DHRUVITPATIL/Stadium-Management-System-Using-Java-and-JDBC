import java.sql.*;
import java.util.*;

public class ManageTk {
    public void addTicket(Tk ticket) {
        String query = "INSERT INTO tickets (event_id, customer_id, seat_number, price) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement cs = conn.prepareStatement(query)) {
            cs.setInt(1, ticket.getEventId());
            cs.setInt(2, ticket.getCustomerId());
            cs.setString(3, ticket.getSeatNumber());
            cs.setDouble(4, ticket.getPrice());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Tk> getAllTickets() {
        List<Tk> tickets = new ArrayList<>();
        String query = "{ call getview2()}";

        try (Connection conn = DatabaseConnection.getConnection();
        CallableStatement cs = conn.prepareCall(query);
        ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                Tk ticket = new Tk();
                ticket.setTicketId(rs.getInt("ticket_id"));
                ticket.setEventId(rs.getInt("event_id"));
                ticket.setCustomerId(rs.getInt("customer_id"));
                ticket.setSeatNumber(rs.getString("seat_number"));
                ticket.setPrice(rs.getDouble("price"));
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    public void updateTicket(Tk ticket) {
        String query = "UPDATE tickets SET event_id = ?, customer_id = ?, seat_number = ?, price = ? WHERE ticket_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, ticket.getEventId());
            ps.setInt(2, ticket.getCustomerId());
            ps.setString(3, ticket.getSeatNumber());
            ps.setDouble(4, ticket.getPrice());
            ps.setInt(5, ticket.getTicketId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTicket(int ticketId) {
        String query = "DELETE FROM tickets WHERE ticket_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, ticketId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
