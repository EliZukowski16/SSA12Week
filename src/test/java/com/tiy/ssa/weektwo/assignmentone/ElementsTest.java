package com.tiy.ssa.weektwo.assignmentone;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tiy.ssa.weektwo.assignmentone.Elements.State;

public class ElementsTest
{

    List<Elements> testElements = new ArrayList<>();

    Elements hydrogen = new Elements("Hydrogen", "H", 1, 1.008, -259.16, -252.879);
    Elements lithium = new Elements("Lithium", "Li", 3, 6.94, 180.50, 1330.0);
    Elements helium = new Elements("Helium", "He", 2, 4.002602, -272.20, -268.928);
    Elements beryllium = new Elements("Beryllium", "Be", 4, 9.0121831, 1287.0, 2469.0);
    Elements nitrogen = new Elements("Nitrogen", "N", 7, 14.007, -210.00, -197.795);
    Elements bromine = new Elements("Bromine", "Br", 35, 79.904, -7.2, 58.8);
    Elements mercury = new Elements("Mercury", "Hg", 80, 200.592, -38.8290, 356.73);
    Elements sulfur = new Elements("Sulfur", "S", 16, 32.06, 115.21, 444.6);
    Elements sodium = new Elements("Sodium", "Na", 11, 22.98976928, 97.794, 882.940);
    Elements gallium = new Elements("Gallium", "Ga", 31, 69.723, 29.7646, 2400.0);

    @Before
    public void setup()
    {
        testElements.add(hydrogen);
        testElements.add(lithium);
        testElements.add(helium);
        testElements.add(beryllium);
        testElements.add(nitrogen);
        testElements.add(bromine);
        testElements.add(mercury);
        testElements.add(sulfur);
        testElements.add(sodium);
        testElements.add(gallium);
    }

    @After
    public void clear()
    {
        testElements.clear();
    }

    @Test
    public void testSeparateByStateAtSTP()
    {
        // Separate the elements by their state at STP (25 deg C, 1 atm)
        List<Elements> gases = new ArrayList<>();
        List<Elements> liquids = new ArrayList<>();
        List<Elements> solids = new ArrayList<>();

        for (Elements e : testElements)
        {
            switch (e.getCurrentState())
            {
            case SOLID:
                solids.add(e);
                break;
            case LIQUID:
                liquids.add(e);
                break;
            case GAS:
                gases.add(e);
                break;
            }
        }

        assertEquals(5, solids.size());
        for (Elements e : solids)
        {
            assertTrue(e.getCurrentState().equals(State.SOLID));
            assertFalse(e.getCurrentState().equals(State.GAS));
            assertFalse(e.getCurrentState().equals(State.LIQUID));
        }

        assertEquals(2, liquids.size());
        for (Elements e : liquids)
        {
            assertFalse(e.getCurrentState().equals(State.SOLID));
            assertFalse(e.getCurrentState().equals(State.GAS));
            assertTrue(e.getCurrentState().equals(State.LIQUID));
        }

        assertEquals(3, gases.size());
        for (Elements e : gases)
        {
            assertFalse(e.getCurrentState().equals(State.SOLID));
            assertTrue(e.getCurrentState().equals(State.GAS));
            assertFalse(e.getCurrentState().equals(State.LIQUID));
        }
    }

    @Test
    public void testExcludeGasesAtSTP()
    {
        // Separate out the gases at STP from the liquids and solids
        List<Elements> nonGases = new ArrayList<>();

        for (Elements e : testElements)
        {
            if (e.getCurrentState() != State.GAS)
            {
                nonGases.add(e);
            }
        }

        assertEquals(7, nonGases.size());
        assertFalse(nonGases.contains(hydrogen));
        assertFalse(nonGases.contains(helium));
        assertFalse(nonGases.contains(nitrogen));

        for (Elements e : nonGases)
        {
            assertFalse(e.getCurrentState().equals(State.GAS));
            assertTrue(e.getCurrentState().equals(State.SOLID) || e.getCurrentState().equals(State.LIQUID));
        }
    }

