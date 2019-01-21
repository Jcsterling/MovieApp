package com.qa.blockbuster.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.blockbuster.Entities.DVD;

@Repository
public interface DVDRepository extends JpaRepository<DVD, Long> {

}
