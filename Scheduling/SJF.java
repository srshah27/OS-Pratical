import java.util.*;

public class SJF {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        int pid[] = new int[n]; // process id
        int at[] = new int[n];  // arrival time
        int bt[] = new int[n];  // burst time
        int ct[] = new int[n];  // completion time
        int ta[] = new int[n];  // turn around time
        int wt[] = new int[n];  // waiting time
        int f[] = new int[n];   // flag
        int currtime = 0, tot = 0;    // start time, total time
        float awt = 0, atat = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nProcess " + (i + 1));
            System.out.print("Arrival time: ");
            at[i] = sc.nextInt();
            System.out.print("Brust time:   ");
            bt[i] = sc.nextInt();
            pid[i] = i + 1;
            f[i] = 0;
        }
        while (true) {
            int c = n, min = 999;
            if (tot == n)
                break;
            for (int i = 0; i < n; i++) {
                
                if ((at[i] <= currtime) && (f[i] == 0) && (bt[i] < min)) {
                    min = bt[i];
                    c = i;
                }
            }

            if (c == n)
                currtime++;
            else {
                ct[c] = currtime + bt[c];
                currtime += bt[c];
                ta[c] = ct[c] - at[c];
                wt[c] = ta[c] - bt[c];
                f[c] = 1;
                tot++;
            }
        }
        System.out.println(
                "\nProcess ID | Arrival Time  | Brust Time | Completion Time | Turn Around Time | Waiting time");
        for (int i = 0; i < n; i++) {
            awt += wt[i];
            atat += ta[i];
            System.out.println("  " + pid[i] + "\t\t" + at[i] + "\t\t" + bt[i] + "\t\t" + ct[i] + "\t\t" + ta[i]
                    + "\t\t  " + wt[i]);
        }
        System.out.print("\nAverage Turn Around Time: " + (float) (atat / n) + " msec.");
        System.out.print("\nAverage Waiting Time: " + (float) (awt / n) + " msec.");
        sc.close();
    }
}