package com.sampleblogger.service;

import java.util.List;

import com.sampleblogger.model.PostModelEntity;

public interface PostService {

    PostModelEntity createPost(PostModelEntity post);

    PostModelEntity updatePost(PostModelEntity post);

    List < PostModelEntity > getAllPost();

    PostModelEntity getPostById(long postId);

    PostModelEntity deletePost(long id);
}
