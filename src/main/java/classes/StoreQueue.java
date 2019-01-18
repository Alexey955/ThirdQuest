package classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class StoreQueue {

    public List<String> fetchHighQueueTime(String ... filePath) throws IOException {
        List<List> generalAmountList = createGeneralAmountList(filePath);

        List<Integer> sumAmountList = createSumAmountList(generalAmountList);

        List<Integer> highPeopleTimeNumList = createHighPeopleTimeNumList(sumAmountList);

        return createHighQueueTimeList(highPeopleTimeNumList);
    }

    private  List<String> createHighQueueTimeList(List<Integer> highPeopleTimeNumList) {
        List<String> highQueueTimeList = new LinkedList<>();
        int startHours = 8;
        int startMinutes = 0;

        for(Integer highTimeNum: highPeopleTimeNumList) {
            int newMinutes = highTimeNum * 30;
            double newHours = (double) newMinutes / 60;

            if(newMinutes != 0) {
                String strHours = "" + (8 + (int)newHours);
                String sthMinutes;

                if(newHours != (int)newHours) {
                    sthMinutes = "30";
                }else {
                    sthMinutes = "00";
                }
                highQueueTimeList.add(strHours + " : " + sthMinutes);
            }else {
                highQueueTimeList.add("8 : 00");
            }
        }
        return highQueueTimeList;
    }

    private static List<Integer> createHighPeopleTimeNumList(List<Integer> sumAmountList) {
        List<Integer> highPeopleTimeNumList = new LinkedList<>();

        OptionalInt max = sumAmountList.stream().mapToInt(x -> x).max();

        for(int i = 0; i < sumAmountList.size(); i++) {
            if(max.getAsInt() == sumAmountList.get(i)) {
                highPeopleTimeNumList.add(i);
            }
        }
        return highPeopleTimeNumList;
    }

    private static List<Integer> createSumAmountList(List<List> generalAmountList) {
        List<Integer> sumAmountList = new LinkedList<>();

        for(int i = 0; i < generalAmountList.get(0).size(); i++) {

            int sum = 0;
            int amountPeople;
            for(int j = 0; j < generalAmountList.size(); j++) {
                amountPeople = (int)generalAmountList.get(j).get(i);
                sum += amountPeople;
            }
            sumAmountList.add(sum);
            sum = 0;
        }
        return sumAmountList;
    }

    private List<Integer> fetchList(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath/*args[0]*/))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private List<Integer> findAmountPeople(List<Integer> list) {
        List<Integer> result = new LinkedList<>();
        result.add(list.get(0));

        for(int i = 1; i < list.size(); i++) {
            int amountPeople = (list.get(i) * (i + 1)) - result.stream().mapToInt(x -> x).sum();
            result.add(amountPeople);
        }
        return result;
    }

    private List<String> createFilePathList(String ... filePath) {
        List<String> filePathList = new LinkedList<>();

        for(String path: filePath) {
            filePathList.add(path);
        }
        return filePathList;
    }

    private List<List> createGeneralAmountList(String ... filePath) throws IOException {
        List<List> generalAmountList = new LinkedList<>();

        List<String> filePathList = createFilePathList(filePath);

        for(String path: filePathList) {
            List<Integer> listFromFile = fetchList(path);
            List<Integer> listAmountPeople = findAmountPeople(listFromFile);

            generalAmountList.add(listAmountPeople);
        }
        return generalAmountList;
    }
}
