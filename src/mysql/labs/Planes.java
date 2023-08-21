package mysql.labs;

//Due to foreign key constraints in my air travel database, this class is required for completed Exercise_04
public class Planes {
    private int planeId;
    private String manufacturer;
    private String model;

    public Planes() {
    }

    public Planes(int planeId, String manufacturer, String model) {
        this.planeId = planeId;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public int getPlaneId() {
        return planeId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Plane{" +
               "planeId=" + planeId +
               ", manufacturer='" + manufacturer + '\'' +
               ", model='" + model + '\'' +
               '}';
    }
}
