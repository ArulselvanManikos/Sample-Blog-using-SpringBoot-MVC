package com.sampleblogger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampleblogger.model.PostModelEntity;
import com.sampleblogger.repositary.PostRepositary;

import jakarta.transaction.Transactional;
@Service
public class PostServiceImpl implements PostService {

		@Autowired
		private PostRepositary postRepo;
		
		
	@Override
	public PostModelEntity createPost(PostModelEntity post) {
		// TODO Auto-generated method stub
		return postRepo.saveAndFlush(post);
	}

	@Override
	public PostModelEntity updatePost(PostModelEntity post) {
		  Optional < PostModelEntity > postDb = this.postRepo.findById((int) post.getId());

	        if (postDb.isPresent()) {
	        	PostModelEntity postUpdate = postDb.get();
	            postUpdate.setId(post.getId());
	            postUpdate.setTitle(post.getTitle());
	            postUpdate.setDescription(post.getDescription());
	            postRepo.save(postUpdate);
	            return postUpdate;
	        } 
			return post;
	}

	@Override
	public List<PostModelEntity> getAllPost(){
		// TODO Auto-generated method stub
		
		return this.postRepo.findAll();
	}

	@Override
	public PostModelEntity getPostById(long postId) {
		// TODO Auto-generated method stub
		  Optional < PostModelEntity > postDb = this.postRepo.findById((int) postId);

	        if (postDb .isPresent()) {
	            return postDb.get();
	        } else {
	           return null;
	        }
	}

	@Override
	public PostModelEntity deletePost(long postId) {
		// TODO Auto-generated method stub
		 Optional < PostModelEntity > postDb = this.postRepo.findById((int)postId);

	        if (postDb.isPresent()) {
	            this.postRepo.delete(postDb.get());
	        }
			return null; 
	      
	}

}
