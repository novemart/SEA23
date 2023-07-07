import java.sql.SQLOutput;

public class App {

    public static void main(String[] args) {
//        System.out.println(args[1]);
//
//        // variable declaration
//        int myVar;
//        // variable initialisation
//        myVar = 7;
//
//        int myVar2 = 8;
//
//        String myName = "Martina";
//        char myCahr = 'a';
//
//        short hello, mum;
//
//        int sizeof = 200;
//        int big = sizeof * sizeof * sizeof;
//
//        boolean myBool = true;

//        int myNum = 6;
//        System.out.println(myNum);
//        System.out.println(myNum++);
//        System.out.println(++myNum);
//
//        long myLong = 8l;
//        int myInt = (int) myLong;
//
//        int myInt2 = 8;
//        myLong = myInt2;


//        double result = (double) a/b;
//        System.out.println(result);
//
//        String fname = "Martina";
//        String lname = "Yusuf";
//        String fullName = fname + lname;

//        if (a > 6 ){
//            System.out.println("a is greater than 6");
//            System.out.println("try again next time");
//        } else{
//            System.out.println("a is not greater than 6");
//        }

//        int a = 8;
//        int b = 5;
//        int max;
//
//        if (a > b) {
//            max = a;
//        } else {
//            max = b;
//        }
//
//        max = (a > b) ? a : b;
//
//        System.out.println(max);


        int sum = 0;
        for (int i = 0; i < 10; sum += i++) ;
        System.out.println("Sum is " + sum);

        int i = 0;
        while (true) {
            i++;
            if (i < 11) {
                if (i % 2 == 0) {
                    System.out.print("I is : " + i);
                } else {
                    continue;
                }
                System.out.println(" I'm not being skipped");
            } else {
                //break;
            }
        }


    }


}
