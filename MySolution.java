public class MySolution {

    public static void main(String[] args) {
        run("👇🤜👇👇👇👇👇👇👇👉👆👈🤛👉👇👊👇🤜👇👉👆👆👆👆👆👈🤛👉👆👆👊👆👆👆👆👆👆👆👊👊👆👆👆👊");
        run("👉👆👆👆👆👆👆👆👆🤜👇👈👆👆👆👆👆👆👆👆👆👉🤛👈👊👉👉👆👉👇🤜👆🤛👆👆👉👆👆👉👆👆👆🤜👉🤜👇👉👆👆👆👈👈👆👆👆👉🤛👈👈🤛👉👇👇👇👇👇👊👉👇👉👆👆👆👊👊👆👆👆👊👉👇👊👈👈👆🤜👉🤜👆👉👆🤛👉👉🤛👈👇👇👇👇👇👇👇👇👇👇👇👇👇👇👊👉👉👊👆👆👆👊👇👇👇👇👇👇👊👇👇👇👇👇👇👇👇👊👉👆👊👉👆👊");
    }

    public static void run(String input) {
        int cursor = 0, pointer = 0;
        int[] memory = new int[1000];
        byte[] bytes = input.getBytes();
        while (cursor < bytes.length) {
            int ins = getIns(bytes, cursor);
            if (ins == 20500368) {
                pointer++;
            } else if (ins == 20672640) {
                pointer--;
            } else if (ins == 21017184) {
                memory[pointer] = (memory[pointer] + 1) % 256;
            } else if (ins == 20844912) {
                memory[pointer] = (memory[pointer] - 1 + 256) % 256;
            } else if (ins == 14278400) {
                int counter = 1;
                while (memory[pointer] == 0 && counter > 0) {
                    cursor += 4;
                    int tmp = getIns(bytes, cursor);
                    counter += tmp == 14278400 ? 1 : 0;
                    counter += tmp == 14421184 ? -1 : 0;
                }
            } else if (ins == 14421184) {
                int counter = 1;
                while (memory[pointer] != 0 && counter > 0) {
                    cursor -= 4;
                    int tmp = getIns(bytes, cursor);
                    counter += tmp == 14421184 ? 1 : 0;
                    counter += tmp == 14278400 ? -1 : 0;
                }
            } else if (ins == 20328096) {
                System.out.print((char) memory[pointer]);
            }
            cursor += 4;
        }
    }

    public static int getIns(byte[] bytes, int a) {
        return bytes[a] * bytes[a + 1] * bytes[a + 2] * bytes[a + 3];
    }
}
