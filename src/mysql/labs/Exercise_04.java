package mysql.labs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
*  MySQL Exercise 4:
*
*   Now that you have mastered your air travel database, it's time to connect this DB to a Java application
*   using JDBC. You can start simple here and build your way up. Within a Java application, using JDBC, please
*   demonstrate how to:
*
*   Note: CRUD means (Create, Read, Update, Delete)
*
*       1.) CRUD new flights
*       2.) CRUD new passengers
*       3.) Bonus: flex those JDBC muscles! How nice, clean, useful can you make this? Show us what you've got!
*
*   Caution: Before you push this code to GitHub, be sure to REMOVE or REPLACE your DATABASE PASSWORD.
*
 */

public class Exercise_04 {

	public static void main(String[] args) {
	    AirlineData airlineData = new AirlineData();
	    airlineData.connect();

	    //Create Airlines, Planes, Destinations, and a Route. These are all Flight dependencies.
	    int airlineId = airlineData.createAirline("AirExpress");
	    int planeId = airlineData.createPlane("Boeing", "747");
	    int destination1 = airlineData.createDestination("USA", "New York", "JFK Airport");
	    int destination2 = airlineData.createDestination("UK", "London", "Heathrow Airport");
	    int routeId = airlineData.createRoute(destination1, destination2);

	    //Create a Flight using previously created Airline, Plane, and Route.
	    Flight flight = new Flight(0, airlineId, "2023-08-21 10:00:00", "2023-08-21 12:00:00", routeId, "Scheduled", planeId);
	    int flightId = airlineData.createFlight(flight); 
	    flight.setFlightId(flightId); //Update the flight object with the generated ID
	    System.out.println("Flight created!");

	    Flight queriedFlight = airlineData.queryFlight(flightId);
	    System.out.println("Queried Flight: " + queriedFlight);

	    //Update the departure time of the Flight
	    flight.setDepartTime("2023-08-21 11:00:00");
	    airlineData.updateFlight(flight);
	    System.out.println("Flight updated!");

	    queriedFlight = airlineData.queryFlight(flightId);
	    System.out.println("Queried Flight: " + queriedFlight);

	    //Delete Flight by ID
	    airlineData.deleteFlight(flightId);
	    System.out.println("Flight deleted!");

	    //Create a Passenger
	    Passenger passenger = new Passenger(0, "John", "Pennington", "jonwpen@gmail.com", "1987-08-14", "5554977656");
	    int passengerId = airlineData.createPassenger(passenger); // generated passenger ID
	    System.out.println("Passenger created!");

	    //Query Passenger by ID
	    Passenger queriedPassenger = airlineData.queryPassenger(passengerId);
	    System.out.println("Queried Passenger: " + queriedPassenger);

	    //Update email of the Passenger
	    passenger.setEmail("john.johngmail@gmail.com");
	    airlineData.updatePassenger(passenger);
	    System.out.println("Passenger updated!");

	    //Query Passenger by ID again to check for update
	    queriedPassenger = airlineData.queryPassenger(passengerId); //Re-query the passenger to get the updated values
	    System.out.println("Queried Passenger: " + queriedPassenger);

	    //Delete Passenger by ID
	    airlineData.deletePassenger(passengerId);
	    System.out.println("Passenger deleted!");

	    //Clean Up: Delete related data created earlier
	    airlineData.deleteRoute(routeId);
	    airlineData.deleteDestination(destination2);
	    airlineData.deleteDestination(destination1);
	    airlineData.deletePlane(planeId);
	    airlineData.deleteAirline(airlineId);

	    airlineData.disconnect();
	}
}

class AirlineData{ //Database connection class for handling all CRUD operations
	
    private Connection connection;

