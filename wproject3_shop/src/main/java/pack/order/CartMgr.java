package pack.order;

import java.util.Hashtable;

public class CartMgr {
	//private Hashtable<String, OrderBean> //캐스팅 필요
	private Hashtable<String, OrderBean> hCart = new Hashtable<String, OrderBean>(); //캐스팅 불필요
	
	public void addCart(OrderBean obean) {
		String product_no = obean.getProduct_no();
		int quantity = Integer.parseInt(obean.getQuantity());
		
		if(quantity > 0) {
			//동일 상품 주문일 경우에는 주문 수량만 늘려주기
			if(hCart.containsKey(product_no)) { //이미 1회 이상 주문된 상품일 경우 hcart에 받아온 product-no가 있는가
				OrderBean temp = hCart.get(product_no);  //상품을 꺼내줌 hcart에 있는 번호를 temp에 담음
				quantity += Integer.parseInt(temp.getQuantity()); //temp가 가진 수량을 int로 변경해 quantity에 누적해 담음
				temp.setQuantity(Integer.toString(quantity)); //temp에 변경된 quantity값을 담음
				hCart.put(product_no, temp);
			}else {
				hCart.put(product_no, obean); //최초로 장바구니에 담기는 종류의 상품
				
			}
		}
	}
	
	public Hashtable<String, OrderBean> getCartList(){
		return hCart;
	}
	
	public void updateCart(OrderBean obean) {
		String product_no = obean.getProduct_no();
		hCart.put(product_no, obean);
	}
	
public void deleteCart(OrderBean obean) {
		String product_no = obean.getProduct_no();
		hCart.remove(product_no);
	}
}
