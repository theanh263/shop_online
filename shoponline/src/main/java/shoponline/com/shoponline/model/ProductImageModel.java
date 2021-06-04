package shoponline.com.shoponline.model;

public class ProductImageModel extends AbstractModel<ProductImageModel>{
	private Long productId;
	private String imagePath;
	private String caption;
	private Long fileSize;
	
	public ProductImageModel(Long productId, String imagePath, String caption, Long fileSize) {
		this.productId = productId;
		this.imagePath = imagePath;
		this.caption = caption;
		this.fileSize = fileSize;
	}
	
	public ProductImageModel() {

	}

	public Long getProductId() { 
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	
}
