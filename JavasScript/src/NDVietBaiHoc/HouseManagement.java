package NDVietBaiHoc;

public class HouseManagement {
	public static void main(String[] args) {
		House house1 = new House("Duytan", "Blue", 1000);
		House house2 = new House("Tonthatthuyet", "Green", 1200);
		System.out.println(house1.address);
		System.out.println(house2.address + "\t" + house2.color + 
		"\t" + house2.are);
		}


}
