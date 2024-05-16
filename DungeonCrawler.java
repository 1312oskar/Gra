import java.util.Random;
import java.util.Scanner;

public class DungeonCrawler {

    private static char[][] map;
    private static int playerX;
    private static int playerY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        generateMap(5, 10);
        playerX = 0;
        playerY = 0;

        while (true) {
            displayMap();

            System.out.print("Move (W, A, S, D): ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("W")) {
                movePlayer(playerX - 1, playerY);
            } else if (input.equals("A")) {
                movePlayer(playerX, playerY - 1);
            } else if (input.equals("S")) {
                movePlayer(playerX + 1, playerY);
            } else if (input.equals("D")) {
                movePlayer(playerX, playerY + 1);
            }
        }
    }

    private static void generateMap(int height, int width) {
        map = new char[height][width];
        Random random = new Random();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (random.nextDouble() < 0.2) {
                    map[i][j] = '#';
                } else {
                    map[i][j] = '.';
                }
            }
        }
    }

    private static void displayMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (i == playerX && j == playerY) {
                    System.out.print("P ");
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void movePlayer(int newX, int newY) {
        if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length) {
            if (map[newX][newY] == '.') {
                map[playerX][playerY] = '.';
                playerX = newX;
                playerY = newY;
            }
        }
    }
}