package model;

import java.time.LocalDateTime;

public class EntryExitRecord {
    /** 入室時間 */
    private LocalDateTime entryDateTime;

    /** 退室時間 */
    private LocalDateTime exitDateTime;

    public EntryExitRecord(LocalDateTime entryDateTime, LocalDateTime exitDateTime) {
        this.entryDateTime = entryDateTime;
        this.exitDateTime = exitDateTime;
    }

    public LocalDateTime getEntryDateTime() {
        return entryDateTime;
    }

    public LocalDateTime getExitDateTime() {
        return exitDateTime;
    }
}
