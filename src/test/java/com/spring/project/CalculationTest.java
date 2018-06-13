package com.spring.project;

import com.test.Calculation;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculationTest {
	
	
	static Calculation test=null;
	@BeforeClass
	public static void init(){
		System.out.println("inside init method");
		test= new Calculation();
	}
	@AfterClass
	public static void clean(){
		
	}
    @Test
	public void testSquare(){
	//	Calculation c = new Calculation();
		
		int res = test.square(5);
		assertEquals(res,25);
	}
    
    public  void sites(){
    	
    	//Calculation c = new Calculation();
    	int res = test.SI(1000, 1, 5);
    	assertEquals(res,1000);
    }
}
