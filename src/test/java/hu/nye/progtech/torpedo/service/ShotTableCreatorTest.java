package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.model.BaseTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ShotTableCreatorTest{

    private ShotTableCreatorTest underTest;

   private int numberOfRows = 10;
   private int numberOfColumns =10;


    @BeforeEach
    private void init(){
    }

    @Test
    public void testShouldReturneNewBasetable(){
        // Given
        char[][] map = new char[numberOfRows][numberOfColumns];

        // When

        // Then
    }
}
