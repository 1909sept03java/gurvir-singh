package com.revature;

import com.revature.beans.Topic;
import com.revature.dao.FlashcardDAO;
import com.revature.dao.FlashcardDAOImpl;
import com.revature.dao.TopicDAO;
import com.revature.dao.TopicDAOImpl;

public class Driver {
	
	public static void main(String[] args) {
		//System.out.println(ConnectionUtil.getSessionFactory());
		//SessionFactory sf = ConnectionUtil.getSessionFactory();
		//Session s = sf.openSession();
		//System.out.println(s.getStatistics());
		//s.close();
		//FlashcardDAO fd = new FlashcardDAOImpl();
		//for(Flashcard f: fd.getAll()) {
		//	System.out.println(f);
		//}
		// all of these Flashcards are not detached - they are no longer associated with an open session
		//System.out.println(fd.getById(1));
		//fd.updateFlashcard(new Flashcard(1, "What is the answer to life, the universe, and everything?", "Pizza"));
		//fd.delete(fd.getById(21));
		//TopicDAO td = new TopicDAOImpl();
		//td.addTopic(new Topic("Math"));
		//Topic b = td.getBySubject("Math");
		
		
		
	}

}
