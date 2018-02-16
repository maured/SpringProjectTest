package com.edeal.test.connector;

import com.edeal.server.bean.ClasseBean;
import com.edeal.server.jdbc.DAOFactory;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.*;
import static sun.plugin2.util.PojoUtil.toJson;

public class ClasseJsonConnectorTest{
	
	@Test
	public void testIsJson() throws Exception {
		
		Object testJson = "{\n" + "  \"classeId\": 6,\n" + "  \"classeName\": \"testJunit\"\n" + "}";
		ClasseBean testBean = new ClasseBean();
		testBean.setClasseId(6);
		testBean.setClasseName("testJunit");

		assertEquals(testJson, toJson(testBean));
		// j'ecris mon json en dur
		// j'instancie mon bean 
		// assert sur mon tojson
		
	}

	@Test
	public void testIsJsonWithNullValue() throws Exception {

		Object testJson = "{\n" + "  \"classeId\": -1,\n" + "  \"classeName\": \"testJunit\"\n" + "}";
		ClasseBean testBean = new ClasseBean();
		testBean.setClasseId(-1);
		testBean.setClasseName(null);

		assertEquals(testJson, toJson(testBean));
		// j'ecris mon json en dur
		// j'instancie mon bean 
		// assert sur mon tojson

	}

	@Test
	public void testIsJsonWithBigInteger() throws Exception {
		//Mock DAOFactory = MOck.populate(DAOFactory.getInstance(), new DAOFactoryImpl());
	}
}