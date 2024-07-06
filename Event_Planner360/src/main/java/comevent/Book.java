package comevent;

public class Book {
	private int id;
	private String name;
	private String email;
	private String country;
	private long mobil;
	private String message;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String name, String email, String country, long mobil, String message) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.mobil = mobil;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getMobil() {
		return mobil;
	}
	public void setMobil(long mobil) {
		this.mobil = mobil;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", email=" + email + ", country=" + country + ", mobil=" + mobil
				+ ", message=" + message + "]";
	}
	
	
	

}
