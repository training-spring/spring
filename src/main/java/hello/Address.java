package hello;

public class Address{

	private String country;
	private String city;

	public Address(String country, String city){
		this.city = city;
		this.country = country;
	}

	public void setCountry(String country){
		this.country = country;
	}
	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public String getCountry(){
		return country;
	}
}