//package com.todo.service;
//
//import java.io.Writer;
//import java.io.FileWriter;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.*;
//
//import com.todo.dao.TodoItem;
//import com.todo.dao.TodoList;
//
//public class TodoUtil {
//	
//	public static void createItem(TodoList list) {
//		
//		String cate, title, desc, due;
//		Scanner sc = new Scanner(System.in);
//		Scanner sd = new Scanner(System.in);
//		
//		System.out.println("[�� �� �߰�]");
//		
//		System.out.print("ī�װ� > ");
//		cate = sc.next().trim();
//		
//		System.out.print("���� > ");
//		title = sc.next().trim();
//		if (list.isDuplicate(title)) {
//			System.out.println("- ������ ������ ���� �ֽ��ϴ� !");
//			return;
//		}
//		
//		System.out.print("���� > ");
//		desc = sd.nextLine().trim();
//		
//		System.out.print("�������� > ");
//		due = sc.next().trim();
//		
//		TodoItem t = new TodoItem(cate, title, desc, due);
//		list.addItem(t);
//	}
//
//	public static void deleteItem(TodoList l) {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("[�� �� ����]");
//		
//		System.out.print("������ ���� ��ȣ > ");
//		int num = sc.nextInt();
//		
//		if (num < 1 || num > l.getList().size()) {
//			System.out.println("�ش� �׸��� �������� �ʽ��ϴ� !");
//		}
//		else {
//			TodoItem item = l.getList().get(num-1);
//			System.out.printf(num+". [%s] %s - %s - %s - %s\n", 
//					item.getCategory(), item.getTitle(), item.getDesc(), item.getDue_date(), item.getCurrent_date());
//			
//			System.out.println("�� ���� �����Ͻðڽ��ϱ�? (y/n)");
//			String answer = sc.next();
//			if (answer.equals("y")) {
//				l.deleteItem(item);
//				System.out.println("�����Ǿ����ϴ�. ");
//			} else {
//				System.out.println("��ҵǾ����ϴ�. ");
//			}
//		}
//		
//	}
//
//
//	public static void updateItem(TodoList l) {
//		
//		Scanner sc = new Scanner(System.in);
//		Scanner sd = new Scanner(System.in);
//		
//		System.out.println("[�� �� ����]");
//		
//		System.out.print("������ ���� ��ȣ > ");
//		int num = sc.nextInt();
//		
//		if (num < 1 || num > l.getList().size()) {
//			System.out.println("�ش� �׸��� �������� �ʽ��ϴ� !");
//		}
//		else {
//			TodoItem item = l.getList().get(num-1);
//			System.out.printf(num+". [%s] %s - %s - %s - %s\n", 
//					item.getCategory(), item.getTitle(), item.getDesc(), item.getDue_date(), item.getCurrent_date());
//			l.deleteItem(item);
//			
//			
//			System.out.print("���ο� ���� ī�װ� > ");
//			String new_cate = sc.next().trim();
//	
//			System.out.print("���ο� ���� ���� > ");
//			String new_title = sc.next().trim();
//			if (l.isDuplicate(new_title)) {
//				System.out.println("- ������ ������ ���� �ֽ��ϴ� !");
//				return;
//			}
//			
//			System.out.print("���ο� ���� ���� > ");
//			String new_desc = sd.nextLine().trim();
//			
//			System.out.print("�������� > ");
//			String new_due = sc.next().trim();
//			
//			TodoItem t = new TodoItem(new_cate, new_title, new_desc, new_due);
//			l.addItem(t);
//			System.out.println("�����Ǿ����ϴ�.");
//		}
//		
//
//	}
//	
//	public static void find(TodoList l, String key) {
//		int num = 1;
//		int result_num = 0;
//		for (TodoItem item : l.getList()) {
//			if (item.getTitle().contains(key) || item.getDesc().contains(key)) {
//				System.out.printf(num+". [%s] %s - %s - %s - %s\n", 
//						item.getCategory(), item.getTitle(), item.getDesc(), item.getDue_date(), item.getCurrent_date());
//				result_num++;
//			}
//			num++;
//		}
//		System.out.println("�� "+result_num+"���� ���� ã�ҽ��ϴ�.");
//	}
//	
//	public static void findCate(TodoList l, String key) {
//		int num = 1;
//		int result_num = 0;
//		for (TodoItem item : l.getList()) {
//			if (item.getCategory().contains(key)) {
//				System.out.printf(num+". [%s] %s - %s - %s - %s\n", 
//						item.getCategory(), item.getTitle(), item.getDesc(), item.getDue_date(), item.getCurrent_date());
//				result_num++;
//			}
//			num++;
//		}
//		System.out.println("�� "+result_num+"���� ���� ã�ҽ��ϴ�.");
//	}
//
//	public static void listAll(TodoList l) {
//		System.out.println("[�� �� ���, �� "+l.getList().size()+"��]");
//		int num = 1;
//		for (TodoItem item : l.getList()) {
//			System.out.printf(num+". [%s] %s - %s - %s - %s\n", 
//					item.getCategory(), item.getTitle(), item.getDesc(), item.getDue_date(), item.getCurrent_date());
//			num++;
//		}
//	}
//	
//	public static void saveList(TodoList l, String filename) {
//		try {
//			Writer w = new FileWriter(filename);
//			
//			for (TodoItem item : l.getList()) {
//				w.write(item.toSaveString());
//			}
//			w.close();
//			
//			System.out.println("��� �����Ͱ� ����Ǿ����ϴ�.");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void loadList(TodoList l, String filename) {
//		try {
//			BufferedReader br = new BufferedReader(new FileReader(filename));
//			
//			String todoLine;
//			while((todoLine = br.readLine()) != null) {
//				StringTokenizer st = new StringTokenizer(todoLine, "##");
//				String cate = st.nextToken();
//				String title = st.nextToken();
//				String desc = st.nextToken();
//				String due = st.nextToken();
//				String current = st.nextToken();
//				
//				TodoItem t = new TodoItem(cate, title, desc, due, current);
//				l.addItem(t);
//			}
//			br.close();
//			System.out.println("�� �� ���� �ε� �Ϸ� !");
//		} catch (FileNotFoundException e) {
//			System.out.println(filename+" ������ �����ϴ�.");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}		
//	}
//}
