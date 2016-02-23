/*
 * Globalroam 2015 @copyright
 */
package com.gnum.experiments.stream.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author chenglong
 * @description
 */
public class TraderAndTransactionDemo {
    public static void main(String[] args) {
        List<Transaction> transactions = constructTransactionData();
//        findByYearAndSortByValue(transactions);
//        findAllUniqueCity(transactions);
        findByTraderNameAndSortByName();
    }

    public static List<Transaction> constructTransactionData() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        return transactions;
    }

    public static List<Trader> constructTraders() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        return Arrays.asList(raoul, mario, alan, brian);
    }

    public static void findByYearAndSortByValue(List<Transaction> transactions) {
        List<Transaction> transactionList = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted((t1, t2) -> t1.getValue() - t2.getValue())
                .collect(Collectors.toList());
        System.out.println(transactionList);
    }

    public static void findAllUniqueCity(List<Transaction> transactions) {
        List<String> cityNames = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(toList());
        System.out.println(cityNames);

    }

    public static void findByTraderNameAndSortByName() {
        List<Trader> traders = constructTraders();
        List<Trader> cambrigeTraders = traders.stream()
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .collect(toList());
        System.out.println(cambrigeTraders);
    }
}
