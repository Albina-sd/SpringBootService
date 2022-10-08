package com.springservice.repositories;

import com.springservice.models.Sweets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SweetsRepository  extends JpaRepository<Sweets, Long> {
}
