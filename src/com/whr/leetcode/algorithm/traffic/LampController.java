package com.whr.leetcode.algorithm.traffic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LampController {
	private Lamp currentLamp;
	public LampController() {
		currentLamp = Lamp.S2N;
		currentLamp.turnGreen();

		ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);
		timer.scheduleAtFixedRate(
				() -> currentLamp = currentLamp.turnRed(),
				10,
				10,
				TimeUnit.SECONDS);
	}
}
