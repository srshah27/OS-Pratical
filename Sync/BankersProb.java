//SE4_43_Alefiya Rampurawala
//Banker's Algorithm

class Bankers {
    int n = 5; // Number of processes
    int m = 3; // Number of resources
    int[][] need = new int[n][m];
    int[][] max;
    int[][] alloc;
    int[] avail;
    int[] safeSequence = new int[n];

    void initializeValues() {
        // Allocation Matrix
        alloc = new int[][] { { 0, 1, 0 },
                { 2, 0, 0 },
                { 3, 0, 2 },
                { 2, 1, 1 },
                { 0, 0, 2 }
        };

        // MAX Matrix
        max = new int[][] { { 7, 5, 3 },
                { 3, 2, 2 },
                { 9, 0, 2 },
                { 2, 2, 2 },
                { 4, 3, 3 }
        };

        // Available Resources
        avail = new int[] { 3, 3, 2 };
    }

    void isSafe() {
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }

        int[] work = new int[m];
        for (int i = 0; i < m; i++) {
            work[i] = avail[i];
        }
        while (count < n) {
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int j;
                    for (j = 0; j < m; j++) {
                        if (need[i][j] > work[j])
                            break;
                    }
                    if (j == m) {
                        safeSequence[count++] = i;  // 3
                        visited[i] = true;
                        flag = true;
                        for (j = 0; j < m; j++) {
                            work[j] = work[j] + alloc[i][j];
                        }
                    }
                }
            }
            if (!flag)
                break;
        }
        if (count < n)
            System.out.println("\nThe System is Unsafe.");
        else {
            System.out.println("\nThe system is Safe.");
            System.out.println("Following is the SAFE Sequence: ");
            for (int i = 0; i < n; i++) {
                System.out.print("P" + safeSequence[i]);
                if (i != n - 1)
                    System.out.print(" -> ");
            }
        }
    }

    void calculateNeed() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                need[i][j] = max[i][j] - alloc[i][j];
            }
        }
    }
}

public class BankersProb {
    public static void main(String[] args) {
        Bankers bankers = new Bankers();
        bankers.initializeValues();
        bankers.calculateNeed();
        bankers.isSafe();
    }
}
