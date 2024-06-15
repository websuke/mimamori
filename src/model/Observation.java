package model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Observation {

    public void watch() {
        List<Home> homes = getHomes();

        for (Home home : homes) {

            if (home.isMonitoredTarget()) {
                home.modifiedLastMonitoringTime();
                if (exceedingTheStipulatedStayTime(home)) {
                    System.out.println("異常です" + home.getId());
                }
            }
        }

        // usageIntervalRegulationTime();
    }

    /**
     * 滞在規定時間超過
     * 
     * @return
     */
    private boolean exceedingTheStipulatedStayTime(Home home) {
        List<EntryExitRecord> latestEntryExitRecords = home.getEntryTimeForThoseWhoHaveNotLeftTheRoom();

        for (EntryExitRecord latestEntryExitRecord : latestEntryExitRecords) {
            long elapsedTime = ChronoUnit.MINUTES.between(
                    latestEntryExitRecord.getEntryDateTime(),
                    LocalDateTime.now());

            if (home.getRegulationOfStayMinute() <= elapsedTime) {
                return true;
            }
        }

        return false;
    }

    /**
     * 利用間隔規定時間超過
     * 
     * @return
     */
    private boolean usageIntervalRegulationTime() {
        return true;
    }

    public static List<Home> getHomes() {
        List<Home> homes = new ArrayList<>();
        homes.add(new Home("1",
                List.of(new Equipment("1")),
                60L,
                720L,
                1,
                LocalDateTime.of(1970, 1, 1, 0, 0)));

        homes.add(new Home("2",
                List.of(new Equipment("2")),
                90L,
                1440L,
                2,
                LocalDateTime.of(1970, 1, 1, 0, 0)));

        return homes;
    }
}
