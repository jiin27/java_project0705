package org.sp.project0705.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;


class ImageCopy{
	public static void main(String[] args){
		//대상이 되는 파일에 스트림을 꽂아보자 -> 파일입력스트림을 연결해보자
		String path = "D:/morning/javase_workspace/project0705/res/mario.png";
		String path2="D:/morning/javase_workspace/project0705/data/copy.png";

		/*
		<try~catch문의 목적: 프로그램의 비정상 종료의 방지>
		try문에서는 에러가 발생할 소지가 있는 코드를 작성하고 만일 try영역에서 우려했던 에러가 발생한다면, 코드를 방치하지 말고
		catch문으로 유도해 에러에 대한 처리를 해줘야 한다. -> 그래야 신뢰성 있는 프로그램을 개발할 수 있다.
		*/
		FileInputStream fis=null;
		FileOutputStream fos=null;

		
		try{
			//원하는 자원인 이미지에 입력스트림을 연결
			fis = new FileInputStream(path);

			//파일을 대상으로 한 출력스트림 객체
			fos = new FileOutputStream(path2);

			System.out.println("스트림 생성 성공");
			
			//생성된 스트림을 이용해 타겟 이미지를 이루고 있는 수많은 알갱이(byte) 중 하나를 들이마셔보자(읽어보자).
			while(true){
				int data = fis.read(); //한 바이트 읽기 > 컴파일 에러. 이미지 byte를 읽는 중 하나의 바이트만 읽고 멈추면 프로그램 오류가 발생할 가능성이 있다.
				if(data == -1)break; //읽어들일 데이터가 없다면, 반복문 종료
				System.out.println(data);
				fos.write(data); //출력
			}
			System.out.println("File 복사 완료");
			
		}catch(FileNotFoundException e){
			System.out.println("존재하지 않는 파일 경로입니다.");
			//e.printStackTrace();
			//System.out.println(e);
		}catch(IOException e){
			System.out.println("읽을 수 없습니다.");
		}finally{
			//사용된 스트림은 반드시 제거 해야 한다가 개발의 원칙★★★
			//실행부는 try문을 수행하든, catch문을 수행하든 반드시 finally블럭을 거치게 되어 있다.
			//따라서 finally 에서는 주로 사용되지 않는 자원등을 해제하는 데 사용한다.
			try{
				fos.close();
			}catch(IOException e){
				e.printStackTrace();
			}

			try{
				fis.close();
			}catch(IOException e){
				e.printStackTrace();
			}

		}

	}
}
