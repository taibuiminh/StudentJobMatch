public class Algorithm {

    final  boolean DEBUG = true;


    public  void simulatorFromProgramm(){

        //creating a test student
        Student student = new Student("Dang");

        //list of his characteristics
        String[] listStudentCharac = {"стрессоустойчивость", "доброжелательность", "аналитическое мышление", "внимательность", "выносливость к эмоциональным нагрузкам", "жесткость",
                                      "гибкость", "коммуникабельность", "авторитаризм", "усидчивость"};
        double[] listStudentLevels = {4.0, 5.0, 2.0, 2.0, 3.0, 4.0, 1.0, 4.0, 5.0, 1.0};

        for(int i = 0; i < listStudentCharac.length; i++){
            student.addStudentAttribute(new Attribute(listStudentCharac[i], listStudentLevels[i]));
        }

        //creating an array of Jobs
        JobArrayList list = new JobArrayList();


        //first job
        Job job1 = new Job("Менеджер по кредитованию");
        String[] listJob1Charac = {"аналитическое мышление", "быстрая обучаемость", "внимательность", "грамотная речь", "дипломатичность", "коммуникабельность",
                                  "концентрация", "опрятность", "ответственность", "память", "способность обрабатывать большие объемы информации",
                                  "стрессоустойчивость", "уравновешенность"};
        double[] managerLevels = {3.0, 3.0, 3.0, 4.0, 4.0, 5.0, 3.0, 4.0, 5.0, 3.0, 4.0, 4.0, 4.0};

        for(int i = 0; i < listJob1Charac.length; i++){
            job1.addJobAttribute(new Attribute(listJob1Charac[i], managerLevels[i]));
        }

        list.add(job1);

        //second job
        Job job2 = new Job("Финанист");
        String[] listJob2Charac = {"коммуникабельность", "концентрация", "ответственность", "скрупулезность", "способность обрабатывать большие объемы информации",
                                   "стратегическое мышление", "стрессоустойчивость", "усидчивость", "целеустремленность", "эмоциональность", "эрудированность" };

        double[] finacialLevels = {3.0, 3.0, 3.0, 4.0, 4.0, 5.0, 3.0, 4.0, 5.0, 3.0, 4.0};
        for(int i = 0; i < listJob2Charac.length; i++){
            job2.addJobAttribute(new Attribute(listJob2Charac[i], finacialLevels[i]));
        }

        list.add(job2);


        addingComparisingData(list, student);


        if(DEBUG) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
            System.out.println(list.toStringArray());
        }


        System.out.println("Best job for " + student.getName() + " is " + choosingBestJob(list).getName());



    }

    public  void addingComparisingData(JobArrayList list, Student student){
        for(int i = 0; i < list.size(); i++){
            list.get(i).setScore(findingMatch(student, list.get(i)));
        }
    }

    public  Job choosingBestJob(JobArrayList list){
        Job job = null;
        int bestScore = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getScore() > bestScore) {
                bestScore = list.get(i).getScore();
                job = list.get(i);
            }

        }
        return job;
    }




    private  int findingMatch(Student student, Job job){

        int countMatch = 0;
        Node studentNode = student.getStudentCharacteristic().getTop();
        Node jobNode = job.getJobCharacteristic().getTop();

        if(DEBUG)
        System.out.println("Analyzing: " + job.getName());

        //if the list of the student's attributes is shorter than job's attributes
        if(student.size() < job.size()) {
            while (studentNode != null) {

                while (jobNode != null) {
                    if (studentNode.getName().equals(jobNode.getName()) && (studentNode.getLevel() - jobNode.getLevel()) >= 0 &&  (studentNode.getLevel() - jobNode.getLevel()) < studentNode.getLevel()) {
                        countMatch++;
                        if(DEBUG)
                        System.out.println("Current characteristic of " + job.getName() + " is: " + studentNode.getName());
                    }
                    jobNode = jobNode.getNext();
                }
                jobNode = job.getJobCharacteristic().getTop();

                studentNode = studentNode.getNext();
            }

        //if the list of the job's attributes is shorter than student's attributes
        }else{
            while(jobNode != null){


                while(studentNode != null){
                    if (jobNode.getName().equals(studentNode.getName()) && (studentNode.getLevel() - jobNode.getLevel()) >= 0 &&  (studentNode.getLevel() - jobNode.getLevel()) < studentNode.getLevel()) {
                        countMatch++;
                        if(DEBUG)
                        System.out.println("There is a match with " + job.getName() + " and it is " + studentNode.getName());
                    }
                    studentNode = studentNode.getNext();
                }
                studentNode = student.getStudentCharacteristic().getTop();

                jobNode = jobNode.getNext();
            }
        }
        if(DEBUG) {
            if (countMatch == 0) {
                System.out.println("There is no MATCH.");
            }

            System.out.println();
        }

        return countMatch;
    }
}
