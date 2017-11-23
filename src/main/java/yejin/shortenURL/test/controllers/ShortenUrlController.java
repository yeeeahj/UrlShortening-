package yejin.shortenURL.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import yejin.shortenURL.test.controllers.forms.AddShortenUrlForm;
import yejin.shortenURL.test.controllers.responses.DefaultResponse;
import yejin.shortenURL.test.controllers.responses.Data.ShortenUrlResponseData;
import yejin.shortenURL.test.domains.ShortenUrl;
import yejin.shortenURL.test.services.ShortenUrlService;

/**
 * @author yeeeah_j
*/
@RestController
@EnableCaching
@RequestMapping("shortenUrl")
@Api
public class ShortenUrlController {
	
	@Autowired
	private ShortenUrlService shortenUrlService;
	
	/**
	 * Methods to add shortenUrl.
	 * @param asuf
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<DefaultResponse> addShortenUrl(@RequestBody final AddShortenUrlForm asuf){

		System.out.println("addshorturlr");

		if(asuf.getOriginUrl() == null) {
			throw new RuntimeException();
		}

		System.out.println(asuf.getOriginUrl());
		ShortenUrl shortenUrl = new ShortenUrl(asuf.getOriginUrl());
		ShortenUrlResponseData shortenUrlResponseData = new ShortenUrlResponseData();
		shortenUrlResponseData.setShortIdx(shortenUrlService.addOriginUrl(shortenUrl));
		
		DefaultResponse dr = new DefaultResponse(shortenUrlResponseData);
		return new ResponseEntity<>(dr, HttpStatus.OK);
	}
	
	@GetMapping("/{idx}")
	public String getOriginUrl(@PathVariable("idx") final long idx){
		ShortenUrl shortenUrl = shortenUrlService.getOriginUrl(idx);
		if(shortenUrl == null){

		}
		
		return "redirect:"+shortenUrl.getOriginUrl();
	}
	
}
