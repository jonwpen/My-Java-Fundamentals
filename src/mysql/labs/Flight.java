package mysql.labs;

class Flight {
    private int flightId;
    private int airlineId;
    private String departTime;
    private String arrivalTime;
    private int routeId;
    private String flightStatus;
    private int planeId;
    
    public Flight() {}

    public Flight(int flightId, int airlineId, String departTime, String arrivalTime, int routeId, String flightStatus, int planeId) {
        this.flightId = flightId;
        this.airlineId = airlineId;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.routeId = routeId;
        this.flightStatus = flightStatus;
        this.planeId = planeId;
    }

    public int getFlightId() { return flightId; }
    public int getAirlineId() { return airlineId; }
    public String getDepartTime() { return departTime; }
    public String getArrivalTime() { return arrivalTime; }
    public int getRouteId() { return routeId; }
    public String getFlightStatus() { return flightStatus; }
    public int getPlaneId() { return planeId; }

    public void setFlightId(int flightId) { this.flightId = flightId; }
    public void setAirlineId(int airlineId) { this.airlineId = airlineId; }
    public void setDepartTime(String departTime) { this.departTime = departTime; }
    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }
    public void setRouteId(int routeId) { this.routeId = routeId; }
    public void setFlightStatus(String flightStatus) { this.flightStatus = flightStatus; }
    public void setPlaneId(int planeId) { this.planeId = planeId; }
    
    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", airlineId=" + airlineId +
                ", departTime='" + departTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", routeId=" + routeId +
                ", flightStatus='" + flightStatus + '\'' +
                ", planeId=" + planeId +
                '}';
    }
}