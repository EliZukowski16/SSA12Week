package com.tiy.ssa.weektwo.assignmentone;

public class Elements
{
    private final String elementName;
    private final String elementSymbol;
    private final Integer atomicNumber;
    private final Double atomicWeight;
    private final Double meltingPoint;
    private final Double boilingPoint;
    private State currentState;

    public enum State
    {
        SOLID, LIQUID, GAS;
    };

    public Elements(String elementName, String elementSymbol, Integer atomicNumber, Double atomicWeight,
            Double meltingPoint, Double boilingPoint, Double currentTemperature)
    {
        this.elementName = elementName;
        this.elementSymbol = elementSymbol;
        this.atomicNumber = atomicNumber;
        this.atomicWeight = atomicWeight;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;

        this.currentState = changeTemperature(currentTemperature);
    }

    public Elements(String elementName, String elementSymbol, Integer atomicNumber, Double atomicWeight,
            Double meltingPoint, Double boilingPoint)
    {
        this(elementName, elementSymbol, atomicNumber, atomicWeight, meltingPoint, boilingPoint, 25.0);

    }

    public State changeTemperature(double temperature)
    {
        if (temperature < meltingPoint)
        {
            this.currentState = State.SOLID;
            return State.SOLID;
        }
        if (temperature < boilingPoint)
        {
            this.currentState = State.LIQUID;
            return State.LIQUID;
        }
        this.currentState = State.GAS;
        return State.GAS;

    }

    public State getCurrentState()
    {
        return currentState;
    }

    public String getElementName()
    {
        return elementName;
    }

    public String getElementSymbol()
    {
        return elementSymbol;
    }

    public Integer getAtomicNumber()
    {
        return atomicNumber;
    }

    public Double getAtomicWeight()
    {
        return atomicWeight;
    }

    public Double getMeltingPoint()
    {
        return meltingPoint;
    }

    public Double getBoilingPoint()
    {
        return boilingPoint;
    }

}
