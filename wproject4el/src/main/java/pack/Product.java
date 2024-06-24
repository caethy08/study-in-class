package pack;

public class Product {
	private String name;
	private double price;
	private String description;
	private java.util.Date realeaseDate;
	
	public Product(String name, double price, String description, java.util.Date releaseDate) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.realeaseDate = releaseDate;
	}
}
