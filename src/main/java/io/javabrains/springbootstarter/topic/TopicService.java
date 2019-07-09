package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Java Framework", "SF Desc"),
			new Topic("rails", "Ruby Framework", "Rails Desc"),
			new Topic("django", "Python Framework", "Django Desc"),
			new Topic("phoenix", "Elixir Framework", "Django Desc")
			));
	
	public List<Topic> getAllTopics() {
//		return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
		
	}
	
	public Topic getTopic(String id) {
//		iterate over a list and run a map on the id
		return topicRepository.findOne(id);
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public Topic updateTopic(Topic topic, String id) {
		topicRepository.save(topic);
		return topicRepository.findOne(id);
	}
	
	
	public void deleteTopic(String id) {
		topicRepository.delete(id);
	}

}
