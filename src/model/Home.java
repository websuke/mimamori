package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Home {
    /** ホームID */
    private String id;
    /** 器材 */
    private final List<Equipment> equipments;
    /** 滞在規定時間(分) */
    private final long regulationOfStayMinute;
    /** 利用間隔規定時間(分) */
    private final long usageIntervalRegulationMinute;
    /** 監視間隔(分) */
    private final long monitoringInterval;
    /** 最終監視時間(分) */
    private LocalDateTime lastMonitoringTime;

    public Home(String homeId,
                List<Equipment> equipments,
                long regulationOfStayTime,
                long usageIntervalRegulationTime,
                long monitoringInterval,
                LocalDateTime lastMonitoringTime
    ) {
        this.id = homeId;
        this.equipments = equipments;
        this.regulationOfStayMinute = regulationOfStayTime;
        this.usageIntervalRegulationMinute = usageIntervalRegulationTime;
        this.monitoringInterval = monitoringInterval;
        this.lastMonitoringTime = lastMonitoringTime;
    }

    public List<Equipment> getEquipment() {
        return equipments;
    }

    public double getRegulationOfStayMinute() {
        return regulationOfStayMinute;
    }

    public double getUsageIntervalRegulationMinute() {
        return usageIntervalRegulationMinute;
    }

    public LocalDateTime modifiedLastMonitoringTime() {
        this.lastMonitoringTime = LocalDateTime.now();

        return this.lastMonitoringTime;
    }

    /**
     * 未退室の入退室記録を取得
     * @return
     */
    public List<EntryExitRecord> getEntryTimeForThoseWhoHaveNotLeftTheRoom() {
        List<EntryExitRecord> result = new ArrayList<>();

        for (Equipment equipment : equipments) {
            EntryExitRecord latestEntryExitRecord = equipment.getLatestEntryExitRecord();
            if (latestEntryExitRecord == null) {
                break;
            }

            if (latestEntryExitRecord.getExitDateTime() == null) {
                result.add(latestEntryExitRecord);
            }
        }

        return result;

    }
}
