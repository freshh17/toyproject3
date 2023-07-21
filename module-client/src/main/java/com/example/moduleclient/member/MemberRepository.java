package com.example.moduleclient.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, String> {
	Optional<Member> findByUsername(String username);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE Member m " +
		"SET m.memberRole = " +
		"CASE WHEN (SELECT COUNT(p.id) FROM Post p WHERE p.member = m AND p.status = 'SHOW') >= 10 " +
		"THEN 'BEST' ELSE 'GENERAL' END")
	int updateMemberRole();
}
