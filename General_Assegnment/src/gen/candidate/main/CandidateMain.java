package gen.candidate.main;

import java.sql.SQLException;
import java.util.Scanner;

import gen.candidate.sevices.CandidateSevices;

public class CandidateMain {
	public static void main(String[] agrs) throws SQLException {
		Scanner sc = new Scanner(System.in);
		CandidateSevices sevisces = new CandidateSevices();
		int chon = 0;
		do {
			System.out.println("========= Chương Trình Quản Lý Ứng Viên FPT =========");
			System.out.println("Nhập Số Để Thao Tác Với Chương Trình Theo Menu Bên Dưới");
			System.out.println("1, Thêm Ứng Viên  vào Database");
			System.out.println("2, Update Thông Tin Của Ứng Viên, Theo CandidateID");
			System.out.println("3, Insert Thông Tin Ứng Viên CONCUAR_UDATE");
			System.out.println("4, Hiểm Thị Tên Tất Cả  Các Ứng Viên");
			System.out.println("5, Hiển Thị Danh Sách Ứng Viên");
			System.out.println("6, Hiểm Thị Các Ứng Viên Và sắp Xếp Tăng Dần Theo typer, Giảm Dần Theo BirtDay");
			System.out.println("7, Kết Thúc Chương Trình");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: {
				sevisces.insertCandidate();
				;
				break;
			}
			case 2: {
				sevisces.concurUpdate();
				break;
			}
			case 3: {
				sevisces.concurInsert();
				break;
			}
			case 4: {
				sevisces.shownameCandidate();
				break;
			}
			case 5: {
				sevisces.showinforCandidate();
				break;
			}
			case 6: {
//				sevisces.sortlistCandidate();
				CandidateSevices.Selectinfor(sc);

				break;
			}

			}

		} while (chon < 7);

	}

}
