public class AlfredTest {
    public static void main(String[] args) {
        //Make and instance of AlfredQuotes to access all it's methods
        AlfredQuotes alfredBot = new AlfredQuotes();
        
        //make some test greetings 
        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Beth Kane", "Evening");
        String testDateAnnouncement = alfredBot.dateAnnouncement();
        String alexisTest = alfredBot.respondBeforeAlexis("Alexis! play some tunes.");
        String alfredTest = alfredBot.respondBeforeAlexis("where is my phone Alfred?");
        String notRelevantTest = alfredBot.respondBeforeAlexis("What time is it?");

        // System.out.println(testGreeting);

        // System.out.println(testGuestGreeting);
        // System.out.println(testDateAnnouncement);
        // System.out.println(alexisTest);
        // System.out.println(alfredTest);
        System.out.println(notRelevantTest);

    }
}