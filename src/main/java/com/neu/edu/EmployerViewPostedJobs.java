package com.neu.edu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.JobListDAO;
import com.neu.pojo.Employer;
import com.neu.pojo.Jobs;
//import com.yusuf.spring.dao.CategoryDAO;
//import com.yusuf.spring.exception.AdException;
//import com.yusuf.spring.pojo.Advert;
//import com.yusuf.spring.pojo.Category;

@Controller
@RequestMapping("/viewApplicants.htm")
public class EmployerViewPostedJobs {
	
	@RequestMapping(method=RequestMethod.GET)
	protected ModelAndView handleRequestInternal(Model model,HttpServletRequest req,HttpSession session) throws Exception {
		JobListDAO categories = null;
        List categoryList = null;
        List jobpostList = new ArrayList();

        try {
            categories = new JobListDAO();
             Employer employer =(Employer) session.getAttribute("employerSession");
			
			long personID= employer.getPersonID();
			
            categoryList = categories.getPostedJobsList(personID);
            
            System.out.println( "Employer person id in view jobposts/applicants" + personID);

            Iterator categIterator = categoryList.iterator();

            while (categIterator.hasNext())
            {
            	Jobs category = (Jobs) categIterator.next();
            	
            	 

               // Iterator advIterator = category.getAdverts().iterator();

               // while (advIterator.hasNext())
                //{
                   // Advert advert = (Advert) advIterator.next();
            	 jobpostList.add(category);
                //}
            }
            //DAO.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("employerViewPostedJobs", "postedJobsList", jobpostList);
        return mv;
    }

}