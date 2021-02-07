package com.sbrestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
* <h1>Model for Address!</h1>
* Address is used to store and get from database.
* 
* @author  Yugandhara Reddy Kuraakula 
* @version 1.0
* @since   2021-02-07
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Setter
@Getter
@ToString
public class Address {
	
	/* id is auto generated value for primary key */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	
	/* suburb is used to store and get from database */
	@Column
	private String suburb;

	/* postCode is used to store and get from database */
	@Column
	private String postCode;
	
}
