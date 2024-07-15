package fa.training.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.entities.May;
import fa.training.main.HibernateUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class mayDao {
	public static void insertMay(May may) {
		Transaction tran = null;
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			tran = sessi.beginTransaction();
			sessi.persist(may);
			tran.commit();
		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}

	public static List<May> displayMay(int pagenumber) {
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			CriteriaBuilder cb = sessi.getCriteriaBuilder();
			CriteriaQuery<May> cr = cb.createQuery(May.class);
			Root<May> root = cr.from(May.class);
			cr.select(root);
			int firstResult = (pagenumber - 1) * 5;
			List<May> listMay = sessi.createQuery(cr).setFirstResult(firstResult).setMaxResults(5).getResultList();

			return listMay;

		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}
	public static List<May> displayMay() {
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			CriteriaBuilder cb = sessi.getCriteriaBuilder();
			CriteriaQuery<May> cr = cb.createQuery(May.class);
			Root<May> root = cr.from(May.class);
			cr.select(root);
			List<May> listMay = sessi.createQuery(cr).setFirstResult(0).setMaxResults(5).getResultList();

			return listMay;

		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}

	public static List<May> displaytenMay(Object may) {
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			CriteriaBuilder cb = sessi.getCriteriaBuilder();
			CriteriaQuery<May> cr = cb.createQuery(May.class);
			Root<May> root = cr.from(May.class);
			cr.select(root);
			cr.where(cb.like(root.get("trangthai"), "%" + may + "%"));

			List<May> listMay = sessi.createQuery(cr).getResultList();
			return listMay;

		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}

	public static void deletemayByID(int id) {
		Transaction tran = null;
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			May may = sessi.find(May.class, id);
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
