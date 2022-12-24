package com.personalproject.urlshortener.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.*;

@Getter
@NoArgsConstructor
@Entity
public class Url {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@NotNull
	@Setter
	private String originUrl;


	public Url(int id, String originUrl) {
		this.id = id;
		this.originUrl = originUrl;
	}
}