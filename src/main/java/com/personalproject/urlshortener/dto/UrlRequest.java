package com.personalproject.urlshortener.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import com.personalproject.urlshortener.domain.Url;

import lombok.Getter;

@Getter
public class UrlRequest {
	@URL
	@NotBlank
	private String originUrl;

	public Url toUrl() {
		Url url = new Url();
		url.setOriginUrl(originUrl);
		return url;
	}
}
