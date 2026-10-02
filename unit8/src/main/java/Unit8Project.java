/**
 * ============================================================
 * UNIT 8 PROJECT: CAMPUS NAVIGATION SYSTEM
 * ============================================================
 *
 * This project introduces graph data structures by modeling a
 * campus navigation system. Buildings are represented as vertices
 * (nodes) and walking paths between buildings are represented as
 * edges (connections). Students will create an undirected graph
 * using adjacency lists and explore how graph traversal can be
 * used to determine whether routes exist between locations.
 *
 * Learning Objectives:
 * - Understand how graphs model real-world navigation systems
 * - Represent graph data using a HashMap and adjacency lists
 * - Add and manage vertices (buildings) in a graph
 * - Create undirected connections between locations
 * - Implement Breadth-First Search (BFS) for pathfinding
 * - Use HashSet and Queue collections during graph traversal
 * - Practice problem solving with graph algorithms
 * - Create and run JUnit tests to validate graph behavior
 *
 * Real-World Applications:
 * - GPS and route planning systems
 * - Campus and building navigation tools
 * - Social network analysis
 * - Computer and communication networks
 * - Transportation and logistics systems
 *
 * Author: DAVID WOODS
 * Date: 2 OCT 2026
 * ============================================================
 */

import java.util.*;

public class Unit8Project {

    public String getUnitName() {
        return "Unit 8 Project";
    }

    // Graph stores each building as a key and its neighbors as a list of connected buildings.
    private Map<String, List<String>> graph = new HashMap<>();

    public void addBuilding(String building) {

        // Make sure duplicate buildings are not added.
        if (!graph.containsKey(building)){
            // Add the building to the graph.
            // Store the building with an empty neighbor list.

            graph.put(building, new ArrayList<>());
        }
    }

    public void addPath(String from, String to) {
        // Ensure the starting building exists in the graph.
        // Ensure the destination building exists in the graph.
        if(graph.containsKey(from) && graph.containsKey(to)){
            // Add a path from the starting building to the destination building.
            graph.computeIfAbsent(from, value -> new ArrayList<>()).add(to);
            // Add a path from the destination building back to the starting building.
            graph.computeIfAbsent(to, value -> new ArrayList<>()).add(from);
            // This graph is undirected, so paths must work in both directions.

        }

    }

    public List<String> getNeighbors(String building) {
        // Return the list of neighboring buildings for the given building.
        if(graph.containsKey(building)){
           return graph.get(building);
            }

        // Return an empty list if the building does not exist.
        else{
            return new ArrayList<>();
        }

    }

    public boolean hasPath(String start, String goal) {
        // Return false if either building does not exist.
        if(!graph.containsKey(start) || !graph.containsKey(goal)){
            return false;
        }

        // Use Breadth-First Search (BFS) to determine whether a route exists.
        // Create a set to track visited buildings.
        Set<String> visited = new HashSet<>();

        // Create a queue to process buildings in BFS order.
        Queue<String> queue = new LinkedList<>();

        // Add the starting building to the queue and mark it as visited.
        queue.add(start);
        visited.add(start);

        // Continue searching while the queue is not empty.
        while (!queue.isEmpty()) {
            // Remove the next building from the queue.
            String currentBuilding = queue.remove();
            // Return true if the current building is the goal.
            if (currentBuilding.equals(goal)){
                return true;
            }
            visited.add(currentBuilding);
            // Visit each unvisited neighbor and add it to the queue.
            for (String b : getNeighbors(currentBuilding)){
                if (!visited.contains(b)){
                    queue.add(b);
                }
            }
        }
        // Return false if no route is found.
        return false;
    }

    public int size() {
        // Return the number of buildings currently stored in the graph.
        return graph.size();
    }

    public static void main(String[] args) {
        Unit8Project app = new Unit8Project();

        // Add the campus buildings.
        app.addBuilding("Library");
        app.addBuilding("Science Hall");
        app.addBuilding("Gym");
        app.addBuilding("Cafeteria");

        // Create walking paths between buildings.
        app.addPath("Library", "Science Hall");
        app.addPath("Science Hall", "Gym");
        app.addPath("Gym", "Cafeteria");

        // Verify the graph size.
        System.out.println("Number of buildings: " + app.size());

        // Display the neighbors of each building.
        System.out.println("Neighbors of Library: "
                + app.getNeighbors("Library"));

        System.out.println("Neighbors of Science Hall: "
                + app.getNeighbors("Science Hall"));

        // Test whether routes exist between buildings.
        System.out.println("Path from Library to Gym: "
                + app.hasPath("Library", "Gym"));

        System.out.println("Path from Library to Cafeteria: "
                + app.hasPath("Library", "Cafeteria"));

        // Test a building that does not exist.
        System.out.println("Path from Library to Unknown: "
                + app.hasPath("Library", "Unknown"));
    }
}