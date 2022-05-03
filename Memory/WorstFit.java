import java.util.Scanner;

public class WorstFit {
    static int parts;
    static int processes;

    static void displayParts(int[] partSizes) {
        String str = "";
        System.out.println("\n");
        for (int i = 0; i < parts; i++)
            str = str + partSizes[i] + "  ";
        System.out.println(str);
    }

    static void fitProcesses(int[] partSizes, int[] processSizes) {
        int worst = -1; // index of worst
        int fragment = 0; // fragment of iteration
        int worstfit = 0; // worst fragmentation
        displayParts(partSizes);
        for (int i = 0; i < processes; i++) {
            worst = -1;
            worstfit = 0;
            for (int j = 0; j < parts; j++) {
                if (processSizes[i] <= partSizes[j]) {
                    fragment = partSizes[j] - processSizes[i];
                    if (fragment >= worstfit) {
                        worstfit = fragment;
                        worst = j;
                    }
                }
            }
            if (worst == -1)
                System.out.print(processSizes[i] + " K must wait.\n");
            else {
                System.out.println(processSizes[i] + " is allocated " + partSizes[worst]);
                partSizes[worst] = partSizes[worst] - processSizes[i];
                displayParts(partSizes);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of partitions: ");
        parts = sc.nextInt();
        System.out.print("Enter number of processes: ");
        processes = sc.nextInt();
        System.out.print("\n");
        int[] partSizes = new int[parts];
        for (int i = 0; i < parts; i++) {
            System.out.print("Enter Partition " + (i + 1) + "'s size: ");
            partSizes[i] = sc.nextInt();
        }
        System.out.print("\n");
        int[] processSizes = new int[processes];
        for (int i = 0; i < processes; i++) {
            System.out.print("Enter Process " + (i + 1) + "'s size: ");
            processSizes[i] = sc.nextInt();
        }
        fitProcesses(partSizes, processSizes);
    }
}
