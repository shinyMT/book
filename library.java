package library;

import java.text.ParseException;
import java.util.Scanner;



/**
 * library:图书馆借书系统
 * 功能：1.进入图书馆系统：a.新进用户注册登陆  b.已有用户登陆
 *       2.书目信息登记
 *       3.借书：查询书目信息，若有查找成功，借出该书且数量减一；否则查找失败
 *       4.还书：将该书的信息加一
 * @author LELNOVO
 *
 */
class libratySet{
	//定义一个书籍类目数组
    String[]  name = new String [1000];
    //定义书籍初始数目值
    int[]  num = new int [1000];
    //定义书籍借出状态：true（书籍全部已借出），false（未全部借出，可借）
    boolean[] state = new boolean[1000];
    //定义借出日期
    String[] date = new String[1000];
    //定义借出次数
    int[] count = new int[1000];
}

class libraryMgr{
	Scanner input = new Scanner(System.in);
    //初始化对象
	libratySet  books = new libratySet();
    //已借出是true，可借是false
    boolean isJiechu = true;
    
    //初始化书籍信息
     void initial(){
   	 //1.
    	books.name[0] = "云边有个小卖部";
    	books.num[0] = 20;
    	books.state[0] =true;  //已借出
   	 //2.
    	books.name[1] = "人间失格";
    	books.num[1] = 35;
    	books.state[1] =false;  //可借出
   	 //3.
    	books.name[2] = "格林童话";
    	books.num[2] = 40;
    	books.state[2] =false;  //可借出
   }
    
    //管理界面
   void startMenu() throws ParseException{
    	 System.out.println("欢迎使用图书馆借书系统");
    	 System.out.println("-----------------------------------");
    	 System.out.println("1.借出排行榜");
    	 System.out.println("2.新增书籍");
    	 System.out.println("3.查看书籍");
    	 System.out.println("4.下架书籍");
    	 System.out.println("5.借出书籍");
    	 System.out.println("6.归还书籍");
    	 System.out.println("7.退        出");	 
    	 System.out.println("-----------------------------------");
        System.out.println("请选择：");
        int   choice = input.nextInt();
        switch(choice){
        case 1:
       	 list();  //查看借出排行
       	 break;
        case 2:
       	 add();   //新增书籍
       	 returnMain();
       	 break;
        case 3:
       	 search();   //查看书籍
       	 break;
        case 4:
       	 delete();  //下架书籍
       	 break;
        case 5:
       	 lend();   //借出书籍
       	 break;
        case 6:
       	 returnBook();   //归还书籍
       	 break;
        case 7:
       	 System.out.println("感谢您的使用！");
       	 break;
        default:
       	 System.out.println("您的输入有误，请重新输入");
       	 returnMain();
        }
    }
   
   //returnMain()
   void returnMain() throws ParseException{
  	 System.out.println("输入0返回：");
  	 if(input.nextInt()==0){
  		 startMenu();
  	 }
  	 else{
  		 System.out.println("输入错误，异常终止！");
  	 }
   }
   
  //查看借出排行list()
  void list() throws ParseException{
  	 //定义新数组 显示书籍名称
  	 String[] newname = new String[1000];
  	 //定义新数组 显示借出次数
  	 int[] newcount = new int[1000];
  	 for(int i=0;i<books.name.length;i++){
  		 newname[i] = books.name[i];
  		 newcount[i] = books.count[i];
  	 }
  	 //按次数由少到多排列
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
  	 System.out.println("----->排行榜\n");
  	 System.out.println("***************************");
  	 System.out.println("次数\t 名称");
  	 //逆序打印排行榜
  	 for(int i=newname.length-1;i>=0;i--){
  		 if(newname[i] != null){
  			 System.out.println(newcount[i]+"\t 《"+newname[i]+"》");			 
  		 }
  	 }
  	 System.out.println("***********************");
  	 returnMain();
   }
   
 //新增书籍
  void add() throws ParseException{
  	 System.out.println("----->新增书籍\n");
  	 System.out.print("请输入书籍的名称：");
  	 String  name = input.next();
  	System.out.print("请输入书籍的初始数目：");
  	 int     num = input.nextInt();
  	 for(int i=0;i<books.name.length;i++){
  		 if(books.name[i] == null){
  			 //判断位置是否为空
  			books.name[i] = name;
  			books.num[i] = num;
  			 System.out.println("新增《"+name+"》成功");
  			 break;
  		 }
  	 }
  	 System.out.println("******************");
  	 returnMain();
   }
   
