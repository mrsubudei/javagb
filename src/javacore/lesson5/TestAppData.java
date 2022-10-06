package javacore.lesson5;

import java.io.*;
import java.util.LinkedList;

public class TestAppData {
    public static void main(String[] args) {

        //creating data and putting it to AppData;
        String[] head = {"book", "pen", "pencil"};
        int[][] dat = new int[3][];
        int[] tmp1 = new int[3];
        int[] tmp2 = new int[3];
        int[] tmp3 = new int[3];

        for (int i = 0; i < 3; i++) {
            tmp1[i] = (i+1)*120;
        }
        dat[0] = tmp1;

        for (int i = 0; i < 3; i++) {
            tmp2[i] = (i+1)*110;
        }
        dat[1] = tmp2;

        for (int i = 0; i < 3; i++) {
            tmp3[i] = (i+1)*175;
        }
        dat[2] = tmp3;

 		AppData myAppToSave = new AppData();
        myAppToSave.setHeader(head);
        myAppToSave.setData(dat);

        // saving to file
        save(myAppToSave);

        // creating new AppData and reading data from file to it
        AppData fromFile = writeOut("src/javacore/lesson5/data/file.csv");
        fromFile.print();
    }

    public static void save(AppData dataToSave) {
        try (OutputStream out = new BufferedOutputStream(new
                FileOutputStream("src/javacore/lesson5/data/file.csv"))) {
            String[] header = dataToSave.getHeader();
            for (int i = 0; i < header.length; i++) {
                String tmp = header[i];
                byte[] byteArr = tmp.getBytes();
                for (int j = 0; j < byteArr.length; j++) {
                    out.write(byteArr[j]);
                }
                if (i != header.length-1) {
                    out.write(';');
                }
            }

            out.write('\n');

            int[][] data = dataToSave.getData();
            for (int i = 0; i < data.length; i++) {
                for (int y = 0; y < data[i].length; y++) {
                    String tmp = String.valueOf(data[i][y]);
                    byte[] byteArr = tmp.getBytes();
                    for (int u = 0; u < byteArr.length; u++) {
                        out.write(byteArr[u]);
                    }
                    if (y != data[i].length-1) {
                        out.write(';');
                    }
                }
                out.write('\n');
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppData writeOut(String filename) {
        AppData answer = new AppData();
        try (BufferedReader reader = new BufferedReader(new
                FileReader(filename))) {
            String tmpStr;
            String[] tmpStrArr;
            if ((tmpStr = reader.readLine()) != null) {
                tmpStrArr = tmpStr.split(";");
                answer.setHeader(tmpStrArr);
            }

            LinkedList<int[]> list = new  LinkedList<>();
            while ((tmpStr = reader.readLine()) != null) {
                tmpStrArr = tmpStr.split(";");
                int[] tmpIntArr = new int[tmpStrArr.length];
                for (int i = 0; i < tmpStrArr.length; i++) {
                    tmpIntArr[i] = Integer.parseInt(tmpStrArr[i]);
                }
                list.add(tmpIntArr);
            }
            int len = list.size();
            int[][] intData = new int[len][];

            for (int i = 0; i < len; i++) {
                intData[i] = list.get(i);
            }
            answer.setData(intData);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return answer;
    }

}
