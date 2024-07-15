package qluvFPT;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Candidate_Main {
 public static void main(String[]agrs) {
	 List<Candidate> listCandi = new ArrayList<Candidate>();
	 CandidateServices ex = new CandidateServices(listCandi);
	 try {
		ex.createExperience();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }
}
