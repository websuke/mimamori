package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Equipment {
    /** 器材ID */
    private String id;

    /** 入退室記録 */
    private List<EntryExitRecord> entryExitRecords;

    public Equipment(String id) {
        this.id = id;
        this.entryExitRecords = new ArrayList<>(){
            {
                add(new EntryExitRecord(
                        LocalDateTime.of(2024, 1, 10, 10, 10),
                        LocalDateTime.of(2024, 1, 10, 10, 15)
                ));
                add(new EntryExitRecord(
                        LocalDateTime.of(2024, 1, 10, 12, 10),
                        LocalDateTime.of(2024, 1, 10, 12, 12)
                ));
                add(new EntryExitRecord(
                        LocalDateTime.of(2024, 1, 10, 13, 10),
                        null
//                        LocalDateTime.of(2024, 1, 10, 13, 11)
                ));
            }
        };
    }

    /**
     * 最新の入退室記録取得
     * @return
     */
    public EntryExitRecord getLatestEntryExitRecord() {
        return entryExitRecords
                .stream()
                .max((p1, p2) -> p1.getEntryDateTime().compareTo(p2.getEntryDateTime())).get();
    }
}
