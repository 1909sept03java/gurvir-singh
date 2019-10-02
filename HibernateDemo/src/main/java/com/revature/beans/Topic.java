package com.revature.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table(name="TOPIC")
public class Topic {
	
	@Id // indicates that this is the primary key! ("persistent topicIdentity" of a Flashcard)
	// generate values for this PK
	@GeneratedValue(strategy=GenerationType.AUTO, generator="topicSequence")
	@SequenceGenerator(allocationSize=1, name="topicSequence", sequenceName="SQ_TOPIC_PK")
	@Column(name="TOPIC_ID")
	private int topicId;
	
	private String subject;
	
    @OneToMany(targetEntity=Flashcard.class)
    private Set flashcard;
	
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Topic(int topicId, String subject) {
		super();
		this.topicId = topicId;
		this.subject = subject;
	}

	public Topic(String subject) {
		super();
		this.subject = subject;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public Set getFlashcard() {
		return flashcard;
	}

	public void setFlashcard(Set flashcard) {
		this.flashcard = flashcard;
	}
	
	

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", subject=" + subject + ", flashcard=" + flashcard + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + topicId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (topicId != other.topicId)
			return false;
		return true;
	}
	
	
	
	

}
