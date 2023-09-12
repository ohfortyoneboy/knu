/*
 * 헬스장 관리 프로그램
 * 기능 : 현인원 파악, 기구 이용 현황 등
 */

package firstclass;
import java.util.Scanner;

public class firstclass {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int a = 0;

        while (true) {
            int x = in.nextInt();
            
            if (x == 0) {
                System.out.println("System off.");
                break;
            }
            
            a = a + x;
            System.out.println("Current : " + a);
        }

        in.close();
	}
}