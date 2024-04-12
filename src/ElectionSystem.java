import java.util.ArrayList;
import java.util.LinkedList;

public class ElectionSystem {
    private Election election;

    public ElectionSystem() {
        election = new Election();
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
