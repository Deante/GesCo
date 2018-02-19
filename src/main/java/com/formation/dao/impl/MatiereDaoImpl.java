package com.formation.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.formation.dao.MatiereDao;
import com.formation.model.Matiere;

@Repository
@Transactional
public class MatiereDaoImpl implements MatiereDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public Matiere findByPrimaryKey(Long id) {
		return em.find(Matiere.class, id);
	}

	@Override
	public List<Matiere> findAll() {
		String querystring = "SELECT c FROM matiere c ";
		Query query = em.createQuery(querystring);
		List<Matiere> list = query.getResultList();
		return list;
	}

	@Override
	public Matiere save(Matiere entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Matiere entity) {
		Matiere eMerged = em.merge(entity);
		em.remove(eMerged);
	}

	@Override
	public Matiere update(Matiere entity) {
		return em.merge(entity);
	}

}
