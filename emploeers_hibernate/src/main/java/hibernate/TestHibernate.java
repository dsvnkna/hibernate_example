package hibernate;

import hibernate.project.EmployeeEntity;
import org.hibernate.Session;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestHibernate {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Add new Employee object 
        EmployeeEntity emp = new EmployeeEntity();
        emp.setEmail("demo-user@mail.com");
        emp.setFirstName("demo");
        emp.setLastName("user");

        session.save(emp);
        List result = session.createQuery( "from Employee" ).list();
        for (EmployeeEntity employee : result) {
            System.out.println( employee.getFirstName() );
        }


        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
} 