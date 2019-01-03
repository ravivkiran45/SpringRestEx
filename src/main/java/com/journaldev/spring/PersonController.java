package com.journaldev.spring;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class PersonController {

	
	
	@RequestMapping("/")
	public String healthCheck() {
		return "OK";
	}
	
	@RequestMapping("/getBlogs")
	public String getBlogs() throws Exception {
		String personsJson = "[\n" + 
				"  {\n" + 
				"    \"id\": \"123\",\n" + 
				"    \"title\": \"Pizza Blog\",\n" + 
				"    \"short_desc\": \"Pizza  is very tasty\",\n" + 
				"    \"author\": \"KFC\",\n" + 
				"    \"image\": \"https://cdn.pixabay.com/photo/2014/04/22/02/56/pizza-329523__340.jpg\",\n" + 
				"    \"created_at\": \"12/20/2018, 5:20:50 AM\"\n" + 
				"  },\n" + 
				"{\n" + 
				"    \"id\": \"124\",\n" + 
				"    \"title\": \"Chicken Blog\",\n" + 
				"    \"short_desc\": \"Chicken   is very tasty\",\n" + 
				"    \"author\": \"Mc Dowell\",\n" + 
				"    \"image\": \"https://image.shutterstock.com/image-photo/barbecue-chicken-wings-close-on-260nw-374862373.jpg\",\n" + 
				"    \"created_at\": \"12/20/2018, 5:20:50 AM\"\n" + 
				"  }\n" + 
				"]";
		//throw new Exception();
		return personsJson;
	}
	
	@RequestMapping("/getCats")
	public String getCats() throws Exception {
		
		String catJson = "[\n" + 
				"  {\n" + 
				"    \"id\": 5,\n" + 
				"    \"name\": \"Technology\"\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 5,\n" + 
				"    \"name\": \"Design\"\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 5,\n" + 
				"    \"name\": \"Culture\"\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 5,\n" + 
				"    \"name\": \"Business\"\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 5,\n" + 
				"    \"name\": \"Politics\"\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 5,\n" + 
				"    \"name\": \"Opinion\"\n" + 
				"  }\n" + 
				"]";
					return catJson;
	}
	

	@RequestMapping("/getBlog")
	public String getBlog(@PathVariable("id") int id) throws Exception {			
		String response = "";		
		if(String.valueOf(id).equals("123"))
		{
			response = "  {\n" + 
					"    \"id\": \"123\",\n" + 
					"    \"title\": \"Pizza Blog\",\n" + 
					"    \"short_desc\": \"Pizza is very tasty\",\n" + 
					"    \"author\": \"KFC\",\n" + 
					"    \"image\": \"https://cdn.pixabay.com/photo/2014/04/22/02/56/pizza-329523__340.jpg\",\n" + 
					"    \"created_at\": \"12/20/2018, 5:20:50 AM\"\n" + 
					"  }";
		}
		
		else if(String.valueOf(id).equals("123"))
		{
			response = "{\n" + 
					"    \"id\": \"124\",\n" + 
					"    \"title\": \"Chicken Blog\",\n" + 
					"    \"short_desc\": \"Chicken is very tasty\",\n" + 
					"    \"author\": \"Mc Dowell\",\n" + 
					"    \"image\": \"https://image.shutterstock.com/image-photo/barbecue-chicken-wings-close-on-260nw-374862373.jpg\",\n" + 
					"    \"created_at\": \"12/20/2018, 5:20:50 AM\"\n" + 
					"  }";
		}
		
		return response;
		
	}
	
	@RequestMapping("/getcms")
	public String getCMSContent() throws Exception {
		
		String str = "{\n" + 
				"  \"id\": \"123\",\n" + 
				"  \"title\": \"Developer\",\n" + 
				"  \"description\": \"This is from Serve\"\n" + 
				"}";
		
		return str;
	}
	
	
	@RequestMapping(
		    value = "/postContact", 
		    method = RequestMethod.POST)
	public String postContact(@RequestBody Contact contact) throws Exception {
		
		System.out.println(contact.getEmail());
		System.out.println(contact.getMessage());
		
		return "123";
	}
	
	
	
	@RequestMapping("/getEmployees")
	public String getEmployees() throws Exception {
		String employeesJSON = "[{\n" + 
				"		\"id\": 1,\n" + 
				"		\"name\": \"Mark\",\n" + 
				"		\"gender\": \"Male\",\n" + 
				"		\"contactPreference\": \"Email\",\n" + 
				"		\"email\": \"mark@pragimtech.com\",\n" + 
				"		\"department\": \"IT\",\n" + 
				"		\"isActive\": true,\n" + 
				"		\"photoPath\": \"assets/images/mark.png\"\n" + 
				"	},\n" + 
				"	{\n" + 
				"		\"id\": 2,\n" + 
				"		\"name\": \"Mary\",\n" + 
				"		\"gender\": \"Female\",\n" + 
				"		\"contactPreference\": \"Phone\",\n" + 
				"		\"phoneNumber\": 2345978640,\n" + 
				"		\"department\": \"HR\",\n" + 
				"		\"isActive\": true,\n" + 
				"		\"photoPath\": \"assets/images/mary.png\"\n" + 
				"	}\n" + 
				"]";
		return employeesJSON.toString();
	}
	
	
	@RequestMapping("/fetchMeSomeValue")
	public String getEmplfetchMeSomeValueoyees() throws Exception {
		String fetchMeValue = "Sai";
		return fetchMeValue.toString();
	}
}
