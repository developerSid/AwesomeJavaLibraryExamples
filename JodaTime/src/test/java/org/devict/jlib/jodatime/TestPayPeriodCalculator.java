package org.devict.jlib.jodatime;

import org.apache.commons.lang3.Range;
import org.joda.time.LocalDateTime;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestPayPeriodCalculator {

   @Test
   public void testWednesdayThroughTuesdayAugust172017() {
      PayPeriodCalculator calculator = new PayPeriodCalculator(DayOfWeek.WEDNESDAY, DayOfWeek.TUESDAY);

      Range<LocalDateTime> result = calculator.calculatePayPeriod(new LocalDateTime(2017, 8, 17, 0, 0, 0));

      assertThat(result.getMinimum()).isEqualByComparingTo(new LocalDateTime(2017, 8, 16, 0, 0, 0));
      assertThat(result.getMaximum()).isEqualByComparingTo(new LocalDateTime(2017, 8, 22, 23, 59, 59));
   }

   @Test
   public void testWednesdayThroughTuesdayAugust152017() {
      PayPeriodCalculator calculator = new PayPeriodCalculator(DayOfWeek.WEDNESDAY, DayOfWeek.TUESDAY);

      Range<LocalDateTime> result = calculator.calculatePayPeriod(new LocalDateTime(2017, 8, 15, 0, 0, 0));

      assertThat(result.getMinimum()).isEqualByComparingTo(new LocalDateTime(2017, 8, 9, 0, 0, 0));
      assertThat(result.getMaximum()).isEqualByComparingTo(new LocalDateTime(2017, 8, 15, 23, 59, 59));
   }

   @Test
   public void testWednesdayThroughTuesdayAugust162017() {
      PayPeriodCalculator calculator = new PayPeriodCalculator(DayOfWeek.WEDNESDAY, DayOfWeek.TUESDAY);

      Range<LocalDateTime> result = calculator.calculatePayPeriod(new LocalDateTime(2017, 8, 16, 0, 0, 0));

      assertThat(result.getMinimum()).isEqualByComparingTo(new LocalDateTime(2017, 8, 16, 0, 0, 0));
      assertThat(result.getMaximum()).isEqualByComparingTo(new LocalDateTime(2017, 8, 22, 23, 59, 59));
   }

   @Test
   public void testWednesdayThroughTuesdayAugust222017() {
      PayPeriodCalculator calculator = new PayPeriodCalculator(DayOfWeek.WEDNESDAY, DayOfWeek.TUESDAY);

      Range<LocalDateTime> result = calculator.calculatePayPeriod(new LocalDateTime(2017, 8, 22, 0, 0, 0));

      assertThat(result.getMinimum()).isEqualByComparingTo(new LocalDateTime(2017, 8, 16, 0, 0, 0));
      assertThat(result.getMaximum()).isEqualByComparingTo(new LocalDateTime(2017, 8, 22, 23, 59, 59));
   }

   @Test
   public void testWednesdayThroughTuesdayAugust232017() {
      PayPeriodCalculator calculator = new PayPeriodCalculator(DayOfWeek.WEDNESDAY, DayOfWeek.TUESDAY);

      Range<LocalDateTime> result = calculator.calculatePayPeriod(new LocalDateTime(2017, 8, 23, 0, 0, 0));

      assertThat(result.getMinimum()).isEqualByComparingTo(new LocalDateTime(2017, 8, 23, 0, 0, 0));
      assertThat(result.getMaximum()).isEqualByComparingTo(new LocalDateTime(2017, 8, 29, 23, 59, 59));
   }

   @Test
   public void testSundayThroughSaturdayAugust172017() {
      PayPeriodCalculator calculator = new PayPeriodCalculator(DayOfWeek.SUNDAY, DayOfWeek.SATURDAY);

      Range<LocalDateTime> result = calculator.calculatePayPeriod(new LocalDateTime(2017, 8, 17, 0, 0, 0));

      assertThat(result.getMinimum()).isEqualByComparingTo(new LocalDateTime(2017, 8, 13, 0, 0, 0));
      assertThat(result.getMaximum()).isEqualByComparingTo(new LocalDateTime(2017, 8, 19, 23, 59, 59));
   }

   @Test
   public void testSundayThroughSaturdayAugust132017() {
      PayPeriodCalculator calculator = new PayPeriodCalculator(DayOfWeek.SUNDAY, DayOfWeek.SATURDAY);

      Range<LocalDateTime> result = calculator.calculatePayPeriod(new LocalDateTime(2017, 8, 13, 0, 0, 0));

      assertThat(result.getMinimum()).isEqualByComparingTo(new LocalDateTime(2017, 8, 13, 0, 0, 0));
      assertThat(result.getMaximum()).isEqualByComparingTo(new LocalDateTime(2017, 8, 19, 23, 59, 59));
   }
}
