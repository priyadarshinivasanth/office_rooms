
public class controller {
  
	//1.homepage url
    @RequestMapping("/homepage")
    public String index() {
        	return "home page {to update status  select login or signup}";
    }

    
    
    //2.sign up of employee
    @RequestMapping(value="/homepage/sign/{id2}",method=RequestMethod.GET)
    public String emp_signup(@PathVariable("id2") Long roomData,@RequestParam int id
			, @RequestParam String e_name,@RequestParam String email
			, @RequestParam String password ) {
    	String str;
        db d=new db();
        str=d.e_signup(id, e_name, email, password);
        return str;
    }
    
    
    
    
    //3.login of employee
    @RequestMapping(value="/homepage/login/{id}",method=RequestMethod.GET)
    public boolean putroom(@RequestParam int id
			, @RequestParam String pass ) {
        System.out.println("inside login function");
        db d=new db();
        
        boolean status=d.e_login(id, pass);
        return status;
    }
    
   
    
    //4.search emp based on id
    @RequestMapping(value="/homepage/search",method=RequestMethod.GET)
    public List<signdetail> search_id(@RequestParam int id ) 
    {
    	    	
    	System.out.println("came to searchid function");
    	db d=new db();
   List<signdetail> arr=new ArrayList<signdetail>();
   arr=d.search_on_id(id);
    	return arr;
    }
   
    
   
    
    //5.enter all room detail by admin
    @RequestMapping(value="/homepage/login/admin/enter",method=RequestMethod.PUT)
    public String enter_room_detail(
    		@RequestParam String r_name,@RequestParam int r_cap,@RequestParam boolean p_avail,@RequestParam boolean b_avail,
    		@RequestParam String nearby,@RequestParam String loca,@RequestParam boolean status)
    {
    	String str;
    	db d=new db();
    	str=d.room_detail(r_name, r_cap, p_avail, b_avail, nearby, loca, status);
    	return str;
    }
    
    
    //6.delete room detail using a particular id
    @RequestMapping(value="/homepage/login/admin/delete",method=RequestMethod.DELETE)
    public String delete_room(@RequestParam String r_name) {
    	String str;
    	db r_d=new db();
    	str=r_d.room_delete(r_name);
    	return str;
    }
    
    //7.display all room details of every room
    @RequestMapping(value="/homepage/display_all_room",method=RequestMethod.PUT)
    public List<room_detail> all_room_details()
    {
    	System.out.println("inside all_room _detail_function");
    	db db_obj=new db();
    	List<room_detail> r_list=new ArrayList<room_detail>();
    	//r_list=db_obj
    	r_list=db_obj.room_search_all();
    	return r_list;
    }
    
    
    
    //8.search on capacity
    @RequestMapping(value="/homepage/search_cap_room",method=RequestMethod.PUT)
    public List<room_detail> search_cap()
    {
    	System.out.println("came inside searchcap");
    	db d=new db();
    	List<room_detail> arr=new ArrayList<room_detail>();
    	arr=d.room_search_cap();
    	return arr;
    }
    //9.

}
