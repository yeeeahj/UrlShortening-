package yejin.shortenURL.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yejin.shortenURL.test.domains.ShortenUrl;
import yejin.shortenURL.test.repositories.ShortenUrlRepository;
import yejin.shortenURL.test.services.interfaces.ShortenUrlInterface;

/**
 * 
 * @author yeeeah_j
 *
 */
@Service("ShortUrlService")
public class ShortenUrlService implements ShortenUrlInterface{
	@Autowired
	private ShortenUrlRepository sur;
	
	@Override
	public ShortenUrl getOriginUrl(long idx) {
		// TODO Auto-generated method stub
		return sur.getOne(idx);
	}

	@Override
	public void addOriginUrl(ShortenUrl OriginUrl) {
		// TODO Auto-generated method stub
		sur.save(OriginUrl);
	}

	@Override
	public void deleteOriginUrl(long idx) {
		// TODO Auto-generated method stub
		sur.delete(idx);
	}


	
}
