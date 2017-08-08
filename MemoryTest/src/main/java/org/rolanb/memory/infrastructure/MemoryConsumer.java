package org.rolanb.memory.infrastructure;


import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class MemoryConsumer {

    private ExecutorService executorService;

    public MemoryConsumer(int poolSize) {
        executorService = Executors.newFixedThreadPool(poolSize);
    }

    public void consume(int threadsCount) {
        IntStream.range(0, threadsCount)
                .forEach(index -> executorService.submit(new MemoryAllocCallable()));
    }

    public List<Runnable> shutdown() {
        return executorService.shutdownNow();
    }
}