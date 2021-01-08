import java.util.ArrayList;

public class JobArrayList extends ArrayList<Job> {


    public boolean add(Job newJob){

        if(newJob == null) {
            System.out.println("Error: NULL job found");
            return false;

        }else{
            super.add(newJob);
            return true;
        }
    }

    public String printTopTen(){
        String retValue = "TOP TEN CHOICES: \n";
        for(int i = 0; i < 10; i++){
            retValue += (i+1) + ") "+get(i).getName() + "  number of MATCHES: " + get(i).getScore() + "\n";
        }
        return retValue;
    }

    public void sort(){

        Job temp;
        int j;

        for ( int i = 0; i < size(); i++ ){

            temp = get(i);
            j = i - 1;

            while(j >= 0 && get(j).getScore() < temp.getScore()){
                set(j + 1, get(j));
                j--;
            }
            set(j + 1, temp);
        }

    }


    public String toStringArray(){
        String retValue = "[";
        for(int i = 0; i < size() - 1; i++){
            retValue += get(i).getName() + "("+ get(i).getScore() + ") " +", ";
        }
        retValue += get(size() - 1).getName() +"("+ get(size() - 1).getScore() + ")" + "]";
        return retValue;
    }
}
