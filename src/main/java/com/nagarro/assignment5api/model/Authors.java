package com.nagarro.assignment5api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="authors")
public class Authors {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long ids;
		
		@Column
		private String author;
		
		@Column
		private String bookName;
		
		@Column
		private String bookCode;

		public long getId() {
			return ids;
		}

		public void setId(long id) {
			this.ids = id;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getBookName() {
			return bookName;
		}

		public void setBookName(String bookName) {
			this.bookName = bookName;
		}

		public String getBookCode() {
			return bookCode;
		}

		public void setBookCode(String bookCode) {
			this.bookCode = bookCode;
		}
		
		

}
