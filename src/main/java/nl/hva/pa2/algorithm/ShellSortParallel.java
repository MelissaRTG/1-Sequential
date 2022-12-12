package nl.hva.pa2.algorithm;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class ShellSortParallel {

    private int TOTAL_THREADS;
    private volatile ShellSortSequential sorter = new ShellSortSequential();
    private AtomicInteger currentThreadsCount = new AtomicInteger(0);

    //ArrayLists
    private volatile ArrayList<Threads> threads = new ArrayList<>();
    private volatile List<List<Crypto>> splitLists;
    private volatile List<Crypto> extremes = new ArrayList<>();

public ShellSortParallel(int threads) {
    this.TOTAL_THREADS = threads;
}

    // Arraylist
    private void sortExtremes() {

        for (Crypto extreme : this.extremes) {
          extreme = (Crypto) sorter.shellSort(extremes);
        }


    }

    private void increment() {
        currentThreadsCount.incrementAndGet();
    }

    private synchronized void startThreads() {
        for (Threads thread : this.threads) {

            thread.start();
            increment();
       }
    }

    private synchronized void getResultsFromThreads() {
        //Count iterations
       try {
            for (Threads thread : this.threads) {
                thread.join();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private synchronized void createThreads(){
        for (List<Crypto> splitList : this.splitLists) {
            this.threads.add(new Threads((List<Crypto>) splitList));
        }
    }



   private long startTime;
   private long endTime;
    public synchronized void parallelSort(List<Crypto> array) {
        this.startTime = System.nanoTime();
        final AtomicInteger counter = new AtomicInteger();
        int chunkSize = array.size() / TOTAL_THREADS;
        if(array.size() % TOTAL_THREADS != 0) {
            chunkSize++;
        }
        int finalChunkSize = chunkSize;
        splitLists = new ArrayList<>(array.stream()
        .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / finalChunkSize))
        .values());
        createThreads();
            this.startThreads();
            Thread.yield();
            this.getResultsFromThreads();
            this.sortExtremes();
            this.endTime= System.nanoTime();
            double elapsed = endTime - startTime;

        System.out.printf("Time for the Parallel way to finish: %, .0f ns on %d threads\n", elapsed, this.currentThreadsCount.get());

    }

}
