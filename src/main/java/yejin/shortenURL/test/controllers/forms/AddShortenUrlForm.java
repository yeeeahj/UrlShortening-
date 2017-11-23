package yejin.shortenURL.test.controllers.forms;
/**
 * 
 * @author yeeeah_j
 *
 */
public class AddShortenUrlForm {
	
	private String orginUrl;
	
	/**
	 * Constructor.
	 */
	public AddShortenUrlForm(){
		
	}
	public AddShortenUrlForm(String originUrl){


		this.orginUrl = originUrl;
	}
	
	public String getOrginUrl() {
		return orginUrl;
	}
	public void setOrginUrl(String orginUrl) {
		this.orginUrl = orginUrl;
	}
	
	

}
