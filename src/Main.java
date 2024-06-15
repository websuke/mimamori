import model.Observation;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        while (true) {
            // 佐藤さん、鈴木さん
            var observation = new Observation();
            observation.watch();
            Thread.sleep(1000L); // TODO 実際には1分〜10分くらいでも良いのでは？
        }

        // それぞれの監視インスタンスの監視メソッド？

        // 委譲検知の場合のみ通知
    }

}