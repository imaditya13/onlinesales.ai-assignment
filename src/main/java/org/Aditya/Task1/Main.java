package org.Aditya.Task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*class contains the main method for running
  the simulation and displaying the results.*/
public class Main {
    public static void main(String[] args) {
        // Initialize event outcomes with their respective probabilities
        List<EventOutcome> eventOutcomes = new ArrayList<>();
        eventOutcomes.add(new EventOutcome("1", 10));
        eventOutcomes.add(new EventOutcome("2", 30));
        eventOutcomes.add(new EventOutcome("3", 15));
        eventOutcomes.add(new EventOutcome("4", 15));
        eventOutcomes.add(new EventOutcome("5", 30));
        eventOutcomes.add(new EventOutcome("6", 0));

        // Create an event generator with the defined outcomes and probabilities
        EventGenerator eventGenerator = new EventGenerator(eventOutcomes);

        // Create an event generator with the defined outcomes and probabilities
        Map<String, Integer> eventOccurrenceCount = new HashMap<>();
        int totalOccurrences = 1000;

        // Simulate event occurrences and update occurrence count
        for (int i = 0; i < totalOccurrences; i++) {
            String eventOutcome = eventGenerator.generateOutcome();
            if(!eventOccurrenceCount.containsKey(eventOutcome))
            {
                eventOccurrenceCount.put(eventOutcome,0);
            }
            eventOccurrenceCount.put(eventOutcome, eventOccurrenceCount.get(eventOutcome) + 1);
        }

        // Display event outcome distribution
        System.out.println("Event outcome distribution after " + totalOccurrences + " occurrences:");
        for (EventOutcome eventOutcome : eventOutcomes) {
            int count = eventOccurrenceCount.getOrDefault(eventOutcome.getEventName(), 0);
            System.out.println(eventOutcome.getEventName() + ": " + count + " times (Expected: " + (totalOccurrences * eventOutcome.getProbability() / 100) + ")");
        }
    }
}

     /*   Event outcome distribution after 1000 occurrences:
        1: 106 times (Expected: 100)
        2: 322 times (Expected: 300)
        3: 146 times (Expected: 150)
        4: 132 times (Expected: 150)
        5: 294 times (Expected: 300)
        6: 0 times (Expected: 0)
       */
