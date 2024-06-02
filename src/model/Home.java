package model;

public class Home {
    /** ホームID */
    private double id;
    /** 器材 */
    private final Equipment equipment;
    /** 滞在規定時間 */
    private final double regulationOfStayTime;
    /** 利用間隔規定時間 */
    private final double usageIntervalRegulationTime;

    public Home(double homeId, Equipment equipment, double regulationOfStayTime, double usageIntervalRegulationTime) {
        this.id = homeId;
        this.equipment = equipment;
        this.regulationOfStayTime = regulationOfStayTime;
        this.usageIntervalRegulationTime = usageIntervalRegulationTime;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    /**
     * 最新の入退室記録取得
     * @return
     */
    public EntryExitRecord getLatestEntryExitRecord() {
        return getEquipment().getLatestEntryExitRecord();
    }
}
