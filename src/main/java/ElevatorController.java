import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ElevatorController implements Runnable {

    private final BlockingQueue<ElevatorRequest> requests;
    private final int numberOfElevators;

    public ElevatorController(BlockingQueue<ElevatorRequest> requests, int numberOfElevators)
    {
        this.requests = requests;
        this.numberOfElevators = numberOfElevators;
    }

    public BlockingQueue<ElevatorRequest> getRequests()
    {
        return requests;
    }

    public void addRequest(ElevatorRequest request) throws InterruptedException
    {
        if (request.getFrom() == request.getTo()) {
            throw new IllegalArgumentException("start must not be equal the destination,"
                + " when adding a request in ElevatorController ");
        }
        requests.put(request);
    }

    @Override
    public void run()
    {
        Executor executor = Executors.newFixedThreadPool(numberOfElevators);
        for (int i = 0; i < numberOfElevators; i++) {
            executor.execute(new Elevator(requests));
        }
    }
}
