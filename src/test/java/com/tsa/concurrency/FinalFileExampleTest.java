package com.tsa.concurrency;

import org.junit.jupiter.api.Test;

public class FinalFileExampleTest {

    FinalFieldExampleBad bad = new FinalFieldExampleBad();

    @Test
    void shouldCheckConstruction() throws Exception {
        FinalFieldExample finalFileExample = new FinalFieldExample();


        final Thread threadWriter = new Thread(finalFileExample::writer);
        threadWriter.start();

        final Thread threadRead = new Thread(finalFileExample::readerDependency);
        threadRead.start();

        threadRead.join();
        threadWriter.join();
    }

    @Test
    void shouldTestBadConstruct() {


        final Thread threadRead = new Thread(bad::readerDependency);
        threadRead.start();
    }
}
