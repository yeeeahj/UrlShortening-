package yejin.shortenURL.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yejin.shortenURL.test.domains.ShortenUrl;
import yejin.shortenURL.test.repositories.ShortenUrlRepository;
import yejin.shortenURL.test.services.interfaces.ShortenUrlInterface;
import yejin.shortenURL.test.utils.AntilogarithmConversion;

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
	public String addOriginUrl(ShortenUrl OriginUrl) {
		// TODO Auto-generated method stub
		ShortenUrl su =sur.save(OriginUrl);
		
		return AntilogarithmConversion.to62(su.getIdx());
		
	}

	@Override
	public void deleteOriginUrl(long idx) {
		// TODO Auto-generated method stub
		sur.delete(idx);
	}


	
}
