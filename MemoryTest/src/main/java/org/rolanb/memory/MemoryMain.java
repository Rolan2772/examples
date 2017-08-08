package org.rolanb.memory;

import lombok.extern.slf4j.Slf4j;
import org.rolanb.memory.infrastructure.MemoryConsumer;

import java.util.concurrent.TimeUnit;

@Slf4j
public class MemoryMain {

    public static void main(String... args) throws InterruptedException {
        log.info("Consuming memory...");
        MemoryConsumer memoryConsumer = new MemoryConsumer(1000);
        memoryConsumer.consume(20);
        memoryConsumer.consume(200);
        memoryConsumer.consume(2000);
        memoryConsumer.consume(20000);

        while (!Thread.currentThread().isInterrupted()) {
            TimeUnit.MINUTES.sleep(1);
        }

        memoryConsumer.shutdown();

    }
}
// 1000 131
// 2000 180
// 3000 205
// 4000 344
