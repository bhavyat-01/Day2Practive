import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    static int sum = 0;

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        CallableFile[] ourCalls = new CallableFile[100];

        for(int i=0; i<100; i++) {
            ourCalls[i] = new CallableFile();

            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Future<Integer> future = executorService.submit(ourCalls[i]);

            sum+=future.get();
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println(sum);
        System.out.println("Total Time Taken: "+totalTime+" ms");

    }
}

