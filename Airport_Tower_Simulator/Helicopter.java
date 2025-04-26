package Airport_Tower_Simulator;

public class Helicopter extends Aircraft {
    public Helicopter(String id) {
        this.id = id;
    }

    @Override
    public void receive(String msg) {
        System.out.println("Helicopter " + id + " received: " + msg);
    }
}
