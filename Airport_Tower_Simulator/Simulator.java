package Airport_Tower_Simulator;

import java.util.*;
import java.util.concurrent.*;

public class Simulator {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        List<Aircraft> aircraftList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int type = random.nextInt(3);
            Aircraft a;
            if (type == 0) {
                a = new PassengerPlane("P" + i);
            } else if (type == 1) {
                a = new CargoPlane("C" + i);
            } else {
                a = new Helicopter("H" + i);
            }
            tower.registerAircraft(a);
            aircraftList.add(a);
        }

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        executor.scheduleAtFixedRate(() -> {
            Aircraft a = aircraftList.get(random.nextInt(aircraftList.size()));
            int action = random.nextInt(10);

            if (action == 0) {
                System.out.println(a.id + " sends MAYDAY!");
                a.send("MAYDAY", tower);
            } else {
                System.out.println(a.id + " requests runway.");
                boolean granted = tower.requestRunway(a);
                if (granted) {
                    Executors.newSingleThreadScheduledExecutor().schedule(tower::releaseRunway, 2, TimeUnit.SECONDS);
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}
