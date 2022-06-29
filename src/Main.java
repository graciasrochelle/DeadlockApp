import com.deadlock.ThreadDeadlock;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new ThreadDeadlock();

        for (int i = 0; i < 5000; i++) {
            sleep(2000);
            System.out.println("app running...!");
        }
    }
}
