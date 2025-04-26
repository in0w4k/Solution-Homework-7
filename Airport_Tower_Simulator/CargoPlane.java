package Airport_Tower_Simulator;

public class CargoPlane extends Aircraft {
    public CargoPlane(String id) {
        this.id = id;
    }

    @Override
    public void receive(String msg) {
        System.out.println("CargoPlane " + id + " received: " + msg);
    }
}
