package nhom4.models;

import java.time.LocalDateTime;

public class Content {
	protected int id;
	protected String title;
	protected String brief;
	protected String content;
	protected String createdate;
	protected LocalDateTime updatetime;
	protected String sort;
	protected int authorid;

	public Content() {
	}
	public Content(int id, String title, String brief, String content, String createdate, int authorid) {
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createdate= createdate;
		this.authorid = authorid;
	}

	public Content(String title, String brief, String content, int authorid) {
		super();
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.authorid = authorid;
	}

	public Content(int id, String title, String brief, String content, int authorid) {
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.authorid = authorid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateDate() {
		return this.createdate;
	}

	public void setCreateDate(String createDate) {
		this.createdate = createDate;
	}

	public LocalDateTime getUpdateTime() {
		return updatetime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		updatetime = updateTime;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getAuthorId() {
		return authorid;
	}

	public void setAuthorId(int authorId) {
		authorid = authorId;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", title=" + title + ", brief=" + brief + ", createdate=" + createdate + "]";
	}
	

}
