package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Flashcard;
import com.revature.util.ConnectionUtil;

public class FlashcardDAOImpl implements FlashcardDAO {
	
	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	@Override
	public Flashcard getById(int id) {
		Flashcard f = null;
		try (Session s = sf.openSession()) {
			f = s.get(Flashcard.class, id);
			//System.out.println(s.getStatistics());
			//f.setAnswer("Merlin");
			
		}
		
		return f;
		
	}

	@Override
	public List<Flashcard> getAll() {
		List<Flashcard> flashcardList = new ArrayList<>();
		// use a Query
		try (Session s = sf.openSession()) {
			flashcardList = s.createQuery("from Flashcard").getResultList();
			System.out.println(s.getStatistics());
			
		}
		return flashcardList;
	}

	@Override
	public boolean addFlashcard(Flashcard flashcard) {
		boolean added = false;
		try (Session s = sf.openSession()) {
			// autocommit is OFF in Hibernate
			Transaction tx = s.beginTransaction();
			s.persist(flashcard);
			tx.commit();
			added=true;
			System.out.println(s.getStatistics());
			
		}
		
		return added;
	}

	@Override
	public boolean updateFlashcard(Flashcard flashcard) {
		boolean updated = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.update(flashcard);
			tx.commit();
			updated=true;
			
		}
		
		return updated;
		
	}

	@Override
	public boolean delete(Flashcard flashcard) {
		boolean deleted = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(flashcard);
			tx.commit();
			deleted=true;
			
		}
		
		return deleted;
	}

	@Override
    public List<Flashcard> getByQuestion(String question) {
        List<Flashcard> flashcardList = new ArrayList<Flashcard>();
        // try with resources on an AutoCloseable resource, closes at thend of control
        try (Session s = sf.openSession()) {
            // autocommit is OFF in Hibernate
            String queryStr = "from Flashcard Where FLASHCARD_QUESTION = :que";
            Query<Flashcard> query = s.createQuery(queryStr);
            query.setParameter("que", question);
            flashcardList = query.list();
        }
        return flashcardList;
    }

}
