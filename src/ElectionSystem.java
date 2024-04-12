import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class ElectionSystem {
    private Election election;
    private Random rand;

    public ElectionSystem() {
        election = new Election();
        rand = new Random();
    }

    public void initializeRandomElection() {
        int numCandidates = rand.nextInt(5) + 2; // random num of candidates between 2 and 6
        LinkedList<String> candidates = generateRandomCandidates(numCandidates);

        int electorateVotes = rand.nextInt(5000) + 1000; // random num of electorate votes between 1000 and 6000

        election.initializeCandidates(candidates);
        for (int i = 0; i < electorateVotes; i++) {
            election.castRandomVote();
        }
    }

    private LinkedList<String> generateRandomCandidates(int numCandidates) {
        LinkedList<String> candidates = new LinkedList<>();
        for (int i = 0; i < numCandidates; i++) {
            candidates.add("Candidate " + (i + 1));
        }
        return candidates;
    }


    public void initializeElection(LinkedList<String> candidates, int electorateVotes) {
        election.initializeCandidates(candidates);
        // simulate the given number of electorate votes
        for (int i = 0; i < electorateVotes; i++) {
            election.castRandomVote();
        }
    }

    public void castPVotes(int p) {
        for (int i = 0; i < p; i++) {
            election.castRandomVote();
        }
    }

    public void castVote(String c) {
        election.castVote(c);
    }

    public void rigElection(String candidate) {
        election.rigElection(candidate);
    }

    public ArrayList<String> getTopKCandidates(int k) {
        return election.getTopKCandidates(k);
    }

    public void auditElection() {
        election.auditElection();
    }
}
