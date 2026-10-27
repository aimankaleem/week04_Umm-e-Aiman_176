import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Polygon {
    private final List<Point> vertices;

    // Constructor accepting an array of vertices
    public Polygon(Point[] pts) {
        if (pts == null) {
            throw new IllegalArgumentException("Vertex array cannot be null.");
        }
        if (pts.length < 3) {
            throw new IllegalArgumentException("A polygon requires at least 3 vertices.");
        }

        this.vertices = new ArrayList<>();
        for (Point p : pts) {
            if (p == null) {
                throw new IllegalArgumentException("Vertices cannot contain null elements.");
            }
            // Defensive copying each point into internal list
            this.vertices.add(new Point(p));
        }
    }

    // Constructor accepting a List of points
    public Polygon(List<Point> pts) {
        if (pts == null) {
            throw new IllegalArgumentException("Vertex list cannot be null.");
        }
        if (pts.size() < 3) {
            throw new IllegalArgumentException("A polygon requires at least 3 vertices.");
        }

        this.vertices = new ArrayList<>();
        for (Point p : pts) {
            if (p == null) {
                throw new IllegalArgumentException("Vertices cannot contain null elements.");
            }
            this.vertices.add(new Point(p));
        }
    }

    public int getVertexCount() {
        return vertices.size();
    }

    // Perimeter: sum of distances between sequential vertices plus last-to-first
    public double calculatePerimeter() {
        double perimeter = 0.0;
        int n = vertices.size();
        for (int i = 0; i < n; i++) {
            Point current = vertices.get(i);
            Point next = vertices.get((i + 1) % n); // Wraps around to 0
            perimeter += current.distanceTo(next);
        }
        return perimeter;
    }

    // Returns a defensive list copy
    public List<Point> getVertices() {
        List<Point> copy = new ArrayList<>();
        for (Point p : vertices) {
            copy.add(new Point(p));
        }
        return Collections.unmodifiableList(copy);
    }

    @Override
    public String toString() {
        return String.format("Polygon[Vertices=%d, Perimeter=%.2f]", vertices.size(), calculatePerimeter());
    }
}
