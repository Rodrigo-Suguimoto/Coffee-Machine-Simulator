public class Main {

    public static void main(String[] args) {
        int counter = 0;
        for (Secret secret : Secret.values()) {
            // Convert to string
            String secretToString = secret.toString();

            if (secretToString.startsWith("STAR")) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}


//enum Secret {
//    STAR, CRASH, START, // ...
//}