package fa.training.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.entities.Khach;
import fa.training.main.HibernateUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class khachhangDao {
	public static void insertKhach(Khach khach) {
		Transaction tran = null;
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			tran = sessi.beginTransaction();
			sessi.persist(khach);
			tran.commit();
		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}

	public static List<Khach> displayKhach(int pagenumber) {
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			CriteriaBuilder cb = sessi.getCriteriaBuilder();
			CriteriaQuery<Khach> cr = cb.createQuery(Khach.class);
			Root<Khach> root = cr.from(Khach.class);
			cr.select(root);
			int firstResult = (pagenumber - 1) * 5;
			List<Khach> listMay = sessi.createQuery(cr).setFirstResult(firstResult).setMaxResults(5).getResultList();

			return listMay;

		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}
	public static List<Khach> displayKhach() {
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			CriteriaBuilder cb = sessi.getCriteriaBuilder();
			CriteriaQuery<Khach> cr = cb.createQuery(Khach.class);
			Root<Khach> root = cr.from(Khach.class);
			cr.select(root);
			List<Khach> listMay = sessi.createQuery(cr).setFirstResult(0).setMaxResults(5).getResultList();

			return listMay;

		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}

	public static List<Khach> displaytenKhach(String tenKH) {
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			CriteriaBuilder cb = sessi.getCriteriaBuilder();
			CriteriaQuery<Khach> cr = cb.createQuery(Khach.class);
			Root<Khach> root = cr.from(Khach.class);
			cr.select(root);
			cr.where(cb.like(root.get("tenKH"), "%" + tenKH + "%"));

			List<Khach> listMay = sessi.createQuery(cr).getResultList();
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
			Khach may = sessi.find(Khach.class, id);
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
