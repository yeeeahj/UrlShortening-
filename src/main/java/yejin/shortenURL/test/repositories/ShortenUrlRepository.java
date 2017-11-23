package yejin.shortenURL.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import yejin.shortenURL.test.domains.ShortenUrl;

/**
 * 
 * @author yeeeah_j
 *
 */
public interface ShortenUrlRepository extends JpaRepository<ShortenUrl, Long>{

}
