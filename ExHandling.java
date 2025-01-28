import java.io.*;

class MyEx extends Exception {
    public MyEx(String message) {
        super(message);
    }
}

public class ExHandling {

    public static void handleIO() throws IOException {
        FileReader file = new FileReader("testt.txt");
        BufferedReader fileInput = new BufferedReader(file);
        fileInput.readLine();
        fileInput.close();
    }

    public static void handleNullPointer() {
        String str = null;
        System.out.println(str.charAt(1));
    }

    public static void handleArrayIndex() {
        int[] arr = {1, 2, 3};
        System.out.println(arr[5]);
    }

    public static void handleCustom() throws MyEx {
        throw new MyEx("This is a custom exception!");
    }

    public static void main(String[] args) {
        try {
            System.out.println("IOException:");
            handleIO();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("NullPointerException:");
            handleNullPointer();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("ArrayIndexOutOfBoundsException:");
            handleArrayIndex();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("CustomException:");
            handleCustom();
        } catch (MyEx e) {
            System.out.println(e.getMessage());
        }
    }
}
