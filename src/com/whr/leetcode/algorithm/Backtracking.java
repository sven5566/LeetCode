package com.whr.leetcode.algorithm;

import java.util.Arrays;

/**
 * 回溯法题目:
 * 设某一机器由n个部件组成，每一个部件都可以从m个不同的供应商处购得。
 * 供应商j供应的部件i具有W[i][j]和价格C[i][j]。
 * 设计一个总价格不超过上限的最小重量机器组成
 * <p>
 * 回溯法及其思路：
 * 首先定义解空间。解空间由长度为n的向量组成，其中每个分量取值来自集合{1,2，...，m}，将解空间用树形结构表示。
 * 接着从根节点开始，以深度优先的方式搜索整个解空间。从根节点开始，根节点成为活节点，同事也成为单钱的扩展节点。
 * 向纵深方向考虑第一个部件从第一个供应商处购买，得到一个新节点。判断当前的机器价格(C[1][1])是否超过上限价格，
 * 重量W[1][1]是否比当前已知的解（最小重量）大，若是，应回溯至最近的一个活节点；
 * 若否，则该新节点成为活结点，同时也成为当前的扩展节点，根节点不再是扩展节点。
 * 继续向纵深方向考虑第二个部件从第一个供应商处购买，得到一个新节点。
 * 同样判断当前的机器价格C[1][1]+C[2][1]是否超过价格上限，以及重量W[1][1]+W[2][1]是否比当前已知的解（最小重量）大。
 * 若是，应回溯至最近的一个活结点。若否，则该新结点成为活结点，同事也成为当前的扩展节点，原来的节点不再是扩展结点。
 * 以这种方式递归地在解空间中搜索，知道找到所求的解或者解空间已无活结点为止。
 */
public class Backtracking {
	private static int PART_NUM = 3;//机器部件数
	private static int SUPPLY_NUM = 3;//供应商数
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
		int j = 0;
		boolean found = false;
		if (i > PART_NUM - 1) {//得到问题解
			bestWeight = processWeight;
			bestPrice = processPrice;
			for (j = 0; j < PART_NUM; j++) {
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
		for (j = 0; j < SUPPLY_NUM; j++) {
			//第i个部件从第j个供应商那买
			System.out.println(String.format("第%d个部件从第%d个供应商那买", i, j));
			x[i] = j;
			System.out.println(String.format("x[%d]=%d", i, j));
			processWeight = processWeight + weightArr[i][j];
			processPrice = processPrice + priceArr[i][j];
			if (processPrice <= PRICE_TOP && processWeight < bestWeight) {//深度搜索，扩展当前节点
				final String s = "processPrice(%d)<=PRICE_TOP(%d)&&processWeight(%d)<bestWeight(%d)，扩展节点";
				System.out.println(String.format(s, processPrice, PRICE_TOP, processWeight, bestWeight));
				if (backtrcking(i + 1)) {
					found = true;
				}
			}
			final String format = "processPrice(%d)<=PRICE_TOP(%d)&&processWeight(%d)<bestWeight(%d)，回溯节点";
			System.out.println(String.format(format, processPrice, PRICE_TOP, processWeight, bestWeight));
			//回溯
			System.out.println(String.format("回溯前processWeight=%d,processPrice=%d", processWeight, processPrice));
			processWeight = processWeight - weightArr[i][j];
			processPrice = processPrice - priceArr[i][j];
			System.out.println(String.format("回溯后processWeight=%d,processPrice=%d", processWeight, processPrice));
		}
		return found;
	}
}
