package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Flashcard;
import com.revature.beans.Topic;
import com.revature.util.ConnectionUtil;

public class TopicDAOImpl implements TopicDAO {
	
	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	@Override
	public boolean addTopic(Topic topic) {
		boolean added = false;
		try (Session s = sf.openSession()) {
			// autocommit is OFF in Hibernate
			Transaction tx = s.beginTransaction();
			s.persist(topic);
			tx.commit();
			added=true;
			System.out.println(s.getStatistics());
			
		}
		
		return added;
		
	}

	@Override
	public List<Topic> getBySubject(String subject) {
        List<Topic> topicList = new ArrayList<Topic>();
        try (Session s = sf.openSession()) {
            // autocommit is OFF in Hibernate
            String queryStr = "from TOPIC Where SUBJECT = :que";
            Query<Topic> query = s.createQuery(queryStr);
            query.setParameter("que", subject);
            topicList = query.list();
        }
        return topicList;
	}



}
