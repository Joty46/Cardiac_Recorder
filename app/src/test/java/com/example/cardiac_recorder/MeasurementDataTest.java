package com.example.cardiac_recorder;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Consists of all the functions required for Unit Test
 */
public class MeasurementDataTest {
    private MeasurementData mockList()
    {
        MeasurementData DataList=new MeasurementData();
        DataList.add(mockMeasure());
        return DataList;
    }
    private Measurement mockMeasure()
    {
        return new Measurement("23/07/2022","11:47am",120,80,60,"normal");
    }

    /**
     * Adds a measurement data in the Recyclerview and check if it is added or not
     */
    @Test
    public void testAdd()
    {
        MeasurementData DataList=mockList();
        assertEquals(1,DataList.getMeasure().size());

        Measurement m=new Measurement("23/07/2022","8:45pm",150,100,70,"high pressure");
        DataList.add(m);

        assertEquals(2,DataList.getMeasure().size());
        assertTrue(DataList.getMeasure().contains(m));
    }
    /**
     * Throws an exception for testAdd() function
     */
    @Test
    public void testAddException()
    {
        MeasurementData DataList=mockList();
        assertThrows(IllegalArgumentException.class,()->{
            DataList.add(mockMeasure());
        });
    }

    /**
     * Gets the data for a particular item from the Recyclerview
     */

    @Test
    public void testGetMeasure()
    {
        MeasurementData DataList = mockList();
        assertEquals(0, mockMeasure().compareTo(mockList().getMeasure().get(0)));

        Measurement measure = new Measurement("23/07/2022","1:45pm",120,70,65,"normal");
        DataList.add(measure);

        assertEquals(0, measure.compareTo(DataList.getMeasure().get(1)));
        assertEquals(0, mockMeasure().compareTo(DataList.getMeasure().get(0)));
    }
    /**
     * Deletes a measurement data from the Recyclerview and checks if it's deleted or not
     */
    @Test
    public void testDelete()
    {
        MeasurementData mList=mockList();
        Measurement measure = new Measurement("23/07/2022","1:45pm",120,70,65,"normal");
        mList.add(measure);
        assertTrue(mList.getMeasure().contains(measure));
        mList.delete(measure);
        assertFalse(mList.getMeasure().contains(measure));

    }
    /**
     * Throws an exception for testDelete() function
     */
    @Test
    public void testDeleteException()
    {
        MeasurementData mList=mockList();
        Measurement measure = new Measurement("23/07/2022","1:45pm",120,70,65,"normal");
        assertThrows(IllegalArgumentException.class,()->{
            mList.delete(measure);
        });
    }
    /**
     * Edits a measurement data in the Recyclerview and check if it's edited or not
     */
    @Test
    public void testEdit()
    {
        MeasurementData DataList=mockList();
        Measurement measure = new Measurement("23/07/2022","8:45pm",120,70,65,"normal");
        DataList.add(measure);
        assertTrue(DataList.getMeasure().contains(measure));
        Measurement another=new Measurement("22/07/2022","2:30am",100,60,50,"low");
        DataList.edit(1,another);
        assertFalse(DataList.getMeasure().contains(measure));
        assertTrue(DataList.getMeasure().contains(another));
    }

}