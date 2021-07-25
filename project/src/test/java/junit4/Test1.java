package junit4;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.DEFAULT)
public class Test1 {
	// junit4
	// before > test > after
	
	@Before
	public void before() {
		System.out.println("Before");
	}
	@Test
	public void test() {
		System.out.println("Test");
	}
	@Test
	public void test2() {
		System.out.println("Test2");
	}
	@After
	public void after() {
		System.out.println("After");
	}
}
