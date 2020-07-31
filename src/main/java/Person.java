public class Person implements Runnable {

    private final ElevatorController elevatorController;
    private final long officeFloor;

    public Person(ElevatorController elevatorController)
    {
        this.elevatorController = elevatorController;
        this.officeFloor = 1 + (long) (Math.random() * (55 - 1));
    }

    private void goToOffice() throws InterruptedException
    {
        elevatorController.addRequest(new ElevatorRequest(0, officeFloor));
    }

    private void goOutFromOffice() throws InterruptedException
    {
        elevatorController.addRequest(new ElevatorRequest(officeFloor, 0));
    }

    public long getOfficeFloor()
    {
        return officeFloor;
    }

    @Override
    public void run()
    {
        try {
            goToOffice();
            Thread.sleep(3000);
            goOutFromOffice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
