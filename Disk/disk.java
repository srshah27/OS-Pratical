import java.util.Arrays;

public class disk {
    
    public static void FCFS(int[] sequence, int head) {
        int totalDist = 0;
        int currentDist = 0;
        for (int i = 0; i < sequence.length; i++) {
            if(head > sequence[i]) {
                currentDist = head - sequence[i];
            } else {
                currentDist = sequence[i] - head;
            }
            totalDist += currentDist;
            System.out.println("The head movement from " + head + " to " + sequence[i] + " is " + currentDist);
            head = sequence[i];
        }
        System.out.println("\n\nTotal head movement is " + totalDist);
        System.out.println("Average Head Movement is " + (float)totalDist/sequence.length);
    }
    
    
    public static void SSTF(int[] sequence, int head) {
        int totalDist = 0;
        int currentDist = 0;
        int[] finished = new int[sequence.length];
        int lowestIndex = -1;
        int c;
        for (int i = 0; i < sequence.length; i++) {
            finished[i] = 0;
        }
        for (int i = 0; i < sequence.length; i++) {
            int lowest = 100000;
            for (int j = 0; j < sequence.length; j++) {
                if(finished[j] == 0){
                    if(head > sequence[j]) {
                        c = head - sequence[j];
                    } else {
                        c = sequence[j] - head;
                    }
                    if(c < lowest) {
                        lowest = c;
                        lowestIndex = j;
                    }
                }
            }
            finished[lowestIndex] = 1;
            if(head > sequence[lowestIndex]) {
                currentDist = head - sequence[lowestIndex];
            } else {
                currentDist = sequence[lowestIndex] - head;
            }
            totalDist += currentDist;
            System.out.println("The head movement from " + head + " to " + sequence[lowestIndex] + " is " + currentDist);
            head = sequence[lowestIndex];
        }
        System.out.println("\n\nTotal head movement is " + totalDist);
        System.out.println("Average Head Movement is " + (float)totalDist/sequence.length);
    }
    
    
    
    public static void CLOOK(int[] sequence, int head) {
        int totalDist = 0;
        int currentDist = 0;
        int current = -1;
        
        Arrays.sort(sequence);
        for (int i = 0; i < sequence.length; i++) {
            if(current == -1){
                for (int j = 1; j < sequence.length; j++) {
                    if(sequence[j-1] < head && sequence[j+1] > head) {
                        current = j+1;
                        break;
                    }
                }
            } 
            else if (current == sequence.length-1)
                current = 0;
            else 
                current++;
            if(head > sequence[current]) {
                currentDist = head - sequence[current];
            } else {
                currentDist = sequence[current] - head;
            }
            totalDist += currentDist;
            
            System.out.println("The head movement from " + head + " to " + sequence[current] + " is " + currentDist);
            head = sequence[current];
        }
        System.out.println("\n\nTotal head movement is " + totalDist);
        System.out.println("Average Head Movement is " + (float)totalDist/sequence.length);
    }
    
    
    public static void LOOK(int[] sequence, int head) {
        int totalDist = 0;
        int currentDist = 0;
        int current = -1;
        int flag = 0;
        int restarts = 0;
        Arrays.sort(sequence);
        for (int i = 0; i < sequence.length ; i++) {
            if(current == -1){
                for (int j = 1; j < sequence.length; j++) {
                    if(sequence[j-1] < head && sequence[j+1] > head) {
                        current = j+1;
                        restarts = j;
                        break;
                    }
                }
            } 
            else if (current == sequence.length - 1) {
                current = restarts;
                flag = 1;
            } 
            else if (flag == 0)
                current++;
            else 
                current--;
            if(head > sequence[current]) {
                currentDist = head - sequence[current];
            } else {
                currentDist = sequence[current] - head;
            }
            totalDist += currentDist;
            
            System.out.println("The head movement from " + head + " to " + sequence[current] + " is " + currentDist);
            head = sequence[current];
        }
        System.out.println("\n\nTotal head movement is " + totalDist);
        System.out.println("Average Head Movement is " + (float)totalDist/sequence.length);
    }
    public static void main(String[] args) {
        int[] sequence = { 176, 79, 34, 60, 92, 11, 41, 114 };
        int head = 50;
        System.out.println("FCFS");
        FCFS( sequence, head);
        System.out.println("\n\nSSTF");
        SSTF(sequence, head);
        System.out.println("\n\nLOOK");
        LOOK(sequence, head);
        System.out.println("\n\nCLOOK");
        CLOOK(sequence, head);
    }
}
