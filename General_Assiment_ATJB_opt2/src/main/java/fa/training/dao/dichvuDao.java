package fa.training.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.entities.DichVu;
import fa.training.main.HibernateUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class dichvuDao {
	public static void insertDichVu(DichVu dv) {
		Transaction tran = null;
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			tran = sessi.beginTransaction();
			sessi.persist(dv);
			tran.commit();
		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}

	public static List<DichVu> displayKhach(int pagenumber) {
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			CriteriaBuilder cb = sessi.getCriteriaBuilder();
			CriteriaQuery<DichVu> cr = cb.createQuery(DichVu.class);
			Root<DichVu> root = cr.from(DichVu.class);
			cr.select(root);
			int firstResult = (pagenumber - 1) * 5;
			List<DichVu> listMay = sessi.createQuery(cr).setFirstResult(firstResult).setMaxResults(5).getResultList();

			return listMay;

		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}
	public static List<DichVu> displayKhach() {
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			CriteriaBuilder cb = sessi.getCriteriaBuilder();
			CriteriaQuery<DichVu> cr = cb.createQuery(DichVu.class);
			Root<DichVu> root = cr.from(DichVu.class);
			cr.select(root);
			List<DichVu> listMay = sessi.createQuery(cr).setFirstResult(0).setMaxResults(5).getResultList();

			return listMay;

		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}

	public static List<DichVu> displaytenKhach(String tenKH) {
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			CriteriaBuilder cb = sessi.getCriteriaBuilder();
			CriteriaQuery<DichVu> cr = cb.createQuery(DichVu.class);
			Root<DichVu> root = cr.from(DichVu.class);
			cr.select(root);
			cr.where(cb.like(root.get("tendv"), "%" + tenKH + "%"));

			List<DichVu> listMay = sessi.createQuery(cr).getResultList();
			return listMay;

		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}

	public static void deleteKhachByID(int id) {
		Transaction tran = null;
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			DichVu may = sessi.find(DichVu.class, id);
			if (may != null) {
				sessi.remove(may);
			}
			tran = sessi.beginTransaction();
			tran.commit();
		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}

	}
}
