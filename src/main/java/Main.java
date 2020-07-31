import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class Main {

    public static void main(String[] args)
    {
        int numberOfElevators = 7;

        final BlockingQueue<ElevatorRequest> elevatorRequests = new ArrayBlockingQueue<>(numberOfElevators);

        ElevatorController elevatorController = new ElevatorController(elevatorRequests, numberOfElevators);

        new Thread(elevatorController).start();

        final int numberOfPeopleInBuilding = 100;

        Executor executor = Executors.newFixedThreadPool(numberOfPeopleInBuilding);
        for (int i = 0; i < 100; i++) {
            executor.execute(new Person(elevatorController));
        }
    }
}
