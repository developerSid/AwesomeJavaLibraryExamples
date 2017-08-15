package org.devict.jlib.jodatime;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.joda.time.LocalDateTime;

import java.util.Optional;

public class CalcluateOperationalPeriodBasedOnConfigurableDaysOfTheWeek {
   private enum DayOfWeek {
      SUNDAY(0),
      MONDAY(1),
      TUESDAY(2),
      WEDNESDAY(3),
      THURSDAY(4),
      FRIDAY(5),
      SATURDAY(6);

      private final int dayNumber;

      DayOfWeek(int dayNumber) {
         this.dayNumber = dayNumber;
      }

      public int getDayNumber() {
         return dayNumber;
      }

      private static Optional<DayOfWeek> findByName(String name) {
         for (DayOfWeek dayOfWeek: DayOfWeek.values()) {
            if (dayOfWeek.name().equalsIgnoreCase(name)) {
               return Optional.of(dayOfWeek);
            }
         }

         return Optional.empty();
      }
   }

   private static final String BEGINNING_DAY_OF_WEEK = "Wednesday";
   private static final String ENDING_DAY_OF_WEEK = "Tuesday";

   public static void main(String[] args) {
      ImmutablePair<LocalDateTime, LocalDateTime> mondayAugust14th = calculateRangeOfDays(new LocalDateTime(2017, 8, 14, 0, 0, 0));
      ImmutablePair<LocalDateTime, LocalDateTime> tuesdayAugust15th = calculateRangeOfDays(new LocalDateTime(2017, 8, 15, 0, 0, 0));
      ImmutablePair<LocalDateTime, LocalDateTime> fridayJuly7th = calculateRangeOfDays(new LocalDateTime(2017, 7, 7, 0, 0, 0));

      System.out.printf("%s -> %s\n", mondayAugust14th.left, mondayAugust14th.right);
      System.out.printf("%s -> %s\n", tuesdayAugust15th.left, tuesdayAugust15th.right);
      System.out.printf("%s -> %s\n", fridayJuly7th.left, fridayJuly7th.right);
   }

   private static ImmutablePair<LocalDateTime, LocalDateTime> calculateRangeOfDays(LocalDateTime dateTime) {
      DayOfWeek beginningDayOfWeek = DayOfWeek.findByName(BEGINNING_DAY_OF_WEEK).orElseThrow(() -> new RuntimeException("Unable to find day"));
      DayOfWeek endingDayOfWeek = DayOfWeek.findByName(ENDING_DAY_OF_WEEK).orElseThrow(() -> new RuntimeException("Unable to find day"));
      int todayDayOfWeekNumber = dateTime.getDayOfWeek();

      LocalDateTime beginningDateTime = dateTime.plusDays(beginningDayOfWeek.dayNumber - todayDayOfWeekNumber).minusDays(7);
      LocalDateTime endDateTime = dateTime.plusDays(endingDayOfWeek.dayNumber - todayDayOfWeekNumber).toDateTime().withTimeAtStartOfDay().plusHours(23).plusMinutes(59).toLocalDateTime();

      return new ImmutablePair<>(beginningDateTime, endDateTime);
   }
}
