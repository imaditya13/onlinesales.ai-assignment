package org.Aditya.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//class handles the logic of generating outcomes based on probabilities.
class EventGenerator {

    private List<EventOutcome>eventOutcomes = new ArrayList<>();
    private Random random;
    public EventGenerator(List<EventOutcome>eventOutcomes)
    {
        this.eventOutcomes = eventOutcomes;
         random = new Random();
    }
    public String generateOutcome()
    {

        // Select the event outcome if the random value is within the cumulative probability range

        int totalProbability =  eventOutcomes.stream()
                .mapToInt(x-> x.getProbability()).sum();

         int randomValue = random.nextInt(totalProbability)+1;

         int runningProbability=0;
         for(EventOutcome eventOutcome : eventOutcomes)
         {
            runningProbability += eventOutcome.getProbability();

            if(randomValue<=runningProbability)
            {
                return eventOutcome.getEventName();
            }
         }
        return ""; // Shouldn't reach here
    }
}
