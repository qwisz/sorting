package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.BFPRP;
import ru.mail.polis.sort.Helper;
import ru.mail.polis.sort.KStatistic;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anton on 27.11.2016.
 */

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class BFPRPBench {

    private int[] a;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        a = Helper.gen(1000000);
        for (int i = 0; i < 10; i++) {
        }
    }

    @Benchmark
    public void measureBFPRP(Blackhole bh) {
        bh.consume(BFPRP.select(a, a.length/2));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BFPRPBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
