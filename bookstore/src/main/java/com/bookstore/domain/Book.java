package com.bookstore.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bookstore.constants.Category;


/**
 * Representation of Book Table
 **/
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    /**
     * Unique Book Number given by company.
     * Eg: ISBN number
     */
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	/**
     * title of the book
     */
   
    private String title;

    /**
     * author of the book
     */
    private String author;

    /**
     * category of the book
     * Eg: Novel, Fiction, etc
     */
    private Category category;

    /**
     * price of the book
     */
    
    private float price;

    /**
     * Amount of book available
     */
  
    private int totalCount;

    /**
     * Total copies of book sold
     */
    
    private int sold;
    
    private String imageURL;

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
}

