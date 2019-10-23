package models;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class TestingSubject {

	@Test
	public void test() {
		Subjects sub = new Subjects();
		
		//Expected Values 1
		String expectedSubCode = "BIT111";
		String expectedSubName = "Programming Concepts";
		String expectedSem = "1";

		//Expected Values 2
		String expectedSubCode1 = "BIT121";
		String expectedSubName1 = "Network Communication Concepts";
		String expectedSem1 = "2";

		//Actual Values 1
		String originalSubCode = sub.getSubjectCode()[3];
		String orginalSubName = sub.getSubjectName()[3];
		String originalSem = sub.getSemester()[3];

		//Actual Values 2
		String originalSubCode1 = sub.getSubjectCode()[5];
		String orginalSubName1 = sub.getSubjectName()[5];
		String originalSem1 = sub.getSemester()[5];

		//Testing for Values 1
		assertEquals(expectedSubCode, originalSubCode);
		assertEquals(expectedSubName, orginalSubName);
		assertEquals(expectedSem, originalSem);

		//Testing for Values 1
		assertEquals(expectedSubCode1, originalSubCode1);
		assertEquals(expectedSubName1, orginalSubName1);
		assertEquals(expectedSem1, originalSem1);

	}
}
