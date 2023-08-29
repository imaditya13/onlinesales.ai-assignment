package org.Aditya.Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    private static final int API_RATE_LIMIT = 50; // API rate limit
    private static final int THREAD_POOL_SIZE = 10; // Number of threads in the thread pool

    public static void main(String[] args) {
        List<String> expressions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter expressions (type 'end' to finish):");
        while (true) {
            String expression = scanner.next();
            if (expression.equals("end")) {
                break;
            }
            expressions.add(expression);
        }

        int totalExpressions = expressions.size();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        int batchStart = 0;
        while (batchStart < totalExpressions) {
            int batchEnd = Math.min(batchStart + API_RATE_LIMIT, totalExpressions);
            List<String> batch = expressions.subList(batchStart, batchEnd);

            CompletableFuture<?>[] futures = batch.stream()
                    .map(expression -> CompletableFuture.supplyAsync(() -> ExpressionEvaluator.evaluateExpression(expression), executor))
                    .toArray(CompletableFuture[]::new);

            CompletableFuture<Void> batchCompletion = CompletableFuture.allOf(futures);
            try {
                batchCompletion.get(); // Wait for the batch to complete
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            batchStart += API_RATE_LIMIT;
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Print the results
        for (int i = 0; i < totalExpressions; i++) {
            String expression = expressions.get(i);
            String result = ExpressionEvaluator.evaluateExpression(expression);
            System.out.println(expression + " => " + result);
        }
    }
}

/*
Enter expressions (type 'end' to finish):
sqrt(25)
pow(2,5)
2^5
3*4
6/2
2+3
3-2
end
..............OUTPUT..................
sqrt(25) => 5
pow(2,5) => 32
2^5 => 32
3*4 => 12
6/2 => 3
2+3 => 5
3-2 => 1


*/