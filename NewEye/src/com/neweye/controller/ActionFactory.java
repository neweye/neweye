package com.neweye.controller;

import com.neweye.action.Action;
import com.neweye.action.CartDeleteAction;
import com.neweye.action.CartInsertAction;
import com.neweye.action.CartListAction;
import com.neweye.action.ContractAction;
import com.neweye.action.FindZipNumAction;
import com.neweye.action.IdCheckFormAction;
import com.neweye.action.IndexAction;
import com.neweye.action.JoinAction;
import com.neweye.action.JoinFormAction;
import com.neweye.action.LoginAction;
import com.neweye.action.LoginFormAction;
import com.neweye.action.LogoutAction;
import com.neweye.action.MyPageAction;
import com.neweye.action.OrderAllAction;
import com.neweye.action.OrderDetailAction;
import com.neweye.action.OrderInsertAction;
import com.neweye.action.OrderListAction;
import com.neweye.action.ProductDetailAction;
import com.neweye.action.QnaListAction;
import com.neweye.action.QnaViewAction;
import com.neweye.action.QnaWriteAction;
import com.neweye.action.QnaWriteFormAction;
import com.neweye.admin.action.AdminIndexAction;
import com.neweye.admin.action.AdminLoginAction;
import com.neweye.admin.action.AdminLogoutAction;
import com.neweye.admin.action.AdminMemberListAction;
import com.neweye.admin.action.AdminOrderListAction;
import com.neweye.admin.action.AdminOrderSaveAction;
import com.neweye.admin.action.AdminOrderSearchListAction;
import com.neweye.admin.action.AdminProductDetailAction;
import com.neweye.admin.action.AdminProductListAction;
import com.neweye.admin.action.AdminProductSearchAction;
import com.neweye.admin.action.AdminProductUpdateAction;
import com.neweye.admin.action.AdminProductUpdateFormAction;
import com.neweye.admin.action.AdminProductWriteAction;
import com.neweye.admin.action.AdminProductWriteFormAction;
import com.neweye.admin.action.AdminQnaDetailAction;
import com.neweye.admin.action.AdminQnaListAction;
import com.neweye.admin.action.AdminQnaResaveAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		if (command.equals("index")) {
			action = new IndexAction();
		} else if (command.equals("product_detail")) {
			action = new ProductDetailAction();
		} else if (command.equals("contract")) {
			action = new ContractAction();
		} else if (command.equals("join_form")) {
			action = new JoinFormAction();
		} else if (command.equals("id_check_form")) {
			action = new IdCheckFormAction();
		} else if (command.equals("find_zip_num")) {
			action = new FindZipNumAction();
		} else if (command.equals("join")) {
			action = new JoinAction();
		} else if (command.equals("login_form")) {
			action = new LoginFormAction();
		} else if (command.equals("login")) {
			action = new LoginAction();
		} else if (command.equals("logout")) {
			action = new LogoutAction();
		} else if (command.equals("cart_insert")) {
			action = new CartInsertAction();
		} else if (command.equals("cart_list")) {
			action = new CartListAction();
		} else if (command.equals("cart_delete")) {
			action = new CartDeleteAction();
		} else if (command.equals("order_insert")) {
			action = new OrderInsertAction();
		} else if (command.equals("order_list")) {
			action = new OrderListAction();
		} else if (command.equals("mypage")) {
			action = new MyPageAction();
		} else if (command.equals("order_detail")) {
			action = new OrderDetailAction();
		} else if (command.equals("order_all")) {
			action = new OrderAllAction();
		} else if (command.equals("qna_list")) {
			action = new QnaListAction();
		} else if (command.equals("qna_write_form")) {
			action = new QnaWriteFormAction();
		} else if (command.equals("qna_write")) {
			action = new QnaWriteAction();
		} else if (command.equals("qna_view")) {
			action = new QnaViewAction();
		}

		// admin
		if (command.equals("admin_login_form")) {
			action = new AdminIndexAction();
		} else if (command.equals("admin_login")) {
			action = new AdminLoginAction();
		} else if (command.equals("admin_logout")) {
			action = new AdminLogoutAction();
		} else if (command.equals("admin_product_list")) {
			action = new AdminProductListAction();
		} else if (command.equals("admin_product_write_form")) {
			action = new AdminProductWriteFormAction();
		} else if (command.equals("admin_product_search")){
			action = new AdminProductSearchAction();
		} else if (command.equals("admin_product_write")) {
			action = new AdminProductWriteAction();
		} else if (command.equals("admin_product_detail")) {
			action = new AdminProductDetailAction();
		} else if (command.equals("admin_product_update_form")) {
			action = new AdminProductUpdateFormAction();
		} else if (command.equals("admin_product_update")) {
			action = new AdminProductUpdateAction();
		} else if (command.equals("admin_order_search")) {
			action = new AdminOrderSearchListAction();
		} else if (command.equals("admin_order_list")) {
			action = new AdminOrderListAction();
		} else if (command.equals("admin_order_save")) {
			action = new AdminOrderSaveAction();
		} else if (command.equals("admin_member_list")) {
			action = new AdminMemberListAction();
		} else if (command.equals("admin_qna_list")) {
			action = new AdminQnaListAction();
		} else if (command.equals("admin_qna_detail")) {
			action = new AdminQnaDetailAction();
		} else if (command.equals("admin_qna_repsave")) {
			action = new AdminQnaResaveAction();
		}
		return action;
	}
}
