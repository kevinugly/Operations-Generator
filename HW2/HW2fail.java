import java.io.*;
import java.util.*;

public class HW2fail
{
    public static void main(String[] args)
    {
        Scanner inputStream = null;
        try
        {
            inputStream = new Scanner(new FileInputStream("firstFile.txt"));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found.");
            System.exit(0);
        }
        
        ArrayList<Double> matrixA =  new ArrayList<Double>();
        int rowsA = 0;
        while(inputStream.hasNextLine())
        {
            String line = inputStream.nextLine();
            rowsA++;
            String[] splitNums = line.split("\\s+");
            for(String s: splitNums)
            {
                matrixA.add(Double.parseDouble(s));
            }
        }
        
        try
        {
            inputStream = new Scanner(new FileInputStream("secondFile.txt"));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found.");
            System.exit(0);
        }
        
        ArrayList<Double> matrixB =  new ArrayList<Double>();
        int rowsB = 0;
        while(inputStream.hasNextLine())
        {
            String line = inputStream.nextLine();
            rowsB++;
            String[] splitNums = line.split("\\s+");
            for(String s: splitNums)
            {
                matrixB.add(Double.parseDouble(s));
            }
        }
        inputStream.close();
        
        Formatter file;
        PrintWriter pw = null;
        //Double.toString().length();
        try
        {
            file = new Formatter("add.txt");
            pw = new PrintWriter(new FileOutputStream("add.txt"));
            ArrayList<Double> add = new ArrayList<Double>();
            String format = "";
            for(int a = 0; a < matrixA.size(); a++)
            {
                add.add(matrixA.get(a) + matrixB.get(a));
            }
            
            for(int a = 0; a < rowsA; a++)
            {
                int max = Integer.MIN_VALUE;
                for(int b = a; b < add.size(); b+=rowsA)
                {
                    if(Double.toString(add.get(b)).length() > max)
                    {
                        max = Double.toString(add.get(b)).length();
                    }
                }
                format += "%-" + max + "s";
            }
            
            for(int a = 0; a < rowsA; a+=rowsA)
            {
                String addNums = "";
                for(int b = 0; b < rowsAadd.size(); b++)
                {
                    addNums = addNums + ""Double.toString(add.get(b)) + 
                }
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found.");
            System.exit(0);
        }
        
        try
        {
            file = new Formatter("subtract.txt");
            pw = new PrintWriter(new FileOutputStream("subtract.txt"));
            for(int a = 0; a < matrixA.size(); a++)
            {
                if((a + 1) % rowsA == 0)
                {
                    pw.println(matrixA.get(a) - matrixB.get(a));
                }
                else
                {
                    pw.print(matrixA.get(a) - matrixB.get(a) + " ");
                }
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found.");
            System.exit(0);
        }
        pw.close();
    }
}

/*
        for(int x = 0; x < 4; x++)
        {
            try
            {
                switch(x)
                {
                    case 0: //add
                    file = new Formatter("add.txt");
                    pw = new PrintWriter(new FileOutputStream("add.txt"));
                    for(int a = 0; a < matrixA.size(); a++)
                    {
                        if((a + 1) % rowsA == 0)
                        {
                            pw.println(matrixA.get(a) + matrixB.get(a));
                        }
                        else
                        {
                            pw.print(matrixA.get(a) + matrixB.get(a) + " ");
                        }
                    }
                    break;
                
                    case 1: //subtract
                    file = new Formatter("subtract.txt");
                    pw = new PrintWriter(new FileOutputStream("subtract.txt"));
                    for(int a = 0; a < matrixA.size(); a++)
                    {
                        if((a + 1) % rowsA == 0)
                        {
                            pw.println(matrixA.get(a) - matrixB.get(a));
                        }
                        else
                        {
                            pw.print(matrixA.get(a) - matrixB.get(a) + " ");
                        }
                    }
                    break;
                
                    case 2: //transpose
                    file = new Formatter("aTranspose.txt");
                    pw = new PrintWriter(new FileOutputStream("aTranspose.txt"));
                    
                    file = new Formatter("bTranspose.txt");
                    pw = new PrintWriter(new FileOutputStream("bTranspose.txt"));
                
                    break;
                
                    case 3: //determinant
                    file = new Formatter("aDeterminant.txt");
                    pw = new PrintWriter(new FileOutputStream("aDeterminant.txt"));
                    
                    file = new Formatter("bDeterminant.txt");
                    pw = new PrintWriter(new FileOutputStream("bDeterminant.txt"));
                
                    break;
                }
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File not found.");
                System.exit(0);
            }
        }
        */