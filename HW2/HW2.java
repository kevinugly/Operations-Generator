import java.io.*;
import java.util.*;

public class HW2
{
    public static void main(String[] args)
    {
        Formatter file;
        PrintWriter pw = null;
        if(args[0].equals("add") || args[0].equals("sub") || args[0].equals("mul"))
        {
            Scanner inputStream = null;
            try
            {
                inputStream = new Scanner(new FileInputStream(args[1]));
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File not found.");
                System.exit(0);
            }
        
            int rows = 0;
            int cols = 0;
            ArrayList<Double> matrixA =  new ArrayList<Double>();
            while(inputStream.hasNextLine())
            {
                String line = inputStream.nextLine();
                rows++;
                String[] splitNums = line.split("\\s+");
                cols = splitNums.length;
                for(String s: splitNums)
                {
                    matrixA.add(Double.parseDouble(s));
                }
            }
        
            try
            {
                inputStream = new Scanner(new FileInputStream(args[2]));
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File not found.");
                System.exit(0);
            }
        
            ArrayList<Double> matrixB =  new ArrayList<Double>();
            while(inputStream.hasNextLine())
            {
                String line = inputStream.nextLine();
                String[] splitNums = line.split("\\s+");
                for(String s: splitNums)
                {
                    matrixB.add(Double.parseDouble(s));
                }
            }
            inputStream.close();
            
            try
            {
                file = new Formatter(args[3]);
                pw = new PrintWriter(new FileOutputStream(args[3]));
                ArrayList<String> mat = new ArrayList<String>();
                switch(args[0])
                {
                    case "add":
                    for(int x = 0; x < rows * cols; x++)
                    {
                        mat.add(Double.toString(matrixA.get(x) + matrixB.get(x)));
                    }
                    break;
                    
                    case "sub":
                    for(int x = 0; x < rows * cols; x++)
                    {
                        mat.add(Double.toString(matrixA.get(x) - matrixB.get(x)));
                    }
                    break;
                    
                    case "mul":
                    break;
                }
                
                int max = Integer.MIN_VALUE;
                for(int x = 0; x < rows; x++)
                {
                    for(int y = x; y < rows * cols; y+=cols)
                    {
                        if(mat.get(y).length() > max)
                        {
                            max = mat.get(y).length();
                        }
                    }
                    
                    for(int y = x; y < rows * cols; y+=cols)
                    {
                        if(mat.get(y).length() < max)
                        {
                            String spaces = "";
                            for(int z = 0; z < max - mat.get(y).length(); z++)
                            {
                                spaces += " ";
                            }
                            mat.set(y, spaces + mat.get(y));
                        }
                    }
                }
                
                for(int x = 0; x < rows * cols; x++)
                {
                    if((x+1) % rows == 0)
                    {
                        pw.println(mat.get(x));
                    }
                    else
                    {
                        pw.print(mat.get(x) + " ");
                    }
                }
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File not found.");
                System.exit(0);
            }
        }
        else if(args[0].equals("tra") || args[0].equals("det"))
        {
            Scanner inputStream = null;
            try
            {
                inputStream = new Scanner(new FileInputStream(args[1]));
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File not found.");
                System.exit(0);
            }
        
            int rows = 0;
            int cols = 0;
            ArrayList<Double> matrix =  new ArrayList<Double>();
            while(inputStream.hasNextLine())
            {
                String line = inputStream.nextLine();
                rows++;
                String[] splitNums = line.split("\\s+");
                cols = splitNums.length;
                for(String s: splitNums)
                {
                    matrix.add(Double.parseDouble(s));
                }
            }
            
            try
            {
                file = new Formatter(args[2]);
                pw = new PrintWriter(new FileOutputStream(args[2]));
                ArrayList<String> mat = new ArrayList<String>();
                switch(args[0])
                {
                    case "tra":
                    for(int x = 0; x < rows; x++)
                    {
                        for(int y = x; y < rows * cols; y+=rows)
                        {
                            mat.add(Double.toString(matrix.get(y)));
                        }
                    }
                    
                    int max = Integer.MIN_VALUE;
                    for(int x = 0; x < rows; x++)
                    {
                        for(int y = x; y < rows * cols; y+=cols)
                        {
                            if(mat.get(y).length() > max)
                            {
                                max = mat.get(y).length();
                            }
                        }
                    
                        for(int y = x; y < rows * cols; y+=cols)
                        {
                            if(mat.get(y).length() < max)
                            {
                                String spaces = "";
                                for(int z = 0; z < max - mat.get(y).length(); z++)
                                {
                                    spaces += " ";
                                }
                                mat.set(y, spaces + mat.get(y));
                            }
                        }
                    }
                
                    for(int x = 0; x < rows * cols; x++)
                    {
                        if((x+1) % rows == 0)
                        {
                            pw.println(mat.get(x));
                        }
                        else
                        {
                            pw.print(mat.get(x) + " ");
                        }
                    }
                }
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File not found.");
                System.exit(0);
            }
        }
        pw.close();
    }
}