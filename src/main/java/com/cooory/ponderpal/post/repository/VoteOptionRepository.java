package com.cooory.ponderpal.post.repository;

import com.cooory.ponderpal.post.domain.VoteOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteOptionRepository extends JpaRepository<VoteOption, Integer> {
    List<VoteOption> findAllByPostIdEquals(int postId);
}
