package nhom4.models;

import java.time.LocalDateTime;

public class Content {
	private int id;
	private String Title;
	private String Brief;
	private String Content;
	private LocalDateTime CreateDate;
	private LocalDateTime UpdateTime;
	private String Sort;
	private int AuthorId;

	public Content() {
	}

	public Content(String title, String brief, String content, int authorid) {
		super();
		this.Title = title;
		this.Brief = brief;
		this.Content = content;
		this.AuthorId = authorid;
	}

	public Content(int id, String title, String brief, String content, int authorid) {
		super();
		this.id = id;
		this.Title = title;
		this.Brief = brief;
		this.Content = content;
		this.AuthorId = authorid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getBrief() {
		return Brief;
	}

	public void setBrief(String brief) {
		Brief = brief;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public LocalDateTime getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		CreateDate = createDate;
	}

	public LocalDateTime getUpdateTime() {
		return UpdateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		UpdateTime = updateTime;
	}

	public String getSort() {
		return Sort;
	}

	public void setSort(String sort) {
		Sort = sort;
	}

	public int getAuthorId() {
		return AuthorId;
	}

	public void setAuthorId(int authorId) {
		AuthorId = authorId;
	}

}
