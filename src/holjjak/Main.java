package holjjak;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("구슬 게임에 오신것을 환영합니다.");
		System.out.println("구슬 게임은 홀/짝 게임으로 진행합니다");
		System.out.println();
		// 오징어 게임의 구슬게임(홀짝)
		// 유저가 구슬을 10개를 가지고 게임시작
		// 유저가 베팅을 하고 홀인지 짝인지
		// 맞추면 구슬을 얻고 틀리면 구슬을 잃는다
		// 10개를 다 잃으면 패배
		// 상대방의 구슬 10개를 다 따면 승리
		
		int marble = 10; // 구슬 10 셋팅
		System.out.println("상대방의 구슬을 다 획득하면 승리하고");
		System.out.println("당신의 구슬을 다 잃으면 패배합니다.");
		System.out.println();
		

		Scanner sc = new Scanner(System.in);
		// 여기서 부터 반복
		while (true) {
			System.out.println("당신의 구슬은 " + marble + "개 입니다.");
			System.out.print("구슬을 베팅하세요: ");
			// 구슬 몇개를 베팅할 것인가 입력 받기
			// 숫자 대신 문자를 입력했을때
			int bet = 0;
			try {
				bet = sc.nextInt(); // 베팅한 구슬의 수
			} catch (Exception e) {
				System.out.println("숫자만 입력이 가능합니다.");
				sc.nextLine();  // 개행문자 처리
				continue;
			}
			if (marble < bet) {
				System.out.println("가진 구슬이 부족합니다. 다시 입력하세요");
				continue;   // 다시 반복문으로 올림
			}
			// 컴퓨터가 홀인지 짝인지를 먼저 문제를 만들어야
			Random rnd = new Random();
			// 랜덤 숫자를 만들어서 홀/짝 인지 답이 정해진 상태에서
			int num = 7;
			// num % 2 == 1 공식 = "홀"
			String cpuDab = "홀"; // 초기값
			if (rnd.nextInt(2) == 0) {
				cpuDab = "짝";
			}
			// 유저에게 홀인지 짝인지를 입력 받기
			System.out.print("홀 / 짝 중에 입력: ");
			String userDab = sc.next(); // 문자열 받기(스페이스)
			// 만약에 맞으면 내가 베팅한 구슬의 갯수만큼 내 구슬은 더하기
			if (cpuDab.equals(userDab)) {
				System.out.println("정답입니다. 구슬을 흭득합니다.");
				marble = marble + bet;
			} else { // 틀리면 베팅한 갯수만큼 내 구슬은 빼기
				System.out.println("오답입니다. 구슬을 잃었습니다.");
				marble = marble - bet;
			}

			// 만약에 내 구슬이 0이면 게임오버
			if (marble == 0) {
				System.out.println("패배하였습니다.");
				break;
			}
			// 만약에 내 구슬이 20개 가 되면 다음스테이지
			if (marble >= 20) {
				System.out.println("승리하였습니다.");
				System.out.println("축하드립니다.");
				break;
			}
		}
		// 여기까지 반복
	}

}