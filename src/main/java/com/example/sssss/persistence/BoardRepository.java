package com.example.sssss.persistence;

import com.example.sssss.domain.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
