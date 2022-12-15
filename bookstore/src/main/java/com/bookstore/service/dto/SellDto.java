package com.bookstore.service.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * Data transfer object for sell
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellDto {

    //book id
    @ApiModelProperty(value = "Id of the book to be sold")
    private Integer bookId;

    //book name
    @ApiModelProperty(value = "Number of copies of the book to be sold.")
   
    private int quantity;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

