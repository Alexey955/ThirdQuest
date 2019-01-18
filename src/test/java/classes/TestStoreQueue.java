package classes;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestStoreQueue {

    @Test
    public void testMinTime() throws IOException {
        String filePathOne = "src/test/java/resources/testFirstSet/TestFileOneQueue.txt";
        String filePathTwo = "src/test/java/resources/testFirstSet/TestFileTwoQueue.txt";
        String filePathThree = "src/test/java/resources/testFirstSet/TestFileThreeQueue.txt";
        String filePathFour = "src/test/java/resources/testFirstSet/TestFileFourQueue.txt";
        String filePathFive = "src/test/java/resources/testFirstSet/TestFileFiveQueue.txt";

        StoreQueue testStoreQueue = new StoreQueue();

        List<String> highQueueTime = testStoreQueue.fetchHighQueueTime(filePathOne, filePathTwo, filePathThree, filePathFour, filePathFive);

        Assert.assertEquals(1, highQueueTime.size());
        Assert.assertEquals("8 : 00", highQueueTime.get(0));
    }

    @Test
    public void testMaxTime() throws IOException {
        String filePathOne = "src/test/java/resources/testSecondSet/TestFileOneQueue.txt";
        String filePathTwo = "src/test/java/resources/testSecondSet/TestFileTwoQueue.txt";
        String filePathThree = "src/test/java/resources/testSecondSet/TestFileThreeQueue.txt";
        String filePathFour = "src/test/java/resources/testSecondSet/TestFileFourQueue.txt";
        String filePathFive = "src/test/java/resources/testSecondSet/TestFileFiveQueue.txt";

        StoreQueue testStoreQueue = new StoreQueue();

        List<String> highQueueTime = testStoreQueue.fetchHighQueueTime(filePathOne, filePathTwo, filePathThree, filePathFour, filePathFive);

        Assert.assertEquals(1, highQueueTime.size());
        Assert.assertEquals("16 : 00", highQueueTime.get(0));
    }

    @Test
    public void testMiddleTime() throws IOException {
        String filePathOne = "src/test/java/resources/testThirdSet/TestFileOneQueue.txt";
        String filePathTwo = "src/test/java/resources/testThirdSet/TestFileTwoQueue.txt";
        String filePathThree = "src/test/java/resources/testThirdSet/TestFileThreeQueue.txt";
        String filePathFour = "src/test/java/resources/testThirdSet/TestFileFourQueue.txt";
        String filePathFive = "src/test/java/resources/testThirdSet/TestFileFiveQueue.txt";

        StoreQueue testStoreQueue = new StoreQueue();

        List<String> highQueueTime = testStoreQueue.fetchHighQueueTime(filePathOne, filePathTwo, filePathThree, filePathFour, filePathFive);

        Assert.assertEquals(1, highQueueTime.size());
        Assert.assertEquals("12 : 00", highQueueTime.get(0));
    }
}
