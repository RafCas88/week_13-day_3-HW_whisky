package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {



	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canWhiskyshaveAParticularYear(){
		List<Whisky> foundWhisky = whiskyRepository.findWhiskeysThatHaveAParticularYear(1991);
		assertEquals("The Rosebank 12 - Flora and Fona", foundWhisky.get(0).getName());
		assertEquals(1, foundWhisky.size());
	}

	@Test
	public void canDistilleriesHaveAParticularRegion(){
		List<Distillery> foundDistillery = distilleryRepository.findDistilleryForAParticularRegion("Highland");
		assertEquals("Glendronach", foundDistillery.get(0).getName());
		assertEquals(1, foundDistillery.size());
	}

	@Test
	public void canFindAllWhiskysByDistilleryIdAndAge(){
		List<Whisky> foundWhisky = whiskyRepository.findAllWhiskysByDistilleryIdAndAge(1L, 15);
		assertEquals(1, foundWhisky.size());

	}

}
