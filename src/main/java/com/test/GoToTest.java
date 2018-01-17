package com.test;

public class GoToTest {
	
	public static void main(String[] args) {
		//测试循环过程中使用lable跳出的顺序
		int num = 0;
		System.out.println("outer 标记的位置");
		// lable 标签，名字可以自己取
		outer:
		while(true)
		{
			System.out.println("外层循环开始");
			while(true)
			{
				num++;
				
				if(num == 2)
				{
					System.out.println("跳出本轮循环，continue");
					continue;
				}
				if(num == 3)
				{
					System.out.println("跳转到标签位置，continue outer");
					continue outer;
				}
				if(num == 4)
				{
					System.out.println("跳出本层循环 break");
					break;
				}
				if(num == 6)
				{
					System.out.println("结束循环，跳出到最外层 break outer");
					break outer;
				}
				System.out.println("循环次数：" + num);
			}
		}
		System.out.println("outer 循环结束");
	}

}
