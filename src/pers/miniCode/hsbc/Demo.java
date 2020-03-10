package pers.miniCode.hsbc;

public class Demo {
	public static void main(String[]args){
		double dis = 800.00;
		double va = 40.00;
		double vb = 60.00;
		
		double rest_dis = 200.00;
		double rest_time = 2.00;
		
		System.out.println(getResult(dis,rest_dis,rest_time,va,vb));
	}

	/**
	 * 
	 * @param dis 每圈长度 dis>0
	 * @param rest_dis 达到休息条件的长度  rest_dis>0
	 * @param rest_time 休息时间 rest_time>=0
	 * @param va A的速度 va>=0
	 * @param vb B的速度 vb>0且B>va
	 * @return
	 */
	public static String getResult(double dis,double rest_dis,double rest_time,double va,double vb) {
		if(vb <= va || va < 0 || vb < 0 || dis <= 0 || rest_dis <= 0 || rest_time < 0){
			return "参数设置错误";
		}

		
		//B 比 A 多休息的时间，设B的休息时间rest_time_b，a为rest_time_a，则有rest_time_b-rest_time_a=rest_time_b_a。
		double rest_time_b_a = (dis/rest_dis) * rest_time;
		
		//设A实际行走时间为x，B为y，总时间为T，则有 vb*y-va*x=800;
		//T = y + rest_time_b = x + rest_time_a     =>      y + rest_time_a + rest_time_b_a = x + rest_time_a
		//得：y = x - rest_time_b_a 代入  vb*y-va*x=800
		// vb * (x - rest_time_b_a) - va * x = 800
		// x = (800 + vb*rest_time_b_a)/(vb-va)
		double time_real_a = (dis + vb*rest_time_b_a) / (vb-va);
		
//		double time_real_b  = time_real_a - rest_time_b_a;
		
		//总距离
		double S = va * time_real_a;
		//A休息时间
		double  rest_time_a = Math.floor((S/rest_dis)) * rest_time;
		//总时间
		double t_sum = time_real_a+rest_time_a;
		
//		System.out.println("A的总路程"+S+"-------"+"B的总路程"+(vb*time_real_b));
//		System.out.println("A的行走时间"+time_real_a+"-------"+"B的总路程"+time_real_b);
//		System.out.println(t_sum);
		return String.format("%.2f", t_sum);
	}
}
