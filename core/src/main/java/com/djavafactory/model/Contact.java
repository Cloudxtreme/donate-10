package com.djavafactory.model;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity implementation class for Entity: Organization
 *
 */
@Entity
@Table(name = "contact")
@Indexed
public class Contact extends BaseObject implements Serializable {

	private Long id;
	private String name;
	private String email;
	private String phoneNo;
	private String message;
	private static final long serialVersionUID = 1L;

	public Contact() {
		super();
	}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
    @Field
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", nullable = false)
	@Field
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone_no", nullable = true)
	@Field
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(name = "message", nullable = false)
	@Field
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Contact{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", phoneNo='" + phoneNo + '\'' +
				", message='" + message + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Contact contact = (Contact) o;

		if (id != null ? !id.equals(contact.id) : contact.id != null) return false;
		if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
		if (email != null ? !email.equals(contact.email) : contact.email != null) return false;
		if (phoneNo != null ? !phoneNo.equals(contact.phoneNo) : contact.phoneNo != null) return false;
		return !(message != null ? !message.equals(contact.message) : contact.message != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (phoneNo != null ? phoneNo.hashCode() : 0);
		result = 31 * result + (message != null ? message.hashCode() : 0);
		return result;
	}
}
