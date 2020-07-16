package org.sang.hanzy.book.dao;

import org.sang.hanzy.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJpaDao extends JpaRepository<Book,Integer> {
}
