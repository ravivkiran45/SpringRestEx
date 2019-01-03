package com.journaldev.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class CouponTask extends RecursiveTask<String>{
	private static final long serialVersionUID = 1L;

	private List<String> stores;

	public CouponTask(List<String> stores) {
		this.stores = stores;
	}

	@Override
	protected String compute() {
		
		if(stores == null || stores.size() < 1) {
			return "";
		}else if(stores.size() == 1) {			
			return getCoupon(stores.get(0));
		}

		List<String> oneStores = stores.subList(0, stores.size()/2);
		List<String> twoStores = stores.subList(stores.size()/2, 
			stores.size());	
		
		CouponTask cTaskOne = new CouponTask(oneStores);
		cTaskOne.fork();
		
		CouponTask cTaskTwo = new CouponTask(twoStores);

		return cTaskTwo.compute()+"," + cTaskOne.join();

	}

	String getCoupon(String store) {
		int dicount = (int )(Math.random() * 90);		
		return "get upto "+dicount+ "% off at "+store;
	}
	
public static void main(String[] args) {
		
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		
		List<String> stores = new ArrayList<String>();
		stores.add("sears");
		stores.add("gap");
		stores.add("nordstorm");
		stores.add("jcpenny");
		
		CouponTask ctask = new CouponTask(stores);
		
		String coupons = forkJoinPool.invoke(ctask);
		System.out.println(coupons);
		
	}
}