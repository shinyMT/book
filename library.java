package library;

import java.text.ParseException;
import java.util.Scanner;



/**
 * library:ͼ��ݽ���ϵͳ
 * ���ܣ�1.����ͼ���ϵͳ��a.�½��û�ע���½  b.�����û���½
 *       2.��Ŀ��Ϣ�Ǽ�
 *       3.���飺��ѯ��Ŀ��Ϣ�����в��ҳɹ������������������һ���������ʧ��
 *       4.���飺���������Ϣ��һ
 * @author LELNOVO
 *
 */
class libratySet{
	//����һ���鼮��Ŀ����
    String[]  name = new String [1000];
    //�����鼮��ʼ��Ŀֵ
    int[]  num = new int [1000];
    //�����鼮���״̬��true���鼮ȫ���ѽ������false��δȫ��������ɽ裩
    boolean[] state = new boolean[1000];
    //����������
    String[] date = new String[1000];
    //����������
    int[] count = new int[1000];
}

class libraryMgr{
	Scanner input = new Scanner(System.in);
    //��ʼ������
	libratySet  books = new libratySet();
    //�ѽ����true���ɽ���false
    boolean isJiechu = true;
    
    //��ʼ���鼮��Ϣ
     void initial(){
   	 //1.
    	books.name[0] = "�Ʊ��и�С����";
    	books.num[0] = 20;
    	books.state[0] =true;  //�ѽ��
   	 //2.
    	books.name[1] = "�˼�ʧ��";
    	books.num[1] = 35;
    	books.state[1] =false;  //�ɽ��
   	 //3.
    	books.name[2] = "����ͯ��";
    	books.num[2] = 40;
    	books.state[2] =false;  //�ɽ��
   }
    
    //�������
   void startMenu() throws ParseException{
    	 System.out.println("��ӭʹ��ͼ��ݽ���ϵͳ");
    	 System.out.println("-----------------------------------");
    	 System.out.println("1.������а�");
    	 System.out.println("2.�����鼮");
    	 System.out.println("3.�鿴�鼮");
    	 System.out.println("4.�¼��鼮");
    	 System.out.println("5.����鼮");
    	 System.out.println("6.�黹�鼮");
    	 System.out.println("7.��        ��");	 
    	 System.out.println("-----------------------------------");
        System.out.println("��ѡ��");
        int   choice = input.nextInt();
        switch(choice){
        case 1:
       	 list();  //�鿴�������
       	 break;
        case 2:
       	 add();   //�����鼮
       	 returnMain();
       	 break;
        case 3:
       	 search();   //�鿴�鼮
       	 break;
        case 4:
       	 delete();  //�¼��鼮
       	 break;
        case 5:
       	 lend();   //����鼮
       	 break;
        case 6:
       	 returnBook();   //�黹�鼮
       	 break;
        case 7:
       	 System.out.println("��л����ʹ�ã�");
       	 break;
        default:
       	 System.out.println("����������������������");
       	 returnMain();
        }
    }
   
   //returnMain()
   void returnMain() throws ParseException{
  	 System.out.println("����0���أ�");
  	 if(input.nextInt()==0){
  		 startMenu();
  	 }
  	 else{
  		 System.out.println("��������쳣��ֹ��");
  	 }
   }
   
  //�鿴�������list()
  void list() throws ParseException{
  	 //���������� ��ʾ�鼮����
  	 String[] newname = new String[1000];
  	 //���������� ��ʾ�������
  	 int[] newcount = new int[1000];
  	 for(int i=0;i<books.name.length;i++){
  		 newname[i] = books.name[i];
  		 newcount[i] = books.count[i];
  	 }
  	 //���������ٵ�������
  	 for(int i=0;i<newname.length;i++){
  		 for(int j=i+1;j<newname.length;j++){
  			 if(newcount[i]>newcount[j]){
  				 int temp = newcount[i];
  				 newcount[i] = newcount[j];
  				 newcount[j] = temp;
  				 String temp1 = newname[i];
  				 newname[i] = newname[j];
  				 newname[j] = temp1;
  			 }
  		 }
  	 }
  	 System.out.println("----->���а�\n");
  	 System.out.println("***************************");
  	 System.out.println("����\t ����");
  	 //�����ӡ���а�
  	 for(int i=newname.length-1;i>=0;i--){
  		 if(newname[i] != null){
  			 System.out.println(newcount[i]+"\t ��"+newname[i]+"��");			 
  		 }
  	 }
  	 System.out.println("***********************");
  	 returnMain();
   }
   
