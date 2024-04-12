import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        ElectionSystem system = new ElectionSystem();
        LinkedList<String> c = new LinkedList<>();
        c.add("Marcus Fenix");
        c.add("Dominic Santiago");
        c.add("Damon Baird");
        c.add("Cole Train");
        c.add("Anya Stroud");


        system.initializeElection(c, 0);
//        system.castPVotes(5);
        system.castVote("Cole Train");
        system.castVote("Cole Train");
        system.castVote("Marcus Fenix");
        system.castVote("Anya Stroud");
        system.castVote("Anya Stroud");

//        System.out.println(system.getTopKCandidates(3));


        system.rigElection("Marcus Fenix");

//        System.out.println(system.getTopKCandidates(3));

        system.auditElection();

//        System.out.println("Hello world!");
    }
}