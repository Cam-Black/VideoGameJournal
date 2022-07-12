package com.qa.videogamejournal.repo;

import com.qa.videogamejournal.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepo extends JpaRepository<Journal, Integer> {
}
