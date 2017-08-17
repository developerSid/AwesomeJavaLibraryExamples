package org.devict.jlib.jodatime;

import org.apache.commons.lang3.Range;
import org.joda.time.LocalDateTime;

public class PayPeriodCalculator {
   private final DayOfWeek beginningDayOfWeek;
   private final DayOfWeek endingDayOfWeek;

   public PayPeriodCalculator(DayOfWeek beginningOfWeek, DayOfWeek endOfWeek) {
      this.beginningDayOfWeek = beginningOfWeek;
      this.endingDayOfWeek = endOfWeek;
   }

   public Range<LocalDateTime> calculatePayPeriod(LocalDateTime dateTime) {
      int todayDayOfWeekNumber = dateTime.getDayOfWeek();
      int endingDifference = endingDayOfWeek.getDayNumber() - todayDayOfWeekNumber;
      int beginningDifference = beginningDayOfWeek.getDayNumber() - todayDayOfWeekNumber;
      LocalDateTime beginningDateTime = calculateEndingDateTime(dateTime, beginningDifference).toDateTime().withTimeAtStartOfDay().toLocalDateTime();
      LocalDateTime endingDateTime = calculateBeginningDateTime(dateTime, endingDifference).toDateTime().withTimeAtStartOfDay().plusHours(23).plusMinutes(59).plusSeconds(59).toLocalDateTime();

      return Range.between(beginningDateTime, endingDateTime, LocalDateTime::compareTo);
   }

   private LocalDateTime calculateBeginningDateTime(LocalDateTime dateTime, int endingDifference) {
      if (endingDifference < 0) {
         return dateTime.plusDays(Math.abs(Math.abs(endingDifference) - 7));
      } else {
         return dateTime.plusDays(endingDifference);
      }
   }

   private LocalDateTime calculateEndingDateTime(LocalDateTime dateTime, int beginningDifference) {
      if (beginningDifference < 1) {
         return dateTime.minusDays(Math.abs(beginningDifference));
      } else {
         return dateTime.minusDays(Math.abs(beginningDifference - 7));
      }
   }
}
