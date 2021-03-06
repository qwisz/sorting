package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.Helper;
import ru.mail.polis.sort.MergeSortWM;

import java.util.concurrent.TimeUnit;

/**
 * Created by Anton on 22.11.2016.
 */

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MergeSortWMBench {

    private int[] a;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        a = Helper.gen(1000000);
        for (int i = 0; i < 10; i++) {
        }
    }

    @Benchmark
    public void measureMergeSortWM(Blackhole bh) {
        bh.consume(MergeSortWM.sort(a));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MergeSortWMBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
