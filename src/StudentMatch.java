import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLOutput;


public class StudentMatch {

    private static JobArrayList jobArrayList = new JobArrayList();
    private final static boolean DEBUG = false;
    private static Algorithm algorithm = new Algorithm();
    private static Student student = null;


    public static void main(String[] args){


        //Start of the program
        System.out.println("=========Start of process=========\n");
        System.out.println("____Supported by B&B Education____\n");

        //loading student information
        loadStudent();
        System.out.println(student.getName());

        //load data set for the excel table
        loadDataSet();

        //run the algorithm for finding matches
        runAlgorithm(student);

        if(DEBUG)
        System.out.println(jobArrayList.toStringArray());

        printResult(student);

        System.out.println("--------End of Program--------");

    }


    private static void runAlgorithm(Student student){
        System.out.println("Process: Starting to run the algorithm...");
        algorithm.addingComparisingData(jobArrayList, student);
        jobArrayList.sort();
        System.out.println("Process: End of the algorithm.\n");
    }

    private static void printResult(Student student){
        System.out.println("Finalizing the results...\n");
        System.out.println("=======RESULTS=======");
        System.out.println(student.printStudentInfo());
        System.out.println("BEST CHOICE: " + algorithm.choosingBestJob(jobArrayList).getName());
        System.out.println(jobArrayList.printTopTen());
    }


    private static void loadStudent(){
        System.out.println("Process: Adding student information...");

        try{

            // Open a file chosen from the File Chooser.
            JFileChooser chooser = new JFileChooser(".");
            chooser.showOpenDialog(null); //This shows a normal "open" (reading) dialog
            File chosenFile = chooser.getSelectedFile();

            FileInputStream fis = new FileInputStream(chosenFile);

            //creating workbook instance that refers to .xls file
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            //creating a Sheet object to retrieve object
            XSSFSheet sheet = workbook.getSheetAt(0);

            for(Row row : sheet){

                for(Cell cell : row) {
                    //getting cell type
                    CellType cellType = cell.getCellTypeEnum();

                    //if the cell contain string
                    if(cellType == CellType.STRING) {
                        if(cell.getStringCellValue().equals("Student Name")) {
                            cell = addStudentName(row);
                        }
                    }

                    //if cell contain only numeric info
                    if(cellType == CellType.NUMERIC) {
                        //add student's characteristic
                        student.addStudentAttribute(new Attribute(sheet.getRow(row.getRowNum()).getCell(0).getStringCellValue(), cell.getNumericCellValue()));

                    }

                }//for Cell
            }//for Row

        }catch (IOException e){
            System.out.println(e);
        }

        //report about end of student info
        System.out.println("Process: Student information is added.\n");

    }

    // load Info about Job list
    private static void loadDataSet(){
        System.out.println("Process: Adding jobs information...");

        try{

            File chosenFile = new File("JobsAndTraits.xlsx");

            FileInputStream fis = new FileInputStream(chosenFile);

            //creating workbook instance that refers to .xls file
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            //creating a Sheet object to retrieve object
            XSSFSheet sheet = workbook.getSheetAt(0);


            for(Row row : sheet){

                for(Cell cell : row){
                    //getting cell type
                    CellType cellType = cell.getCellTypeEnum();

                    //if the cell contain string
                    if(cellType == CellType.STRING) {

                        //just for coding
                        if(DEBUG)
                        System.out.println(cell.getStringCellValue());

                        //if cell is
                        if(cell.getStringCellValue().equals("Job Title")) {
                            cell = addJobs(row);
                        }
                    }

                    //if cell contain only numeric info
                    if(cellType == CellType.NUMERIC) {
                        if (DEBUG)
                            System.out.println(cell.getNumericCellValue() + " has up: " + sheet.getRow(1).getCell(cell.getColumnIndex()).getStringCellValue());

                        //adding
                        jobArrayList.get(cell.getColumnIndex()-1).addJobAttribute(new Attribute(sheet.getRow(row.getRowNum()).getCell(0).getStringCellValue(), cell.getNumericCellValue()));

                    }

                }//for Cell
            }//for Row


            System.out.println("Process: Data is loaded successfully.\n");

    }catch (IOException e){

            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    private static Cell addStudentName(Row row){
        Cell retCell = null;
        for( Cell cell : row){
            if(cell.getColumnIndex() != 0) {
                student = new Student(cell.getStringCellValue());
                retCell = cell;
            }
        }

        return retCell;
    }


    private static Cell addJobs(Row row){
        Cell retCell = null;
        for( Cell cell : row){
            if(cell.getColumnIndex() != 0) {
                Job job = new Job(cell.getStringCellValue());
                jobArrayList.add(job);
                retCell = cell;
            }
        }

        return retCell;
    }
}


/**
 //creating a test student
 Student student = new Student("Tai");

 //list of his characteristics
 String[] listStudentCharac = {"абстрактность мышления", "авторитаризм", "аккуратность",
 "амбициозность", "аналитическое мышление", "артистизм", "быстрая обучаемость",
 "выносливость к эмоциональным нагрузкам", "гибкость мышления", "доброжелательность",
 "добросовестность", "жесткость", "зрение", "изобретательность",
 "инициативность", "интеллектуальность", "коммуникабельность", "конфликтность", "критическое мышление",
 "кропотливость", "лидерские качества", "логическое мышление", "любовь к загадкам, пазлам", "любовь к спорту",
 "любовь к технике", "математические способности", "моральная устойчивость", "музыкальный слух", "настойчивость",
 "организаторские способности", "пунктуальность", "самообразование", "системное мышление", "способность находить компромиссы", "стратегическое мышление",
 "умение работать в команде", "харизматичность", "честность"};
 double[] listStudentLevels = {3.0, 4.0, 2.0, 4.0, 5.0, 4.0, 5.0, 5.0, 4.0, 4.0, 5.0, 4.0, 1.0, 3.0, 5.0, 4.0, 3.0, 2.0, 4.0, 3.0, 5.0, 4.0, 4.0, 5.0,
 3.0, 5.0, 4.0, 4.0, 4.0, 4.0, 1.0, 3.0, 4.0, 4.0, 4.0, 4.0, 5.0, 4.0};

 for(int i = 0; i < listStudentCharac.length; i++){
 student.addStudentAttribute(new Attribute(listStudentCharac[i], listStudentLevels[i]));
 }
 */

