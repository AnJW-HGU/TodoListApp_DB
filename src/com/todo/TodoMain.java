package com.todo;

import java.util.Scanner;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
   public static void start()
   {
//      Scanner sc = new Scanner(System.in);
//      TodoList l = new TodoList();
//      l.importData("todolist.txt");
	   
	   	Scanner sc = new Scanner(System.in);
		TodoList l = new TodoList();
		boolean isList = false;
		boolean quit = false;
		String key;
		
		Menu.displaymenu();
		do {
			Menu.prompt();
			isList = false;
			String choice = sc.next();
			switch (choice) {

			case "add":
				TodoUtil.createItem(l);
				break;
			
			case "del":
				TodoUtil.deleteItem(l);
				break;
				
			case "edit":
				TodoUtil.updateItem(l);
				break;
				
			case "ls":
				TodoUtil.listAll(l);
				break;
				
			case "ls_cate":
				TodoUtil.listCateAll(l);
				break;

//			case "ls_name_asc":
//				l.sortByName();
//				isList = true;
//				System.out.println("��������� ���ĵǾ����ϴ�.");
//				break;
//
//			case "ls_name_desc":
//				l.sortByName();
//				l.reverseList();
//				System.out.println("���񿪼����� ���ĵǾ����ϴ�.");
//				isList = true;
//				break;
//				
//			case "ls_date":
//				l.sortByDate();
//				System.out.println("��¥������ ���ĵǾ����ϴ�.");
//				isList = true;
//				break;
//				
//			case "ls_date_desc":
//				l.sortByDate();
//				l.reverseList();
//				System.out.println("��¥�������� ���ĵǾ����ϴ�.");
//				isList = true;
//				break;
			
			case "find":
				key = sc.next().trim();
				TodoUtil.findList(l, key);
				break;
			
			case "find_cate":
				key = sc.next();
				TodoUtil.findCateList(l, key);
				break;

			case "exit":
				quit = true;
				break;
			
			case "help":
				Menu.displaymenu();
				break;

			default:
				System.out.println("��Ȯ�� ��ɾ �Է����ּ���. (��ɾ� �ٽ� ���� - help)");
				break;
			}
		} while (!quit);
   }
}