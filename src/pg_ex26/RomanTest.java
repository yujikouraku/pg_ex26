package pg_ex26;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanTest {

	@Test
	public void testToNumber() {
		assertEquals(1, Roman.toNumber("I"));
		assertEquals(3, Roman.toNumber("III"));
		assertEquals(4, Roman.toNumber("IV"));
		assertEquals(5, Roman.toNumber("V"));
		assertEquals(6, Roman.toNumber("VI"));
		assertEquals(9, Roman.toNumber("IX"));
		assertEquals(444, Roman.toNumber("CDXLIV"));
		assertEquals(3999, Roman.toNumber("MMMCMXCIX"));
	}

	@Test
	public void testToNumberException(){
		try {
			System.out.println(Roman.toNumber("IIII"));
			fail();
		}catch (IllegalArgumentException e) {
			System.out.println(e);
			assertEquals(1,1);
		}catch (Exception e) {
			System.out.println(e);
			fail();
		}

		try {
			System.out.println(Roman.toNumber("VV"));
			fail();
		}catch (IllegalArgumentException e) {
			System.out.println(e);
			assertEquals(1,1);
		}catch (Exception e) {
			System.out.println(e);
			fail();
		}

		try {
			System.out.println(Roman.toNumber("A"));
			fail();
		}catch (IllegalArgumentException e) {
			System.out.println(e);
			assertEquals(1,1);
		}catch (Exception e) {
			System.out.println(e);
			fail();
		}
	}
	@Test
	public void testToRoman() {
		assertEquals("I", Roman.toRoman(1));
		assertEquals("III", Roman.toRoman(3));
		assertEquals("IV", Roman.toRoman(4));
		assertEquals("V", Roman.toRoman(5));
		assertEquals("VIII", Roman.toRoman(8));
		assertEquals("IX", Roman.toRoman(9));
		assertEquals("X", Roman.toRoman(10));
		assertEquals("L", Roman.toRoman(50));
		assertEquals("CDXLIV", Roman.toRoman(444));
		assertEquals("MMMCMXCIX", Roman.toRoman(3999));
	}

	@Test
	public void testToRomanException() {
		assertEquals("範囲外です", Roman.toRoman(0));
		assertEquals("範囲外です", Roman.toRoman(4000));
	}
}
