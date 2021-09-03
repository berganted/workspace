package junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;

public class Test2 {

	//Assertuibs : 성공/실패 검증
	//	-assertEquals(a,b) : a와 b가 같은지 검증
	// 	-assertTura(a) : a 가 true인지 검증
	// 	-assertFalse(n) : n 가 False인지 검증
	// 	-assertNull(n) : null인지
	// 	-assertNotNull(n) : null이 아닌지
	//	-assertArrayEquals(a.b) : 배열이 같은지
	//Assumptions: 성공일때만 테스트 진행
	//	-assumeTrue() :
	//  -assumeFalse():
	//	-assumeEquals():
	
	@Test
	void test1() {
		String a = "홍길동";
		String b = "홍길동";
		assertEquals(a, b);
		
	}
	@Test
	void test2() {
		assumeTrue(1==2);
		assertEquals("a", "a");
	}
	@Test
	void count() {
		int r=10;
		assertTrue(r>0);
		assertTrue(r<0);
		
	}
	
}
