package pack.order;

import java.util.Hashtable;

public class CartMgr {
	//private Hashtable<String, OrderBean> //캐스팅 필요
	private Hashtable<String, OrderBean> hCart = new Hashtable<String, OrderBean>(); //캐스팅 불필요
	
	public void addCart(OrderBean obean) {
		
	}
	
	public Hashtable<String, OrderBean> getCartList(){
		return hCart;
	}
	
	public void updateCart(OrderBean order) {
		
	}
	
public void deleteCart(OrderBean order) {
		
	}
}
