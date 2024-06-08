package model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Observation {
    /** 家庭 */
    private Home home;

    public Observation(Home home) {
        this.home = home;
    }

    public boolean watch() {

        if (home.isMonitoredTarget()) {
            home.modifiedLastMonitoringTime();

            return exceedingTheStipulatedStayTime();
        }

        return false;

//        usageIntervalRegulationTime();
    }

    /**
     * 滞在規定時間超過
     * @return
     */
    private boolean exceedingTheStipulatedStayTime(){
        List<EntryExitRecord> latestEntryExitRecords = home.getEntryTimeForThoseWhoHaveNotLeftTheRoom();

        for (EntryExitRecord latestEntryExitRecord : latestEntryExitRecords) {
            long elapsedTime = ChronoUnit.MINUTES.between(
                    latestEntryExitRecord.getEntryDateTime(),
                    LocalDateTime.now()
            );

            if (home.getRegulationOfStayMinute() <= elapsedTime) {
                return true;
            }
        }

        return false;
    }

    /**
     * 利用間隔規定時間超過
     * @return
     */
    private boolean usageIntervalRegulationTime() {
        return true;
    }
}
