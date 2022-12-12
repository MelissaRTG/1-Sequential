package nl.hva.pa2.algorithm;

import java.util.List;

//import static sun.util.locale.LocaleUtils.isEmpty;

public class ShellSortSequential {

    private long startTime;
    private long endTime;


    public List<Crypto> shellSort(List<Crypto> data) {
        int n = data.size();
        String newLine = System.getProperty("line.separator");
        for (int step = n / 2; step > 0; step /= 2) {
            for (int i = step; i < n; i++) {
                for (int j = i - step; j >= 0 && data.get(j).getPriceChange() > data.get(j + step).getPriceChange(); j -= step) {
                    Crypto x = data.get(j);
                    data.set(j, data.get(j + step));
                    data.set(j + step, x);
                }
            }
        }
        //System.out.println(data + newLine);

        return data;
    }

    public List<Crypto> sequentialSort(List<Crypto> array) {
        this.startTime = System.nanoTime();
        List<Crypto> sorted = shellSort(array);
        this.endTime = System.nanoTime();


        System.out.printf(
                "Time for the Sequential way to finish: %, d ns\n", this.endTime - this.startTime
        );
        return sorted;
    }


}
