package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import AObject.Book;


public class Main {
	public static void main(String[] args) {
		System.out.println("Nhập đường dẫn:"); 
		String dataRoot = sc.nextLine();		
		ArrayList<Book> listBook = DataIO.loadData(dataRoot);

		int chon;
		do {
			printMenu();
			System.out.println("Nhập lựa chọn:");
			chon = esc.nextInt();
			switch(chon) {
			case 1:
				printListBook(listBook);
				break;
			case 2:
				addBook(listBook);
				break;
			case 3:
				delBook(listBook);
				break;
			case 4:
				searchByID(listBook);
				break;
			case 5:
				searchByAuthor(listBook);
				break;
			case 6:
				searchByTitle(listBook);
				break;
			case 0:
				DataIO.saveData(listBook, dataRoot);
				System.out.println("< Đã Thoát >");
				break;
			}
		}while(chon != 0);		
	}
	
	
	private static Scanner sc = new Scanner(System.in);
	private static Scanner esc = new Scanner(System.in);

	private static void searchByTitle(ArrayList<Book> listBook) {
		System.out.println("Nhập tựa sách muốn tìm: ");
		String _sTitle = sc.nextLine();
		int count = 0;
		for(Book book : listBook) {
			String _lTitle = book.getTuaSach().toLowerCase();
			if(book.getTuaSach().contains(_sTitle) || _lTitle.contains(_sTitle)) {
				book.showInfo();
				count++;
			}
		}
		if(count == 0) {
			System.out.println("<<< Không tìm thấy >>>\n");
		}
	}

	private static void searchByAuthor(ArrayList<Book> listBook) {
		System.out.println("Nhập tác giả của sách muốn tìm: ");
		String _sAth = sc.nextLine();
		int count = 0;
		for(Book book : listBook) {
			String _lAth =book.getTacGia().toLowerCase();
			if(book.getTacGia().contains(_sAth) || _lAth.contains(_sAth)) {
				book.showInfo();
				count++;
			}
		}
		if(count == 0) {
			System.out.println("<<< Không tìm thấy >>>\n");
		}
	}

	private static void searchByID(ArrayList<Book> listBook) {
		System.out.println("Nhập mã sách muốn tìm: ");
		String _sId = sc.nextLine();
		int count = 0;
		for(Book book : listBook) {
			if(book.getMa().equals(_sId)) {
				book.showInfo();
				count++;
			}
		}
		if(count == 0) {
			System.out.println("<<< Không tìm thấy >>>\n");
		}
	}
	
	private static void delBook(ArrayList<Book> listBook) {
		System.out.println("Nhập mã sách muốn xóa: ");
		String _dId = sc.nextLine();
		int count = 0;
		for(int i=0; i<listBook.size(); i++) {
			if(listBook.get(i).getMa().equals(_dId)) {
				listBook.remove(i);
				count++;
				System.out.println("Xóa thành công !!\n");
			}
		}
		if (count == 0) {
			System.out.println("<<< Không có cuốn sách này >>>");
		}
		
	}

	private static void addBook(ArrayList<Book> listBook) {
		System.out.println("Nhập thông tin sách mới:");
		String temp = "";
		String _ma;
		do {
			System.out.print("Nhập mã sách: ");
			_ma = sc.nextLine();
			for (int i=0;i<listBook.size(); i++) {
				temp = listBook.get(i).getMa();
				if(temp.equals(_ma)) {
					System.out.println("<!> Mã sách đã tồn tại <!>");
					break;
				}
			}
		}while(temp.equals(_ma));
		System.out.print("Nhập tựa sách: ");
		String _tuaS = sc.nextLine();
		System.out.print("Nhâp tác giả: ");
		String _tacG = sc.nextLine();
		System.out.print("Nhập thể loại: ");
		String _theL = sc.nextLine();
		System.out.print("Nhập năm xuất bản: ");
		String _namXB = sc.nextLine();
		int _fSize = listBook.size();
		Book newBook = new Book(_ma,_tuaS,_tacG,_theL,_namXB);
		listBook.add(newBook);
		int _lSize = listBook.size();
		if(_fSize < _lSize) {
			System.out.println("<<< Thêm sách thành công >>>");
		} else {
			System.out.println("<<< Thêm sách thất bại >>>");
		}
	}

	private static void printListBook(ArrayList<Book> listBook) {
		Comparator<Book> com = new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				return o1.getTheLoai().compareTo(o2.getTheLoai());
			}
		};
		System.out.println("|Tổng " + listBook.size() + "|");
		listBook.sort(com);
		for (Book book : listBook) {
			book.showInfo();
		}
	}

	private static void printMenu() {
		System.out.println("=========================================="
					+ "==============================================");
		System.out.println("1. Hiển thị danh sách.");
		System.out.println("2. Thêm một cuốn sách mới.");
		System.out.println("3. Xóa sách.");
		System.out.println("4. Tìm kiếm sách theo mã.");
		System.out.println("5. Tìm kiếm sách theo tên tác giả.");
		System.out.println("6. Tìm kiếm sách theo tựa sách.");
		System.out.println("0. Thoát.\n");
	}
}