 //�����鼮
  void add() throws ParseException{
  	 System.out.println("----->�����鼮\n");
  	 System.out.print("�������鼮�����ƣ�");
  	 String  name = input.next();
  	System.out.print("�������鼮�ĳ�ʼ��Ŀ��");
  	 int     num = input.nextInt();
  	 for(int i=0;i<books.name.length;i++){
  		 if(books.name[i] == null){
  			 //�ж�λ���Ƿ�Ϊ��
  			books.name[i] = name;
  			books.num[i] = num;
  			 System.out.println("������"+name+"���ɹ�");
  			 break;
  		 }
  	 }
  	 System.out.println("******************");
  	 returnMain();
   }
   
 //�鿴�鼮��search����
  void search() throws ParseException{
  	 System.out.println("---->�鿴�鼮\n");
  	 System.out.println("���\t��Ŀ\t����\t");
  	 for(int i=0;i<books.name.length;i++){
  		 if(books.name[i]==null){
  			 break;
  		 }else if(books.num[i] == 0){
  			 System.out.println((i+1)+"\t��ȫ�����\t ��"+books.name[i]+"�� ");
  		 }else if(books.num[i] != 0){
  			 System.out.println((i+1)+"\t �ɽ�\t ��"+books.name[i]+"��");
  		 }
  	 }
  	 System.out.println("**************************");
  	 returnMain();
   }
   
   //�¼��鼮��delete()
  void delete() throws ParseException{
  	 System.out.println("--->�¼��鼮\n");
  	 System.out.println("�������¼��鼮������");
  	 String name = input.next();
  	 boolean flag = false;
  	 for(int i=0;i<books.name.length;i++){
  		 if(books.name[i] != null && books.name[i].equalsIgnoreCase(name) && books.num[i]!=0){
  			 int j=i;
  			 while(books.name[j+1]!=null){
  				books.name[j]=books.name[j+1]; //ɾ��Ԫ�أ�Ԫ��ǰ��
  				books.num[j]=books.num[j+1];
  				 j++;
  			 }
  			 //���һ����Ϊ�յ�Ԫ���ÿ�
  			books.name[j]=null;
  			books.num[j] = 0;
  			 System.out.println("�¼ܡ�"+name+"���ɹ���");
  			 flag = true;  //��ʶ��
  			 break;   			 
  		 }else if(books.name[i]!=null &&books.name[i].equalsIgnoreCase(name) && books.num[i]==0){
  			 System.out.println("��"+name+"��Ϊ���״̬������ɾ����");
  			 flag = true;
  			 break;
  		 }
  		 if(flag == true){
  			 System.out.println("û���ҵ�ƥ����Ϣ");
  		 }		 
  	 }
  	 System.out.println("*****************");
  	 returnMain();
   }
   
   //����鼮��lend()
   void lend() throws ParseException{
  	 System.out.println("--->��� �鼮\n");
  	 System.out.print("�������鼮������:");
  	 String  name=input.next();
  	 for(int i=0;i<books.name.length;i++){
  		 if(books.name[i] == null){
  			 System.out.println("û���ҵ�ƥ����Ϣ��");
  			 break;
  		 }else if(books.name[i].equals(name)&&books.num[i]!=0){
  			 System.out.println("��"+name+"������ɹ�");
  			books.state[i]=true;
  			books.num[i]--;
  			books.count[i]++;
  			 break;
  		 }else if(books.name[i].equals(name)&&books.num[i]==0){
  			 System.out.println("������˼����"+name+"���ѱ������");
  			 break;
  		 }
  	 }
  	 System.out.println("*******************");
  	 returnMain();
   }
   
 //�黹�鼮��returnBook()
  void returnBook() throws ParseException{
  	 System.out.println("--->�黹�鼮\n");
  	 System.out.print("�������鼮���ƣ�");
  	 String name=input.next();
  	 for(int i=0;i<books.name.length;i++){
  		 if(books.name[i]==null){
  			 System.out.println("û���ҵ�ƥ����Ϣ��");
  			 break;
  		 }else if(books.name[i].equals(name)&&books.num[i]==0){
  			 System.out.println("\n��"+name+"���黹�ɹ�");
  			 books.num[i]++;
  			 break;
  		 }else if(books.name[i].equals(name)&&books.num[i]==books.num[i]){
  			 System.out.println("��"+name+"��û�б�������޷����й黹����");
  			 break;
  		 }
  	 }
  	 System.out.println("****************");
  	 returnMain();
  	 }
  
}

public class library {
	 //�û���½����
	 boolean Login(String managerName,String managerPass,int i){
		  if(managerName.equals("admin") && managerPass.equals("123")){
			  return true;
		  }else if(i<3){
			  System.out.println("�û��������벻ƥ�䣡ʣ��"+(2-i)+"�λ���");
		  }
		  return false;
	  }
	
	public static void main(String[] args) throws ParseException {

      			libraryMgr book=new libraryMgr();
      	        book.initial();
      	        book.startMenu();
      
	}
}
