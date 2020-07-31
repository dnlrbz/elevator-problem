public class ElevatorRequest {

    private final long from;
    private final long to;
    private final Direction direction;

    public ElevatorRequest(long from, long to)
    {
        this.from = from;
        this.to = to;
        this.direction = from < to ? Direction.UP : Direction.DOWN;
    }

    public long getFrom()
    {
        return from;
    }

    public long getTo()
    {
        return to;
    }

    @Override
    public String toString()
    {
        return "[" +
            "current floor: " + from +
            ", destination floor: " + to +
            ", direction:" + direction +
            ']';
    }
}
