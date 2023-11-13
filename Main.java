import java.util.ArrayList;
import java.util.concurrent.*;

public class Main {
    static int sum = 0;

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        ArrayList<CallableFile> ourCalls = new ArrayList<CallableFile>();
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for(int i=0; i<100; i++) {
            ourCalls.add(new CallableFile());
        }

        ArrayList<Future<Integer>> myFutures = (ArrayList<Future<Integer>>) executorService.invokeAll(ourCalls);

        for(int i=0; i<100; i++){
            sum += myFutures.get(i).get();
        }
        
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println(sum);
        System.out.println("Total Time Taken: "+totalTime+" ms");

    }
}

