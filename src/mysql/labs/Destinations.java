package mysql.labs;

//Due to foreign key constraints in my air travel database, this class is required for completed Exercise_04
public class Destinations {
    private int destinationId;
    private String country;
    private String city;
    private String airport;

    public Destinations() {
    }

    public Destinations(int destinationId, String country, String city, String airport) {
        this.destinationId = destinationId;
        this.country = country;
        this.city = city;
        this.airport = airport;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getAirport() {
        return airport;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    @Override
    public String toString() {
        return "Destination{" +
               "destinationId=" + destinationId +
               ", country='" + country + '\'' +
               ", city='" + city + '\'' +
               ", airport='" + airport + '\'' +
               '}';
    }
}

