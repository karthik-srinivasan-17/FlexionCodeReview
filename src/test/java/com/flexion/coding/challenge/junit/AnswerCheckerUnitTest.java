package com.flexion.coding.challenge.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.flexion.coding.challenge.utilities.*;

public class AnswerCheckerUnitTest {
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void trueTest() {
		assertTrue(AnswerChecker.checkTemperature(Temperature.CELSIUS.toString(), Temperature.FAHRENHEIT.toString(), 1.0, 33.8));
	}
	
	@Test
	public void falseTest() {
		assertFalse(AnswerChecker.checkTemperature(Temperature.CELSIUS.toString(), Temperature.FAHRENHEIT.toString(), 2.0, 33.8));
	}

}
