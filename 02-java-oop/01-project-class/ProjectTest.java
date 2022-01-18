public class ProjectTest {
    public static void main(String[] args) {
        Project projectOne = new Project();
        Project projectTwo = new Project("To Do");
        Project projectThree = new Project("Grade Homework", "Listen to student's audio files and put grades");
    
        projectOne.setName("Fun");
        projectOne.setDescription("Have fun");
        projectTwo.setDescription("write to do list");

        System.out.println(projectOne.elevatorPitch());
        System.out.println(projectTwo.elevatorPitch());
        System.out.println(projectThree.elevatorPitch());
        System.out.println(projectOne.getName());
        
        
    }
}