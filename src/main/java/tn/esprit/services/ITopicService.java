package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Topic;

public interface ITopicService {

	Topic getTopicById(int id);

	List<Topic> getAllTopics();

	Topic AddTopic(Topic Topic);

	void removeTopic(int id);


	Topic updateTopic(int idTopic, Topic Topic);

	long count();

}
