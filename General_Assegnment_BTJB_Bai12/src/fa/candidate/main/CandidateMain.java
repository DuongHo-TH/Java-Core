package fa.candidate.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.candidate.enitities.Candidate;
import fa.candidate.sevices.CandidateSevices;

public class CandidateMain {
	public static void main(String[] agrs) throws SQLException {
		Scanner sc = new Scanner(System.in);
		List<Candidate> Candi = new ArrayList<>();
		CandidateSevices sevisces = new CandidateSevices(Candi);
		int chon = 0;
		do {
			System.out.println("========= Chương Trình Quản Lý Ứng Viên FPT =========");
			System.out.println("Nhập Số Để Thao Tác Với Chương Trình Theo Menu Bên Dưới");
			System.out.println("1, Thêm Ứng Viên Expericence vào Database");
			System.out.println("2, Thêm Ứng Viên Fresher vào Database");
			System.out.println("3, Thêm Ứng Viên Intern vào Database");
			System.out.println("4, Update Thông Tin Của Ứng Viên, Theo CandidateID");
			System.out.println("5, Hiểm Thị Tất Cả Tên Các Ứng Viên");
			System.out.println("6, Hiển Thị Danh Sách Ứng Viên");
			System.out.println("7, Hiển Thị Các Ứng Viên Loại Bỏ ID Trùng Lặp");
			System.out.println("8, Hiểm Thị Các Ứng Viên Và sắp Xếp Tăng Dần Theo typer, Giảm Dần Theo BirtDay");
			System.out.println("9, Kết Thúc Chương Trình");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: {
				sevisces.createExperience();
				break;
			}
			case 2: {
				sevisces.createFresher();
				break;
			}
			case 3: {
				sevisces.createIntern();
				break;
			}
			case 4: {
				sevisces.updateCandidate();
				break;
			}
			case 5: {
				sevisces.selectCandidate();
				break;
			}
			case 6: {
				sevisces.showinfoExper();
				sevisces.showinfoFres();
				sevisces.showinfoIntern();
				break;
			}
			case 7: {
				sevisces.showMapExper();
				sevisces.showMapFres();
				sevisces.showMapIntern();
				break;
			}
			case 8: {
				sevisces.displayall();
			}
			}

		} while (chon < 9);

	}
}
