package yejin.shortenURL.test.services.interfaces;

import yejin.shortenURL.test.domains.ShortenUrl;
/**
 * 
 * @author yeeeah_j
 *
 */
public interface ShortenUrlInterface {
	public ShortenUrl getOriginUrl(final long idx);
	
	public String addOriginUrl(final ShortenUrl OriginUrl);
	
	public void deleteOriginUrl(final long idx);
		
	//TODO: extend to list?

}
