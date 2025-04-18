import java.util.Scanner;

public class Statistics_of_Grades {
    public static void main(String[] args) {
//        int[] grades = {2,20, 21, 22, 23, 30, 48, 49, 50, 55, 60, 65, 72, 63, 76, 80, 68, 90, 85, 98};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the number of students: ");
        int numberofStudents = scanner.nextInt();
        int[] grades = new int[numberofStudents];
        for(int i=0;i<numberofStudents;i++){
            System.out.print("Enter grade of student "+(i+1)+": ");
            grades[i] = scanner.nextInt();
        }
        System.out.println();

        System.out.println("The maximum grade is: "+maximumGrade(grades));
        System.out.println("The minimum grade is: "+minimumGrade(grades));
        System.out.println("The average grade is: "+averageGrade(grades));
        int[] stats = gradeDistributionArray(grades);
        System.out.println("\nBar Graph Representation :\n");
        graph(stats);



    }

    //    To find maximum Grade
    public static int maximumGrade (int[] grades){
        int maximumGrade = grades[0]; //set the default maximum grade to the first value in the array
        for(int i=0;i<grades.length-1;i++){
            if(maximumGrade<grades[i+1]){
                maximumGrade = grades[i+1];//find and stores the maximum Grade
            }
        }
        //the maximum grade of the class
        return maximumGrade;
    }

    //To find minimum Grade
    public static int minimumGrade (int[] grades){
        int minimumGrade = grades[0]; //set the default maximum grade to the first value in the array
        for(int i=0;i<grades.length-1;i++){
            if(minimumGrade>grades[i+1]){
                minimumGrade = grades[i+1];//find and stores the maximum Grade
            }
        }
        //the minimum grade of the class
        return minimumGrade;
    }

    //To find average of Grades
    public static float averageGrade (int[] grades){
        int sumOfGrades = 0;//set the sum of all grades to 0
        for(int i=0;i<grades.length;i++){
            sumOfGrades +=  grades[i];//calculate and store the sum of grades
        }
        float averageOfGrades =  (float) sumOfGrades /grades.length;
        //return the average grade of the class
        return averageOfGrades;
    }

    //Grades Distribution Array
    public static int[] gradeDistributionArray (int[] grades){
        //Grades Distribution Array
        int[] stats = new int[5]; //set the size of stats to be 5
        int above80 = 0,above60=0,above40=0,above20=0,below20=0;
        for(int i=0;i<grades.length;i++){
            if (grades[i]>80){
                above80+=1;
                stats[4] =above80;
            }
            else if (grades[i]>60){
                above60+=1;
                stats[3] =above60;
            }
            else if (grades[i]>40){
                above40+=1;
                stats[2] =above40;
            }
            else if (grades[i]>20){
                above20+=1;
                stats[1] =above20;
            }
            else if (grades[i]<=20){
                below20+=1;
                stats[0] =below20;
            }
        }
        // return Grades Distribution Array
        return stats; //contains array to be used for graph
    }

    //Graph Representation
    public static void graph (int [] stats){
        //finding the y-axis for the graph, which is also the longest bar
        int maximumHeight = stats[0]; //set the maximum height to be the first value
        for (int value : stats) {
            if (value > maximumHeight) {
                //y-axis = maximumHeight
                maximumHeight = value;// y-axis
            }
        }
        //Bar Graph Representation
        for (int i = maximumHeight; i > 0; i--){
            System.out.printf("%4d >", i);
            for (int stat : stats) {
                if (stat >= i) {
                    System.out.print("  #######");
                } else {
                    System.out.print("         ");
                }
            }

            System.out.println();
        }
        System.out.println("    +---------+--------+---------+--------+---------+");
        System.out.println("    I   0-20  I  21-40 I  41-60  I  61-80 I  81-100 I");
    }

}
