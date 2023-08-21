package mysql.labs;

//Due to foreign key constraints in my air travel database, this class is required for completed Exercise_04
public class Route {
    private int routeId;
    private int departingDest;
    private int arrivingDest;

    public Route() {
    }

    public Route(int routeId, int departingDest, int arrivingDest) {
        this.routeId = routeId;
        this.departingDest = departingDest;
        this.arrivingDest = arrivingDest;
    }

    public int getRouteId() {
        return routeId;
    }

    public int getDepartingDest() {
        return departingDest;
    }

    public int getArrivingDest() {
        return arrivingDest;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public void setDepartingDest(int departingDest) {
        this.departingDest = departingDest;
    }

    public void setArrivingDest(int arrivingDest) {
        this.arrivingDest = arrivingDest;
    }

    @Override
    public String toString() {
        return "Route{" +
               "routeId=" + routeId +
               ", departingDest=" + departingDest +
               ", arrivingDest=" + arrivingDest +
               '}';
    }
}
