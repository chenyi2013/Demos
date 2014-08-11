package com.example.demos;

public class Content {

	private int image;
	private String title;

	public Content(int image, String title) {
		super();
		this.image = image;
		this.title = title;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Content [image=" + image + ", title=" + title + "]";
	}

}
