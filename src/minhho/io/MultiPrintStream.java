package minhho.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class MultiPrintStream extends PrintStream {
    public MultiPrintStream(String fileName) throws FileNotFoundException {
        super(fileName);
        try
        {
            FileOutputStream fout= new FileOutputStream(fileName);

            MultiOutputStream multiOut= new MultiOutputStream(System.out, fout);

            PrintStream stdout= new PrintStream(multiOut);

            System.setOut(stdout);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Error writing to file");
        }

    }
}
