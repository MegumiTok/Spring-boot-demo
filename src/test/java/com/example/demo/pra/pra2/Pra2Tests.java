package com.example.demo.pra.pra2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * こちらのブログで書かれているコードを試させていただきました：
 * https://qiita.com/village/items/2f0d99b25eef0c8fd4ec
 *
 *  Tests for {@link Pra2.class}.
 * */

class Pra2Tests {

	/*
	 * publicメソッドのテスト
	 */
	@Test
	public void testEqual() {
		var pra2 = new Pra2();
		int expected = 10;
		int actual = pra2.add(8, 2);

		assertThat(actual).isEqualTo(expected);
	}

	/*
	 * protected,privateメソッドのテスト リフレクションを使用してテストケースを作成
	 */

	@Test
	public void testMinus() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		var pra2 = new Pra2();
		int expected = 6;

		var method = Pra2.class.getDeclaredMethod("minus", int.class, int.class);
		method.setAccessible(true);

		int actual = (int) method.invoke(pra2, 8, 2);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testMultiplication() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		var pra2 = new Pra2();
		int expected = 16;

		var method = Pra2.class.getDeclaredMethod("multiplication", int.class, int.class);
		method.setAccessible(true);

		int actual = (int) method.invoke(pra2, 8, 2);

		assertThat(actual).isEqualTo(expected);

	}

}
