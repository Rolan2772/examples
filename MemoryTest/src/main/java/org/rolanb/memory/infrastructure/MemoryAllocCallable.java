package org.rolanb.memory.infrastructure;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MemoryAllocCallable implements Callable<Void> {

    public static final int DEFAULT_SIZE = 1024;

    @Override
    public Void call() throws Exception {
        final byte[] bytes = new byte[DEFAULT_SIZE];
        ThreadLocalRandom.current().nextBytes(bytes);
        log.info("Allocated {} bytes: {}", bytes.length, bytes);
        TimeUnit.SECONDS.sleep(1);
        return null;
    }
}
