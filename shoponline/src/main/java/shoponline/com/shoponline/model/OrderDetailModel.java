package shoponline.com.shoponline.model;

public class OrderDetailModel extends AbstractModel<OrderDetailModel> {
	private Long productId;
	private Long quantity;
	private Long userId;
	private String userName;
	private String productName;

	public OrderDetailModel() {

	}

	public OrderDetailModel(Long productId, Long quantity, Long userId, String userName, String productName) {
		this.productId = productId;
		this.quantity = quantity;
		this.userId = userId;
		this.userName = userName;
		this.productName = productName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	

}
