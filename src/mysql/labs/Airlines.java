package mysql.labs;

//Due to foreign key constraints in my air travel database, this class is required for completed Exercise_04
public class Airlines {
    private int airlineId;
    private String name;

    public Airlines() {
    }

    public Airlines(int airlineId, String name) {
        this.airlineId = airlineId;
        this.name = name;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public String getName() {
        return name;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Airline{" +
               "airlineId=" + airlineId +
               ", name='" + name + '\'' +
               '}';
    }
}
