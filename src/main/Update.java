package main;

import java.util.ArrayList;
import java.util.Scanner;

import AObject.Book;

public class Update {
	
	private static Scanner sc = new Scanner(System.in);
	
	private static void menu() {
		System.out.println("Lựa chọn chức năng.");
		System.out.println("1. Sửa mã sách.");
		System.out.println("2. Sửa tựa sách.");
		System.out.println("3. Sửa tác giả.");
		System.out.println("4. Sửa thể loại.");
		System.out.println("5. Sửa năm xuất bản.");
		System.out.println("0. Quay lại menu chính.");
		System.out.println("Nhap lua chon cua ban:");
	}
	
	private static void editID(ArrayList<Book> listBook) {
		System.out.println("Nhập mã sách muốn sửa: ");
		String _sId = sc.nextLine();
		int count = 0;
		for(Book book : listBook) {
			if(book.getMa().equals(_sId)) {
				String _eId;
				do {
					System.out.print("Nhập mã mới: ");
					_eId = sc.nextLine();
					if(checkID(listBook, _eId)) {
						System.out.println("<!> Mã sách đã tồn tại <!>");
					}
				}while(checkID(listBook, _eId));
				book.setMa(_eId);
				count++;
				System.out.println("<<< Sửa thành công >>>");
			}		
		}
		if (count == 0) {
			System.out.println("<<< Không có cuốn sách này >>>");
		}
	}
	
	private static boolean checkID(ArrayList<Book> listBook, String eid) {
		for(Book book : listBook) {
			if(book.getMa().equals(eid)) {
				return true;
			}
		}
		return false;
	}
	
	private static void editTitle(ArrayList<Book> listBook) {
		System.out.println("Nhập mã sách muốn sửa: ");
		String _sId = sc.nextLine();
		int count = 0;
		for(Book book : listBook) {
			if(book.getMa().equals(_sId)) {
				System.out.print("Nhập tựa sách mới: ");
				String _eTitle = sc.nextLine();		
				book.setTuaSach(_eTitle);
				count++;
				System.out.println("<<< Sửa thành công >>>");
			}
		}
		if (count == 0) {
			System.out.println("<<< Không có cuốn sách này >>>");
		}
	}
	
	private static void editAuthor(ArrayList<Book> listBook) {
		System.out.println("Nhập mã sách muốn sửa: ");
		String _sId = sc.nextLine();
		int count = 0;
		for(Book book : listBook) {
			if(book.getMa().equals(_sId)) {
				System.out.print("Nhập tựa sách mới: ");
				String _eAuthor = sc.nextLine();		
				book.setTuaSach(_eAuthor);
				count++;
				System.out.println("<<< Sửa thành công >>>");
			}
		}
		if (count == 0) {
			System.out.println("<<< Không có cuốn sách này >>>");
		}
	}
	
	private static void editGenre(ArrayList<Book> listBook) {
		System.out.println("Nhập mã sách muốn sửa: ");
		String _sId = sc.nextLine();
		int count = 0;
		for(Book book : listBook) {
			if(book.getMa().equals(_sId)) {
				System.out.print("Nhập tác giả mới: ");
				String _eGen = sc.nextLine();		
				book.setTuaSach(_eGen);
				count++;
				System.out.println("<<< Sửa thành công >>>");
			}
		}
		if (count == 0) {
			System.out.println("<<< Không có cuốn sách này >>>");
		}
	}
	
	private static void editPublication(ArrayList<Book> listBook) {
		System.out.println("Nhập mã sách muốn sửa: ");
		String _sId = sc.nextLine();
		int count = 0;
		for(Book book : listBook) {
			if(book.getMa().equals(_sId)) {
				System.out.print("Nhập năm xuất bản mới: ");
				String _eYear = sc.nextLine();		
				book.setTuaSach(_eYear);
				count++;
				System.out.println("<<< Sửa thành công >>>");
			}
		}
		if (count == 0) {
			System.out.println("<<< Không có cuốn sách này >>>");
		}
	}
	
	public static void update(ArrayList<Book> listBook) {
		int chon;
		do {
			menu();
			chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1:
				editID(listBook);
				break;
			case 2: 
				editTitle(listBook);
				break;
			case 3: 
				editAuthor(listBook);
				break;
			case 4: 
				editGenre(listBook);
				break;
			case 5: 
				editPublication(listBook);
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le.");
			}
		}while(chon!=0);
	}
}
