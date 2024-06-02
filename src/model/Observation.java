package model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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
        EntryExitRecord latestEntryExitRecord = home.getLatestEntryExitRecord();

        // 最新の退出時間があればスルー
        if (latestEntryExitRecord.getExitDateTime() != null) {
            return false;
        }

        long elapsedTime = ChronoUnit.MINUTES.between(
                latestEntryExitRecord.getEntryDateTime(),
                LocalDateTime.now()
        );

        return home.getRegulationOfStayMinute() <= elapsedTime;
    }

    /**
     * 利用間隔規定時間超過
     * @return
     */
    public boolean usageIntervalRegulationTime() {
        return true;
    }
}
