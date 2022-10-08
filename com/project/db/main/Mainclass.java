package com.project.db.main;

import java.util.List;
import java.util.Scanner;

import com.project.db.dao.Customerdao;
import com.project.db.dao.Locationdao;
import com.project.db.model.Customer;
import com.project.db.model.Location;

public class Mainclass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Customerdao  custdao = new Customerdao();
		Locationdao locdao = new Locationdao();
		
		int id;
		String fname;
		String lname;
		int phoneno;
		String location;
		
		
		String picklocation;
		String droplocation;
		String date;
		String time;
		int custid;
		
		int choice;
	  while(true) {
		  System.out.println("1. Create your Account");
		  System.out.println("2. Login and Booking");
		  System.out.println("3. Display All Record");
		  System.out.println("4. Exit");
		  
		  choice =sc.nextInt();
		  Customer cust;
		if (choice == 4)
			  break;
		  else 
		  switch (choice){
		  case 1 :  System.out.println("Enter Id : ");
                    id = sc.nextInt();
                    System.out.print("Enter Fname : ");
		            fname = sc.next();
		            System.out.print("Enter Lname : ");
		            lname = sc.next();
		            System.out.print("Enter Phoneno : ");
		            phoneno = sc.nextInt();
		            System.out.print("Enter Location : ");
		            location = sc.next();
		            boolean result = custdao.insertRecord(id, fname, lname, phoneno, location);
					   if(result)
							System.out.println(" Record Inserted Successfully...!!");
						else
							System.out.println("Record Not Inserted..!!");
			                     break;
		  case 2 : 	System.out.println("Enter the Id : ");
                          id = sc.nextInt();
	                      cust = custdao.loginbyid(id);
	                      if(cust.getId() != 0)
	                            System.out.println(cust);
	                      System.out.println("Welcome to Zapto Cab Reservation");
	                      System.out.println("1. Reserve the Cab");
	   	 		          System.out.println("2. Update Reservation");
	   	 		          System.out.println("3. Delete Reservation");
	   	 		          System.out.println("4. Booking Detail");
	   	 		     int booking = sc.nextInt();
		 		       switch (booking) {
		 		 	          case 1: System.out.println("Reserve the Cab"); 
		 		 	                  System.out.println("Enter Id : ");
		                              id = sc.nextInt();
		                              System.out.print("Enter Pickup Location : ");
				                      picklocation = sc.next();
				                      System.out.print("Enter Drop Location : ");
				                      droplocation = sc.next();
				                      System.out.print("Enter Date : ");
				                      date = sc.next();
				                      System.out.print("Enter Time : ");
				                      time = sc.next();
				                      System.out.print("Enter Customer Id : ");
				                      custid = sc.nextInt();
				                      boolean result1 = locdao.insertRecord(id, picklocation, droplocation, date, time, custid);
									   if(result1)
											System.out.println(" Record Inserted Successfully...!!");
										else
											System.out.println("Record Not Inserted..!!");
		 		 		         break;
		 		 	         case 2: System.out.print("Enter the ID of the student:");
		 		 		       id = sc.nextInt();
		 		 		       Location loc = locdao.searchbyid(id);
		 		 		       System.out.println("What do you want to update?");
		 		 		       System.out.println("1. Pickup Location");
		 		 		       System.out.println("2. Drop Location");
		 		 		       System.out.println("3. Date");
		 		 		       System.out.println("4. Time");
		 		 		       int update = sc.nextInt();
		 		 		       switch (update) {
		 		 		 	         case 1: System.out.println("Enter New Pickup Location :");
		 		 		 			         picklocation = sc.next();
		 		 		 			         loc.setPicklocation(picklocation);				 		 	
		 		 		 		         break;
		 		 		 	         case 2: System.out.println("Enter New Drop Location :");
		 		 					         droplocation = sc.next();
		 		 					         loc.setDroplocation(droplocation);				 		 		
		 		 		 		         break;
		 		 		 	         case 3: System.out.println("Enter New Date :");
		 		 					         date = sc.next();
		 		 					         loc.setDate(date);
		 		 		 		         break;
		 		 		 	        case 4: System.out.println("Enter New Date :");
		 					                 time = sc.next();
		 					                 loc.setTime(time);
		 		 		                 break;
		 		 		        }
		 			 		    result = locdao.updateRecord(loc);
		 					       if(result)
		 						        System.out.println("Updated Successfully");
		 					       else
		 						       System.out.println("Not Updated");			 		 		
		 		 		         break;
		 		 	         case 3:System.out.print("Enter the ID :");
		 		 		            id = sc.nextInt();	
		 		 		            result = locdao.deleteRecord(id);
		 				            if(result)
		 					              System.out.println("Deleted Successfully");
		 				            else
		 					              System.out.println("Not Deleted");
		 		 		         break;
		 		 	         case 4:List<Location> locations = locdao.getAllRecods();
                                    for(Location loc1: locations) {
                                          System.out.println(loc1);
                                    } 
		 		 	        	 break;
		 		       }
				 break;
		  case 3 : List<Customer> customer = custdao.getAllRecods();
                      for(Customer ct : customer) {
                            System.out.println(ct);
                             }
			  break;
	      default : 
	                break;
			
		}
	  }
	}
}