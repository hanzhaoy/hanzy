package org.sang.hanzy.dao;

import org.sang.hanzy.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJpaDao extends JpaRepository<Book,Integer> {
}
