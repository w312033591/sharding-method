package org.easydevelop.mapreduce.stategy;

import org.easydevelop.business.TestApplicationConfig;
import org.easydevelop.mapreduce.annotation.MapReduce;
import org.easydevelop.sharding.annotation.ShardingContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;



/** 
* @author xudeyou 
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes={FloatObjectReduceProviderTest.class,TestApplicationConfig.class})
@Configuration
public class FloatObjectReduceProviderTest {
	
	
	@Service("agTest")
	@ShardingContext(dataSourceSet="orderSet")
	public static class AgTest{
		
		@MapReduce
		public Float listTest1(){
			return 0.1f;
		}
		
		@MapReduce
		public Float listTest2(Float value){
			return value;
		}
	}
	
	
	@Autowired
	private AgTest agTest;
	
	@Test
	public void listTest1(){
		Float agTest1 = agTest.listTest1();
		Assert.assertTrue(agTest1 == 0.1f + 0.1f);
	}
	
	@Test
	public void listTest2(){
		Float agTest1 = agTest.listTest2(0.1f);
		Assert.assertTrue(agTest1 == 0.1f+0.1f);
	}
	
}
