import java.util.*;

public class FIFO {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of memory frames: ");
        int nf = sc.nextInt();

        System.out.print("Enter number of page references: ");
        int nr = sc.nextInt();

        int frame[] = new int[nf];
        int page[] = new int[nr];

        System.out.println("Enter page references: ");
        for (int i = 0; i < nr; i++) {
            System.out.print("Enter page reference " + (i + 1) + ": ");
            page[i] = sc.nextInt();
        }

        for (int i = 0; i < nf; i++) {
            frame[i] = -1;
        }

        int out = 0;        // out is the index of the frame to be replaced
        int hit = 0, miss = 0;
        boolean flag = false;

        for (int i = 0; i < nr; i++) {
            flag = false;
            for (int j = 0; j < nf; j++) {
                if (frame[j] == page[i]) {
                    hit++;
                    flag = true;
                    break;
                }
            }
                // 1 2 3 4 5 6 7 8 9 10
            if (!flag) {
                miss++;
                frame[out] = page[i];
                out = (out + 1) % nf;
            }
            for (int j = 0; j < nf; j++) {
                System.out.print("\t" + frame[j]);
            }
            System.out.println();
        }

        System.out.println();
        float hr = (float) hit / ((float) hit + (float) miss);
        System.out.println("\nNumber of hit: " + hit);
        System.out.println("Number of miss: " + (nr - hit));
        System.out.println("\nPage Hit ratio = " + hr);
        System.out.println("Page Miss ratio = " + (1 - hr));
        sc.close();
    }
}
