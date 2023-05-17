package AObject;

public class Book {
	private String ma;
	private String tuaSach;
	private String tacGia;
	private String theLoai;
	private String namXB;

	public Book(String input) {
		String[] parts = input.split(";");
		this.ma = parts[0];
		this.tuaSach = parts[1];
		this.tacGia = parts[2];
		this.theLoai = parts[3];
		this.namXB = parts[4];
	}
	
	public Book(String ma, String tuaSach, String tacGia, String theLoai, String namXB) {
		this.ma = ma;
		this.tuaSach = tuaSach;
		this.tacGia = tacGia;
		this.theLoai = theLoai;
		this.namXB = namXB;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getTuaSach() {
		return tuaSach;
	}

	public void setTuaSach(String tuaSach) {
		this.tuaSach = tuaSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public String getNamXB() {
		return namXB;
	}

	public void setNamXB(String namXB) {
		this.namXB = namXB;
	}

	@Override
	public String toString() {
		String out = String.format("%s;%s;%s;%s;%s", ma,tuaSach,tacGia,theLoai,namXB);
		return out;
	}

	public void showInfo() {
		String maCell[] = {this.ma};
		String tuaSachCell[] = lineWarp(30, this.tuaSach);
		String tacGiaCell[] = lineWarp(20, this.tacGia);
		String theLoaiCell[] = lineWarp(15, this.theLoai);
		String namXBCell[] = {this.namXB};
		int _max = Math.max(tuaSachCell.length, tacGiaCell.length);
		int maxLength = Math.max(theLoaiCell.length, _max);
		// int max = a > b ? a > c ? a : c : b > c ? b : c;
		System.out.println("------------------------------------------------"
								+ "----------------------------------------");
		for (int i=0; i<maxLength; i++) {
			System.out.format("%-5s | %30s | %20s | %15s | %6s",
								getByIndex(maCell,i), 
								getByIndex(tuaSachCell, i), 
								getByIndex(tacGiaCell, i), 
								getByIndex(theLoaiCell, i), 
								getByIndex(namXBCell, i));
			System.out.println();
		}
	}

	// cover for showInfo()
	private String[] lineWarp(int width, String text) {
		StringBuilder sbd = new StringBuilder();
		while(text.length() > width) {
			int spaceIndex = text.indexOf(" ");
			int id = spaceIndex;
			while(spaceIndex < width && spaceIndex > 0) {
				id = spaceIndex;
				spaceIndex = text.indexOf(" ", spaceIndex + 1);
			}
			String sub = text.substring(0,id);
			sbd.append(sub);
			sbd.append(";");
			text = text.substring(id+1);
		}
		sbd.append(text);
		return sbd.toString().split(";");
	}
	
	// cover for showInfo()
	private static String getByIndex(String[] data, int i) {
		if(i<data.length) {
			return data[i];
		}
		return "";
	}
}
