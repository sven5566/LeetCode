package com.whr.leetcode.algorithm.traffic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Road {
	private List<String> vehicles = new ArrayList<>();
	private String name;

	Road(String name) {
		this.name = name;
		ExecutorService pool = Executors.newSingleThreadExecutor();
		pool.execute(() -> {
			while (true){
				try {
					Thread.sleep((new Random().nextInt(10) + 1) * 200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				vehicles.add(Road.this.name +new Random().nextInt(100)+ "_" + vehicles.size());
				System.out.println(String.format("驶入数量%s",vehicles.get(vehicles.size()-1)));
			}
		});

		ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);
		timer.scheduleAtFixedRate(
				() -> {
					if (vehicles.size() > 0) {
						boolean lighted = Lamp.valueOf(Road.this.name).isGreen();
						if (lighted){
							System.out.println(vehicles.remove(0) + " is travelling");
							System.out.println(String.format("%s路还有%d辆车在排队", Road.this.name,vehicles.size()));
						}
					}
				},
				1,
				1,
				TimeUnit.SECONDS);
	}
}
