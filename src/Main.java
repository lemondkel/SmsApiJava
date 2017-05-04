import java.io.IOException;
import java.util.Scanner;

/**
 * Created by l2jong on 2017-04-27.
 * Cool SMS 기준 Java SMS Api 설정방법
 */
public class Main {

	public Main() throws IOException {
		SMS sms = new SMS();

		sms.appversion("TEST/1.0");
		sms.charset("utf8");
		sms.setuser("id", "password");                // cool sms 계정

		String number[] = new String[2];                                  // 받을 사람 폰번호
		number[0] = "01012345678";
		number[1] = "01011223344";


		for (int i = 0; i < number.length; i++) {
			SmsMessagePdu pdu = new SmsMessagePdu();
			pdu.type = "SMS";
			pdu.destinationAddress = number[i];
			pdu.scAddress = "01098765432";                   // 발신자 번호 -- 홈페이지 등록 필요
			pdu.text = "메세지테스트";                        // 보낼 메세지 내용
			sms.add(pdu);

			try {
				sms.connect();
				sms.send();
				sms.disconnect();
			} catch (IOException e) {
				System.out.println(e.toString());
			}
			sms.printr();
			sms.emptyall();
		}
	}

	public static void main(String[] args) throws IOException {
//		Main sms = new Main() ;
		Scanner sc = new Scanner(System.in);

		int baguniCount;
		int changeCount;

		baguniCount = sc.nextInt();

		String[] list = new String[5];
		for (int i = 1; i <= baguniCount; i++) {
			list[i - 1] = Integer.toString(i);
		}

		changeCount = sc.nextInt();

		for (int i = 0; i < changeCount; i++) {
			int change1 = sc.nextInt();
			int change2 = sc.nextInt();

			String temp = list[change1 - 1];

			list[change1 - 1] = list[change2 - 1];
			list[change2 - 1] = temp;
		}

		for (int i = 0; i < baguniCount; i++) {
			System.out.print(list[i]);
			if (i != baguniCount - 1)
				System.out.print(" ");
		}
	}
}
