package NDVietBaiHoc;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class demosort {
	private String name;
	private int age;
	private double diem;
	private Date ngaythi;
	
	public demosort() {
		super();
	}
	public demosort(String name, int age, double diem, Date ngaythi) {
		this.name = name;
		this.age = age;
		this.diem = diem;
		this.ngaythi = ngaythi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	public Date getNgaythi() {
		return ngaythi;
	}

	public void setNgaythi(Date ngaythi) {
		this.ngaythi = ngaythi;
	}

	@Override
	public String toString() {
		return "demosort [getName()=" + getName() + ", getAge()=" + getAge() + ", getDiem()=" + getDiem()
				+ ", getNgaythi()=" + getNgaythi() + "]";
	}
public void createsort() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Nhap ten");
	this.name = sc.nextLine();
	System.out.println("Nhap Tuoi");
	this.age = Integer.parseInt(sc.nextLine());
	System.out.println("Nhap Dem");
	this.diem = Double.parseDouble(sc.nextLine());
	System.out.println("Nhap Ngay Thi");
	 String ngaythi1 = sc.nextLine();
	 SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	 try {
		this.ngaythi = (Date) format.parse(ngaythi1);
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
}
	public static void main(String[] agrs) {
               List<demosort> DS = new ArrayList<>();
               demosort a = new demosort();
               demosort a1 = new demosort();
               demosort a2 = new demosort();
               demosort a3 = new demosort();
               a.createsort();
               DS.add(a);
               a2.createsort();
               DS.add(a2);
               a3.createsort();
               DS.add(a3);
               a1.createsort();
               DS.add(a1);
               for (demosort demosort : DS) {
            	   System.out.println(demosort.toString());
			}
               Collections.sort(DS, Comparator.comparingDouble(demosort :: getDiem).reversed().thenComparingInt(demosort :: getAge));
//               Collections.sort(DS, new Comparator<demosort>() {
//
//				@Override
//				public int compare(demosort o1, demosort o2) {
//					 if((int) o1.getDiem() > o2.getDiem()) {
//						 return -1;
//					 }
//					
//					
//					return 1;
//					}   
//			});
              for (demosort demosort : DS) {
				System.out.println(demosort.toString());
			}
               
	}
}
