import java.util.*;

public class Election {

    private HashMap<String, Integer> candidateVotes; //to get the freq of votes
    private PriorityQueue<HashMap.Entry<String, Integer>> maxHeap;

;    public Election(){
        candidateVotes = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    }

    public void initializeCandidates(LinkedList<String> candidates){
        //defaults votes to 0
        for (String c : candidates) {
            candidateVotes.put(c, 0);
        }
    }

    //updates the freq of the candidate
    public void castVote(String candidate){
        if (candidateVotes.containsKey(candidate)) {
            candidateVotes.put(candidate, candidateVotes.get(candidate) + 1);
        } else {
            System.out.println("Candidate does not exist.");
        }
        updateMaxHeap();
    }

    public void castRandomVote(){
        Random random = new Random();
        List<String> list = new ArrayList<>(candidateVotes.keySet());
        String randomCandidate = list.get(random.nextInt(list.size()));
        castVote(randomCandidate);
    }

    public void rigElection(String candidate){
        int totalVotes = 0;
        for (int votes : candidateVotes.values()) {
            totalVotes += votes;
        }

        int remainingVotes = totalVotes; //num of candidates

        if (candidateVotes.containsKey(candidate)) { //if person exists

            remainingVotes -= 2; //able to overtake the highest one

            candidateVotes.put(candidate, remainingVotes);
            // Iterate over all candidates
            for (String c : candidateVotes.keySet()) {
                // Exclude the specified candidate
                if (!c.equals(candidate) && remainingVotes > 0) {
                    // Assign 1 vote to each candidate (except the specified candidate)
                    candidateVotes.put(c, 1);
                    // Decrement remaining votes by 1 for each candidate (except the specified candidate)
                    remainingVotes -= 2;
                }
            }
            // Update the max heap to reflect the changes in the number of votes
            updateMaxHeap();
        } else {
            // If the specified candidate does not exist, print an error message
            System.out.println("Candidate does not exist.");
        }

    }


    private void updateMaxHeap() {
        maxHeap.clear();
        maxHeap.addAll(candidateVotes.entrySet());
    }

    public ArrayList<String> getTopKCandidates(int k) {
        ArrayList<String> topCandidates = new ArrayList<>();
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            topCandidates.add(maxHeap.poll().getKey()); //gets value on top and returns names
        }
        return topCandidates;
    }

    public void auditElection() {
        for (Map.Entry<String, Integer> entry : maxHeap) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }



}
