import java.util.concurrent.BlockingQueue;

public class Elevator implements Runnable {

    private final BlockingQueue<ElevatorRequest> requests;

    public Elevator(BlockingQueue<ElevatorRequest> requests)
    {
        this.requests = requests;
    }

    @Override
    public void run()
    {
        while (true) {
            try {
                elevate(requests.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void elevate(ElevatorRequest elevatorRequest) throws InterruptedException
    {
        System.out.println(elevatorRequest.toString());
        Thread.sleep(2000);
    }
}
