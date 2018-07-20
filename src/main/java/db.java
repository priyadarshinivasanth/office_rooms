
public class db {
final String DB_URL = "jdbc:mysql://localhost/office_map?autoReconnect=true&useSSL=false";
		final String USER = "root";
		final String PASS = "";
		Connection conn = null;
		Statement stmt = null;
		
		
		static List<room_detail> r= new ArrayList<room_detail>();
	 
		
		//connecting to the databases
	   public void connect () {
		   try{
			
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      System.out.println("Creating statement...");
			      stmt = conn.createStatement();
		   		}
		   catch(SQLException se){
			      se.printStackTrace();
			   }
	   }
	   
	   
	   //closing the connected database
	   public void closedb() {
		   try {
			   System.out.println("came inside close function");
			   stmt.close();
			   conn.close();
		   }
		   catch(SQLException se){
			      se.printStackTrace();
			   }
		   finally
		   {
			   //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }
			      catch(SQLException se2)
			      {
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }
			      catch(SQLException se)
			      {
			         se.printStackTrace();
			      }//end finally try
		   }
	   }
	  
	   
	   //for sign-up of employee
	   public List<signdetail> search_on_id(int id)
	   
	   {
		   connect();
		   System.out.println("came insied search on id");
		   List<signdetail> s=new ArrayList<signdetail>();;
		   try {
		   PreparedStatement ps=conn.prepareStatement(  
		    		  "select * from sign_up where emp_id=? or emp_id=2"); 
		   ps.setInt(1,id);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next()) {
			   System.out.println("came inside loop");
			  signdetail s1=new signdetail();
			  s1.setE_email(rs.getNString(3));
			  s1.setE_id(rs.getInt(1));
			  s1.setE_name(rs.getString(2));
			  s.add(s1);
			 	}
			  closedb(); 
			 
		   }
		   catch(SQLException se){
			   se.printStackTrace();
		   }
		return s;
			   
		   }
	   
	   //employee sign_up
	   public String e_signup(int id,String e_name,String e_mail,String pass)
	 
	   {
		   	connect();
		   	System.out.print("came inside signup form");
		   	try {
		   		String sql;
		   		sql = "insert into sign_up values('"+id+"','"+e_name+"','"+e_mail+"','"+pass+"')";
			      stmt.executeUpdate(sql);
			      closedb();
		   	}catch(SQLException e)
		   	{
		   		e.printStackTrace();
		   	}
		   	return "Successfully created account ";
	   }
	   
	   
	   //employee log in 
	   public boolean e_login(int id,String pass)
	   {
		   connect();
		   System.out.println("Came inside login function in db");
		   boolean status=false;
		   try {
		   PreparedStatement ps=conn.prepareStatement( "select * from sign_up where emp_id=? COLLATE utf8_bin and password=? COLLATE utf8_bin");  
		    		  ps.setInt(1,id);  
		    		  ps.setString(2,pass);  
		    		        
		    		  ResultSet rs=ps.executeQuery();  
		    		  status=rs.next();  
		    		  closedb();
		   }
		   catch(SQLException se)
		   {
			   se.printStackTrace();
		   }
		    		  return status;   
	   }
	   
	   
	   //entering room_details
	   public String room_detail(String name,int capacity,boolean p_avail,boolean b_avail,String nearby,String location,boolean status)
	   {
		   connect();
		   System.out.println("entered db room_entering");
		   String str="Entered room detail";
		   try {
			   String sql;
		   		sql = "insert into room values('"+name+"','"+capacity+"','"+p_avail+"','"+b_avail+"','"+nearby+"','"+location+"','"+status+"')";
			      stmt.executeUpdate(sql);
			      closedb();
		   }
		   catch(SQLException e)
		   {
			   e.printStackTrace();
		   }
		   return str;
	   }
	   
	   
	   
	   //delete room based on name given
	   public String room_delete(String name)
	   {
		   connect();
		   System.out.println("entered deleting room detail");
		   String str="deleted";
		   try {
			   String sql_q;
			   sql_q="delete from room where room_name='"+name+"' ";
			   stmt.executeQuery(sql_q);
			   closedb();
		   }catch(SQLException se)
		   {
			   se.printStackTrace();
		   }
		   return str;
	   }
	  //display room which has projector
	 /*  public List<room_detail> room_search_p()
	   {
	   connect();
	   
	   }*/
	   
	   //displaying all room
	   public List<room_detail> room_search_all()
	   {
		   connect();
		   System.out.println("inside the db all room search functin");
		   try {
			   String sql="Select * from room";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				System.out.println("came inside while loop of room_search_all");
				room_detail r1= new room_detail();
				r1.setR_name(rs.getString(1));
				r1.setR_capacity(rs.getInt(2));
				r1.setP_avail(rs.getBoolean(3));
				r1.setB_avail(rs.getBoolean(4));
				r1.setR_nearby(rs.getString(5));
				r1.setR_loc(rs.getString(6));
				r1.setB_avail(rs.getBoolean(7));
				r.add(r1);
				
			}
			closedb();
		   }
		   catch(SQLException se){
			   se.printStackTrace();
		   }
		return r;
	   }
	   public List<room_detail> room_search_cap()
	   {
		  // connect();
		 //  room_search_all();
		   System.out.println("inseide function of search cap");
		   List<room_detail> li= new ArrayList<room_detail>();
		   room_detail ro= new room_detail();
		   System.out.println("list size"+r.size());
		   for(int i=0;i<r.size();i++)
		   {
			   System.out.println("inside loop of search cap");
			   ro=r.get(i);
			   if(ro.r_capacity==3)
			   {
				   System.out.println("there is a room with cap =3");
				   li.add(ro);
			   }
				   
		   }
		   //closedb();
		   return li;
	   }
	
}
