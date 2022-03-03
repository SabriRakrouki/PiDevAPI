package tn.esprit.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.logging.log4j.Logger;
import org.hibernate.engine.transaction.jta.platform.internal.WeblogicJtaPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import tn.esprit.entities.*;
import tn.esprit.repositories.CommentRepository;
import tn.esprit.repositories.NotificationRepository;
import tn.esprit.repositories.PostRepository;
import tn.esprit.repositories.UserRepository;



@Service
public class CommentServiceImpl implements ICommentService {
	

    @Autowired
    private CommentRepository CommentRepository;
    private PostRepository postRepository ;
    private UserRepository userRepository;
    private NotificationRepository notificationRepository;


    public CommentServiceImpl(CommentRepository commentRepository) {
		
		CommentRepository = commentRepository;
	}
	@Override
    public List<Comment> getAllComments() {
		//System.out.println(CommentRepository.findAll());
		return CommentRepository.findAll();
    }
    @Override
	public Comment getCommentById(int id) {
	    return CommentRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "entity not found"
                )
        );
    }


    @Override
    public Comment AddComment(Comment comment) {
    	//Post post =comment.getPost();
    	comment.setContent(comment.getContent());
    	comment.setDateComment(Calendar.getInstance().getTime());
    	//post.setComments((Set<Comment>)comment);
        //postRepository.save(post);
    	return CommentRepository.save(comment);
	
	}

    
    @Override
	public void saveComment(Comment comment) {

		boolean verif = false ;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
            		"./src/main/resources/dict_mots"));
            String line = reader.readLine();
            while (line != null && verif== false) {
                if (comment.getContent().contains(line))
                {
                    System.out.println("You are using bad words");
                    verif = true ;
                }
                else{
                	comment.setContent(comment.getContent());
                	comment.setDateComment(Calendar.getInstance().getTime());
                	
                	CommentRepository.save(comment);;
                }
                // read next line
                line = reader.readLine();
            }
            
            reader.close();
         
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void removeComment(int id) {
    	CommentRepository.deleteById(id);
    }
    @Override
    public Comment updateComment(int idComment,Comment comment) {
    	    	    Comment OldComment =CommentRepository.getById(idComment);
    	    	    OldComment = comment;
    	    		CommentRepository.save(OldComment);
    	    		return comment;
    	    	}


    
    //getcommentbypost
   /* @Override
	public List<Comment> findByPost(int id_post) {
		
		return CommentRepository.findByPost(id_post);
	}
	*/
    @Override
    public long count() {
        return this.CommentRepository.count();
    }
	
	
}



