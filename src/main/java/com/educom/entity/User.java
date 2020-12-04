package com.educom.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.educom.exception.ResourceNotFoundException;
import com.educom.util.EducomGenerator;
import com.sun.istack.NotNull;

@Entity 
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, name = "user_id")
	@NotNull
	private Long userId;
	
	@Column(name = "user_first_name")
	private String firstName;	

	@Column(name = "user_uuid")
	@NotNull
	private String userUUID;	
	
	@Column(name = "user_last_name")
	private String lastName;
	
	@Column(name = "user_email")
	private String email;

	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_age")
	private Integer userAge;
	
	@Column(name = "user_bithdate")
	@Temporal(TemporalType.DATE)
	private Date userBirthDate;
	
	@Column(name = "user_contact")
	private String[] userContact;
	
	@Column(name = "user_address")
	private String[] userAddress;
	
	@Column(name = "gender")
	private String gender;
	
	@Lob
	@Column(name = "User_bio")
	private byte[] userBio;

	@Lob
	@Column(name = "User_image")
	private byte[] userImage;

	@Column(name = "User_type")
	private String userType;
		
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public User() {
		setUserUUID(EducomGenerator.generateUuid().toString());
	}
	
	public User(Long userId) {
		this.userId = userId;
	}

	public String getUserUUID() {
		return userUUID;
	}

	public void setUserUUID(String userUUID) {
		this.userUUID = userUUID;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userAge
	 */
	public Integer getUserAge() {
		return userAge;
	}

	/**
	 * @param userAge the userAge to set
	 */
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	/**
	 * @return the userBirthDate
	 */
	public Date getUserBirthDate() {
		return userBirthDate;
	}

	/**
	 * @param userBirthDate the userBirthDate to set
	 */
	public void setUserBirthDate(Date userBirthDate) {
		this.userBirthDate = userBirthDate;
	}

	/**
	 * @return the userContact
	 */
	public String[] getUserContact() {
		return userContact;
	}

	/**
	 * @param userContact the userContact to set
	 */
	public void setUserContact(String[] userContact) {
		this.userContact = userContact;
	}

	/**
	 * @return the userAddress
	 */
	public String[] getUserAddress() {
		return userAddress;
	}

	/**
	 * @param userAddress the userAddress to set
	 */
	public void setUserAddress(String[] userAddress) {
		this.userAddress = userAddress;
	}

	/**
	 * @return the userBio
	 */
	public byte[] getUserBio() {
		return userBio;
	}

	/**
	 * @param userBio the userBio to set
	 */
	public void setUserBio(byte[] userBio) {
		this.userBio = userBio;
	}

	/**
	 * @return the userImage
	 */
	public byte[] getUserImage() {
		return userImage;
	}

	/**
	 * @param userImage the userImage to set
	 */
	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}