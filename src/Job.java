public class Job {

    private LinkedList listOfAttributes;
    private String name;
    private int sizeOfJobCharacteristic;
    private int score;

    public Job(String name){
        listOfAttributes = new LinkedList();
        this.name = name;
        sizeOfJobCharacteristic = 0;
        score = 0;
    }

    //set Job name
    public String getName(){
        return name;
    }

    //return job's characteristic list
    public LinkedList getJobCharacteristic(){
        return listOfAttributes;
    }

    //set number of matches
    public void setScore(int score){
        this.score = score;
    }

    //return number of matches
    public int getScore(){
        return score;
    }

    //adding new attribute
    public void addJobAttribute(Attribute attribute){
        listOfAttributes.add(attribute);
        sizeOfJobCharacteristic++;
    }

    public int size(){
        return sizeOfJobCharacteristic;
    }

    public String toString(){
       return name + " has next attributes " + listOfAttributes.toString() + " and it has: " + score + " matches\n";
    }
}
