public class Main {
    public static void main(String[] args) {
        Window window = new Window();
        boolean checkError = System.out.checkError();
        System.out.println(checkError);
    }
}