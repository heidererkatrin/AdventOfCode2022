package advent.of.code.ropeBridge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class RopeBridge {
    static int x, y, tailX, tailY;
    static HashSet<String> visited;

    public void calculate(String filepath) throws IOException {
        int count = 0;
        boolean[] visited = new boolean[26];
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String line = "";
        while ((line = br.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                int position = line.charAt(i) - 'A';
                if (!visited[position]) {
                    count++;
                    visited[position] = true;
                }
            }
            System.out.println(count);
        }
    }

    private static void updateTail() {
        int dx = x - tailX;
        int dy = y - tailY;

        if (dx == 0) {
            tailY += dy > 0 ? 1 : -1;
        } else if (dy == 0) {
            tailX += dx > 0 ? 1 : -1;
        } else if (Math.abs(dx) == 2 || Math.abs(dy) == 2) {
            tailX += dx > 0 ? 1 : -1;
            tailY += dy > 0 ? 1 : -1;
        } else {
            tailX += dx > 0 ? 1 : -1;
            tailY += dy > 0 ? 1 : -1;
        }
    }
}
