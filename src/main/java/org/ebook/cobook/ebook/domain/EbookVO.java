package org.ebook.cobook.ebook.domain;

import java.util.Date;

public class EbookVO {

	private Integer ebook_no;
	private String title;
	private String author;
	private String publisher;
	private Date publishedDate;
	private String intro;
	private Integer price;
	private String category;
	private String cover;
	private String epub;
	private Date expiryDate;
	
	
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Integer getEbook_no() {
		return ebook_no;
	}
	public void setEbook_no(Integer ebook_no) {
		this.ebook_no = ebook_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getEpub() {
		return epub;
	}
	public void setEpub(String epub) {
		this.epub = epub;
	}
} 