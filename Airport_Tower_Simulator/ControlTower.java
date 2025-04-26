package Airport_Tower_Simulator;

import java.util.*;

public class ControlTower implements TowerMediator {
    private Queue<Aircraft> landingQueue = new LinkedList<>();
    private final Queue<Aircraft> takeoffQueue = new LinkedList<>();
    private boolean runwayAvailable = true;
    private final List<Aircraft> allAircraft = new ArrayList<>();

    public void registerAircraft(Aircraft a) {
        allAircraft.add(a);
    }

    @Override
    public void broadcast(String msg, Aircraft sender) {
        if (msg.equalsIgnoreCase("MAYDAY")) {
            handleEmergency(sender);
        } else {
            for (Aircraft a : allAircraft) {
                if (a != sender) {
                    a.receive(sender.id + ": " + msg);
                }
            }
        }
    }

    @Override
    public boolean requestRunway(Aircraft a) {
        if (runwayAvailable) {
            runwayAvailable = false;
            System.out.println("Tower: Runway granted to " + a.id);
            return true;
        } else {
            System.out.println("Tower: Runway busy, " + a.id + " queued.");
            if (a instanceof PassengerPlane || a instanceof CargoPlane || a instanceof Helicopter) {
                landingQueue.offer(a);
            } else {
                takeoffQueue.offer(a);
            }
            return false;
        }
    }

    private void handleEmergency(Aircraft emergencyAircraft) {
        System.out.println("Tower: EMERGENCY! " + emergencyAircraft.id + " needs immediate landing.");

        for (Aircraft a : allAircraft) {
            if (a != emergencyAircraft) {
                a.receive("Hold position! Emergency in progress for " + emergencyAircraft.id);
            }
        }
        landingQueue.remove(emergencyAircraft);

        if (runwayAvailable) {
            System.out.println("Tower: Emergency landing cleared for " + emergencyAircraft.id);
            runwayAvailable = false;
        } else {
            Queue<Aircraft> temp = new LinkedList<>();
            temp.offer(emergencyAircraft);
            temp.addAll(landingQueue);
            landingQueue = temp;
        }
    }

    public void releaseRunway() {
        runwayAvailable = true;
        processQueues();
    }

    private void processQueues() {
        if (!landingQueue.isEmpty()) {
            Aircraft a = landingQueue.poll();
            System.out.println("Tower: Next landing cleared for " + a.id);
            requestRunway(a);
        } else if (!takeoffQueue.isEmpty()) {
            Aircraft a = takeoffQueue.poll();
            System.out.println("Tower: Next takeoff cleared for " + a.id);
            requestRunway(a);
        }
    }
}
