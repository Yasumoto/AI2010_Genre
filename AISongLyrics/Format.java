import java.io.*;

public class Format {
    public static String replace(String s){
        //replace all non-word chars except white space
        s = s.replaceAll("[\\W&&[\\S]]+","");
        return s;
    }
    
    public static void main(String[] args){
        try{
            //StringBuffer will make the read faster
            StringBuffer sb = new StringBuffer(1000);
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String line = null;
            while((line=br.readLine())!=null){
                line = Format.replace(line);
                //get rid of any leading and trailing white space.
                line = line.trim();
                //add a newline and append to buffer
                line += "\n";
                sb.append(line);
            }
            br.close();
            //overwrite the file with formatted contents
            PrintWriter pw = new PrintWriter(new FileWriter(args[0]));
            pw.println(sb.toString().trim());
            pw.flush();
            pw.close();
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
