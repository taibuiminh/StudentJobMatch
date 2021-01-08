public class Test {


    public static void main (String[] args){

        System.out.println("========Start of process========\n");


        testJob();
        testStudent();
        testJobArrayList();
        testDouble();


    }

    public static void testJob(){

        System.out.println("--------Test Job class--------");

        Attribute s1 = new Attribute("talented", 3.0);
        Attribute s2 = new Attribute("ambition", 3.0);
        Attribute s3 = new Attribute("work with numbers", 3.0);
        Attribute s4 = new Attribute("creative", 3.0);
        Attribute s5 = new Attribute("critical thinking", 3.0);
        Job job = new Job("IT specialist");

        System.out.println("Is the list is empty?");
        if(job.getJobCharacteristic().isEmpty())
            System.out.println("YES");
        else System.out.println("NO");

        System.out.println("Process: adding elements in the list of job's <" + job.getName() + "> attribute ...");
        job.addJobAttribute(s1);
        job.addJobAttribute(s2);
        job.addJobAttribute(s3);
        job.addJobAttribute(s4);
        job.addJobAttribute(s5);


        System.out.println("The size of list after insertions is: " + job.size());
        System.out.println("Is the list is empty?");
        if(job.getJobCharacteristic().isEmpty())
            System.out.println("YES");
        else System.out.println("NO");
        System.out.println("The current list is:");
        System.out.println(job);

        System.out.println("--------End of Test Job class--------\n");
    }

    public static void testStudent(){

        System.out.println("--------Test Student class--------");


        Attribute s1 = new Attribute("lazy", 3.0);
        Attribute s2 = new Attribute("cool", 3.0);
        Attribute s3 = new Attribute("work with numbers", 3.0);
        Attribute s4 = new Attribute("creative", 3.0);
        Attribute s5 = new Attribute("critical thinking", 3.0);

        Student student = new Student("Dang");

        System.out.println("Process: adding elements in the list of student's <" + student.getName() + "> attribute ...");
        student.addStudentAttribute(s1);
        student.addStudentAttribute(s2);
        student.addStudentAttribute(s3);
        student.addStudentAttribute(s4);
        student.addStudentAttribute(s5);

        System.out.println("The size of list after insertions is: " + student.size());


        System.out.println("The current list is:");
        System.out.println(student);

        System.out.println("--------End of Test Student Job class--------\n");




    }

    public static void testJobArrayList(){

        System.out.println("--------Test JobArrayList class--------");

        Attribute s1 = new Attribute("a", 3.0);
        Attribute s2 = new Attribute("b", 3.0);
        Attribute s3 = new Attribute("work with numbers", 3.0);
        Attribute s4 = new Attribute("creative", 3.0);
        Attribute s5 = new Attribute("critical thinking", 3.0);

        Job j1 = new Job("Delivery guy");
        j1.addJobAttribute(s1);
        Job j2 = new Job("Lawyer");
        j2.addJobAttribute(s2);
        Job j3 = new Job("Pilot");
        j3.addJobAttribute(s3);
        Job j4 = new Job("Fighter");
        j4.addJobAttribute(s4);
        Job j5 = new Job("Doctor");
        j5.addJobAttribute(s5);

        JobArrayList listOfJobs = new JobArrayList();

        listOfJobs.add(j1);
        listOfJobs.add(j2);
        listOfJobs.add(j3);
        listOfJobs.add(j4);
        listOfJobs.add(j5);



        System.out.println("The current size of the ArrayList is : "+listOfJobs.size());
        System.out.println(listOfJobs.toStringArray());
        System.out.println("--------End of Test JobArrayList class--------");

    }

    public static void testDouble(){
        double x = 5.0;
        double y = -1.0;

        System.out.println(x-y);
    }


}
