package com.tiy.ssa.weekthree.day3;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.tiy.ssa.weektwo.assignmentthree.WordCount;

public class WordCountTestsDay3
{
    WordCount counter = new WordCount();
    static Logger LOGGER = LogManager.getLogger();

    @Test
    public void justChecking() throws Exception
    {
        BufferedReader reader = null;

        try
        {
            reader = Files.newBufferedReader(
                    Paths.get("C:/Users/admin/workspace/SSA12Week/resources/the-complete-works.txt"),
                    Charset.defaultCharset());

            String line;

            int i = 0;

            // for(int j = 0; j < 15; j++)
            // {
            // System.err.println(reader.readLine());
            // }

            while (null != (line = reader.readLine()) && i++ < 130_000)
            {
                String[] words = line.split("\\W+");
                for (String word : words)
                {
                    if (!word.isEmpty())
                    {
                        this.counter.addWord(word);
                    }
                }
            }
            List<String> top = this.counter.top(12);
            LOGGER.info(top);
            
        }

        catch (IOException iex)
        {
            System.err.println(iex);
            throw iex;
        }
        finally
        {
            if (null != reader)
                reader.close();
        }
        
        assertTrue("", this.counter.count("juliet") > 10);
        assertTrue("", this.counter.count("thou") > 1_000);
    }
}
