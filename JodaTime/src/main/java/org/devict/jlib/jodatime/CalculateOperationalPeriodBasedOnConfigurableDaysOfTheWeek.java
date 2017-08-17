package org.devict.jlib.jodatime;

import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;

public class CalculateOperationalPeriodBasedOnConfigurableDaysOfTheWeek {
   public static void main(String[] args) {
      PayPeriodCalculator wedThruTue = new PayPeriodCalculator(DayOfWeek.WEDNESDAY, DayOfWeek.TUESDAY);

      System.out.println("Wednesday through Tuesday");
      System.out.println(StringUtils.center("-", 75, '-'));
      Range<LocalDateTime> calculation = wedThruTue.calculatePayPeriod(new LocalDateTime(2017, 8, 17, 0, 0, 0));
      System.out.printf("Aug 17 2017 -> %s %s\n", calculation.getMinimum(), calculation.getMaximum());
      calculation = wedThruTue.calculatePayPeriod(new LocalDateTime(2017, 8, 22, 0, 0, 0));
      System.out.printf("Aug 22 2017 -> %s %s\n", calculation.getMinimum(), calculation.getMaximum());
      calculation = wedThruTue.calculatePayPeriod(new LocalDateTime(2017, 7, 4, 0, 0, 0));
      System.out.printf("July 4 2017 -> %s %s\n", calculation.getMinimum(), calculation.getMaximum());

      System.out.println("\nSunday through Saturday");
      System.out.println(StringUtils.center("-", 75, '-'));
      PayPeriodCalculator sunThruSat = new PayPeriodCalculator(DayOfWeek.SUNDAY, DayOfWeek.SATURDAY);
      calculation = sunThruSat.calculatePayPeriod(new LocalDateTime(2017, 8, 17, 0, 0, 0));
      System.out.printf("Aug 17 2017 -> %s %s\n", calculation.getMinimum(), calculation.getMaximum());
      calculation = sunThruSat.calculatePayPeriod(new LocalDateTime(2017, 8, 22, 0, 0, 0));
      System.out.printf("Aug 22 2017 -> %s %s\n", calculation.getMinimum(), calculation.getMaximum());
      calculation = sunThruSat.calculatePayPeriod(new LocalDateTime(2017, 7, 4, 0, 0, 0));
      System.out.printf("July 4 2017 -> %s %s\n", calculation.getMinimum(), calculation.getMaximum());
   }
}