    @Test
    public void testChangeTemperatureTo30DegC()
    {
        // Set the temperature to 30 deg C and change the state of all the
        // elements based upon
        // their melting point and boiling point. Separate the elements by their
        // new states.
        List<Elements> solids = new ArrayList<>();
        List<Elements> liquids = new ArrayList<>();
        List<Elements> gases = new ArrayList<>();

        for (Elements e : testElements)
        {
            switch (e.changeTemperature(30.0))
            {
            case SOLID:
                solids.add(e);
                break;
            case LIQUID:
                liquids.add(e);
                break;
            case GAS:
                gases.add(e);
                break;
            }
        }

        assertTrue(liquids.contains(bromine));
        assertTrue(liquids.contains(mercury));
        assertTrue(liquids.contains(gallium));

        assertEquals(4, solids.size());
        for (Elements e : solids)
        {
            assertTrue(e.getCurrentState().equals(State.SOLID));
            assertFalse(e.getCurrentState().equals(State.GAS));
            assertFalse(e.getCurrentState().equals(State.LIQUID));
        }

        assertEquals(3, liquids.size());
        for (Elements e : liquids)
        {
            assertFalse(e.getCurrentState().equals(State.SOLID));
            assertFalse(e.getCurrentState().equals(State.GAS));
            assertTrue(e.getCurrentState().equals(State.LIQUID));
        }

        assertEquals(3, gases.size());
        for (Elements e : gases)
        {
            assertFalse(e.getCurrentState().equals(State.SOLID));
            assertTrue(e.getCurrentState().equals(State.GAS));
            assertFalse(e.getCurrentState().equals(State.LIQUID));
        }
    }

    @Test
    public void testChangeTemperatureToAbsoluteZero()
    {
        // Set the temperature to absolute zero (-273.15 deg C) and change the
        // state of all elements
        // based upon their melting and boiling points. All elements should
        // change to a solid at this temperature
        List<Elements> solids = new ArrayList<>();
        List<Elements> liquids = new ArrayList<>();
        List<Elements> gases = new ArrayList<>();

        for (Elements e : testElements)
        {
            switch (e.changeTemperature(-273.15))
            {
            case SOLID:
                solids.add(e);
                break;
            case LIQUID:
                liquids.add(e);
                break;
            case GAS:
                gases.add(e);
                break;
            }
        }

        assertEquals(10, solids.size());
        for (Elements e : solids)
        {
            assertTrue(e.getCurrentState().equals(State.SOLID));
            assertFalse(e.getCurrentState().equals(State.GAS));
            assertFalse(e.getCurrentState().equals(State.LIQUID));
        }

        assertEquals(0, liquids.size());
        for (Elements e : liquids)
        {
            assertFalse(e.getCurrentState().equals(State.SOLID));
            assertFalse(e.getCurrentState().equals(State.GAS));
            assertTrue(e.getCurrentState().equals(State.LIQUID));
        }

        assertEquals(0, gases.size());
        for (Elements e : gases)
        {
            assertFalse(e.getCurrentState().equals(State.SOLID));
            assertTrue(e.getCurrentState().equals(State.GAS));
            assertFalse(e.getCurrentState().equals(State.LIQUID));
        }
    }

    @Test
    public void testChangeTemperatureTo10000DegC()
    {
        // Set the temperature to 10,000 deg C and change the
        // state of all elements
        // based upon their melting and boiling points. All elements should
        // change to a solid at this temperature
        List<Elements> solids = new ArrayList<>();
        List<Elements> liquids = new ArrayList<>();
        List<Elements> gases = new ArrayList<>();

        for (Elements e : testElements)
        {
            switch (e.changeTemperature(10000))
            {
            case SOLID:
                solids.add(e);
                break;
            case LIQUID:
                liquids.add(e);
                break;
            case GAS:
                gases.add(e);
                break;
            }
        }

        assertEquals(0, solids.size());
        for (Elements e : solids)
        {
            assertTrue(e.getCurrentState().equals(State.SOLID));
            assertFalse(e.getCurrentState().equals(State.GAS));
            assertFalse(e.getCurrentState().equals(State.LIQUID));
        }

        assertEquals(0, liquids.size());
        for (Elements e : liquids)
        {
            assertFalse(e.getCurrentState().equals(State.SOLID));
            assertFalse(e.getCurrentState().equals(State.GAS));
            assertTrue(e.getCurrentState().equals(State.LIQUID));
        }

        assertEquals(10, gases.size());
        for (Elements e : gases)
        {
            assertFalse(e.getCurrentState().equals(State.SOLID));
            assertTrue(e.getCurrentState().equals(State.GAS));
            assertFalse(e.getCurrentState().equals(State.LIQUID));
        }
    }

}
