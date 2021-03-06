import classes.StoreQueue;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        StoreQueue storeQueue = new StoreQueue();

        List<String> highQueueTime = storeQueue.fetchHighQueueTime(args[0], args[1], args[2], args[3], args[4]);

        highQueueTime.forEach(System.out::println);
    }

}
