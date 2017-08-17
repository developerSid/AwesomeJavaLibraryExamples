package org.devict.jlib.jodatime;

import java.util.Optional;

public enum DayOfWeek {
   MONDAY(1),
   TUESDAY(2),
   WEDNESDAY(3),
   THURSDAY(4),
   FRIDAY(5),
   SATURDAY(6),
   SUNDAY(7);

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
