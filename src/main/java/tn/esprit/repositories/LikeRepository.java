package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Like;


@Repository
public interface LikeRepository extends JpaRepository<Like, Integer>{

}
