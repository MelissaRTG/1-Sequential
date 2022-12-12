package nl.hva.pa2.algorithm;

import java.io.*;
import java.util.Arrays;


public class Main {


    public static void main(String[] args) throws InterruptedException {
        String line = "";
        String splitBy = ",";
        int cryptoRows = 0;

        try {
            String currentWorkingPath = System.getProperty("user.dir");
            String fullPath = currentWorkingPath + File.separator + "src/main/resources/crypto-markets2_kladblok.txt";
            BufferedReader br = new BufferedReader(new FileReader(fullPath));
            while ((line = br.readLine()) != null) {
                cryptoRows++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Crypto[] cryptoSequential = new Crypto[cryptoRows];


        try {

            String currentWorkingPath = System.getProperty("user.dir");
            String fullPath = currentWorkingPath + File.separator + "src/main/resources/crypto-markets2_kladblok.txt";
            BufferedReader br = new BufferedReader(new FileReader(fullPath));
            int index = 0;
            while ((line = br.readLine()) != null) {
                String[] cryptoData = line.split(splitBy);
                double open = Double.parseDouble(cryptoData[5]);
                double close = Double.parseDouble(cryptoData[8]);

                double priceChange = (close - open) / close * 100;
                double priceFormatted = Math.round(priceChange * 100) / 100.0;
                Crypto crypto = new Crypto(cryptoData[1], cryptoData[3], priceFormatted);
                cryptoSequential[index] = crypto;
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ShellSortSequential shellSortSequential = new ShellSortSequential();
        shellSortSequential.sequentialSort(Arrays.asList(cryptoSequential));
        ShellSortParallel shellSortParallel = new ShellSortParallel(1);
        ShellSortParallel shellSortParallel2 = new ShellSortParallel(2);
        ShellSortParallel shellSortParallel3 = new ShellSortParallel(4);
        ShellSortParallel shellSortParallel4 = new ShellSortParallel(8);
        ShellSortParallel shellSortParallel5 = new ShellSortParallel(16);
        ShellSortParallel shellSortParallel6 = new ShellSortParallel(32);
        ShellSortParallel shellSortParallel7 = new ShellSortParallel(64);
        shellSortParallel.parallelSort(Arrays.asList(cryptoSequential));
        shellSortParallel2.parallelSort(Arrays.asList(cryptoSequential));
        shellSortParallel3.parallelSort(Arrays.asList(cryptoSequential));
        shellSortParallel4.parallelSort(Arrays.asList(cryptoSequential));
        shellSortParallel5.parallelSort(Arrays.asList(cryptoSequential));
        shellSortParallel6.parallelSort(Arrays.asList(cryptoSequential));
        shellSortParallel7.parallelSort(Arrays.asList(cryptoSequential));




    }
}