    public AirlineData() {
        String url = "jdbc:mysql://localhost/johns_airtravel_DB?user=root&password=JaneVerbana@7&useSSL=false&allowPublicKeyRetrieval=true";
        
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Error initializing database connection: " + e.getMessage());
        }
    }

    public void connect() {
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Database connected successfully");
            } else {
                System.out.println("Database connection is not active");
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }
    
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database disconnected successfully");
            }
        } catch (SQLException e) {
            System.out.println("Error disconnecting from database: " + e.getMessage());
        }
    }

    public int createFlight(Flight flight) {
        String sql = "INSERT INTO flights (airline_id, depart_time, arrival_time, route_id, flight_status, plane_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, flight.getAirlineId());
            pstmt.setString(2, flight.getDepartTime());
            pstmt.setString(3, flight.getArrivalTime());
            pstmt.setInt(4, flight.getRouteId());
            pstmt.setString(5, flight.getFlightStatus());
            pstmt.setInt(6, flight.getPlaneId());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        System.out.println("Flight created successfully with ID: " + generatedId);
                        return generatedId; 
                    }
                }
            } else {
                System.out.println("No rows affected. Flight creation failed.");
            }
        } catch (SQLException e) {
            System.out.println("Error creating flight: " + e.getMessage());
        }
        return -1; 
    }

    public Flight queryFlight(int id) {
        String sql = "SELECT * FROM flights WHERE flight_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Flight(resultSet.getInt("flight_id"),
                                      resultSet.getInt("airline_id"),
                                      resultSet.getString("depart_time"),
                                      resultSet.getString("arrival_time"),
                                      resultSet.getInt("route_id"),
                                      resultSet.getString("flight_status"),
                                      resultSet.getInt("plane_id"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error querying flight: " + e.getMessage());
        }
        return null;
    }

    public void updateFlight(Flight flight) {
        String sql = "UPDATE flights SET airline_id = ?, depart_time = ?, arrival_time = ?, route_id = ?, flight_status = ?, plane_id = ? WHERE flight_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, flight.getAirlineId());
            pstmt.setString(2, flight.getDepartTime());
            pstmt.setString(3, flight.getArrivalTime());
            pstmt.setInt(4, flight.getRouteId());
            pstmt.setString(5, flight.getFlightStatus());
            pstmt.setInt(6, flight.getPlaneId());
            pstmt.setInt(7, flight.getFlightId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating flight: " + e.getMessage());
        }
    }

    public void deleteFlight(int id) {
        String sql = "DELETE FROM flights WHERE flight_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting flight: " + e.getMessage());
        }
    }
    
    public int createPassenger(Passenger passenger) {
        String sql = "INSERT INTO passengers (first_name, last_name, email, date_of_birth, phone) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, passenger.getFirstName());
            pstmt.setString(2, passenger.getLastName());
            pstmt.setString(3, passenger.getEmail());
            pstmt.setString(4, passenger.getDateOfBirth());
            pstmt.setString(5, passenger.getPhone());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        passenger.setPassengerId(generatedId); //Update the passenger object's ID
                        System.out.println("Passenger created successfully with ID: " + generatedId);
                        return generatedId;
                    }
                }
            } else {
                System.out.println("No rows affected. Passenger creation failed.");
            }
        } catch (SQLException e) {
            System.out.println("Error creating passenger: " + e.getMessage());
        }
        return -1;
    }
    
    public Passenger queryPassenger(int id) {
        String sql = "SELECT * FROM passengers WHERE passender_id = ?"; 
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Passenger(resultSet.getInt("passender_id"), 
                                         resultSet.getString("first_name"),
                                         resultSet.getString("last_name"),
                                         resultSet.getString("email"),
                                         resultSet.getString("date_of_birth"),
                                         resultSet.getString("phone"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error querying passenger: " + e.getMessage());
        }
        return null; 
    }

    public void updatePassenger(Passenger passenger) {
        String sql = "UPDATE passengers SET first_name = ?, last_name = ?, email = ?, date_of_birth = ?, phone = ? WHERE passender_id = ?"; 
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, passenger.getFirstName());
            pstmt.setString(2, passenger.getLastName());
            pstmt.setString(3, passenger.getEmail());
            pstmt.setString(4, passenger.getDateOfBirth());
            pstmt.setString(5, passenger.getPhone());
            pstmt.setInt(6, passenger.getPassengerId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating passenger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deletePassenger(int id) {
        String sql = "DELETE FROM passengers WHERE passender_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting passenger: " + e.getMessage());
        }
    }
    
    public int createAirline(String name) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO airlines (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error creating airline: " + e.getMessage());
        }
        return -1; 
    }

    public void deleteAirline(int id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM airlines WHERE airline_id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting airline: " + e.getMessage());
        }
    }

    public int createPlane(String manufacturer, String model) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO planes (manufacturer, model) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, manufacturer);
            statement.setString(2, model);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error creating plane: " + e.getMessage());
        }
        return -1; 
    }

    public void deletePlane(int id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM planes WHERE plane_id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting plane: " + e.getMessage());
        }
    }

    public int createDestination(String country, String city, String airport) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO destinations (country, city, airport) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, country);
            statement.setString(2, city);
            statement.setString(3, airport);
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error creating destination: " + e.getMessage());
        }
        return -1;
    }

    public void deleteDestination(int id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM destinations WHERE destination_id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting destination: " + e.getMessage());
        }
    }

    public int createRoute(int departingDest, int arrivingDest) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO route (departing_dest, arriving_dest) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, departingDest);
            statement.setInt(2, arrivingDest);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error creating route: " + e.getMessage());
        }
        return -1; 
    }

    public void deleteRoute(int id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM route WHERE route_id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting route: " + e.getMessage());
        }
    }
}







