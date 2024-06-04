package model;

import java.util.List;

public class Home {
    /** ホームID */
    private double id;
    /** 器材 */
    private final List<Equipment> equipment;
    /** 滞在規定時間(分) */
    private final long regulationOfStayMinute;
    /** 利用間隔規定時間(分) */
    private final long usageIntervalRegulationMinute;

    public Home(double homeId, List<Equipment> equipment, long regulationOfStayTime, long usageIntervalRegulationTime) {
        this.id = homeId;
        this.equipment = equipment;
        this.regulationOfStayMinute = regulationOfStayTime;
        this.usageIntervalRegulationMinute = usageIntervalRegulationTime;
    }

    public List<Equipment> getEquipment() {
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
