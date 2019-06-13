package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {


		Department obj = new Department(1, "Books");
		//System.out.println(obj);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test1: Test find by ID of seller===");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
	}

}
