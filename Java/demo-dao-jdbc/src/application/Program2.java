package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.creatDepartmentDao();
        
        System.out.println("=== Test 1: department Insert ===");
        Department newDepartment = new Department(null,"Test");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id= "+ newDepartment.getId());

        System.out.println("\n=== Test 2: department Update ===");
        Department department = departmentDao.fingById(9);
        department.setName("D3");
        departmentDao.update(department);
        System.out.println("Update completed!");

        System.out.println("\n=== Test 3:  department delete ===");
        System.out.println("Enter if for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed! ");

        System.out.println("=== Test 4: department findById ===");
        department = departmentDao.fingById(3);
        System.out.println(department);

        System.out.println("\n=== Test 5: department findall ===");
        List<Department> list = departmentDao.findAll();
        for(Department obj: list){
            System.out.println(obj);
        }

        sc.close();
    }
}
