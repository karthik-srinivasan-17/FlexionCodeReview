package com.flexion.coding.challenge.mockito;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

import org.mockito.runners.MockitoJUnitRunner;

import com.flexion.coding.challenge.main.UnitConversionMain;

@RunWith(MockitoJUnitRunner.class)
public class UnitConversionMockito {

	 @InjectMocks 
	UnitConversionMain uc= new UnitConversionMain();
	 
	 @Mock
	 BufferedReader br;
	 
	 @Before
	 public void setUp() {
	
	 }
	
	@Test
	public void test() throws Exception {

	
	}

	



}
