package com.edu.vo;

public class NoticeVO {
	private int noticeId;
	private String noticeTitle;
	private String noticeContent;
	private String noticeWdate;
	private int noticeHit;

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeWdate() {
		return noticeWdate;
	}

	public void setNoticeWdate(String noticeWdate) {
		this.noticeWdate = noticeWdate;
	}

	public int getNoticeHit() {
		return noticeHit;
	}

	public void setNoticeHit(int noticeHit) {
		this.noticeHit = noticeHit;
	}

	@Override
	public String toString() {
		return "NoticeVO [noticeId=" + noticeId + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeWdate=" + noticeWdate + ", noticeHit=" + noticeHit + "]";
	}

}
