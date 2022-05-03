
import java.util.*;

public class RR {
    public static int cirque[] = new int[50];
    public static int front = -1, rear = -1;
    public static int completed = 0;
    public static int ttat, tawt;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        System.out.print("Enter Time Quantum: ");
        int timeFrame = sc.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        int rt[] = new int[n];  // remaining time
        int f[] = new int[n];   // flag
        int currtime = 0;       
        float awt = 0, atat = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nProcess " + (i + 1));
            System.out.print("Arrival time: ");
            at[i] = sc.nextInt();
            System.out.print("Brust time:   ");
            bt[i] = sc.nextInt();
            rt[i] = bt[i];
            pid[i] = i;
            f[i] = 0;
        }

        while (completed != n) {
            int i;
            for (i = 0; i < n; i++) {
                if (at[i] <= currtime && f[i] != 1 && f[i] != 2) {
                    enque(i);
                    f[i] = 1;
                }
            }

            if (rt[cirque[front]] > timeFrame) {
                int temp;
                rt[cirque[front]] = rt[cirque[front]] - timeFrame;
                currtime = currtime + timeFrame;
                temp = dequeue();

                for (i = 0; i < n; i++) {
                    if (at[i] <= currtime && f[i] != 1 && f[i] != 2) {
                        enque(i);
                        f[i] = 1;
                    }
                }


                enque(temp);
            }

            else if (rt[cirque[front]] == timeFrame) {
                rt[cirque[front]] = rt[cirque[front]] - timeFrame;
                currtime = currtime + timeFrame;
                ct[cirque[front]] = currtime;
                f[cirque[front]] = 2;
                completed++;
                dequeue();
            }

            else if (rt[cirque[front]] < timeFrame) {
                int temp = rt[cirque[front]];
                rt[cirque[front]] = rt[cirque[front]] - temp;
                currtime = currtime + temp;
                ct[cirque[front]] = currtime;
                f[cirque[front]] = 2;
                completed++;
                dequeue();
            }
        }

            for (int i = 0; i < n; i++) {
                tat[i] = ct[i] - at[i];
                wt[i] = tat[i] - bt[i];
            }

            for (int i = 0; i < n; i++) {
                ttat = ttat + tat[i];
                tawt = tawt + wt[i];
            }

            awt = (float) tawt / n;
            atat = (float) ttat / n;

    
        System.out.println("\nProcess ID | Arrival Time  | Brust Time | Completion Time | Turn Around Time | Waiting time");
        for(int i=0;i<n;i++)
        {
            System.out.println("  " + pid[i] + "\t\t" + at[i] + "\t\t" + bt[i] + "\t\t" + ct[i] + "\t\t" + tat[i] + "\t\t  " + wt[i]);
        }
        System.out.print ("\nAverage Turn Around Time: "+ (float)atat + " msec.");
        System.out.print ("\nAverage Waiting Time: "+ (float) awt + " msec.");
        sc.close();
    }

    public static void enque(int n) {
        if (rear == -1) {
            rear = 0;
            front = 0;
            cirque[rear] = n;
        } else {
            rear = (rear + 1) % 50;
            cirque[rear] = n;
        }
    }

    public static int dequeue() {
        int num = -1;
        if (front == rear) {
            num = cirque[front];
            front = rear = -1;
        } else {
            num = cirque[front];
            front = (front + 1) % 50;
        }
        return num;
    }
}