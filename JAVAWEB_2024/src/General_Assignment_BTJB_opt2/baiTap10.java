package General_Assignment_BTJB_opt2;

public class baiTap10 {
	
 private int diem;
 private int masv;
 private int tongdiem ;
 public int diemtrungbinh() {
	 return 0;
 }
 public int diemtrungbinh(int masv, int diem) {
	 return 0;
 }
 
 // Dưới đây là ví dụ về truyền tham chiếu trong Java
 // các đoạn chú thích này để thực hiện bài tập bài 11.
 public void baiTap10(int tongdiem, int diem, int masv ) {
	 this.diem = diem;
	 this.masv = masv;
	 this.tongdiem = tongdiem;
 }
 /**
  * đây là đoạn ví dụ về chú thích Javadoct . chúng ta có thể gắn tài liệu vào bằng @ .
  * @param diem
  * @param masv
  */
 public void baitap10(int diem, int masv) {
	 this.diem = 9;
	 this.masv = 22134;
 }
}
