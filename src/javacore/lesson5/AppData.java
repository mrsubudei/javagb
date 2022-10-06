package javacore.lesson5;

public class AppData {
     private String[] header;
     private int[][] data;

     public void setHeader(String[] sl) {
         this.header = sl;
     }

     public void setData(int[][] sl) {
         this.data = sl;
     }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public void print() {
         for (int i = 0; i < header.length; i++) {
             System.out.print(header[i]);
             if (i != header.length) {
                 System.out.print(" ");
             }
         }
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j]);
                if (i != header.length) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}