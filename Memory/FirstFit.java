import java.util.*;

public class FirstFit {
    static int parts;
    static int process;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number odf aprts: ");
        parts = sc.nextInt();

        System.out.print("Enter the number odf process: ");
        process = sc.nextInt();

        int partSize[] = new int[parts];
        for (int i = 0; i < parts; i++) {
            System.out.print("Enter the size of partion " + (i + 1) + " : ");
            partSize[i] = sc.nextInt();
        }
        int processSize[] = new int[process];
        for (int i = 0; i < process; i++) {
            System.out.print("Enter the size of process " + (i + 1) + " : ");
            processSize[i] = sc.nextInt();
        }
        first(partSize, processSize);

        int fragmentation = 0;
        for (int i = 0; i < parts; i++) {
            fragmentation += partSize[i];
        }
        System.out.println("Total External Fragmention: " + fragmentation);
    }

    public static void first(int partSize[], int processSize[]) {
        displayParts(partSize);
        boolean flag = true;
        for (int i = 0; i < process; i++) {
            for (int j = 0; j < parts; j++) {
                if (partSize[j] >= processSize[i]) {
                    System.out.println(processSize[i] + " is put into " + partSize[j]);
                    partSize[j] = partSize[j] - processSize[i];
                    displayParts(partSize);
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
            if (!flag) {
                System.out.println(processSize[i] + " must wait.");
            }
        }
    }

    public static void displayParts(int partSize[]) {
        for (int i = 0; i < parts; i++) {
            System.out.print(partSize[i] + "\t");
        }
        System.out.println();
    }
}