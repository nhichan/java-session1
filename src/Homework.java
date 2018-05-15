import java.util.Random;
import java.util.Scanner;

public class Homework {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

                // hằng số kích thước bản đồ
                int height = 5;
                int width = 5;


                // vị trí người chơi
                int player_x, player_y;

                // vị trí địch đi dọc
                int enemy_v_x, enemy_v_y;

                // vị trí địch đi ngang
                int enemy_h_x, enemy_h_y;

                // vị trí quà
                int goal_x, goal_y;

                // random vị trí người chơi
                Random random = new Random();
                player_y = random.nextInt(height);
                player_x = random.nextInt(width);

                while (true) { // địch đi dọc
                    enemy_v_y = random.nextInt(height);
                    enemy_v_x = random.nextInt(width);
                    if (!((enemy_v_x == player_x) && (enemy_v_y == player_y))) {
                        break;
                    }
                }
                while (true) { // địch đi ngang
                    enemy_h_y = random.nextInt(height);
                    enemy_h_x = random.nextInt(width);
                    // không trùng người chơi
                    if (((enemy_h_x == player_x) && (enemy_h_y == player_y))) {
                        continue;
                    }
                    // không trùng con còn lại
                    if (((enemy_h_x == enemy_v_x) && (enemy_h_y == enemy_v_y))) {
                        continue;
                    }
                    break;
                }
                while (true) {
                    goal_y = random.nextInt(height);
                    goal_x = random.nextInt(width);
                    if (!((goal_x == player_x) && (goal_y == player_y))) {
                        break;
                    }
                }


                while (true) {
                    // in bản đồ
                    for (int y = 0; y < height; ++y) {
                        for (int x = 0; x < width; ++x) {
                            if ((x == player_x) && (y == player_y)) {
                                // in ra người chơi
                                System.out.print("P ");
                            } else if ((x == enemy_h_x) && (y == enemy_h_y)) {
                                // in ra địch 1
                                System.out.print("X ");
                            } else if ((x == enemy_v_x) && (y == enemy_v_y)) {
                                // in ra địch 2
                                System.out.print("X ");
                            } else if ((x == goal_x) && (y == goal_y)) {
                                // in ra đích đến
                                System.out.print("G ");
                            } else {
                                // không có gì
                                System.out.print("* ");
                            }
                        }
                        System.out.println();
                    }

                    System.out.print("Your move: ");
                    String move = scanner.next().toUpperCase();
                    if (move.equals("W")) {
                        // đi lên trên, giảm y đi 1
                        player_y = (player_y + height - 1) % height;
                    }
                    else if (move.equals("S")) {
                        player_y = (player_y + 1) % height;
                    }
                    else if (move.equals("A")) {
                        player_x = (player_x + width - 1) % width;
                    }
                    else if (move.equals("D")) {
                        player_x = (player_x + 1) % width;
                    }
                    else {
                        System.out.println("Illegal move!");
                        continue;
                    }

                    // kiểm tra điều kiện thắng
                    if ((player_x == goal_x) && (player_y == goal_y)) {
                        System.out.println("You win!");
                        break;
                    }

                    // di chuyển các con địch
                    enemy_h_x = (enemy_h_x + 1) % width;
                    enemy_v_y = (enemy_v_y + 1) % height;
                }
            }
        }
