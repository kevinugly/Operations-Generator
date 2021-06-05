import java.io.*;
import java.util.*;
import java.lang.*;

public class hw2linkkim
{
    public static void main(String[] args) 
    {
        SinglyLinkedList matrix_1 = new SinglyLinkedList();
        SinglyLinkedList matrix_2 = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);
        Scanner inputFile = null;
        try 
        {
            inputFile = new Scanner(new FileInputStream(args[1]));
        } catch (FileNotFoundException e) 
        {
            System.out.println("File not found.");
            System.exit(0);
        }
        Scanner inputFile_2 = null;

        try {
            inputFile_2 = new Scanner(new FileInputStream(fileName_2 + ".txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
        int colCount = 0;
        int rowCount = 0;
        while(inputFile.hasNextLine())
        {
            rowCount++;
            String line = inputFile.nextLine();
            if(line.contains(" ")){
                String[] split = line.split(" ");
                colCount = split.length;
                for(int x = 0; x<split.length; x++)
                {
                    int value = Integer.parseInt(split[x].trim());
                    matrix_1.addLast((double)value);
                }
            }

        }
        int rowCount_2 = 0;
        int colCount_2 = 0;
        while(inputFile_2.hasNextLine())
        {
            rowCount_2++;
            String line = inputFile_2.nextLine();
            if(line.contains(" ")){
                String[] split = line.split(" ");
                colCount_2 = split.length;
                for(int x = 0; x<split.length; x++)
                {
                    int value = Integer.parseInt(split[x].trim());
                    matrix_2.addLast((double)value);
                }
            }
        }
        Formatter outFile;
        PrintWriter pw = null;
        String word = "";
        try {
            outFile = new Formatter("subTest.txt");
            pw = new PrintWriter(new FileOutputStream("subTest.txt"));
            //subtract
            /*for(int x = 0; x<rowCount; x++)
            {
                for(int y = 0; y<colCount; y++)
                {
                    pw.print((matrix_1.head.value - matrix_2.head.value) + " ");
                    matrix_1.head = matrix_1.getNextVal();
                    matrix_2.head = matrix_2.getNextVal();
                }
                pw.println("\n");
            }
            pw.close();*/
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
        //add
            /*for(int x = 0; x<rowCount; x++)
            {
                for(int y = 0; y<colCount; y++)
                {
                    pw.print((matrix_1.head.value + matrix_2.head.value) + " ");
                    matrix_1.head = matrix_1.getNextVal();
                    matrix_2.head = matrix_2.getNextVal();
                }
                pw.println("\n");
            }
            pw.close();*/
        //multiply
            /*for(int x = 0; x<rowCount; x++)
            {
                for(int y = 0; y<colCount; y++)
                {
                    pw.print((matrix_1.head.value * matrix_2.head.value) + " ");
                    matrix_1.head = matrix_1.getNextVal();
                    matrix_2.head = matrix_2.getNextVal();
                }
                pw.println("\n");
            }
            pw.close();*/

    }
}

