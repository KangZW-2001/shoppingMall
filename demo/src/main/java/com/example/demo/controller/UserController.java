package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.UserService;
import java.util.ArrayList;
import com.example.demo.service.*;

/**
 * @author KangZW
 * */

@RestController
@RequestMapping("/mall")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private OwnerService ownerService;
		
	//获得用户ID
	@PostMapping("/users/id")
	@ResponseBody
	public int getUserID(@RequestParam("userName")String userName,@RequestParam("userPW")String userPW) {
		int re = userService.getuserID(userName, userPW);
		return re;
	}
	
	//获得商家ID
	@PostMapping("/owners/id")
	@ResponseBody
	public int getOwnerID(@RequestParam("ownerName")String ownerName,@RequestParam("ownerPW")String ownerPW) {
		int re = ownerService.getOwnerID(ownerName, ownerPW);
		return re;
	}
	
	//注册用户
	@PostMapping("/users")
	@ResponseBody
	public String signUp(@RequestParam("name") String name,@RequestParam("password")String password) {
		System.out.println("Controller userName = " + name);
		System.out.println("Controller userPassword = " + password);
		
		boolean j1 = userService.userRegister(name, password);
		return getR(j1);
	}
	
	//登录用户
	@PostMapping("/users/lands")
	@ResponseBody
	public String land(@RequestParam("userName") String userName,@RequestParam("userPassword") String password) {
		boolean j1 = userService.userLand(userName, password);
		return getR(j1);
	}
	
	//更改名字
	@PostMapping("/users/name")
	@ResponseBody
	public String changeName(@RequestParam("userID") int userID,@RequestParam("newName") String newName) {
		boolean j1 = userService.changeUserName(userID,newName);
		return getR(j1);
	}
	
	//更改密码
	@PostMapping("/users/password")
	@ResponseBody
	public String changePW(@RequestParam("userID") int userID ,@RequestParam("newPassword") String newPassword) {
		boolean j1 = userService.changeUserPW(userID,newPassword);
		return getR(j1);
	}
	
	//更改性别
	@PostMapping("/users/sex")
	@ResponseBody
	public String changeSex(@RequestParam("userID") int userID,@RequestParam("newSex") String newSex) {
		boolean j1 = userService.changeUserSex(userID,newSex);
		return getR(j1);
	}
	
	//更改电话号码
	@PostMapping("/users/phone")
	@ResponseBody
	public String changePhone(@RequestParam("userID") int userID,@RequestParam("newPhone") String newPhone) {
		boolean j1 = userService.changeUserPhone(userID,newPhone);
		return getR(j1);
	}
	
	//更改微信号
	@PostMapping("/users/wechat")
	@ResponseBody
	public String changeWechat(@RequestParam("userID") int userID,@RequestParam("newWechat") String weChat) {
		boolean j1 = userService.changeUserWechat(userID,weChat);
		return getR(j1);
	}
	
	//无参数查商品
	@RequestMapping("/products")
	@ResponseBody
	public ArrayList getProducts() {
		ArrayList list = (ArrayList) userService.queryProductWucan();
		return list;
	}
	
	//根据商品名字查商品
	@PostMapping("/products/productName")
	@ResponseBody
	public ArrayList getProductsByName(@RequestParam("productName") String productName){
		ArrayList list = (ArrayList) userService.queryProductPN(productName);
		return list;
	}
	
	//根据商店名字查商品
	@PostMapping("/products/shopName")
	@ResponseBody
	public ArrayList getProductByShopName(@RequestParam("shopName") String shopName){
		ArrayList list = (ArrayList) userService.queryProductSN(shopName);
		return list;
	}
	
	//添加物品进购物车
	@PostMapping("/trolley")
	@ResponseBody
	public String addProduct(@RequestParam("userID") int userID, @RequestParam("productName") String productName) {
		boolean j1 = userService.addtrolleyProduct(userID, productName);
		return getR(j1);
	}
	
	//删除购物车中的商品
	@DeleteMapping("/trolley")
	@ResponseBody
	public String deleteProduct(@RequestParam("userID") int userID,@RequestParam("productName") String productName) {
		boolean j1 = userService.deletetrollryProduct(userID, productName);
		return getR(j1);
	}
	
	//结算购物车中的商品
	@DeleteMapping("/trolley/bills")
	@ResponseBody
	public String billProduct(@RequestParam("userID")int userID,@RequestParam("productName")String productName,@RequestParam("productNumber")int productNumber) {
		boolean j1 = userService.settlementtrolleyProduct(userID, productName,productNumber);
		return getR(j1);
	}
	
	//查看购物车中的商品
	@PostMapping("trolley/products")
	@ResponseBody
	public ArrayList getAllProducts(@RequestParam("userID")int userID,@RequestParam("userName")String userName) {
		ArrayList list =   (ArrayList) userService.querytrolleyProduct(userID, userName);
	    return list;
	}
	
	//查询所有的订单
	@PostMapping("/orders")
	@ResponseBody
	public ArrayList getAllOrders(@RequestParam("userID")int userID,@RequestParam("userName")String userName) {
		ArrayList list = (ArrayList)userService.queryOrder(userID, userName);
		return list;
	}
	
	//根据商店的名字获取商家微信号
	@PostMapping("/oeders/wechat")
	@ResponseBody
	public String getWechat(@RequestParam("shopName") String shopName) {
		return userService.queryWeChat(shopName);
	}
	
	//卖家注册
	@PostMapping("/owners")
	@ResponseBody
	public String signUpOwner(@RequestParam("ownerName")String ownerName,@RequestParam("ownerPW")String ownerPW,@RequestParam("ownerIDcard") String ownerIDcard, @RequestParam("ownerPhone") String ownerPhone, @RequestParam("ownerWechat")String ownerWechat) {
		boolean j = ownerService.ownerRegister(ownerName, ownerPW, ownerIDcard, ownerPhone, ownerWechat);
		return getR(j);
	}
	
	//卖家登录
	@PostMapping("/owners/lands")
	@ResponseBody
	public String ownerLand(@RequestParam("ownerName")String ownerName,@RequestParam("ownerPW")String ownerPassword) {
		boolean j = ownerService.ownerLand(ownerName, ownerPassword);
		return getR(j);
	}
	
	//卖家改名字
	@PostMapping("/owners/name")
	@ResponseBody
	public String changeOwnersName(@RequestParam("ownerID")int ownerID,@RequestParam("ownerPW")String newOwnerName) {
		boolean j = ownerService.changeOwnerName(ownerID, newOwnerName);
		return getR(j);
	}
	
	//卖家改密码
	@PostMapping("/owners/password")
	@ResponseBody
	public String changeOwnerPW(@RequestParam("ownerID")int ownerID,@RequestParam("ownerPW")String newOwnerPW) {
		boolean j = ownerService.changeOwnerPW(ownerID, newOwnerPW);
		return getR(j);
	}
	
	//卖家更改电话号码
	@PostMapping("/owners/phone")
	@ResponseBody
	public String changeOwnerPhone(@RequestParam("ownerID")int ownerID,@RequestParam("ownerPhone")String newOwnerPhone) {
		boolean j = ownerService.changeOwnerPhone(ownerID, newOwnerPhone);
		return getR(j);
	}

	//卖家更改微信号
	@PostMapping("/owners/wechat")
	@ResponseBody
	public String changeOwnerWechat(@RequestParam("ownerID")int ownerID,@RequestParam("ownerWechat")String newOwnerWechat) {
		boolean j = ownerService.changeOwnerWechat(ownerID, newOwnerWechat);
		return getR(j);
	}

	//注册商店
	@PostMapping("/shops")
	@ResponseBody
	public String signUpShop(@RequestParam("shopName")String shopName,@RequestParam("shopOwner")int shopOwner) {
		boolean j = ownerService.registerShop(shopName, shopOwner);
		return getR(j);
	}

	//卖家更改商店名字
	@PostMapping("shops/names")
	@ResponseBody
	public String changeShopName(@RequestParam("shopID")int shopID,@RequestParam("newShopName")String newShopName) {
		boolean j = ownerService.changeShopName(shopID, newShopName);
		return getR(j);
	}
	
	//卖家上架商品
	@PostMapping("/ownerProducts")
	@ResponseBody
	public String upLoadProduct(@RequestParam("shopID")int shopID,@RequestParam("productName")String productName,@RequestParam("productPrice")double productPrice) {
		boolean j = ownerService.putOnproduct(shopID, productName, productPrice);
		return getR(j);
	}
	
	//卖家下架商品
	@DeleteMapping("/ownerProducts")
	@ResponseBody
	public String downLoadProduct(@RequestParam("shopID")int shopID,@RequestParam("productName")String productName) {
		boolean j = ownerService.deleteProduct(shopID,productName);
		return getR(j);
	}
	
	
	//卖家更改商品价格
	@PostMapping("/owners/productPrice")
	@ResponseBody
	public String changeProductPrice(@RequestParam("shopID")int shopID,@RequestParam("productName")String productName,@RequestParam("productInformation")String productInformation) {
		boolean j =ownerService.addProductInformation(shopID, productName, productInformation);
		return getR(j);
	}
	
	//卖家更改商品名字
	@PostMapping("/owners/productName")
	@ResponseBody
	public String changeProductName(@RequestParam("shopID")int shopID,@RequestParam("productName")String productName,@RequestParam("newProductName")String newProductName) {
		boolean j = ownerService.changeProductName(shopID, productName, newProductName);
		return getR(j);
	}
	
	
	//卖家更改商品描述
	@PostMapping("/owners/productDescription")
	@ResponseBody
	public String changeProductDesciption(@RequestParam("shopID")int shopID,@RequestParam("productName")String productName,@RequestParam("productInformation")String pInfo) {
		boolean j = ownerService.changeProductInformation(shopID, productName, pInfo);
		return getR(j);
	}
	
	//传入boolean值，返回成功还是失败字符串函数
	private String getR(boolean j) {
		if(j)
			return "更改成功";
		else
			return "更改失败";
	}

















}