 //查看书籍：search（）
  void search() throws ParseException{
  	 System.out.println("---->查看书籍\n");
  	 System.out.println("序号\t数目\t名称\t");
  	 for(int i=0;i<books.name.length;i++){
  		 if(books.name[i]==null){
  			 break;
  		 }else if(books.num[i] == 0){
  			 System.out.println((i+1)+"\t已全部借出\t 《"+books.name[i]+"》 ");
  		 }else if(books.num[i] != 0){
  			 System.out.println((i+1)+"\t 可借\t 《"+books.name[i]+"》");
  		 }
  	 }
  	 System.out.println("**************************");
  	 returnMain();
   }
   
   //下架书籍：delete()
  void delete() throws ParseException{
  	 System.out.println("--->下架书籍\n");
  	 System.out.println("请输入下架书籍的名称");
  	 String name = input.next();
  	 boolean flag = false;
  	 for(int i=0;i<books.name.length;i++){
  		 if(books.name[i] != null && books.name[i].equalsIgnoreCase(name) && books.num[i]!=0){
  			 int j=i;
  			 while(books.name[j+1]!=null){
  				books.name[j]=books.name[j+1]; //删除元素，元素前移
  				books.num[j]=books.num[j+1];
  				 j++;
  			 }
  			 //最后一个不为空的元素置空
  			books.name[j]=null;
  			books.num[j] = 0;
  			 System.out.println("下架《"+name+"》成功！");
  			 flag = true;  //标识符
  			 break;   			 
  		 }else if(books.name[i]!=null &&books.name[i].equalsIgnoreCase(name) && books.num[i]==0){
  			 System.out.println("《"+name+"》为借出状态，不能删除！");
  			 flag = true;
  			 break;
  		 }
  		 if(flag == true){
  			 System.out.println("没有找到匹配信息");
  		 }		 
  	 }
  	 System.out.println("*****************");
  	 returnMain();
   }
   
   //借出书籍：lend()
   void lend() throws ParseException{
  	 System.out.println("--->借出 书籍\n");
  	 System.out.print("请输入书籍的名称:");
  	 String  name=input.next();
  	 for(int i=0;i<books.name.length;i++){
  		 if(books.name[i] == null){
  			 System.out.println("没有找到匹配信息！");
  			 break;
  		 }else if(books.name[i].equals(name)&&books.num[i]!=0){
  			 System.out.println("《"+name+"》借出成功");
  			books.state[i]=true;
  			books.num[i]--;
  			books.count[i]++;
  			 break;
  		 }else if(books.name[i].equals(name)&&books.num[i]==0){
  			 System.out.println("不好意思，《"+name+"》已被借出！");
  			 break;
  		 }
  	 }
  	 System.out.println("*******************");
  	 returnMain();
   }
   
 //归还书籍：returnBook()
  void returnBook() throws ParseException{
  	 System.out.println("--->归还书籍\n");
  	 System.out.print("请输入书籍名称：");
  	 String name=input.next();
  	 for(int i=0;i<books.name.length;i++){
  		 if(books.name[i]==null){
  			 System.out.println("没有找到匹配信息！");
  			 break;
  		 }else if(books.name[i].equals(name)&&books.num[i]==0){
  			 System.out.println("\n《"+name+"》归还成功");
  			 books.num[i]++;
  			 break;
  		 }else if(books.name[i].equals(name)&&books.num[i]==books.num[i]){
  			 System.out.println("《"+name+"》没有被借出，无法进行归还操作");
  			 break;
  		 }
  	 }
  	 System.out.println("****************");
  	 returnMain();
  	 }
  
}

public class library {
	 //用户登陆函数
	 boolean Login(String managerName,String managerPass,int i){
		  if(managerName.equals("admin") && managerPass.equals("123")){
			  return true;
		  }else if(i<3){
			  System.out.println("用户名和密码不匹配！剩余"+(2-i)+"次机会");
		  }
		  return false;
	  }
	
	public static void main(String[] args) throws ParseException {

      			libraryMgr book=new libraryMgr();
      	        book.initial();
      	        book.startMenu();
      
	}
}
