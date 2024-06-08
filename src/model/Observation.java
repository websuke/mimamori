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

    /**
     * 滞在規定時間超過
     * @return
     */
    public boolean exceedingTheStipulatedStayTime(){
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
    public boolean usageIntervalRegulationTime() {
        return true;
    }
}
