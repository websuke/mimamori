import model.Equipment;
import model.Home;
import model.Observation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        while (true) {
            // 佐藤さん、鈴木さん
            getHomes().forEach(home -> {
                var observation = new Observation(home);
                if (observation.exceedingTheStipulatedStayTime()) {
                    // 滞在規定時間超過
                    System.out.println("異常です");
                }
                if (observation.usageIntervalRegulationTime()) {
                    // 利用間隔規定時間超過
                }
            });

            Thread.sleep(30000L);
        }

        // それぞれの監視インスタンスの監視メソッド？

        // 委譲検知の場合のみ通知
    }

    public static List<Home> getHomes() {
        List<Home> homes = new ArrayList<>();
        homes.add(new Home("1", List.of(new Equipment("1")), 60L, 720L));
        homes.add(new Home("2", List.of(new Equipment("2")), 90L, 1440L));


        return homes;
    }
}