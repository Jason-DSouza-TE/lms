package com.te.lms.dao.mentor;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.entity.mentor.MockDetails;

public interface MentorDao  extends JpaRepository<MockDetails, Integer>{

}
