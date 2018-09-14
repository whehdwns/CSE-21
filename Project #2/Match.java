
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
 
public class Match {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Student[] person; 
        person = new Student[100]; 
        int personNum, k=0; 
        String change; 
        for (int i=0; i<100; i++) { 
            person[i] = new Student(); 
        } 
 
 
        Scanner input = new Scanner(System.in); 
        System.out.print( "Information?"); 
        String filename; 
        filename = input.next(); 
        try { 
            Scanner in = new Scanner(new FileReader(filename +".txt")); 
            int i = 0; 
            while (in.hasNextLine() && i<100) { 
                Scanner scanner = new Scanner(in.nextLine());
				Scanner data = scanner.useDelimiter("[\t-]"); 
                if (data.hasNext()){ 
                    person[i].Name = data.next(); 
                } 
                if (data.hasNext()){ 
                    change = data.next(); 
                    person[i].Gender = change.charAt(0); 
                } 
                if (data.hasNext()){ 
                    person[i].birthDay.month = data.nextInt(); 
                    person[i].birthDay.day = data.nextInt(); 
                    person[i].birthDay.year = data.nextInt(); 
                } 
 
                int Music =0;
                int Reading= 0;
                int Chatting = 0;
                int Quiet =0 ;
 
                if (data.hasNext()) 
                    Quiet= data.nextInt(); 
                if (data.hasNext()) 
                    Music= data.nextInt(); 
                if (data.hasNext()) 
                    Reading= data.nextInt(); 
                if (data.hasNext()) 
                    Chatting= data.nextInt(); 
                person[i].pref = new Preference (Quiet, Music, Reading, Chatting);
                i++; 
            } 
            input.close(); 
        }catch (NoSuchElementException e) { 
            System.out.println(e); 
        }catch (FileNotFoundException e) { 
            System.out.println(e); 
        } 
        for (personNum=0; person[personNum].Name !=""; personNum++) { 
        } 
        String[] match = new String[personNum]; 
        int[] results = new int[1000]; 
        k=0; 
        int marker = 0; 
        for (int i=0; i<personNum; i++) { 
            for (k=i+1; k<personNum; k++) { 
                if (person[i].matched==false) { 
                    if (person[i].Gender == person[k].Gender) { 
 
                        if (person[i].Compatibility(person[k])>results[i]) { 
                            results[i] = person[i].Compatibility(person[k]); 
                            match[i]=person[k].Name; 
                            marker = k; 
 
                        } 
                    } 
 
                    else{ 
 
                    } 
                } 
                if (k == personNum-1) { 
                    if (results[i]>0) { 
                        person[i].matched=true; 
                        person[marker].matched=true; 
 
                    } 
                } 
            } 
        } 
 
 
 
        for (int i=0; i<match.length; i++) { 
            for (int j=0; j<match.length; j++) { 
                if (j != i) { 
                    if (match[i] == match[j]) { 
                        //match[j] = null; 
 
                    } 
                } 
            } 
        } 
 
 
        for (int i=0; i<personNum; i++) { 
            if (match[i] != null) { 
 
                System.out.println(person[i].Name + " matches with " + match[i] + " with the score " +results[i]); 
 
            } 
            else { 
 
                System.out.println(person[i].Name + " has no matches"); 
            } 
 
 
 
 
        } 
 
 
 
    } 
}