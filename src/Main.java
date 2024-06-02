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
        homes.add(new Home(1L, new Equipment(1L), 1, 12));
        homes.add(new Home(2L, new Equipment(2L), 1.5, 24));

        return homes;
    }
}