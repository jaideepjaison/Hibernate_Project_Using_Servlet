package com.mkyong.common;

import java.util.Scanner;

import org.hibernate.Session;
import com.mkyong.persistence.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
        System.out.println("Maven + Hibernate + MySQL");
        System.out.println("Enter Code");
        String code=sc.next();
        System.out.println("Enter name");
        String name=sc.next();
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        Stock stock = new Stock();
        
        stock.setStockCode(code);
        stock.setStockName(name);
        
        session.save(stock);
        session.getTransaction().commit();
    }
}