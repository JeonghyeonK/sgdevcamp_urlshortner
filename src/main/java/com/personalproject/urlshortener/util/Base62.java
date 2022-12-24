package com.personalproject.urlshortener.util;

import org.springframework.stereotype.Component;

@Component
public class Base62 {
	private static final int BASE = 62;
	private static final char[] CODEC = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};

	public String encode(int id) {
		StringBuilder encoded = new StringBuilder();

		while (id > 0) {
			encoded.append(CODEC[id % BASE]);
			id /= BASE;
		}

		return encoded.toString();
	}

	public int decode(String shorten) {
		int decoded = 0;
		int power = 1;

		for (int i = 0, n = shorten.length(); i < n; i++) {
			decoded += new String(CODEC).indexOf(shorten.charAt(i)) * power;
			power *= BASE;
		}

		return decoded;
	}
}
