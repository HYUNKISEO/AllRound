package com.lec.spring.repository.testinfo;

import com.lec.spring.domain.testinfo.Testinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestinfoRepository extends JpaRepository<Testinfo, Long> {
}
