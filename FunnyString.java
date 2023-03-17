package pack1;

import java.io.*;
import java.util.stream.*;

class FSResult {

    /*
     * Complete the 'funnyString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String funnyString(String s) 
    {
    // Write your code here
        String rev="";
        int len=s.length();
        for(int i=len-1;i>=0;i--)
        {
            rev+=s.charAt(i);
        }
        byte arr1[]=s.getBytes();
        byte arr2[]=rev.getBytes();
        int ar1[]=new int[len-1];
        int ar2[]=new int[len-1];
        for(int i=0;i<arr1.length-1;i++)
        {
            int val=arr1[i]-arr1[i+1];
            if(val<0) val=-val;
            ar1[i]=val;
        }
        for(int i=0;i<arr2.length-1;i++)
        {
            int val=arr2[i]-arr2[i+1];
            if(val<0) val=-val;
            ar2[i]=val;
        }
        int c=0; 
        for(int i=0;i<ar1.length;i++)
        {
            if(ar1[i]==ar2[i]) c++;
        }
        if(c==ar1.length) return "Funny";
        else return "Not Funny";
    }

}

public class FunnyString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = FSResult.funnyString(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}