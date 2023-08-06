package com.sampleblogger.repositary;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sampleblogger.model.PostModelEntity;

public interface PostRepositary extends JpaRepository<PostModelEntity,Integer>{

}







