package com.formation.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.ProfDao;
import com.formation.model.Prof;

@Transactional
@Repository
public class ProfDaoImpl implements ProfDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Prof> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Prof> crit = cb.createQuery(Prof.class);
		Root<Prof> r = crit.from(Prof.class);

		crit.select(r);

		return em.createQuery(crit).getResultList();
	}

	@Override
	public Prof save(Prof entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Prof entity) {
		Prof eMerged = em.merge(entity);
		em.remove(eMerged);

	}

	@Override
	public Prof findByPrimaryKey(Long id) {
		return em.find(Prof.class, id);
	}

	@Override
	public Prof update(Prof entity) {
		return em.merge(entity);
	}

}
