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
	 * @param dis ÿȦ���� dis>0
	 * @param rest_dis �ﵽ��Ϣ�����ĳ���  rest_dis>0
	 * @param rest_time ��Ϣʱ�� rest_time>=0
	 * @param va A���ٶ� va>=0
	 * @param vb B���ٶ� vb>0��B>va
	 * @return
	 */
	public static String getResult(double dis,double rest_dis,double rest_time,double va,double vb) {
		if(vb <= va || va < 0 || vb < 0 || dis <= 0 || rest_dis <= 0 || rest_time < 0){
			return "�������ô���";
		}

		
		//B �� A ����Ϣ��ʱ�䣬��B����Ϣʱ��rest_time_b��aΪrest_time_a������rest_time_b-rest_time_a=rest_time_b_a��
		double rest_time_b_a = (dis/rest_dis) * rest_time;
		
		//��Aʵ������ʱ��Ϊx��BΪy����ʱ��ΪT������ vb*y-va*x=800;
		//T = y + rest_time_b = x + rest_time_a     =>      y + rest_time_a + rest_time_b_a = x + rest_time_a
		//�ã�y = x - rest_time_b_a ����  vb*y-va*x=800
		// vb * (x - rest_time_b_a) - va * x = 800
		// x = (800 + vb*rest_time_b_a)/(vb-va)
		double time_real_a = (dis + vb*rest_time_b_a) / (vb-va);
		
//		double time_real_b  = time_real_a - rest_time_b_a;
		
		//�ܾ���
		double S = va * time_real_a;
		//A��Ϣʱ��
		double  rest_time_a = Math.floor((S/rest_dis)) * rest_time;
		//��ʱ��
		double t_sum = time_real_a+rest_time_a;
		
//		System.out.println("A����·��"+S+"-------"+"B����·��"+(vb*time_real_b));
//		System.out.println("A������ʱ��"+time_real_a+"-------"+"B����·��"+time_real_b);
//		System.out.println(t_sum);
		return String.format("%.2f", t_sum);
	}
}
