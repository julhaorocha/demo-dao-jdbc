package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("\n=== Test 1: Test find by Department ===");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);

		System.out.println("\n=== Test 2: Test insert new Department ===");
		/*
		Department newDepartment = new Department(null, "Food");
		departmentDao.insert(newDepartment);
		System.out.println("New department inserted! new number: " + newDepartment.getId());
		*/
		System.out.println("\n=== Test 3: Test  Department delete ===");
		
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete comleted");
		sc.close();
		
		System.out.println("\n=== Test 4: department update ===");
		Department department = departmentDao.findById(1);
		department.setName("Music");	
		departmentDao.update(department);
		System.out.println("Update complete");
		
		System.out.println("\n=== Test 4: department update ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
	}

}
