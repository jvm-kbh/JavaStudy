package me.kbh.javastudy.basic.ch07;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 1)
@Measurement(iterations = 1, time = 1)
public class TestStreamBenchmark {

  private static long testNumber = 0;

  @Setup
  public void setUp() {
    testNumber = 10_000_000L;
  }

  @Benchmark
  public long sequentialSumBenchmark() {
    return TestStream.sequentialSum(testNumber);
  }

  @Benchmark
  public long iterativeSumBenchmark() {
    return TestStream.iterativeSum(testNumber);
  }

  @Benchmark
  public long parallelSumBenchmark() {
    return TestStream.parallelSum(testNumber);
  }
}
