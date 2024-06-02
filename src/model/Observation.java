package model;

import java.time.Duration;

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
        double regulationOfStayTime = home.getRegulationOfStayMinute();
        // Durationを使って差分を計算

        Duration duration = Duration.between(
                latestEntryExitRecord.getEntryDateTime(),
                latestEntryExitRecord.getExitDateTime()
        );
        // 差分を日、時間、分で取得
        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        return true;
    }

    /**
     * 利用間隔規定時間超過
     * @return
     */
    public boolean usageIntervalRegulationTime() {
        return true;
    }
}
