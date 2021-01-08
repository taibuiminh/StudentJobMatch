public class Student {

    private LinkedList attributes;
    private String name;
    private int sizeOfStudentCharacteristic;

    public Student(String name){
        attributes = new LinkedList();
        this.name = name;
        sizeOfStudentCharacteristic = 0;

    }

    public String getName(){
        return name;
    }

    public LinkedList getStudentCharacteristic(){
        return attributes;
    }

    public void addStudentAttribute(Attribute attribute){
        attributes.add(attribute);
        sizeOfStudentCharacteristic++;
    }

    public int size(){
        return sizeOfStudentCharacteristic;
    }

    public String printStudentInfo(){
        return "Student info: \n" + "Name: " + name + "\n" + "List of characteristics: " + toString();
    }

    public String toString(){
        return attributes.toString();
    }


}
