package org.sp.project0705.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;


class ImageCopy{
	public static void main(String[] args){
		//����� �Ǵ� ���Ͽ� ��Ʈ���� �Ⱦƺ��� -> �����Է½�Ʈ���� �����غ���
		String path = "D:/morning/javase_workspace/project0705/res/mario.png";
		String path2="D:/morning/javase_workspace/project0705/data/copy.png";

		/*
		<try~catch���� ����: ���α׷��� ������ ������ ����>
		try�������� ������ �߻��� ������ �ִ� �ڵ带 �ۼ��ϰ� ���� try�������� ����ߴ� ������ �߻��Ѵٸ�, �ڵ带 ��ġ���� ����
		catch������ ������ ������ ���� ó���� ����� �Ѵ�. -> �׷��� �ŷڼ� �ִ� ���α׷��� ������ �� �ִ�.
		*/
		FileInputStream fis=null;
		FileOutputStream fos=null;

		
		try{
			//���ϴ� �ڿ��� �̹����� �Է½�Ʈ���� ����
			fis = new FileInputStream(path);

			//������ ������� �� ��½�Ʈ�� ��ü
			fos = new FileOutputStream(path2);

			System.out.println("��Ʈ�� ���� ����");
			
			//������ ��Ʈ���� �̿��� Ÿ�� �̹����� �̷�� �ִ� ������ �˰���(byte) �� �ϳ��� ���̸��ź���(�о��).
			while(true){
				int data = fis.read(); //�� ����Ʈ �б� > ������ ����. �̹��� byte�� �д� �� �ϳ��� ����Ʈ�� �а� ���߸� ���α׷� ������ �߻��� ���ɼ��� �ִ�.
				if(data == -1)break; //�о���� �����Ͱ� ���ٸ�, �ݺ��� ����
				System.out.println(data);
				fos.write(data); //���
			}
			System.out.println("File ���� �Ϸ�");
			
		}catch(FileNotFoundException e){
			System.out.println("�������� �ʴ� ���� ����Դϴ�.");
			//e.printStackTrace();
			//System.out.println(e);
		}catch(IOException e){
			System.out.println("���� �� �����ϴ�.");
		}finally{
			//���� ��Ʈ���� �ݵ�� ���� �ؾ� �Ѵٰ� ������ ��Ģ�ڡڡ�
			//����δ� try���� �����ϵ�, catch���� �����ϵ� �ݵ�� finally���� ��ġ�� �Ǿ� �ִ�.
			//���� finally ������ �ַ� ������ �ʴ� �ڿ����� �����ϴ� �� ����Ѵ�.
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
