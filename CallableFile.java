import java.util.concurrent.Callable;

public class CallableFile implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        //in each thread count up to 1 mil
        int count = 0;

        for(int i = 0; i<1000000; i++){
            count++;
        }
        return count;
    }
}
