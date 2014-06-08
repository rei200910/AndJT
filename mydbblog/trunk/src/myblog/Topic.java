package myblog;
import java.util.Date;

public class Topic {
	/** 編號 */
	private int id;	
	/** 標題 */
	private String title;
	/** 內容 */
	private String content;
	/** 投稿日期 */
	private Date postDate;
	
	public String toString() {
		return super.toString()+",id=" + id + ", title=" + title + ", content=" + content
				+ ", postDate=" + postDate ;
	}

	/** 簡單的getter,setter */
	
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	
	
	
	
	
	
}
