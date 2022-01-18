import java.util.Date;
public class AlfredQuotes {
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name, String dayPeriod){
        String result = "";
        if (dayPeriod.equals("morning")) {
            result = String.format("Good morning, %s. Lovely to see you.", name);
        } else if (dayPeriod.equals("afternoon")){
            result = String.format("Good afternoon, %s. Lovely to see you.", name);
        } else if (dayPeriod.equals("evening")){
            result = String.format("Good evening, %s. Lovely to see you.", name);
        }else {
            result = "I'm sorry I do not recognize that time of day";
        }

        return result;
    }

    public String dateAnnouncement(){
        Date date = new Date();
        return "Current date is: " + date;
    }

    public String respondBeforeAlexis(String conversation){
        String response = "";
        if (conversation.indexOf("Alexis") >= 0) {
            response = "Right away sir. She certainly isn't sophisticated enough for that.";

        } else if (conversation.indexOf("Alfred") >= 0){
            response = "At your service. As you wish, naturally.";
        } else {
            response = "Right. And with that I shall retire.";
        }
        return response;
    }
}
