import java.io.File; 
import java.io.IOException;
import java.io.FileWriter;
import java.util.*;
class Main {
    public static void main(String[] args)
    {   Integer N = UserInput.giveInpute();
       
        String floyd = Calculation.Floyd(N);
        FileHandling.saveToFile(floyd, "Floyd's triangle");
    }
}

class Calculation {
      public static String Floyd(Integer n){
        String sb = new String();
        Integer sumOfNum = 0;
        int i, j, k = 1;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= i; j++) {
                sb += k+" ";
                System.out.print(k + "  ");
                sumOfNum +=k;
                k++;
            }
            sb += "\n" ;
            if(i!=n) {System.out.println();}
        }
        System.out.format("\t"+ "Sum of the Numbers: "+sumOfNum); 
       // System.out.print(sumOfNum);
        return sb;
    }
}
class FileHandling {
     public static void saveToFile(String sb, String filename){
            try {
          File myObj = new File(filename);
            //System.out.println("File created: " + myObj.getName());
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(sb);
            myWriter.close();
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }
}
class UserInput {
    public static Integer giveInpute(){
        System.out.println("Enter the Floyd's triangle size:");
            Scanner sc = new Scanner(System.in);
            Boolean Valid = true;
            Integer input = 0;
            while(Valid){
                //it must be Integer
                while (!sc.hasNextInt()){
                   sc.nextLine();
                }
                //it must be Positive
                input = sc.nextInt();
                if(input>0){Valid = false;}
            }
            sc.close();
            return input;
    }
}


