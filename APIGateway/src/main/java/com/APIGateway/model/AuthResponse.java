package com.APIGateway.model;

import java.util.Collection;

public class AuthResponse {
	private String userId;
	private String accessToken;
	private String refreshToken;

	private long expireAt;

	private Collection<String> authorities;

	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthResponse(String userId, String accessToken, String refreshToken, long expireAt,
			Collection<String> authorities) {
		super();
		this.userId = userId;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.expireAt = expireAt;
		this.authorities = authorities;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public long getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(long expireAt) {
		this.expireAt = expireAt;
	}

	public Collection<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<String> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "AuthResponse [userId=" + userId + ", accessToken=" + accessToken + ", refreshToken=" + refreshToken
				+ ", expireAt=" + expireAt + ", authorities=" + authorities + "]";
	}

}