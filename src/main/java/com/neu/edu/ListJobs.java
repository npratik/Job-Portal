package com.neu.edu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.JobListDAO;
import com.neu.pojo.Jobs;
//import com.yusuf.spring.dao.CategoryDAO;
//import com.yusuf.spring.exception.AdException;
//import com.yusuf.spring.pojo.Advert;
//import com.yusuf.spring.pojo.Category;
import com.neu.pojo.Jobseeker;

@Controller
@RequestMapping("/listjobs.htm")
public class ListJobs {
	
	@RequestMapping(method=RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpSession session) throws Exception {
		JobListDAO categories = null;
        List categoryList = null;
        List advList = new ArrayList();

        try {
        	
        	categories = new JobListDAO();
        	
        	Jobseeker jobseeker =(Jobseeker) session.getAttribute("employeeSession");//request.getSession().getAttribute("employeeSession");
			long jobSeekerId =jobseeker.getPersonID();
			System.out.println(" Person id in jobseekers job list  " + jobSeekerId);
        	categoryList = categories.getListofJobs(jobSeekerId);
        	//int size = categoryList.size();
        	//getListofJobs
           /* categories = new JobListDAO();
            categoryList = categories.list();

            Iterator categIterator = categoryList.iterator();

            while (categIterator.hasNext())
            {
            	Jobs category = (Jobs) categIterator.next();
            	
            	 System.out.println( "category " + category);

               // Iterator advIterator = category.getAdverts().iterator();

               // while (advIterator.hasNext())
                //{
                   // Advert advert = (Advert) advIterator.next();
                    advList.add(category);
                //}
            }*/
            //DAO.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        ModelAndView mv = new ModelAndView("ViewJobs", "adverts", categoryList);
        //ModelAndView mv = new ModelAndView("ViewJobs", "adverts", advList);
        return mv;
    }
}