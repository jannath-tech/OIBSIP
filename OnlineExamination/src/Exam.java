import java.util.Scanner;

public class Exam {

    private Questions[] questions;

    public Exam() {

        questions = new Questions[]{

                new Questions(
                        "Which language is platform independent?",
                        new String[]{"1. C", "2. Java", "3. Python", "4. C++"},
                        2
                ),

                new Questions(
                        "Who developed Java?",
                        new String[]{"1. Microsoft", "2. Google", "3. Sun Microsystems", "4. IBM"},
                        3
                ),

                new Questions(
                        "Which keyword is used for inheritance?",
                        new String[]{"1. implements", "2. extends", "3. inherit", "4. super"},
                        2
                ),

                new Questions(
                        "JVM stands for?",
                        new String[]{"1. Java Virtual Machine", "2. Java Vendor Machine",
                                "3. Joint Virtual Machine", "4. Java Visual Machine"},
                        1
                ),
                new Questions(
            "Which loop executes at least once?",
            new String[]{
                    "1. for",
                    "2. while",
                    "3. do-while",
                    "4. foreach"
            },
            3
    ),

                new Questions(
                        "Which package contains Scanner?",
                        new String[]{"1. java.io", "2. java.lang", "3. java.util", "4. java.net"},
                        3
                )
                
        };
    }

    public void startExam() {

        Scanner sc = new Scanner(System.in);

        long startTime = System.currentTimeMillis();

        int score = 0;

        System.out.println("\n===== ONLINE EXAM STARTED =====");
        System.out.println("You have 60 seconds.\n");

        for (Questions q : questions) {

            long currentTime = System.currentTimeMillis();

            if ((currentTime - startTime) > 60000) {
                System.out.println("\nTime Over! Auto Submitting...");
                break;
            }

            System.out.println(q.question);

            for (String option : q.options) {
                System.out.println(option);
            }

            System.out.print("Enter Answer: ");
            int ans = sc.nextInt();

            if (q.checkAnswer(ans)) {
                score++;
            }

            System.out.println();
        
        }
         sc.close();
         

        double percentage = (score * 100.0) / questions.length;

System.out.println("===== EXAM SUBMITTED =====");
System.out.println("Score: " + score + "/" + questions.length);
System.out.println("Percentage: " + percentage + "%");

if (percentage >= 40) {
    System.out.println("Status: PASS");
} else {
    System.out.println("Status: FAIL");
}
        
        
    }
    
}
