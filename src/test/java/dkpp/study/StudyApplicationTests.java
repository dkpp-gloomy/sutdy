package dkpp.study;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;


class StudyApplicationTests {


    @Test
    void contextLoads() throws InterruptedException {
        ConcurrentHashMap<Integer, Object> map = new ConcurrentHashMap<>();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int j = 0; j < 100; j++) {
            new Thread(() -> {
                for (int r = 0; r < 8000; r++) {
                    int andIncrement = atomicInteger.getAndIncrement();
                    map.put(andIncrement, andIncrement);
                }
            }).start();
        }
        Thread.sleep(2000);
        System.out.println(atomicInteger.get());
        System.out.println(map.size());


    }

    @Test
    void test() throws InterruptedException {
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        System.out.println(a == b);
        System.out.println(c == d);

    }

}
