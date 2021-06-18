package net.codejava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PostMapping;
@RestController
public class admin {
	@Autowired
	usersServices udao;
	@Autowired
	jobServices jdao;
	
	@PostMapping(
			  value = "/admin/addUser")//تقوم هذه البميثود باستقبال مستخدم جديد وتفحص اذا كان ملائم للشروط(
	                    // كلمة السر اطول من 6 حروف، كلمة السر المدخلة مرتان هي نفسها، لا يوجد مستخم سابق بنفس الاسم و كلمة السر)
                        //	ثم تحفظ المستخدم الجديد والا تعيد "error"
	public ArrayList<String> register (@RequestBody user x) {
		ArrayList<String>  mylist = new ArrayList<String>(); 
if(x.getPassword().length()<6) {
	
		mylist.add("the password is short");
	return mylist;}
if(!(x.getPassword().equals(x.getRptpassword()))) {
	mylist.add("the password doesnt match");
return mylist;
}
Object[] users = udao.getAllUsers().toArray();
for (int i = 0; i < users.length; i++) {
	if((((user)users[i]).getUsername()).equals(x.getUsername())) {
		mylist.add("the user already exist");
	return mylist;
	}
}
mylist.add("true");
udao.saveUser(x);
		return mylist;

	}
	
	@PostMapping("admin/updateJobs/")
    public int updateById(@RequestParam("id") int id,
    		@RequestParam("name") String name,
    		@RequestParam("location") String location,
    		@RequestParam("details") String details,
    		@RequestParam("phonenum") int phone)
    {
		
		
		Object[] jarr = jdao.getAllJobs().toArray();
        for (int i = 0; i < jarr.length; i++) {
            if((((job) jarr[i]).getId())==((id))) {             
            	 ((job) jarr[i]).setName(name) ;
            	((job) jarr[i]).setDetails(details) ;
            	((job) jarr[i]).setLocation(location) ;
            	((job) jarr[i]).setPhonenum(phone) ;
            jdao.saveJob((job) jarr[i]);
            	break;
            } 
               
            }
        return id;
        }
    
	
	@PostMapping(
			  value = "/admin/CheckUser")//تعمل على فحص اذا كان المستخدم موجود سابقا وترجع ترو والا ترجع فولز
	public ArrayList<String>  login (@RequestBody user x ) {
		ArrayList<String>  mylist = new ArrayList<String>(); 
		Object[] users = udao.getAllUsers().toArray();
for (int i = 0; i < users.length; i++) {
	if((((user)users[i]).getUsername()).equals(x.getUsername())&&(((user)users[i]).getPassword()).equals(x.getPassword())) {
		mylist.add("true");
		
		  mylist.add(String.valueOf(((user) users[i]).getId()));
		
		mylist.add("26");
		return mylist;}
	}	
mylist.add("false");
		return mylist;
	}
	
	@PostMapping(
			  value = "/admin/addJob")//تقوم باضافة(job)جديدة
	public boolean  addjob (@RequestBody job x) {
jdao.saveJob(x);
return true;
	}
	
	@PostMapping("/admin/usersJobs/{id}")//ترجع جميع ال(jobs)التي تحمل (id) يوزر معين
	public ArrayList<job>  UsersJobs (@RequestParam("id") int id ) {
		
		ArrayList<job>  mylist = new ArrayList<job>(); 
		   Object[] jobs = jdao.getAllJobs().toArray();
		 		  
			
			  for (int i = 0; i < jobs.length; i++) { 
				  if(( ((job)jobs[i]).getIduser())==(id))
						
						  mylist.add((((job)jobs[i])));
							 
	}			 	  
		  return mylist;	
	}	

	@GetMapping("/admin/all")//ترجع جميع ال(jobs)الموجودة
	public Collection<job>getAllJobs()
	{
		return jdao.getAllJobs();
	}
	
	
	@PostMapping("/admin/getjob")//ترجع جميع ال(jobs) التي تحمل نفس الاسم المدخل
	public ArrayList<job> GetJob(@RequestParam("namesrch") String x) {
		 ArrayList<job> mylist = new ArrayList<job>();

		   Object[] jobs = jdao.getAllJobs().toArray();
		 		  
		  for (int i = 0; i < jobs.length; i++) { 
			  if(( ( (job)jobs[i]).getName()).contains(x)) 
				  mylist.add( (((job)jobs[i])));
			  }
		
		 return mylist;	
	}


	@PostMapping(
			  value = "/admin/removeJob/")//تحذف ال(job) التي تحمل ال(id)المدخل
	public void  removejob (@RequestParam("id") int id){
		jdao.removeJob(id);
		
	}         
	
}
