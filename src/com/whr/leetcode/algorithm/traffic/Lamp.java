package com.whr.leetcode.algorithm.traffic;

public enum Lamp {
	S2N(false,"N2S","S2W"),S2W(false,"N2E","E2W"),E2W(false,"W2E","E2S"),E2S(false,"W2N","S2N"),
	N2S(false,"S2N","N2E"),N2E(false,"S2W","W2E"),W2E(false,"E2W","W2N"),W2N(false,"E2S","N2S"),
	S2E(true,"N2W","E2N"),E2N(true,"W2S","N2W"),N2W(true,"S2E","W2S"),W2S(true,"E2N","S2E");

	private boolean green;
	private String oppoLamp;
	private String nextLamp;
	Lamp(boolean green, String oppoLamp, String nextLamp) {
		this.green = green;
		this.oppoLamp = oppoLamp;
		this.nextLamp = nextLamp;
	}

	public boolean isGreen() {
		return green;
	}

	public void turnGreen() {
		if(!this.green) {
			this.green = true;
			if(oppoLamp!=null) {
				Lamp oppo = Lamp.valueOf(oppoLamp);
				oppo.turnGreen();
			}
//			System.out.println(name()+"方向上灯变绿，可以看到六个方向的车行驶");
		}
	}

	public Lamp turnRed() {
		if(this.green) {
			this.green = false;
			if(oppoLamp!=null) {
				Lamp oppo = Lamp.valueOf(oppoLamp);
				oppo.turnRed();
			}
			if(nextLamp!=null) {
				System.out.println("绿灯从"+name()+"方向变成"+nextLamp+"方向");
				Lamp next = Lamp.valueOf(nextLamp);
				next.turnGreen();
				return next;
			}
		}
		return null;
	}
}
