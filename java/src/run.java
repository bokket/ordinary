public class run {
    public static void main(String[] args)
    {
    for (int i = 0; i < 10; i++) {
        if (i == 10 - i) {
            break;
        }

        if (i % 3 != 0) {
            continue;
        }
        System.out.print(i + " ");
    }
    }
}
