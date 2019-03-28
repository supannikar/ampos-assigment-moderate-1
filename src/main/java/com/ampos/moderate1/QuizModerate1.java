// MODERATE-1

package com.ampos.moderate1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class QuizModerate1 {
    public int run(List<TableReservation> customerList) {
        int count = 0;
        try {
            SimpleDateFormat df = new SimpleDateFormat("HH:mm");

            for (int i = 0; i < customerList.size(); i++) {
                Date currentStart;
                Date currentEnd;
                Date nextStart;
                Date nextEnd;
                if (i == customerList.size()-1) {
                    currentStart = df.parse(customerList.get(i).startTime);
                    currentEnd = df.parse(customerList.get(i).endTime);
                    nextStart = df.parse(customerList.get(0).startTime);
                    nextEnd = df.parse(customerList.get(0).endTime);
                } else {
                    currentStart = df.parse(customerList.get(i).startTime);
                    currentEnd = df.parse(customerList.get(i).endTime);
                    nextStart = df.parse(customerList.get(i+1).startTime);
                    nextEnd = df.parse(customerList.get(i+1).endTime);
                }

                if (isOverlapping(currentStart, currentEnd, nextStart, nextEnd)) {
                    count++;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return count;
    }

    private boolean isOverlapping(Date currentStart,
                                 Date currentEnd,
                                 Date nextStart,
                                 Date nextEnd) {
        return currentStart.before(nextEnd)
                || (currentStart.equals(nextEnd) && currentEnd.after(nextStart));
    }

}
