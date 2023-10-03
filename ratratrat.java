package gymrat;
import java.util.Scanner;

public class ratratrat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalUsers = 0;

        while (true) {
            System.out.println("1: 현재 사용자 수 \n2: 기구 이용 현황 \n0: 종료");

            int mode = in.nextInt();

            if (mode == 0) {
                System.out.println("프로그램 종료.");
                break;
            } else if (mode == 1) {
                System.out.println("사용자 수를 추가하려면 인원수를 입력하세요.");
                while (true) {
                    int input = in.nextInt();

                    if (input == 0) {
                        System.out.println("현재 사용자 관리 종료");
                        break; 
                    }

                    totalUsers += input;
                    System.out.println("현재 사용자 수: " + totalUsers);
                }
            } else if (mode == 2) {
            	System.out.println("이용 현환");
            	while (true) {
            		int input = in.nextInt();
            		
            		if (input == 0) {
                        System.out.println("이용 현황 관리 종료");
                        break; 
                    }
            	}
            }
        }
    }
}