import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Gameplay {

    private int allColors;
    private int colors;
    private int maxAttempts;
    private int[] pattern;
    private int[] result;

    Gameplay(int allColors, int colors, int maxAttempts){
        this.allColors = allColors;
        this.colors = colors;
        this.maxAttempts = maxAttempts;
        this.pattern = generatePattern();
    }

    private int[] generatePattern(){  // create random 'colors' to be guessed
        Random random = new Random();
        int[] arr = new int[allColors];

        for(int i = 0; i < allColors; i++){
            arr[i] = i;
        }

        for(int j = 0; j < 5; j++){     // shuffles array to make it random
            for(int i = 0; i < allColors; i++){
                int rand = random.nextInt(allColors);
                int temp = arr[rand];
                arr[rand] = arr[i];
                arr[i] = temp;
            }
        }

        return Arrays.copyOfRange(arr, 0, colors);
    }

    private int[] sort(int[] start){    // reversed bubble sort :)
        for(int i = 0; i < start.length; i++ ){
            for(int j = i; j < start.length; j++) {
                if(start[i] < start[j]){
                    int temp = start[i];
                    start[i] = start[j];
                    start[j] = temp;
                }
            }
        }
        return  start;
    }


    public int[] check(int[] myGuess){ // returns sorted array with results; 0 - no match, 1 - wrong place, 2 - right place
        int[] result = new int[colors];

        for(int i = 0; i < colors; i++){
            result[i] = 0;
            for(int j = 0; j < colors; j++){
                if(myGuess[i] == pattern[j]){
                    if(i == j){
                        result[i] = 2;
                    }
                    else{
                        result[i] = 1;
                    }
                    break;
                }
            }
        }
        return sort(result);
    }


    public int[] getPattern() {
        return pattern;
    }
}
