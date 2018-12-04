import java.util.Scanner;
public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static Boolean escape = false;
    public static int round = 30;

    // Define position
    public static Boolean InFoyer = true;
    public static Boolean InLibrary = false;
    public static Boolean InConservatory = false;

    // Define objects in foyer
    public static Boolean chestisopened = false;
    public static Boolean hasmatches = false;
    public static Boolean candleislighted = false;
    public static Boolean foyerdoorislocked = true;
    public static Boolean foyerdoorisopened = false;


    // Define objects in library
    public static Boolean gotpen = false;
    public static Boolean booktitled = false;
    public static Boolean librarydoorislocked = true;
    public static Boolean librarydoorisopened = false;

    // Define objects in conservatory
    public static Boolean trumpetisplayed = false;
    public static Boolean drumisplayed = false;
    public static Boolean pianoisplayed = false;
    public static Boolean conservatorydoorisopened = false;
    public static String output;

    public static void main(String[] args) {
        String output = "When you open your eyes, you will find yourself in a foyer.\nInside the foyer is a bench, a chest, an unlit candle, and a note which says “May my light show you the way.”\nThere is a door to the north, but it is locked.";
        System.out.println(output);
        System.out.println("You have 30 turns to escape from the room\nyou can use these words:\nopen, close, light, read, write, play, look, get, go\nalong with several nouns\ndoor, room, bench, chest, candle, note, matches, shelves, book, pen, scroll, music, trumpet, piano, drum, lock\nand direction\nnorth, south, east, west");
        System.out.println("Good Luck!");

        for (int a = 1; a < 31; a++) {
            GameUsage();
            round--;
        }
    }

    public static void GameUsage() {
        if (InFoyer) {
            foyer();
        }
        else if (InLibrary) {
            library();
        }
        else if (InConservatory) {
            conservatory();
        }
    }
    public static void foyer() {
        System.out.println("you have " + round + " rounds left.");
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your command");
        String input = scan.nextLine();

        switch (input) {
            case "look chest":
            case "open chest":
                if(!chestisopened){
                    chestisopened=true;
                    output = "the chest is open and you find matches in the chest";
                }
                else if (!chestisopened){
                    chestisopened=false;
                    output = "the chest door is closed";}
                System.out.println(output);
                break;

            case "get matches":
                if(chestisopened){
                    hasmatches =true;
                    output = "You get a box of matches.";}
                else if (!hasmatches){
                    output = "the chest door is closed so you don't have a match yet";
                }
                System.out.println(output);
                break;

            case "light candle":
            case "light candles":
                if (hasmatches) {
                    candleislighted = true;
                    foyerdoorislocked = false;
                    output = "The candle is lit. You heard a metal grinding sound from the north.";
                } else {
                    output = "You don't have any matches.";
                }
                System.out.println(output);
                break;

            case "open door":
                if (!foyerdoorislocked) {
                    foyerdoorisopened = true;
                    output = "The north door is open.";
                }
                else if (foyerdoorisopened){
                    foyerdoorisopened=false;
                    output = "something went wrong, please enter another command";
                }
                System.out.println(output);
                break;

            case "go north":
                if (foyerdoorisopened) {
                    InFoyer = false;
                    InLibrary = true;
                    output = "Congratulation! You have left the foyer. On your way out, the door slammed and locked. You now find yourself in a library full of shelves of books. In the center of the room is a desk, which has a pen and a scroll on it. A door is on the north side wall waiting for you to open";
                }
                else {
                    output = "the exit door is closed ";
                }
                System.out.println(output);
                break;

        }
    }

    public static void library(){
        System.out.println("you have " + round + " rounds left.");
        scan = new Scanner(System.in);
        String input = scan.nextLine();

        switch (input) {

            case "scroll":
                output = "the scroll says, 'Share your story.'";
                System.out.println(output);
                break;

            case "search bookshelf":
                output = "there is an open book on the shelves titled “The Autobiography of...” with the rest of the title empty.";
                System.out.println(output);
                break;

            case "get pen":
                gotpen = true;
                output = "Now you have a pen.";
                System.out.println(output);
                break;

            case "write name":
                booktitled = true;
                librarydoorislocked = false;
                output = "you now have finished the book with your pen. You are ready to leave";
                System.out.println(output);
                break;

            case "check the door":
                if (!librarydoorislocked) {
                    if (librarydoorisopened=true) {
                        output = "The door is unlocked and open.";
                    } else {
                        output = "The door is unlocked, but closed.";
                    }
                } else {
                    output = "The door is locked.";
                }
                System.out.println(output);
                break;

            case "open door":
                if (!librarydoorislocked) {
                    librarydoorisopened = true;
                    output = "The door to the north opens.";
                }
                System.out.println(output);
                break;

            case "go north":
                if (foyerdoorisopened) {
                    InLibrary = false;
                    InConservatory = true;
                    output = "Congratulation! You are now in the conservatory.There are three music instruments: a trumpet, a drum, and a piano.Good luck!";
                }
                System.out.println(output);
                break;
        }
    }


    public static void conservatory() {
        System.out.println("you have " + round + " rounds left.");
        scan = new Scanner(System.in);
        String input= scan.nextLine();

        switch (input) {
            case "read music":{
                output="There are three music instruments in front of you. There also has a phrase written on the musical staff 'Timbre, Tone, and Time' ";
            }
            System.out.println(output);
            break;

            case "play trumpet":
                if (!pianoisplayed&& !drumisplayed) {
                    trumpetisplayed = true;
                    output = "you have played the trumpet!";
                } else {
                    output = "Wrong order. Please try again!";
                }
                System.out.println(output);
                break;

            case "play piano":
                if (trumpetisplayed==true && !drumisplayed==true) {
                    pianoisplayed = true;
                    output = "you have played the piano";
                } else {
                    output = "Wrong order, try again";
                }
                System.out.println(output);
                break;

            case "play drum":
                if (trumpetisplayed==true && pianoisplayed==true) {
                    drumisplayed = true;
                    output = "you have played the drum";
                } else {
                    output = "Wrong order, try again";
                }
                System.out.println(output);
                break;


            case "open door":
                if (trumpetisplayed && pianoisplayed && drumisplayed) {
                    conservatorydoorisopened = true;
                    output = "The north door is open.";
                }else{
                    conservatorydoorisopened=false;
                    output= "The north door is locked";
                }
                System.out.println(output);
                break;

            case "go north":
                if (trumpetisplayed && pianoisplayed && drumisplayed) {
                    escape = true;
                    System.out.printf("\nCongratulations! You finish the room");
                }
                else {
                    System.out.println("\nYou have failed to escape from the room but you can try again. Good luck! ");
                }
        }
    }



}