package model;

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
