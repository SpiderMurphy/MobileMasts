package com.bink.mobilemasts.utils;

import com.bink.mobilemasts.models.Mast;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Cyan on 02/03/2018.
 */

public class MastParser {
    /**
     *
     *
     * @param reader
     * @param comparator
     * @return
     */
    public static List<Mast> readFromCsv(Reader reader, Comparator<Mast> comparator) {
        // Masts
        List<Mast> mastList = new LinkedList<>();

        // CSV reader
        CSVReader csvReader = new CSVReader(reader);

        // Header first line
        List<String> header = null;

        try {
            header = Arrays.asList(csvReader.readNext());

            String[] row = null;

            while((row = csvReader.readNext()) != null){
                mastList.add(getFrom(row, header));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(comparator != null)
            Collections.sort(mastList, comparator);

        return mastList;
    }

    /**
     *
     *
     * @param buffer
     * @param header
     * @return
     */
    public static Mast getFrom(String[] buffer, List<String> header){
        // Mast value
        Mast mast = new Mast();

        // Date format dd MMM yyyy (always en)
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);

        // Numbers and dates
        Double currentRent = Double.valueOf(buffer[header.indexOf("Current Rent")]);
        Integer leaseYears = Integer.valueOf(buffer[header.indexOf("Lease Years")]);
        Date leaseStartDate = null;
        Date leaseEndDate = null;

        try {
            leaseStartDate = dateFormat.parse(buffer[header.indexOf("Lease Start Date")]);
            leaseEndDate = dateFormat.parse(buffer[header.indexOf("Lease End Date")]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        mast.setPropertyName(buffer[header.indexOf("Property Name")]);
        mast.setPropertyAddress1(buffer[header.indexOf("Property Address [1]")]);
        mast.setPropertyAddress2(buffer[header.indexOf("Property  Address [2]")]);
        mast.setPropertyAddress3(buffer[header.indexOf("Property Address [3]")]);
        mast.setPropertyAddress4(buffer[header.indexOf("Property Address [4]")]);
        mast.setUnitName(buffer[header.indexOf("Unit Name")]);
        mast.setCurrentRent(currentRent == null ? 0.0 : currentRent);
        mast.setLeaseYears(leaseYears == null ? 0 : leaseYears);
        mast.setLeaseStartDate(leaseStartDate);
        mast.setLeaseEndDate(leaseEndDate);

        return mast;
    }
}
