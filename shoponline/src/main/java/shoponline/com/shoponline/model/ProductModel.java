package shoponline.com.shoponline.model;

public class ProductModel extends AbstractModel<ProductModel>{
	private String title;
	private String thumbnail;
	private String shortDescription;
	private String description;
	private Long price;
	private int stock;
	private Long categoryId;
	private String categoryCode;
	private String producer;
	
	public ProductModel() {

	}
	
	public ProductModel(String title, String thumbnail, String shortDescription, Long categoryId, String categoryCode,
			Long price, int stock, String description, String producer) {
		this.title = title;
		this.thumbnail = thumbnail;
		this.shortDescription = shortDescription;
		this.categoryId = categoryId;
		this.categoryCode = categoryCode;
		this.price = price;
		this.stock = stock;
		this.description = description;
		this.producer = producer;
	}
	

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
