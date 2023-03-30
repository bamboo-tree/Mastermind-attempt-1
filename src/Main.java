public class Main {
    public static void main(String[] args) {

        Gameplay game = new Gameplay(10, 5, 10);



        for(int i : game.getPattern()){
            System.out.print(i + "  ");
        }
        System.out.println();

        int[] x = {1, 2, 3, 4, 5};
        int[] t = game.check(x);

        for (int i = 0; i < 5; i++){
            System.out.print(t[i] + "  ");
        }
        System.out.println();




    }
}
