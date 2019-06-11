package day05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MAP_Managerment {
	public static void main(String []args) {
		int number=0;
		Map<Integer,Students> map = new HashMap<Integer,Students>();
		map.put(number++,new Students("name00",0,0,0));
		map.put(number++,new Students("name01",0,0,0));
		map.put(number++,new Students("name02",0,0,0));
		Scanner scann = new Scanner(System.in);
		while(true) {	
			System.out.println("1.입력 2.조회 3.수정 4.삭제 5.전체조회 6.종료");
			int selection=scann.nextInt();
			if(selection==1){
				String name;//입력
				int []arr = new int[3];
				System.out.print("name : ");name = scann.next();
				System.out.print("kor  : ");arr[0]=scann.nextInt();
				System.out.print("eng  : ");arr[1]=scann.nextInt();
				System.out.print("math : ");arr[2]=scann.nextInt();
				map.put(number, new Students(name,arr));
				System.out.println("your Key is : "+number++);
			}else if(selection==2) {//조회
				System.out.print("index : ");int index = scann.nextInt();
				if(map.containsKey(index)) {
				System.out.println("name : "+map.get(index).getName());
				System.out.println("Kor  : "+map.get(index).getScore()[0]);
				System.out.println("Eng  : "+map.get(index).getScore()[1]);
				System.out.println("Math : "+map.get(index).getScore()[2]);
				System.out.println("Sum  : "+map.get(index).getSum());
				System.out.println("Avg  : "+map.get(index).getAvg());
				}else {
					System.out.println("not found");
				}
			}else if(selection==3) {//수정
				int arr[] = new int[3];
				System.out.print("index : ");int index = scann.nextInt();
				if(map.containsKey(index)) {
					System.out.print("name : ");String name3= scann.next();
					System.out.print("Kor  : ");arr[0]=scann.nextInt();
					System.out.print("Eng  : ");arr[1]=scann.nextInt();
					System.out.print("Math : ");arr[2]=scann.nextInt();
					map.remove(index);
					map.put(index,new Students(name3,arr));
					map.get(index).setAvg();
				}else {
					System.out.println("not found");
				}
					
			}else if(selection==4) {//삭제
				System.out.print("index : ");int index = scann.nextInt();
				if(map.containsKey(index)) {
				map.remove(index);
				System.out.println("index "+index+"is removed");
				}else {
					System.out.println("not found");
				}
			}else if(selection==5) {//전체조회
				System.out.println("index\t name\t Kor\t Eng\t Math\t Sum\t Avg\t");
				System.out.println("--------------------------------------------");
				for(int i=0;i<map.size();i++) {
					if(map.containsKey(i)) {
						System.out.println(i+"\t"+map.get(i).getName()+"\t"+map.get(i).getScore()[0]+
								"\t"+map.get(i).getScore()[1]+"\t "+map.get(i).getScore()[2]+
								"\t "+map.get(i).getSum()+"\t "+map.get(i).getAvg());
					}
				}
			}else {//종료
				System.out.println("Good bye");
				break;
			}	
		}
	}
}
