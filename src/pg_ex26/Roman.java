package pg_ex26;

import java.util.HashMap;

class ValueErrorException extends Exception {
	public ValueErrorException(String str) {
		super(str);
	}
}

public class Roman {

	public static void main(String[] args) {
		try {
			System.out.println(toNumber("XVIII"));
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}

		System.out.println(toRoman(1));
		System.out.println(toRoman(4));
		System.out.println(toRoman(5));
		System.out.println(toRoman(9));
		System.out.println(toRoman(10));
		System.out.println(toRoman(11));
		System.out.println(toRoman(444));
		System.out.println(toRoman(3999));

	}

	public static int toNumber(String roman)throws IllegalArgumentException {
		int number = 0;
		int pre = 0;
		 String pattern = "^M{0,3}(CM|D|CD)?C{0,3}(XC|L|XL)?X{0,3}(IX|V|IV)?I{0,3}?$";
		// ローマ数字の正当性を確認
		if (!(roman.matches(pattern))) {
			throw new IllegalArgumentException();
		}

		// ローマ数字と数値の紐付けを連想配列で定義
		HashMap<Character, Integer> roman2num = new HashMap<Character, Integer>();
		roman2num.put('M', 1000);
		roman2num.put('D', 500);
		roman2num.put('C', 100);
		roman2num.put('L', 50);
		roman2num.put('X', 10);
		roman2num.put('V', 5);
		roman2num.put('I', 1);

		// 変換処理を開始
		for (int i = roman.length() - 1; i > -1; i-- ) {
			char ch = roman.charAt(i);
			int num = roman2num.get(ch);
			if (num >= pre){
				number += num;
				pre = num;
			} else {
				number -= num;
			}
		}
		return number;
	}

	public static String toRoman(int number) {
		// 数値をローマ字に変換する
		String roman = null;

		if (number < 1 || 3999 < number) {
			return "範囲外です";
		}

		int m = number / 1000;
		number %= 1000;
		int c = number / 100;
		number %= 100;
		int x = number / 10;
		int i = number % 10;

		roman = toRoman(m, "M", "", "");
		roman += toRoman(c, "C", "D", "M");
		roman += toRoman(x, "X", "L", "C");
		roman += toRoman(i, "I", "V", "X");

		return roman;
	}

	public static String toRoman(int number, String one, String five, String ten) {
		// 位ごとに数値をローマ数字に変換する

		if (number == 0) {
			return "";
		}
		if (number == 1) {
			return one;
		}
		if (number == 2) {
			return one + one;
		}
		if (number == 3) {
			return one + one + one;
		}
		if (number == 4) {
			return one + five;
		}
		if (number == 5) {
			return five;
		}
		if (number == 6) {
			return five + one;
		}
		if (number == 7) {
			return five + one + one;
		}
		if (number == 8) {
			return five + one + one + one;
		}
		if (number == 9) {
			return one + ten;
		}else {
			return "不正な値です";
		}

	}
}
