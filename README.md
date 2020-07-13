# tinyUrlCreatorWebService
**Web Service which converts website urls to tiny/deeplink urls.**

This project aims to convert Trendyol website urls to deeplink urls by using specific format.

-Application works locally and accepts request format as a JSON(application/json) in a request body.
**Http Method : POST
Endpoint : http://localhost:8080 
Type : application/json**

Result will be a json formatted data.
EXP (via Postman):

Request : 

{         	    	
          	"webURL":"https://www.trendyol.com/avva/erkek-beyaz-polo-yaka-duz-t-shirt-a01b1175-p-42427628?boutiqueId=512009&merchantId=107671"     	
}
Response: 
          
{
             "deeplink": "ty://?Page=Product&ContentId=42427628&CampaignId=42427628&MercantId=107671"
}

The result will be saved in PostgreSQL Tables. Database designed as a followinG format : 

-4 Main Requst-Response Tables for each type of request:
* Home Page Table (home_page_request_response_record)
* Product Page Table (product_page_request_response_record)
* Search Page Table (search_page_request_response_record)
* Other Request Page Table (other_page_request_response_record)

Each of them have following columns
id / request / response /timestamp


-3 Details table for following categories for save parsed data of request to use for further software development activities.(for example analyzing most searched query etc. -For this feature elasticSearch can be integrated to project in the future release)  
* Home Page Table (product_page)
Columns : id / section_name /weburl
* Product Page Table (search_page)
Columns : id / brand_name / butiqueid /contentid / domain/ mercantid / product_name /weburl
* Search Page Table (product_page)
Columns : id / query /weburl

NOTE: In database design normalization steps are not included because requirements are not clear about brand_name / butiqueid /contentid / domain/ mercantid / product_name etc. 
In a correct design, all entities should have their own table and connected each other by using relationships (fn/pk) and join tables and it should be optimized by Normalization steps.


---Technology Stack---

Java / Spring Framework(Boot-MVC)
Hibernate / Spring Data JPA
Maven 
Tomcat
JUnit / Mockito

----- DATABASE ------- 
PostgreSQL

Connetion information: 
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/test
spring.datasource.username=postgres
spring.datasource.password=postgres


--------------------
Request and Response behaviours are system are test via Postman & Junit tests in different conditions:
 
These Example Cases of test result in POSTMAN:
 
 Case1 : 
 
 NOTE: For homepage url conversion it accepts valid url which consists of English letters.
 In requirements it is not clarified, request will be consist of Turkish or English characters.
 If Turkish or any other language character is required it can be easily converted and externalized by internalization classes.
 
  exp 1.1:
   => Request:
 {
 	"webURL":"https://www.trendyol.com/butik/liste/kadin"
 }
   
   Response:
  {
      "deeplink": "ty://?Page=Home&SectionId=1"
  }
  
  exp 1.2:
  => Request:
 {	
 	"webURL":"https://www.trendyol.com/butik/liste/erkek"	
 }
  
  Response:
 {
     "deeplink": "ty://?Page=Home&SectionId=2"
 }
 
  exp 1.3:
   => Request:
  {
  	"webURL":"https://www.trendyol.com/butik/liste/supermarket"
  }
   
   Response:
  {
      "deeplink": "ty://?Page=Home&SectionId=3"
  }
  
  exp 1.4:
   => Request:
 {	
 	"webURL":"https://www.trendyol.com/butik/liste/cocuk"	
 }
   
   Response:
  {
      "deeplink": "ty://?Page=Home&SectionId=4"
  }
 
 Case 2 : Product Requests
 exp 2.1:
 => Request:
 {	
 	"webURL":"https://www.trendyol.com/avva/erkek-beyaz-polo-yaka-duz-t-shirt-a01b1175-p-42427628?boutiqueId=512009&merchantId=107671"	
 }
 
 Response:
 {
     "deeplink": "ty://?Page=Product&ContentId=42427628&CampaignId=42427628&MercantId=107671"
 }
 
 exp 2.2 :
  => Request:
 {
 	"webURL":"https://www.trendyol.com/avva/erkek-beyaz-polo-yaka-duz-t-shir175-p-42427628?&merchantId=107671"
 }
  
  Response:
  {
      "deeplink": "ty://?Page=Product&ContentId=42427628&MercantId=107671"
  }
  
   exp 2.3 :
   => Request:
   {
   	"webURL":"https://www.trendyol.com/avva/erkek-beyaz-polo-yaka-duz-t-shir175-p-42427628"
   }
   
   Response:
  {
      "deeplink": "ty://?Page=Product&ContentId=42427628"
  }
   
 
  Case 3 : Search Requests
  exp 3.1 :
  Request:
 {
 	"webURL":"https://www.trendyol.com/tum-urunler?q=elbise"
 }
  
  Response:
  {
      "deeplink": "ty://?Page=Search&Query=elbise"
  }
  
   Case 4 : Other Requests
   
   exp 4.1 :
   Request:
  {
  	"webURL":"https://www.trendyol.com/xxxxxx"
  }
  
   Response:
 {
     "deeplink": "ty://?Page=Home"
 }
 
  exp 4.2 :
    Request:
   {
   	"webURL":"https://www.trendyol.com"
   }
   
   Response:
  {
      "deeplink": "ty://?Page=Home"
  }