package com.formation.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.SalleDao;
import com.formation.model.Salle;

@Transactional
@Repository
public class SalleDaoImpl implements SalleDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Salle> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Salle> crit = cb.createQuery(Salle.class);
		Root<Salle> r = crit.from(Salle.class);

		crit.select(r);

		return em.createQuery(crit).getResultList();
	}

	@Override
	public Salle save(Salle entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Salle entity) {
		Salle eMerged = em.merge(entity);
		em.remove(eMerged);

	}

	@Override
	public Salle update(Salle entity) {
		return em.merge(entity);
	}

	@Override
	public Salle findByPrimaryKey(Long id) {
		return em.find(Salle.class, id);
	}

}
