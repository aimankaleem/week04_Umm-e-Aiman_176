# Week 04: Dynamic Aggregation, Collections & Structural Invariants

## Student Information
- **Name:** Umm-e-Aiman
- **Seat Number:** 176
- **Course:** Object-Oriented Programming (CS)

---

## Technical Architecture & Core Classes

1. **`Point` (Value Object Evolution):**
   - Implements immutable 2D coordinates.
   - Overrides `equals()` and `hashCode()` following the Java standard contract to enable safe comparison in data structures.

2. **`LineSegment` (Composition of Endpoints):**
   - Composed of two distinct `Point` objects.
   - Calculates Euclidean length, geometric midpoint, and line slope (with safeguards for undefined vertical lines).
   - Enforces the invariant that endpoints must not be identical.

3. **`Polygon` (Dynamic Collection Aggregation):**
   - Aggregates an arbitrary sequence of `Point` vertices using `List<Point>`.
   - Invariant enforcement: rejects null inputs, null elements, and sequences with fewer than 3 vertices.
   - Perimeter calculation iterates cyclically using modulus arithmetic (`(i + 1) % n`).
   - Deep defensive copying shields internal vertices from external array or list mutations.

---

## Compilation & Execution Guide

```bash
# Compile all source files
javac src/*.java

# Run test suite
java -cp src Main

# Capture output into text file
java -cp src Main > SampleOutput.txt