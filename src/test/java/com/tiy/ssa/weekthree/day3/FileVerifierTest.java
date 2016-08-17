package com.tiy.ssa.weekthree.day3;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class FileVerifierTest
{

    FileVerifier cornedBeef;

    @Test
    public void test() throws Exception
    {
        String path = "C:/Users/admin/Downloads/eclipse-inst-win64.exe";
        
        try
        {
            cornedBeef = new FileVerifier(path, "SHA-512");
            String hash = cornedBeef.hash();
            
            String expectedHash = "21302bcf1d6d22ce3022af54f958649695afb84e38c8e640eafd7e64ba852ff3c13eae33db9e19affbc4e861341391143a40669da839c1bddcc8dea7240218e9";
            
            assertEquals(expectedHash, hash);
            
            
        }
        catch (NoSuchAlgorithmException | IOException e)
        {
            
        }
       
    }

}
