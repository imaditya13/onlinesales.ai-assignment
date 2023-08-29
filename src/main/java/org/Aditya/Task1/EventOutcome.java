package org.Aditya.Task1;

//class represents their outcomes(names) along with their probabilities.
class EventOutcome {
   private String eventName;
   private Integer probability;

   public EventOutcome(String eventName, Integer probability)
   {
       this.eventName = eventName;
       this.probability = probability;
   }

   //Getter and Setter methods
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getProbability() {
        return probability;
    }

    public void setProbability(Integer probability) {
        this.probability = probability;
    }
}
