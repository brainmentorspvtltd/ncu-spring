package com.brainmentors.testengine.models.user;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserInfo { 
	private String userid;
	private String roleName;
	private String message;
	private String tokenId;
	
	private List<Right> rights;
	
	
	
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	public List<Right> getRights() {
		return rights;
	}
	public void setRights(List<Right> rights) {
		this.rights = rights;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", roleName=" + roleName + ", message=" + message + ", tokenId=" + tokenId
				+ ", rights=" + rights + "]";
	}
	

}
