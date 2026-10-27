public class LineSegment {
    private final Point start;
    private final Point end;

    public LineSegment(Point start, Point end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Endpoints of a LineSegment cannot be null.");
        }
        if (start.equals(end)) {
            throw new IllegalArgumentException("Endpoints must be distinct to form a valid line segment.");
        }
        // Defensive copy of endpoints
        this.start = new Point(start);
        this.end = new Point(end);
    }

    public double getLength() {
        return start.distanceTo(end);
    }

    // Midpoint formula: ((x1 + x2)/2, (y1 + y2)/2)
    public Point getMidpoint() {
        double midX = (start.getX() + end.getX()) / 2.0;
        double midY = (start.getY() + end.getY()) / 2.0;
        return new Point(midX, midY);
    }

    // Slope calculation with handling for vertical lines
    public double getSlope() {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        if (Math.abs(dx) < 1e-9) {
            return Double.POSITIVE_INFINITY; // Vertical line
        }
        return dy / dx;
    }

    public Point getStart() { return new Point(start); }
    public Point getEnd() { return new Point(end); }

    @Override
    public String toString() {
        return String.format("LineSegment[%s -> %s, Length=%.2f]", start, end, getLength());
    }
}
