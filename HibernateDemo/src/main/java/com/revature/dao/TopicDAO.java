package com.revature.dao;

import java.util.List;

import com.revature.beans.Topic;

public interface TopicDAO {
	
	public boolean addTopic(Topic topic);
	public List<Topic> getBySubject(String subject);
}
