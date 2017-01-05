package co.kr.neweye.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.neweye.db.sqlconfig.IBatisDBConnector;
import kr.co.neweye.dto.ProductVO;
import kr.co.neweye.dto.SearchVO;
import co.kr.neweye.dao.ProductDAO;

import com.ibatis.sqlmap.client.SqlMapClient;

public class ProductDAO_iBatis implements ProductDAO {
		
	private SqlMapClient client = IBatisDBConnector.getSqlMapInstance();
	private static ProductDAO_iBatis instance = new ProductDAO_iBatis();

	private ProductDAO_iBatis() {}
	public static ProductDAO_iBatis getInstance() {
		return instance;
	}
	
	static int view_rows = 5; // 페이지의 개수
	static int counts = 6; // 한 페이지에 나타낼 상품의 개수
	
	@Override
	public ArrayList<ProductVO> listSelProduct(SearchVO search) throws SQLException {
		ArrayList<ProductVO> listNewProduct = null;
		
		int startRow = -1;
		int endRow = -1;
		int tpage = Integer.parseInt(search.getTpage());
		
		int totalRecord = totalRecord("");

		startRow = (tpage - 1) * counts ;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		
		if(search.getOrderby().equals("asc")){
			listNewProduct = (ArrayList<ProductVO>) client.queryForList("listForProduct", search,startRow,counts);
		}else{
			listNewProduct = (ArrayList<ProductVO>) client.queryForList("listForProduct", search,startRow,counts);
		}
		return listNewProduct;
	}
	
	@Override
	public String pageNum(SearchVO search) throws SQLException {
		
		int tpage = Integer.parseInt(search.getTpage());
		
		int total_pages = (Integer) client.queryForObject("listForProductCount",search);
		int page_count = total_pages / counts;
		
		if (total_pages % counts != 0) page_count++;

		int page=tpage;
		if(tpage%view_rows==0) page--;
		
		int start_page= page - (page % view_rows) +1;
		int end_page = start_page + (view_rows - 1);
		
		if (end_page > page_count) end_page = page_count;
		
		String str = "";
		String key = "";
		
		if(!search.getKind().equals("")){
			key = "&kind="+search.getKind();
		}else if(!search.getCategory().equals("")){
			key = "&category="+search.getCategory();
		}
		
		if(!search.getName().equals("")){
			key += "&key="+ search.getName();
		}
		
		////////////////////////////////////////////////////////////////////
		
		if (start_page > view_rows) {
			str += "<a href='product.ne?tpage=1" + key + "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='product.ne?tpage=" + (start_page - 1);
			str += "&key=<%=product_name%>'>&lt;</a>&nbsp;&nbsp;";
		}
		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='product.ne?tpage=" + i + key + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}
		if (page_count > end_page) {
			str += "<a href='product.ne?tpage=" + (end_page + 1) + key + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='product.ne?tpage=" + page_count + key + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	
	@Override
	public ProductVO getProduct(String pseq) throws SQLException {
		ProductVO product = new ProductVO();
		product = (ProductVO) client.queryForObject("getProduct", pseq);
		increaseReadCount(product);
		product.setRead_count((product.getRead_count()+1));
		return product;
	}

	@Override
	public int totalRecord(String product_name) throws SQLException {
		int total_pages = 0;
		if (product_name.equals("")) {
			product_name = "%";
		}
		total_pages = (Integer) client.queryForObject("totalRecord",product_name);
		return total_pages;
	}
	
	@Override
	public String pageNumber(int tpage, String name) throws SQLException {
		String str = "";

		int total_pages = totalRecord(name);
		int page_count = total_pages / counts + 1;

		if (total_pages % counts == 0) {
			page_count--;
		}
		if (tpage < 1) {
			tpage = 1;
		}
		
		int page=tpage;
		if(tpage%view_rows==0) page--;
		
		int start_page = page - (page % view_rows) + 1;
		int end_page = start_page + (counts - 1);

		if (end_page > page_count) {
			end_page = page_count;
		}
		if (start_page > view_rows) {
			str += "<a href='adminProductList.ne?tpage=1&key="
					+ name + "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='adminProductList.ne?tpage="
					+ (start_page - 1);
			str += "&key=<%=product_name%>'>&lt;</a>&nbsp;&nbsp;";
			
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='adminProductList.ne?tpage="
						+ i + "&key=" + name + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='adminProductList.ne?tpage="
					+ (end_page + 1) + "&key=" + name
					+ "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='adminProductList.ne?tpage="
					+ page_count + "&key=" + name
					+ "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	
	@Override
	public ArrayList<ProductVO> listProduct(int tpage, String product_name)
			throws SQLException {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		int startRow = -1;
		int endRow = -1;

		if (product_name.equals("")) {
			product_name = "%";
		}

		int totalRecord = totalRecord(product_name);

		startRow = (tpage - 1) * counts ;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		
		productList=(ArrayList<ProductVO>)client.queryForList("listProduct",product_name,startRow,counts);
		return productList;
	}

	@Override
	public int insertProduct(ProductVO product) throws SQLException {
		int result = (Integer)client.update("insertProduct",product);
		return result;
	}

	@Override
	public int updateProduct(ProductVO product) throws SQLException {
		int result = (Integer)client.update("updateProduct",product);
		return result;
	}

	// 상품 조회수/////////////////////////////
	@Override
	public int increaseReadCount(ProductVO product) throws SQLException {
		client.update("increaseReadCount",product);
		return 0;
	}

	@Override
	public ArrayList<ProductVO> listDetailProduct(int tpage, String product_name)
			throws SQLException {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		int startRow = -1;
		int endRow = -1;

		if (product_name.equals("")) {
			product_name = "%";
		}

		int totalRecord = totalRecord(product_name);

		startRow = (tpage - 1) * counts ;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		
		productList=(ArrayList<ProductVO>)client.queryForList("listProduct",product_name,startRow,counts);
		return productList;
	}

	@Override
	public int deleteProduct(ProductVO product) throws SQLException {
		int result = (Integer)client.update("deleteProduct",product);
		return result;
	}

}
