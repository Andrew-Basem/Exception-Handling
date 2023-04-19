import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        try {
            String file = args[0]; //taking file name
            if (!file.endsWith(".arxml")) {   // checking file extension
                throw new NotVaildAutosarFileException("Checking file (" + file + ")...... Not valid Autosar file,try again");
            }
            File fileIn = new File(file);  // creating file with same name of input file
            if (fileIn.length()==0){  // if file has no one byte at least
                throw new EmptyAutosarFileException("Checking file (" + file + ")...... OOPS,Empty File.Nothing there to read");
            }
            FileInputStream stream = new FileInputStream(fileIn); //for reading from file
            StringBuffer sb = new StringBuffer(); //will carry content of file
            int num; //for read method purpose
            while ((num = stream.read()) != -1) {
                sb.append((char) num); // append till reach end of file
            }
            String parsed = sb.toString();
            Scanner input = new Scanner(parsed); //for reading data parsed to string
            ArrayList<XMLContainer> containerArrayList = new ArrayList<>();
            while (input.hasNext()) {
                String tag = input.nextLine();
                if (tag.contains("<CONTAINER")) {
                    String id = tag.substring(tag.indexOf("UUID="),tag.indexOf(">"));
                    String shortTag = input.nextLine();
                    String shortName = shortTag.substring(shortTag.indexOf(">") + 1, shortTag.indexOf("</"));
                    String longTag = input.nextLine();
                    String longName = longTag.substring(longTag.indexOf(">") + 1, longTag.indexOf("</"));
                    XMLContainer c = new XMLContainer(id,shortName,longName);
                    containerArrayList.add(c);
                }

            }
            String outFile = file.substring(0,file.indexOf("."))+"_mod.arxml"; //modyfying name of file
            if (new File(outFile).exists()){
                System.out.println("Modified file already exists");
            }else{
                System.out.println("Creating modified file....Go check the "+ outFile);
            }
            PrintWriter outputting = new PrintWriter(outFile);
            outputting.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            outputting.println("<AUTOSAR>");
            Collections.sort(containerArrayList);
            for (int i = 0; i < containerArrayList.size(); i++) {
                outputting.println(containerArrayList.get(i).toString()); //writing containers...
            }
            outputting.println("</AUTOSAR>");
            outputting.close();



        } catch (NotVaildAutosarFileException e) {

        } catch (FileNotFoundException e) {
            e = new FileNotFoundException("File is not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




