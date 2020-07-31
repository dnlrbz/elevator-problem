import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElevatorControllerTest {

    private static final int NUMBER_OF_ELEVATORS = 7;

    private ElevatorController elevatorController;

    @BeforeEach
    public void setUp() {
        final BlockingQueue<ElevatorRequest> elevatorRequests = new ArrayBlockingQueue<>(NUMBER_OF_ELEVATORS);
        elevatorController = new ElevatorController(elevatorRequests,NUMBER_OF_ELEVATORS);
    }

    @Test
    public void addRequestTest() throws InterruptedException
    {
        assertEquals(elevatorController.getRequests().size(),0);
        elevatorController.addRequest(new ElevatorRequest(0,35));
        elevatorController.addRequest(new ElevatorRequest(0,35));
        assertEquals(elevatorController.getRequests().size(),2);
    }

    @Test
    public void addWrongRequestTest()
    {
        assertThrows(IllegalArgumentException.class,
            () -> elevatorController.addRequest(new ElevatorRequest(35,35)));
    }
}
