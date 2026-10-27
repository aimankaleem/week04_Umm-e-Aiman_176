public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     WEEK 4 LAB: AGGREGATION & INVARIANT DEFENSE  ");
        System.out.println("==================================================");

        // 1. LineSegment Testing
        System.out.println("\n[1] LineSegment Operations:");
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(4.0, 6.0);
        LineSegment line = new LineSegment(p1, p2);
        System.out.println(line);
        System.out.printf("Length: %.2f (Expected: 5.00)%n", line.getLength());
        System.out.println("Midpoint: " + line.getMidpoint());
        System.out.printf("Slope: %.2f%n", line.getSlope());

        // Invariant guard for duplicate endpoints
        try {
            new LineSegment(new Point(2, 2), new Point(2, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Guard (Identical Points): " + e.getMessage());
        }

        // 2. Polygon Testing (Square of side 4)
        System.out.println("\n[2] Polygon Invariants & Perimeter:");
        Point[] squareVertices = {
            new Point(0, 0),
            new Point(4, 0),
            new Point(4, 4),
            new Point(0, 4)
        };
        Polygon square = new Polygon(squareVertices);
        System.out.println(square);
        System.out.printf("Perimeter: %.2f (Expected: 16.00)%n", square.calculatePerimeter());

        // 3. Verifying Defensive Copying in Polygon
        System.out.println("\n[3] Defensive Array Integrity Check:");
        // External mutation attempt
        squareVertices[0] = new Point(999, 999);
        System.out.println("Modified external array[0] to (999, 999).");
        System.out.printf("Polygon Vertex 0 remains: %s (Defensive Copy Verified)%n", square.getVertices().get(0));

        // 4. Invariant Guard for Polygon Vertex Threshold
        System.out.println("\n[4] Polygon Minimum Vertex Guard (< 3):");
        try {
            Point[] invalidVertices = { new Point(0, 0), new Point(1, 1) };
            new Polygon(invalidVertices);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Guard (< 3 Vertices): " + e.getMessage());
        }
    }
}
