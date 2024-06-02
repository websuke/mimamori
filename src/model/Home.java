package model;

public class Home {
    /** ホームID */
    private double id;
    /** 器材 */
    private final Equipment equipment;
    /** 滞在規定時間(分) */
    private final long regulationOfStayMinute;
    /** 利用間隔規定時間(分) */
    private final long usageIntervalRegulationMinute;

    public Home(double homeId, Equipment equipment, long regulationOfStayTime, long usageIntervalRegulationTime) {
        this.id = homeId;
        this.equipment = equipment;
        this.regulationOfStayMinute = regulationOfStayTime;
        this.usageIntervalRegulationMinute = usageIntervalRegulationTime;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public double getRegulationOfStayMinute() {
        return regulationOfStayMinute;
    }

    public double getUsageIntervalRegulationMinute() {
        return usageIntervalRegulationMinute;
    }

    /**
     * 最新の入退室記録取得
     * @return
     */
    public EntryExitRecord getLatestEntryExitRecord() {
        return getEquipment().getLatestEntryExitRecord();
    }
}
