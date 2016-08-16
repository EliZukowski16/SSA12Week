package com.tiy.ssa.weekthree.chess;

public interface Piece extends Comparable<Piece>
{   
    Location where();
    
    boolean canMove(Location where);
    
    @Override
    public int compareTo(Piece o);
    
    @Override
    boolean equals(Object obj);
    
    @Override
    int hashCode();
    
    @Override
    String toString();
    
}
