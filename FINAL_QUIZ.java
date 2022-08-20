import java.util.Scanner;

public class FINAL_QUIZ {

    public static void main(String[] args) {

       
        System.out.println("Select Quiz subject:");
        System.out.println("A.CHEMISTRY");
        System.out.println("B.PHYISICS");
         char choice;
          Scanner scan = new Scanner(System.in);
            choice = scan.next().charAt(0);
          switch(choice)
            {
                case 'A':
                   Quiz quiz1 = new Quiz();
        quiz1.chemistry();
                    break;
                case 'B':
                   Quiz quiz2 = new Quiz();
        quiz2.physics();
                    break;
            }
       
    }
}

class Quiz
{
    void chemistry()
    {
        Question[] questions = new Question[5];

        questions[0] = new Question("Ozone layer is present at a height of about:","80 km above the earth","100 km above the earth","5 km above the earth","28 km above the earth", new Answer("28 km above the earth"));
        questions[1] = new Question("The most abundant element in the universe is","Hydrogen","Oxygen","Carbon dioxide","Silicon", new Answer("Hydrogen"));
        questions[2] = new Question("The average human body contains about _______ gram of Sodium Chloride.","190","210","230","250", new Answer("250"));
        questions[3] = new Question("pH is an abbreviation for?","Power of Hydrogen","Possibility of Hydrogen","Population of Hydrogen","Position of Hydrogen", new Answer("Power of Hydrogen"));
        questions[4] = new Question("The substance which increases the rate of chemical reaction is","Metal","Catalyst","Alloy","Enzymes", new Answer("Catalyst"));

        int countTotal = 0;
        int countRight = 0;
        int countWrong = 0;

        for(Question q: questions)
        {
            System.out.println(q.getQuestion());
            System.out.println("A : " +q.getOption1());
            System.out.println("B : " +q.getOption2());
            System.out.println("C : " +q.getOption3());
            System.out.println("D : " +q.getOption4());

            String answer = "";

            char ans;
            System.out.println("Enter your answer");
            Scanner scan = new Scanner(System.in);
            ans = scan.next().charAt(0);

            switch(ans)
            {
                case 'A':
                    answer = q.getOption1();
                    break;
                case 'B':
                    answer = q.getOption2();
                    break;
                case 'C':
                    answer = q.getOption3();
                    break;
                case 'D':
                    answer = q.getOption4();
                    break;
                default:break;
            }
            System.out.println("Your answer " + answer + " " + q.getAnswer());
            if(answer.equals(q.getAnswer().getAnswer()))
            { 
                System.out.println("                  Correct Answer                      ");  
                countRight++;
            }
            else
            {
                System.out.println("                  Wrong Answer                      ");  
                countWrong++;
            }
            System.out.println("============================================================================================");
            countTotal++;
        }

        Result result = new Result(countTotal,countRight,countWrong);
        result.showResult();
    }
     void physics()
    {
        Question[] questions = new Question[5];

        questions[0] = new Question("The work performed on an object does not depend upon","displacement","force applied","the angle at which the force is applied to the displacement","initial velocity of the object.", new Answer("initial velocity of the object."));
        questions[1] = new Question("The slope of the potential energy versus position vector gives","momentum","force","work done","power", new Answer("force"));
        questions[2] = new Question("The slope of the kinetic energy versus position vector gives the time rate of change of:","momentum","force","work done","power", new Answer("momentum"));        
        questions[3] = new Question("A bullet is fired into a block of sand and its velocity decreases by 50% when it penetrates through 9 cm. What will be the total distance penetrated by the bullet?","9 cm","10 cm","12 cm","18 cm", new Answer("12 cm"));
        questions[4] = new Question("Which of the following changes when a particle is moving with uniform velocity?","Speed","Velocity","Acceleration","Position vector", new Answer("Position vector"));

        int countTotal = 0;
        int countRight = 0;
        int countWrong = 0;

        for(Question q: questions)
        {
            System.out.println(q.getQuestion());
            System.out.println("A : " +q.getOption1());
            System.out.println("B : " +q.getOption2());
            System.out.println("C : " +q.getOption3());
            System.out.println("D : " +q.getOption4());

            String answer = "";

            char ans;
            System.out.println("Enter your answer");
            Scanner scan = new Scanner(System.in);
            ans = scan.next().charAt(0);

            switch(ans)
            {
                case 'A':
                    answer = q.getOption1();
                    break;
                case 'B':
                    answer = q.getOption2();
                    break;
                case 'C':
                    answer = q.getOption3();
                    break;
                case 'D':
                    answer = q.getOption4();
                    break;
                default:break;
            }
            System.out.println("Your answer " + answer + " " + q.getAnswer());
            if(answer.equals(q.getAnswer().getAnswer()))
            {
                System.out.println("                  Correct Answer                      ");
                countRight++;
            }
            else
            {  
                System.out.println("                  Wrong Answer                      ");  
                countWrong++;
            }
             System.out.println("============================================================================================");
             countTotal++;
        }

        Result result = new Result(countTotal,countRight,countWrong);
        result.showResult();
    }
}

class Question
{

    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    Answer answer;

    public Question(String question, String option1, String option2, String option3, String option4, Answer answer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public Answer getAnswer() {
        return answer;
    }
}

class Answer
{
    String answer;

    public Answer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}

interface IResult
{
    void showResult();
    double showPercentage(int correctAnswers,int totalQuestions);
    String showPerformance(double percentage);
}

class Result implements IResult
{
    int totalQuestions;
    int correctAnswers;
    int wrongAnswers;

    public Result(int totalQuestions, int correctAnswers, int wrongAnswers) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.wrongAnswers = wrongAnswers;
    }

    @Override
    public void showResult() {
        System.out.println("Your results!");
        System.out.println("Total Questions " + totalQuestions);
        System.out.println("Number of correct answers " + correctAnswers);
        System.out.println("Number of wrong answers " + wrongAnswers);
        System.out.println("Percentage " + showPercentage(correctAnswers,totalQuestions));
        System.out.println("Your performance " + showPerformance(showPercentage(correctAnswers,totalQuestions)));

    }

    @Override
    public double showPercentage(int correctAnswers, int totalQuestions) {
        //System.out.println(correctAnswers + " " + totalQuestions);
        return (double) (correctAnswers / (double)totalQuestions) * 100 ;
    }

    @Override
    public String showPerformance(double percentage) {
        String performance = "";

        if(percentage > 60)
        {
            performance = "Good";
        }
        else if(percentage < 40)
        {
            performance = "Poor";
        }

        return performance;

    }
}











