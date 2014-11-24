package javasports;

import java.util.Scanner;

public class FootBallClub extends SportsClub implements java.io.Serializable, Comparable<FootBallClub> {

    private static final long serialVersionUID = -5294188737237640015L;
    private String clubName;
    private String clubAddress;
    private String clubID;
    private int wins;
    private int draws;
    private int defeats;                // use private method and use getter and setters to 
    private int numOfGoal;              // use outside of the class
    private int recivedGoal;
    private int currentPoint;
    private int numberOfMatchs;
    private int score;

    transient Scanner input = new Scanner(System.in);

    public String getClubName() {
        return clubName;
    }

    public String getClubAddress() {
        return clubAddress;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setClubAddress(String clubAddress) {
        this.clubAddress = clubAddress;
    }

    public String getClubID() {
        return clubID;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getNumOfGoal() {
        return numOfGoal;
    }

    public int getRecivedGoal() {
        return recivedGoal;
    }

    public int getCurrentPoint() {
        return currentPoint;
    }

    public int getNumberOfMatchs() {
        return numberOfMatchs;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID;
    }

    public void setWins(int wins) {                 // validate win not to go for - values
        if (wins > 0) {
            this.wins = wins;
        }
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public void setNumOfGoal(int numOfGoal) {
        this.numOfGoal = numOfGoal;
    }

    public void setRecivedGoal(int recivedGoal) {
        this.recivedGoal = recivedGoal;
    }

    public void setCurrentPoint(int currentPoint) {
        if (currentPoint > 0) {
            this.currentPoint = currentPoint;
        }
    }

    public void setNumberOfMatchs(int numberOfMatchs) {
        this.numberOfMatchs = numberOfMatchs;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void createClub() {
        System.out.println("Enter name of club :");                         // make create club method
        setClubName(input.nextLine());                                      // request informations from user
        System.out.println("Enter address of the club :");                  
        setClubAddress(input.nextLine());
        System.out.println("Enter ID number of club :");
        setClubID(input.nextLine());
        System.out.println("Enter number of wins :");
        setWins(input.nextInt());
        System.out.println("Enter number of draws :");
        setDraws(input.nextInt());
        System.out.println("Enter number of defeats :");
        setDefeats(input.nextInt());
        System.out.println("Enter number of number of goals :");
        setNumOfGoal(input.nextInt());
        System.out.println("Enter number of number of goals recived:");
        setRecivedGoal(input.nextInt());
        System.out.println("Enter the points :");
        setCurrentPoint(input.nextInt());
        System.out.println("Enter match number :");
        setNumberOfMatchs(input.nextInt());
        System.out.println("Enter score :");
        setScore(input.nextInt());
    }

    @Override
    public int compareTo(FootBallClub o) {

        int compare = (int) o.getScore();

        return (int) compare - this.getScore();

    }

}
