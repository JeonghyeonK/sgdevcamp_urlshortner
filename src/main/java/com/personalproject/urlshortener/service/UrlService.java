package com.personalproject.urlshortener.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.personalproject.urlshortener.domain.Url;
import com.personalproject.urlshortener.domain.UrlRepository;
import com.personalproject.urlshortener.dto.UrlRequest;
import com.personalproject.urlshortener.util.Base62;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class UrlService {

	private final UrlRepository urlRepository;
	private final Base62 base62;

	public String shortenUrl(UrlRequest urlRequest) {
		int id = Optional.ofNullable(urlRepository.findByOriginUrl(urlRequest.getOriginUrl()))
			.map(Url::getId)
			.orElseGet(() -> save(urlRequest));

		return "http://localhost:8080/" + base62.encode(id);
	}

	public String restoreUrl(String shorten) {
		int id = base62.decode(shorten);

		return findById(id);
	}

	public String findById(int id) {
		Url url = urlRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("존재하지 않는 url 입니다."));

		return url.getOriginUrl();
	}

	public int save(UrlRequest urlRequest) {
		Url url = urlRequest.toUrl();
		urlRepository.save(url);

		return url.getId();
	}
}
