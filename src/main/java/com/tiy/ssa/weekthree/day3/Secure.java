package com.tiy.ssa.weekthree.day3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Secure
{
    static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args)
    {
        String path = "";
        String hashFunc = "";
        String outputHash = "";
        boolean upperCase = true;
        FileVerifier fileDigest;

        if (args.length >= 4)
        {
            if (args[0].equals("-f"))
                path = args[1];
            if (args[2].equals("-alg"))
                hashFunc = args[3];
            if (args.length >= 5)
            {
                if (args[4].equals("-l"))
                    upperCase = false;
                if (args[4].equals("-u"))
                    upperCase = true;
            }
        }

        try
        {
            if (!path.isEmpty() && !hashFunc.isEmpty())
            {
                fileDigest = new FileVerifier(path, hashFunc);
                outputHash = upperCase ? fileDigest.hash().toUpperCase() : fileDigest.hash().toLowerCase();
            }
        }
        catch (Exception e)
        {
            
        }
        LOGGER.info(outputHash);
        System.out.println(outputHash);
    }
}
