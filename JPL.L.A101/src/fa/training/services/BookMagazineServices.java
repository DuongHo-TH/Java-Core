package fa.training.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import fa.training.entities.*;
import fa.training.utils.Validator;

public class BookMagazineServices {
	public List<Publication> listPub = new ArrayList<Publication>();

	public BookMagazineServices(List<Publication> pub) {
		this.listPub = pub;
	}

	Scanner sc = new Scanner(System.in);

	public void createBook() {
		Book book1 = new Book();
		System.out.println("Nhập Tên Nhà Xuất Bản Book : ");
		book1.setPublisher(sc.nextLine());
		System.out.println("Nhập Năm Xuất Bản Sách");
		book1.setPublicationYear(Integer.parseInt(sc.nextLine()));
		do {
			System.out.println("Nhập Thời Gian Xuất Bản Sách");
			String inputdate = sc.nextLine();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				book1.setPublicationDate(dateFormat.parse(inputdate));
				break;
			} catch (ParseException e) {
				System.out.println("Ngày Không Hợp Lệ, Vui Lòng Nhập Lại theo định dạng dd/MM/yyyy.");
			}
		} while (true);

		do {
			System.out.println("Nhập Số Sách");
			String insbook = sc.nextLine();
			if (insbook.matches(Validator.Check_isbn)) {
				book1.setIsbn(insbook);
				break;
			} else {
				System.out.println("Isbn Sách không hợp lệ vui lòng nhập lại");
			}

		} while (true);
		Set<String> authorList = new LinkedHashSet<String>();
		while (true) {
			System.out.println("Nhập Tên Tác Giả Của Sách");
			String authorbook1 = sc.nextLine();
			authorList.add(authorbook1);
			System.out.println("Bạn Có Muốn Nhập Thêm Tên Tách Giả : Y/N");
			String chon = sc.nextLine();
			if (chon.equalsIgnoreCase("n")) {
				break;
			}
		}
		book1.setAuthor(authorList);
		System.out.println("Nhập Nơi Sản Xuất:");
		book1.setPublicationPlace(sc.nextLine());
		this.listPub.add(book1);
	}

	public void createMagazine() {
		Magazine maga = new Magazine();
		System.out.println("Nhập Tên Nhà Xuất Bản Magazine : ");
		maga.setPublisher(sc.nextLine());
		System.out.println("Nhập Năm Xuất Bản :");
		maga.setPublicationYear(Integer.parseInt(sc.nextLine()));
		do {
			System.out.println("Nhập Thời Gian Xuất Bản Sách");
			String inputdate = sc.nextLine();

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				maga.setPublicationDate(dateFormat.parse(inputdate));
				break;
			} catch (ParseException e) {
				System.out.println("Ngày Không Hợp Lệ, Vui Lòng Nhập Lại theo định dạng dd/MM/yyyy.");
			}
		} while (true);
		System.out.println("Nhập Tên Tác Giả : ");
		maga.setAuthor(sc.nextLine());
		System.out.println("Nhập Số Tập : ");
		maga.setVolumn(Integer.parseInt(sc.nextLine()));
		System.out.println("Nhập Số Lần Tái Bản : ");
		maga.setEdition(Integer.parseInt(sc.nextLine()));
		this.listPub.add(maga);
	}

	public void display() {
		System.out.println("Tất Cả Sách Và Tạp Trí Có Cùng Năm Xuất Bản");
		Collections.sort(listPub,
				Comparator.comparing(Publication::getPublisher).thenComparingInt(Publication::getPublicationYear));
		for (Publication publication : listPub) {
			System.out.println(publication.toString());
		}

	}

	public void setAuthorbook() {
		System.out.println("Nhập isbn Sách muốn thêm tác giả");
		String namebook = sc.nextLine();

		for (Publication publication : listPub) {
			if (publication instanceof Book && ((Book) publication).getIsbn().equalsIgnoreCase(namebook)) {
				System.out.println("Nhập tên tác giả muốn thêm vào");
				String nameauthor = sc.nextLine();
				for (String publication2 : ((Book) publication).getAuthor()) {

					if (publication2.equals(nameauthor)) {
						System.out.println("Tác giả đã tồn tại");
						break;
					} else {
						((Book) publication).getAuthor().add(nameauthor);
						System.out.println("Thêm thành công");
						break;
					}
				}
			} else {
				System.out.println("Sách Không Có Trong Danh Sách");

			}
		}
	}

	public void searchMaga() {
		List<Magazine> maga = new ArrayList<Magazine>();
		for (Publication publication : listPub) {
			if (publication instanceof Magazine) {
				maga.add((Magazine) publication);
			}
		}
		Collections.sort(maga, Comparator.comparingInt(Magazine::getVolumn1));
//		
//		Collections.sort(maga, new Comparator<Magazine>(){
//			public int compare(Magazine s1, Magazine s2) {
//				if (s1.getVolumn1() > s2.getVolumn1()) {
//					return -1;
//				} else {
//					return 1;
//				}
//			}
//		}
//		);
		for (int i = 0; i < 10 && i < maga.size(); i++) {
			System.out.println(maga.get(i).toString());
		}
	}

	public void searchBook() {
		System.out.println(" Hãy Chọn Các Trường Muốn Tìm Kiếm Theo Hướng Dẫn : ");
		System.out.println("1. Tìm kiếm theo isbn");
		System.out.println("2. Tìm Kiếm Theo Tác Giả");
		System.out.println("3. Tìm Kiếm Theo nhà Xuất Bản");
		int menu = Integer.parseInt(sc.nextLine());

		switch (menu) {
		case 1: {
			System.out.println("Nhập mã số sách cần tìm kiếm: ");
			List<Book> listsearch = new ArrayList<>();
			String search = sc.nextLine();
			for (Publication publication : listPub) {
				if (publication instanceof Book && ((Book) publication).getIsbn().equalsIgnoreCase(search)) {
					listsearch.add((Book) publication);
					Collections.sort(listsearch,
							Comparator.comparing(Book::getIsbn).thenComparing(Book::getPublicationDate));
					for (Book book : listsearch) {
						System.out.println(book.toString());
					}
				} else {
					System.out.println("Không Có sách phù hợp trong danh sách");
				}
			}
			break;
		}
		case 2: {
			System.out.println("Nhập tên Tác Giả Cần Tìm Kiếm: ");
			String search = sc.nextLine();
			List<Book> listsearch = new ArrayList<>();
			for (Publication publication : listPub) {
				if (publication instanceof Book) {
					for (String author : ((Book) publication).getAuthor()) {
						if (author.equalsIgnoreCase(search)) {
							listsearch.add((Book) publication);
							Collections.sort(listsearch,
									Comparator.comparing(Book::getIsbn).thenComparing(Book::getPublicationDate));
							for (Book book : listsearch) {
								System.out.println(book.toString());
							}

						} else {
							System.out.println("Không Có sách phù hợp trong danh sách");
						}
					}
				}
			}
			break;
		}
		case 3: {
			List<Book> listsearch = new ArrayList<>();
			System.out.println("Nhập Nhà Xuất Bản sách cần tìm kiếm: ");
			String search = sc.nextLine();
			for (Publication publication2 : listPub) {
				if (publication2 instanceof Book && publication2.getPublisher().equalsIgnoreCase(search)) {
					listsearch.add((Book) publication2);
					Collections.sort(listsearch,
							Comparator.comparing(Book::getIsbn).thenComparing(Book::getPublicationDate));
					for (Book book : listsearch) {
						System.out.println(book.toString());
					}
				} else {
					System.out.println("Không Có sách phù hợp trong danh sách");
				}
			}

			break;
		}
		default:
			break;
		}
	}

}
