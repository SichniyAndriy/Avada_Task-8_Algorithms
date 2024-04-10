package ch_07;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Vertex {
    @Setter
    private int index;
    private final String name;
    private final Map<Vertex, Integer> neighbors;

    private Vertex(String name) {
        this.name = name;
        neighbors = new HashMap<>();
    }

    public static Vertex of(String name) {
        return new Vertex(name);
    }

    public void addNeighbor(Vertex vertex, Integer distance) {
        neighbors.put(vertex, distance);
    }

    public void removeNeighbor(Vertex vertex) {
        neighbors.remove(vertex);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(name);
        stringBuilder.append(" : { ");
        for (var el: neighbors.entrySet()) {
            stringBuilder.append(el.getKey().name).append(" - ").append(el.getValue()).append(", ");
        }
        if (stringBuilder.charAt(stringBuilder.length() - 2) == ',') {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
