import java.util.*;

public class BetterLRU {

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

        int age[] = new int[nf];
        for (int i = 0; i < nf; i++) {
            age[i] = 0;
        }
        int hit = 0, miss = 0, loc = 0, max;
        boolean flag = false;

        for (int i = 0; i < nr; i++) {
            flag = false;
            for (int j = 0; j < nf; j++) {
                if (frame[j] == page[i]) {
                    age[j] = 0;
                    hit++;
                    flag = true;
                    break;
                } else {
                    age[j]++;
                }
            }

            if (!flag) {
                miss++;
                max = age[0];
                loc = 0;

                for (int j = 0; j < nf; j++) {
                    if (age[j] > max) {
                        max = age[j];
                        loc = j;
                    }
                }
                frame[loc] = page[i];
                age[loc] = 0;
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