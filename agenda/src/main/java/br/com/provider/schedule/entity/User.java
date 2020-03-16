package br.com.provider.schedule.entity;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {

	@Id
	@SequenceGenerator(name = "seqSchedule")
	@GeneratedValue(generator = "seqSchedule", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "ds_name")
	private String name;

	@Column(name = "ds_address")
	private String address;

	@Column(name = "ds_cellphone")
	private String cellphone;

	public User() {

	}

	public User(String name, String address, String cellphone) {
		this.name = name;
		this.address = address;
		this.cellphone = cellphone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public static List<User> getPessoas(List<User> pessoas) {
		return pessoas.stream().collect(Collectors.toList());
	}

}
