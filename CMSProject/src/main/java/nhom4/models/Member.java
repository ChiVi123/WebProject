package nhom4.models;

import java.time.LocalDateTime;

public class Member {
	private int id;
	private String Firstname;
	private String Lastname;
	private String Username;
	private String Password;
	private String Phone;
	private String Email;
	private String Description;
	private LocalDateTime CreateDate;
	private LocalDateTime UpdateTime;

	public Member() {}
	public Member(int id, String firstname, String lastname, String phone, String description) {
		super();
		this.id = id;
		this.Firstname = firstname;
		this.Lastname = lastname;
		this.Phone = phone;
		this.Description = description;
	}
	public Member(int id, String firstname, String lastname,String email ,String phone, String description) {
		super();
		this.id = id;
		this.Firstname = firstname;
		this.Lastname = lastname;
		this.Email = email;
		this.Phone = phone;
		this.Description = description;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public LocalDateTime getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		CreateDate = createDate;
	}

	public LocalDateTime getUpdateTime() {
		return UpdateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		UpdateTime = updateTime;
	}

}
