import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<String> listOfTasks = new ArrayList<String>();
    Scanner input= new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();

    }

    public void run(){
        Menu();
    }

    public void addToList(){
        System.out.println("How many tasks would you like to add?");
        int userInput = input.nextInt();
        input.nextLine();//the first nextLine doest work after nextInt. Damn you Java >:(

        if (userInput>0) {
            for (int i =1;i<=userInput;i++){
                System.out.println("task #"+i);
                String task =input.nextLine();
                listOfTasks.add(task);
            }
        }else{
            System.out.println("You cant have tasks less than one");
            Menu();
        }
        Menu();
    }

    public void checkList(){
        System.out.println("All  the tasks to finish:");

        for (int i =0; i<listOfTasks.size(); i++){
            System.out.println("Task number " + (i+1) + ": " + listOfTasks.get(i));
        }

        Menu();
    }

    public void removeFromList(){
        //getting the numbers that we want to remove
        System.out.println("Which tasks would you like to remove (separate by , sign and no spaces) :");
        String userInput = input.nextLine();


        //converting the string to and array of numbers
        String[] tasksToRemove = userInput.split(",");
        int[] numbers = new int[tasksToRemove.length];

        for(int i = 0;i < tasksToRemove.length;i++) {
            numbers[i] = Integer.parseInt(tasksToRemove[i]);

            //TODO we have to do try catch in case of invalid numbers
//            try {
//                numbers[i] = Integer.parseInt(tasksToRemove[i]);
//            }
//            catch (NumberFormatException nfe) {
//                numbers[i] = Integer.parseInt(null);
//            }
            

        }


        //sorting the array with selection sort just in case the user entered the numbers not in order
        if(numbers.length>1){
            selectionSort(numbers);
        }

        //removing the numbers(looping throw the array backwards so that the indexes stay the same)
        for (int j = numbers.length-1; j>=0;j--){
            int x = (int)Array.get(numbers, j);
            listOfTasks.remove(x);
        }
        System.out.println(listOfTasks.toString());

        Menu();
    }


    public void Menu(){
        System.out.println("your options:");
        System.out.println("1) Check the list");
        System.out.println("2) Add to the List");
        System.out.println("3) Remove from the List");
        System.out.println("0) Terminate the program");
        int userInput = input.nextInt();
        if(userInput== 1){
            checkList();
        }else if(userInput== 2){
            addToList();
        }else if(userInput== 3){
            removeFromList();
        }else if(userInput== 0){
            System.exit(0);
        }else{
            System.out.println("Only numbers between 0 and 3");
        }
    }

    //sorting alg
    public static int[] selectionSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }

}
