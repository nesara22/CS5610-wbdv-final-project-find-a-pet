package edu.northeastern.cs5610;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.northeastern.cs5610.daos.PetFinderDao;

@SpringBootTest
class WbdvProjectApplicationTests {

	@Autowired
  PetFinderDao dao;

	@Test
	void contextLoads() {

		 System.out.println(dao.findUser("ankita", "Qw12345"));
	}

}
