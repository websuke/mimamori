package model;

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

    public Home(String homeId, List<Equipment> equipments, long regulationOfStayTime, long usageIntervalRegulationTime) {
        this.id = homeId;
        this.equipments = equipments;
        this.regulationOfStayMinute = regulationOfStayTime;
        this.usageIntervalRegulationMinute = usageIntervalRegulationTime;
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
