package com.hanains.jblog.vo;

public class CommentsVo {
	private Long no;
	private String content;
	private Long postNo;
	private String memberId;
	private String regDate;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getPostNo() {
		return postNo;
	}
	public void setPostNo(Long postNo) {
		this.postNo = postNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "CommentsVo [no=" + no + ", content=" + content + ", postNo=" + postNo + ", memberId=" + memberId
				+ ", regDate=" + regDate + "]";
	}
	
}
