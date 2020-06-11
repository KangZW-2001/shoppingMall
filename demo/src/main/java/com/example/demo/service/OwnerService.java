package com.example.demo.service;

public interface OwnerService {
	    //获取用户ID
        public int getOwnerID(String ownerName , String ownerPW);
        //获取用户ID
        public int getshopID(String shopName);
	    //卖家注册
		public boolean ownerRegister(String ownerName , String ownerPW, String ownerIDcard, String ownerPhone, String ownerWechat);
		//卖家登陆
		public boolean ownerLand(String ownerName,String ownerPW);
		//卖家更改名字
		public boolean changeOwnerName(int ownerID,String newOwnerName);
		//卖家更改密码
		public boolean changeOwnerPW(int ownerID,String newPW);
		//卖家更改电话号码
		public boolean changeOwnerPhone(int ownerID,String newOwnerPhonenumber);
		//卖家更改微信号
		public boolean changeOwnerWechat(int ownerID,String newOwnerWechat);
		
		//卖家注册商店
		//shopOwner是商户的ID
		public boolean registerShop(String shopName, int shopOwner);
		//卖家更改商店名字
		public boolean changeShopName(int shopID, String newShopName);
		//卖家删除商店
		public boolean deleteShop(int shopID);
		
		//上架商品
		public boolean putOnproduct(int shopID,String productName,double productPrice);
		//增加商品信息
		public boolean addProductInformation(int shopID,String productName, String productInformation);
		//下架商品
		public boolean deleteProduct(int shopID,String productName);
		//更改商品价格
		public boolean changeProductPrice(int shopID,String productName, double newproductPrice);
		//更改商品名字
		public boolean changeProductName(int shopID,String productName, String newproductName);
		//更改商品描述
		public boolean changeProductInformation(int shopID,String productName, String newproductInformation);
		//更改商品库存
		public boolean changeProductStock(int shopID,String productName , int stock);
}
