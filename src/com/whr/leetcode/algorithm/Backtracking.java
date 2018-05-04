package com.whr.leetcode.algorithm;

import java.util.Arrays;

/**
 * 回溯法题目
 */
public class Backtracking {
	private int partNum = 3;//机器部件数
	private int supplyNum = 3;//供应商数
	private static int PRICE_TOP = 4;//价格上限
	private int weightArr[][] = new int[][]{{1, 2, 3}, {3, 2, 1}, {2, 2, 2}};//二维数组
	private int priceArr[][] = new int[][]{{1, 2, 3}, {3, 2, 1}, {2, 2, 2}};//二维数组
	private int bestWeight = 8;//满足价格上限约束条件的最小机器重量
	private int bestPrice = 0;//最小重量机器的价格
	private int bestX[] = {0, 0, 0};//最优解
	private int x[] = {0, 0, 0};//搜索过程中产生的解，x[i]表示第i个部件来自哪个供应商
	private int processWeight = 0;//搜索过程中机器的重量
	private int processPrice = 0;//搜索过程中机器的价格


	//i：当前考虑的部件，从0~n-1
	//j：循环变量
	public static void main(String[] args) {
		Backtracking b = new Backtracking();
		b.backtrcking(0);
		System.out.println("最终结果：" + Arrays.toString(b.bestX));
	}

	private boolean backtrcking(int i) {
		System.out.println("开始处理：i=" + i + "号部件");
		int j=0;
		boolean found =false;
		if (i > partNum - 1) {//得到问题解
			bestWeight = processWeight;
			bestPrice = processPrice;
			for (j = 0; j < partNum; j++) {
				bestX[j] = x[j];
			}
			System.out.println("最优解：" + Arrays.toString(bestX));
			System.out.println("最优重量：" + bestWeight + ",最优价格" + bestPrice);
			return true;
		}
		if (processPrice <= PRICE_TOP) {//有解
			System.out.println("有解");
			found = true;
		}
		for (j = 0; j < supplyNum; j++) {
			//第i个部件从第j个供应商那买
			System.out.println(String.format("第%d个部件从第%d个供应商那买", i, j));
			x[i] = j;
			System.out.println(String.format("x[%d]=%d", i, j));
			processWeight = processWeight + weightArr[i][j];
			processPrice = processPrice + priceArr[i][j];
			if (processPrice <= PRICE_TOP && processWeight < bestWeight) {//深度搜索，扩展当前节点
				System.out.println(String.format("processPrice(%d)<=PRICE_TOP(%d)&&processWeight(%d)<bestWeight(%d)，扩展节点", processPrice, PRICE_TOP, processWeight, bestWeight));
				if (backtrcking(i + 1)) {
					found = true;
				}
			}
			System.out.println(String.format("processPrice(%d)<=PRICE_TOP(%d)&&processWeight(%d)<bestWeight(%d)，回溯节点", processPrice, PRICE_TOP, processWeight, bestWeight));
			//回溯
			System.out.println(String.format("回溯前cw=%d,processPrice=%d", processWeight, processPrice));
			processWeight = processWeight - weightArr[i][j];
			processPrice = processPrice - priceArr[i][j];
			System.out.println(String.format("回溯后cw=%d,processPrice=%d", processWeight, processPrice));
		}
		return found;
	}
}
