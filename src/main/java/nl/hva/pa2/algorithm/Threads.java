package nl.hva.pa2.algorithm;

import java.util.List;

public class Threads extends Thread {
    private ShellSortSequential shellSort = new ShellSortSequential();
    private List<Crypto> list;

    public Threads(List<Crypto> list) {
        this.list = list;
    }

    public void run() {
        this.list = shellSort.shellSort(list);
    }

    public List<Crypto> returnList() {
        return this.list;
    }
}
