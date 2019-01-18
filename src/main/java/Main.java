import classes.StoreQueue;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        String filePathOne = "src/main/resources/FilesInputSet/FileInputOne.txt";
        String filePathTwo = "src/main/resources/FilesInputSet/FileInputTwo.txt";
        String filePathThree = "src/main/resources/FilesInputSet/FileInputThree.txt";
        String filePathFour = "src/main/resources/FilesInputSet/FileInputFour.txt";
        String filePathFive = "src/main/resources/FilesInputSet/FileInputFive.txt";

        StoreQueue storeQueue = new StoreQueue();

        List<String> highQueueTime = storeQueue.fetchHighQueueTime(filePathOne, filePathTwo, filePathThree, filePathFour, filePathFive);

        highQueueTime.stream().forEach(System.out::println);
    }

}
