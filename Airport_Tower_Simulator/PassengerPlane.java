package Airport_Tower_Simulator;

public class PassengerPlane extends Aircraft {
    public PassengerPlane(String id) {
        this.id = id;
    }

    @Override
    public void receive(String msg) {
        System.out.println("PassengerPlane " + id + " received: " + msg);
    }
}
