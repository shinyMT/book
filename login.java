package library;

import java.util.Scanner;

public class login {
	public static String name;
	public static String password;
	public static void main(String[] args) {
		Manager manager = new Manager();
		System.out.println("-------------------");
		System.out.println("1. 登录");
		System.out.println("2. 注册");
		System.out.println("-------------------");
		System.out.println("请选择需要的选项：");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		switch(option){
		case 1:
			if(name == null){
				System.out.println("请先注册");
				System.out.println("请输入您的账号：");
				Scanner sc1 = new Scanner(System.in);
				name = sc1.nextLine();
				System.out.println("请输入您的密码：");
				Scanner sc2 = new Scanner(System.in);
				password = sc2.nextLine();
				int opt = 1;
				manager.Login(name,password,opt);
			}
			else{
				option++;
			}
		case 2:
			System.out.println("请输入您的账号：");
			Scanner sc1 = new Scanner(System.in);
			name = sc1.nextLine();
			System.out.println("请输入您的密码：");
			Scanner sc2 = new Scanner(System.in);
			password = sc2.nextLine();
			int opt = 2;
			manager.Login(name,password,opt);
		}
	}
}
class Manager{
	public static String name;
	public static String password;
	public String Update(){
		System.out.println("请输入新的用户名");
		Scanner sc4 = new Scanner(System.in);
		name = sc4.nextLine();
		System.out.println("请输入新的密码");
		Scanner sc5 = new Scanner(System.in);
		password = sc5.nextLine();
		int opt = 2;
		return (name+password+opt);
	}
	public void Login(String na,String pw,int opt){
		na = login.name;
		pw = login.password;
		switch(opt){
		case 1:
			if(na.equals(na) && pw.equals(pw)){
//				System.out.println("显示主菜单");
				showMainMenu showMmenu = new showMainMenu();
				showMmenu.Modify();
			}
			else{
				System.out.println("账号或密码错误，请重新输入");
				login.main(null);
			}
		break;
		case 2:
			if(na.equals(Manager.name) && pw.equals(Manager.password)){
//				System.out.println("显示主菜单");
				showMainMenu showMmenu = new showMainMenu();
				showMmenu.Modify();
			}
			else{
				System.out.println("账号或密码错误，请重新输入");
				login.main(null);
			}
		break;
		}
		
		
	}
}
class Menu{
	public void showLoginMenu(){
		System.out.println("登陆或者退出"); 
	}
}
class showMainMenu{
	public void Modify(){
		Manager manager = new Manager();
		Menu menu = new Menu();
		System.out.println("-----------------------");
		System.out.println("1. 修改管理员账号和密码");
		System.out.println("2. 退出系统");
		System.out.println("-----------------------");
		System.out.println("请选择需要的选项");
		Scanner sc3 = new Scanner(System.in);
		int option = sc3.nextInt();
		switch(option){
		case 1:
			manager.Update();
			System.out.println("新的用户名为："+Manager.name);
			System.out.println("新的密码为："+Manager.password);
			login.name = Manager.name;
			login.password = Manager.password;
			login.main(null);
			break;
		case 2:
			menu.showLoginMenu();
			break;
		}
	}
}
