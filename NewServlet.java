/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author pro_ge3k
 */
public class NewServlet extends HttpServlet {

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out=response.getWriter();
       String uname=request.getParameter("uname");
       String pass=request.getParameter("pass");
       Configuration c=new Configuration().configure();
       SessionFactory sf=c.buildSessionFactory();
       Session s=sf.openSession();
       Query q=s.createQuery("from login where uname=:uname and pass=:pass");
       q.setParameter("uname", uname);
       q.setParameter("pass", pass);
       List<login> l=q.list();
       
       if(l.size()>0){
       out.println("Login Successful!!");}
      
       else{
       out.println("Invalid username or password");
       }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
