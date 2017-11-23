package yejin.shortenURL.test.services;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import yejin.shortenURL.test.domains.ShortenUrl;
import yejin.shortenURL.test.repositories.ShortenUrlRepository;
import yejin.shortenURL.test.services.interfaces.ShortenUrlInterface;
import yejin.shortenURL.test.utils.AntilogarithmConversion;
import yejin.shortenURL.test.utils.Validator;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * 
 * @author yeeeah_j
 *
 */
@Service("ShortUrlService")
public class ShortenUrlService implements ShortenUrlInterface{
	@Autowired
	private ShortenUrlRepository sur;

	@Autowired
	private CacheManager cacheManager;
	
	@Override
	@Cacheable(value="findMemberCache", key="#idx")
	public ShortenUrl getOriginUrl(long idx) {
		// TODO Auto-generated method stub
		return sur.getOne(idx);
	}

	@Override
	public String addOriginUrl(ShortenUrl OriginUrl) {

		String tempUrl = Validator.validate(OriginUrl.getOriginUrl());

		OriginUrl.setOriginUrl(tempUrl);
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
