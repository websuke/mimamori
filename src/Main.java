import model.Equipment;
import model.Home;
import model.Observation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        var test = getHomes();
        while (true) {
            // 佐藤さん、鈴木さん
            test.forEach(home -> {
                var observation = new Observation(home);
                if (observation.watch()) {
                    // 滞在規定時間超過
                    // 利用間隔規定時間超過
                    System.out.println("異常です" + home.getId());
                }
            });

            Thread.sleep(1000L); // TODO 実際には1分〜10分くらいでも良いのでは？
        }

        // それぞれの監視インスタンスの監視メソッド？

        // 委譲検知の場合のみ通知
    }

    public static List<Home> getHomes() {
        List<Home> homes = new ArrayList<>();
        homes.add(new Home("1",
                List.of(new Equipment("1")),
                60L,
                720L,
                        1,
                LocalDateTime.of(1970, 1, 1, 0, 0)
                )
        );

        homes.add(new Home("2",
                List.of(new Equipment("2")),
                90L,
                1440L,
                2,
                LocalDateTime.of(1970, 1, 1, 0, 0)
                )
        );


        return homes;
    }
}