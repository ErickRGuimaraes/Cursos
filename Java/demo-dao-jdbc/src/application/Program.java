package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.creatSellerDao();
        
        System.out.println("=== Test 1: seller findById ===");
        Seller seller = sellerDao.fingById(3);
        System.out.println(seller);

        System.out.println("\n=== Test 2: seller findByDepartment ===");
        Department department = new Department(1,null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj: list){
            System.out.println(obj);
        }

        System.out.println("\n=== Test 3: seller findall ===");
        list = sellerDao.findAll();
        for(Seller obj: list){
            System.out.println(obj);
        }

        System.out.println("\n=== Test 4: seller Insert ===");
        Seller newSeller = new Seller(null,"Greg","greg@gmail.com",new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id= "+ newSeller.getId());
        
        System.out.println("\n=== Test 5: seller Update ===");
        seller = sellerDao.fingById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed!");
        
        System.out.println("\n=== Test 6:  seller delete ===");
        System.out.println("Enter if for delete test: ");
        int id = sc.nextInt();

        sellerDao.deleteById(id);
        System.out.println("Delete completed! ");

        sc.close();
    }
}
