package com.lt.bigcalc;

import java.util.Observable;
import java.util.Stack;

import com.lt.util.CalcCallback;

/**
 * 计算器的模型
 * 
 * @author litong
 *
 */
public class CalcModel extends Observable {

	// 逆波兰表达式
	private Stack<String> stack;
	// 操作数和运算符
	CalcCallback callback;

	public CalcModel() {
		stack = new Stack<>();
	}

	public void setCallback(BigCalcFrame view) {
		this.callback = view;

	}

	public void push(String e) {
		stack.push(e);
		// 数据改变了，发送给观察者
		setChanged();
		notifyObservers(getResult());
		// System.out.println(stack.toString());
	}

	public String getResult() {
		// System.out.println(stack.toString());
		String[] str = stack.toString().split("\\[|\\]|\\,| ");
		StringBuilder sb = new StringBuilder();
		for (String s : str) {
			sb.append(s);
		}
		return sb.toString();
	}

	/**
	 * 清空栈
	 */
	public void clear() {
		stack.clear();
	}

	public String peek() {
		return stack.peek();
	}

	/**
	 * 出栈（被观察）
	 * @return
	 */
	public String pop() {

		String pop = stack.pop();
		setChanged();
		notifyObservers(getResult());
		return pop;

	}
	/**
	 * 出栈
	 * @return
	 */
	public String popx() {

		String pop = stack.pop();		
		return pop;

	}
	public int getStackSize() {
		return stack.size();
	}

	public String get(int index) {
		return stack.get(index);
	}

}
