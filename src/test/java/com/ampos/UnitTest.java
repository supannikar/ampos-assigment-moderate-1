package com.ampos;

import com.ampos.moderate1.QuizModerate1;
import com.ampos.moderate1.TableReservation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UnitTest {
    @Test
    public void testCase1() {
        QuizModerate1 answerClass = new QuizModerate1();
        
        List<TableReservation> input = new ArrayList<TableReservation>();
        input.add(new TableReservation("13:00", "14:00"));
        input.add(new TableReservation("11:00", "12:00"));
        input.add(new TableReservation("11:30", "12:30"));
        input.add(new TableReservation("11:40", "12:40"));
        
        int result = answerClass.run(input);
        assertThat(result, is(3));
    }
    
    @Test
    public void testCase2() {
        QuizModerate1 answerClass = new QuizModerate1();
        
        List<TableReservation> input = new ArrayList<TableReservation>();
        input.add(new TableReservation("13:00", "14:00"));
        input.add(new TableReservation("11:00", "12:00"));
        input.add(new TableReservation("11:30", "12:30"));
        input.add(new TableReservation("11:40", "12:40"));
        input.add(new TableReservation("10:00", "17:00"));

        
        int result = answerClass.run(input);
        assertThat(result, is(4));
    }
    
    @Test
    public void testCase3() {
        QuizModerate1 answerClass = new QuizModerate1();
        
        List<TableReservation> input = new ArrayList<TableReservation>();
        input.add(new TableReservation("00:00", "23:59"));
        input.add(new TableReservation("11:00", "12:00"));
        input.add(new TableReservation("11:30", "12:30"));
        input.add(new TableReservation("11:40", "12:40"));
        input.add(new TableReservation("10:00", "11:00"));

        
        int result = answerClass.run(input);
        assertThat(result, is(4));
    }
    
    @Test
    public void testCase4() {
        QuizModerate1 answerClass = new QuizModerate1();
        
        List<TableReservation> input = new ArrayList<TableReservation>();

        int result = answerClass.run(input);
        assertThat(result, is(0));
    }

    @Test
    public void testCase5() {
        QuizModerate1 answerClass = new QuizModerate1();
        
        List<TableReservation> input = new ArrayList<TableReservation>();
        input.add(new TableReservation("07:00", "10:00"));
        input.add(new TableReservation("10:00", "14:00"));
        input.add(new TableReservation("08:00", "10:00"));
        input.add(new TableReservation("13:00", "15:00"));
        input.add(new TableReservation("09:00", "11:30"));

        int result = answerClass.run(input);
        assertThat(result, is(4));
    }
}
