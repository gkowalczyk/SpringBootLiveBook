package com.example.springjpa.onetomany;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ZooRepo extends CrudRepository<Zoo, Long> {
}
