package com.zkteco.biometric;


public class LogTest {

	public static void main(String[] args) {
		int sum1 = 0;
		int sum2 = 0;
		int count = 20;
		long bytes =  2147483647;
		for(int num=0;num<count;num++){
			int k = 1024;
			String[] sizes = {"B", "KB", "MB", "GB", "TB"};//, "PB", "EB", "ZB", "YB"
			//循环算法
			long c = System.currentTimeMillis();
			int n = 0;
			double bytes2 = bytes;
			while(bytes2 >= k){
				bytes2 /= k;
				n++;
			}
			double val2 = 0;
			if(n>sizes.length){
				val2 = Math.floor(bytes2 *100/Math.pow(k, sizes.length))/100;
				n = sizes.length-1;
			}else{
				val2 = Math.floor(bytes2 * 100) / 100;
			}
			System.out.println(val2 + sizes[n]+"------循环算法");
			long d = System.currentTimeMillis();
			
			//对数算法
			long a = System.currentTimeMillis();
			int i = (int) Math.floor(Math.log(bytes) / Math.log(k));
			if(i > sizes.length){
				i = sizes.length-1;
			}
			double val = (bytes / Math.pow(k, i));
			val = Math.floor(val * 100) / 100;
			System.out.println(val + sizes[i]+"------对数算法");
			long b = System.currentTimeMillis();
			
			sum1 += (b-a);
			sum2 += (d-c);
		}
		System.out.println("对数算法平均耗时："+((double)sum1/count)+"  循环算法平均耗时："+((double)sum2/count));
		
		sum1 = 0; sum2 = 0;
		long time = 3600;
		for(int num=0;num<count;num++){
			int k = 60;
			String[] times = {"秒","分","时"};
			//循环算法
			long c = System.currentTimeMillis();
			int n = 0;
			double time2 = time;
			while(time2 >= k){
				time2 /= k;
				n++;
			}
			double val2 = 0;
			if(n>=times.length){
				val2 = Math.floor(time *100/Math.pow(k, times.length-1))/100;
				n = times.length-1;
			}else{
				val2 = Math.floor(time2 * 100) / 100;
			}
			System.out.println(val2 + times[n]+"------循环算法");
			long d = System.currentTimeMillis();
			
			//对数算法
			long a = System.currentTimeMillis();
			int i = (int) Math.floor(Math.log(time) / Math.log(k));
			if(i >= times.length){
				i = times.length-1;
			}
			double val = (time / Math.pow(k, i));
			val = Math.floor(val * 100) / 100;
			System.out.println(val + times[i]+"------对数算法");
			long b = System.currentTimeMillis();
			
			sum1 += (b-a);
			sum2 += (d-c);
		}
		System.out.println("对数算法平均耗时："+((double)sum1/count)+"  循环算法平均耗时："+((double)sum2/count));
	}

}
