package com.tiy.ssa.weekthree.day3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileVerifier
{
    private MessageDigest digest;
    private File file;
    static Logger LOGGER = LogManager.getLogger();

    public FileVerifier(String path, String hashFunc) throws Exception
    {
        try
        {
            digest = MessageDigest.getInstance(hashFunc);
            file = new File(path);
            if (!file.exists())
            {
                throw new IllegalArgumentException(path + " does not exist.");
            }
        }
        catch (IllegalArgumentException | NoSuchAlgorithmException ex)
        {
            LOGGER.error(ex.getMessage());
            System.err.println(ex.getMessage());
            throw ex;
        }
        finally
        {

        }
    }

    public String hash() throws IOException
    {
        byte[] bytes = new byte[1024];
        StringBuilder outputHash = new StringBuilder();
        try (BufferedInputStream buffStream = new BufferedInputStream(
                Files.newInputStream(Paths.get(this.file.getPath()))))
        {
            digest.reset();

            int read;

            while ((read = buffStream.read(bytes)) > 0)
            {
                digest.update(bytes, 0, read);
            }
        }
        catch (IOException ioex)
        {
            LOGGER.error(ioex.getMessage());
            System.err.println(ioex.getMessage());
            throw ioex;
        }

        for (Byte b : digest.digest())
        {
            outputHash.append(String.format("%02x", b));
        }

        return outputHash.toString();
    }
}
