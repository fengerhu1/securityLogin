package com.example.springboot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {
	public static Worldladdercontrol test_wordladder = new Worldladdercontrol();
	@Test
	public void contextLoads() throws Exception {
	}
	@Test
	public void test1() throws Exception {

		assertEquals("code cade cate date data", test_wordladder.test("data","code"));
	}
	@Test
	public void test2()throws Exception { ;
		assertEquals("code cade cate date", test_wordladder.test("data","code"));
	}
	@Test
	public void test3()throws Exception { ;
		assertEquals("The two words must be found in the dictionary.", test_wordladder.test("data","codell"));
	}
	@Test
	public void test4()throws Exception { ;
		assertEquals("The two words must be the same length.", test_wordladder.test("data","dog"));
	}

}
