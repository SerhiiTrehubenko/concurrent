package com.tsa.concurrency;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class VolatileExampleTest {
    @RepeatedTest(20)
    void shouldTestVolatile() {
        VolatileExample volatileExample = new VolatileExample();

        final Thread threadWriter = new Thread(volatileExample::writer);
        final Thread threadReader = new Thread(volatileExample::reader);

        threadWriter.start();
        threadReader.start();
    }
}
