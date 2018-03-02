package com.bink.mobilemasts;

import com.bink.mobilemasts.models.Mast;
import com.bink.mobilemasts.utils.MastParser;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.StringReader;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Cyan on 02/03/2018.
 */

public class MastParserUnitTest {
    // Csv buffer
    private static String mCsvBuffer;

    @BeforeClass
    public static void setup(){
        mCsvBuffer = "Property Name,Property Address [1],Property  Address [2],Property Address [3],Property Address [4],Unit Name,Tenant Name,Lease Start Date,Lease End Date,Lease Years,Current Rent\n" +
                "Beecroft Hill,Broad Lane,,,LS13,Beecroft Hill - Telecom App,Arqiva Services ltd,01 Mar 1994,28 Feb 2058,64,23950.00\n" +
                "Potternewton Crescent,Potternewton Est Playing Field,,,LS7,Potternewton Est Playing Field,Arqiva Ltd,24 Jun 1999,23 Jun 2019,20,6600.00\n" +
                "Seacroft Gate (Chase) - Block 2,Telecomms Apparatus,Leeds,,LS14,Seacroft Gate (Chase) block 2-Telecom App.,Vodafone Ltd.,30 Jan 2004,29 Jan 2029,25,12250.00";
    }

    @Test
    public void test_csv_load_unordered_list (){
        List<Mast> mastList = MastParser.readFromCsv(new StringReader(mCsvBuffer), null);
        assertEquals(mastList.size(), 3);
    }

    @Test
    public void test_csv_load_ordered_list_ascending (){
        List<Mast> mastList = MastParser.readFromCsv(new StringReader(mCsvBuffer),
                ((mast, t1) -> mast.getLeaseYears() > t1.getLeaseYears() ? 1 : (mast.getLeaseYears() < t1.getLeaseYears() ? -1 : 0)));

        assertEquals(mastList.get(0).getPropertyName(), "Potternewton Crescent");
    }

    @Test
    public void test_csv_load_ordered_list_descending (){
        List<Mast> mastList = MastParser.readFromCsv(new StringReader(mCsvBuffer),
                ((mast, t1) -> mast.getLeaseYears() > t1.getLeaseYears() ? -1 : (mast.getLeaseYears() < t1.getLeaseYears() ? 1 : 0)));

        assertEquals(mastList.get(0).getPropertyName(), "Beecroft Hill");
    }
}
