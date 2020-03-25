package com.javaeetest.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.javaeetest.entity.Address;
import com.javaeetest.entity.User;
import com.javaeetest.entity.UserAddress;
import com.javaeetest.service.AddressService;
import com.javaeetest.service.UserAddressService;
import com.opensymphony.xwork2.ActionSupport;

public class AddressAction extends ActionSupport {

	private AddressService addressService;
	private UserAddressService userAddressService;
	private String receiverName;
	private String receiverPhone;
	private String province;
	private String city;
	private String detailedAddress;

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;

	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDetailedAddress() {
		return detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}

	/**
	 * 新增收货地址
	 */
	public String execute() throws UnsupportedEncodingException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Address address = new Address();

		request.setCharacterEncoding("UTF-8");
		String receiverName = request.getParameter("receiverName");
		// String receiverName = new String(request.getParameter("receiverName")
		// .getBytes("ISO-8859-1"), "utf-8");
		// String receiverName = java.net.URLDecoder.decode(
		// request.getParameter("receiverName"), "UTF-8");
		System.out.println(receiverName + " sssss");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String detailedAddress = request.getParameter("detailedAddress");
		String receiverPhone = request.getParameter("receiverPhone");

		System.out.println("address1:" + detailedAddress);
		address.setCity(city);
		address.setDetailedAddress(detailedAddress);
		address.setProvince(province);

		address.setReceiverName(receiverName);

		address.setReceiverPhone(receiverPhone);
		String addressId = String.valueOf(System.currentTimeMillis());

		System.out.println(address.getReceiverName() + ":::name");
		System.out.println(address.getDetailedAddress() + ":::::detaild");
		address.setAddressId(addressId);
		// 添加地址
		addressService.saveAddress(address);

		// 将新添加的地址存入session中
		List<Address> addresses = (List<Address>) session
				.getAttribute("userAddress");
		addresses.add(address);
		session.setAttribute("userAddress", addresses);

		/*
		 * if(addressService.saveAddress(address)){ return SUCCESS; } else{
		 * addActionError("添加地址失败"); return ERROR; }
		 */
		User user = (User) session.getAttribute("loginUser");
		if (user == null) {
			System.out.println("未登录");
			return ERROR;
		}
		UserAddress userAddress = new UserAddress(user, address);
		if (userAddressService.savaUserAddress(userAddress)) {

			return SUCCESS;
		} else {
			addActionError("登录失败");
			return ERROR;
		}

	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	public AddressService getAddressService() {
		return addressService;
	}

	public void setUserAddressService(UserAddressService userAddressService) {
		this.userAddressService = userAddressService;
	}

	public UserAddressService getUserAddressService() {
		return userAddressService;
	}

}
