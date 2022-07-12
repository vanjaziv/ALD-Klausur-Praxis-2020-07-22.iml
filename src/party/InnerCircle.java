package party;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InnerCircle {
    public List<Person> getFriends(Person person, int level) {
        ArrayList<Person> result = new ArrayList<>();
        HashMap<Person, Integer> distance = new HashMap<>();
        ArrayDeque<Person> queue = new ArrayDeque<>();

        queue.add(person);
        distance.put(person, 0);

        while (!queue.isEmpty()) {
            //Liefern des ersten Elements aus Queue und löschen aus der Queue
            Person cur = queue.remove(); // neim 1. Durchlauf = Andy
            result.add(cur);

            //Wenn die gesuchte Distanz ereicht ist. interessieren mich die Nachbarn nicht mehr
            //Alternative: Alles reinspeichrn und dann aussortieren
            if (distance.get(cur) == level) {
                continue;
            }
            // In current.friends beim 1. Durchlauf die Freunde von Array gespeichert
            for (Person f: cur.friends) {
                // Prüfen, ob manPerson schon besucht hat, denn überspringen
                if (distance.containsKey(f)) {
                    continue;
                }
                queue.add(f);
                distance.put(f, distance.get(cur) + 1);
            }
        }

        return result;
    }
}
