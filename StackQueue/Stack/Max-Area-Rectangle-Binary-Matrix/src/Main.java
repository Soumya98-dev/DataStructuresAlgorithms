import java.util.*;

class Pair{
    int value;
    int index;

    public Pair(int value, int index){
        this.value = value;
        this.index = index;
    }
}

public class Main{

    //main function
    public static void main(String[] args){
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };


        System.out.print(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        //maximum area histogram; will run in accordance with the length of the array
        int area = 0;
        for(int r = 0; r < matrix.length; r++){
            area =   ;
        }

        return area;
    }

    //maximum area histogram
    public static int mah(int row, char[][] matrix){

    }

    public int[] width(){

    }

    public int[] nearestSmallerRight(){

    }

    public int[] nearestSmallerLeft(){
        int[] res = new int[];
    }

    public int[] area(){

    }


}