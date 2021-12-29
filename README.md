

# Weather Info Service
	  A simple RESTful application for collecting wether information.

## Used Libraries

 * Java : version  - 11
 * Spring boot : version - 2.5.2
 * Springfox swagger : version  - 3.0.0
 * Spring boot web : version  - 2.6.2
 * Spring boot security : version  - 2.6.2
 * Log4j2 : version  - 2.15.0
 * Google Gson : version  - 2.8.5
 * Jspyt : version  - 3.0.4
 * Apache http client : version  - 4.5.6
 * Mssql connector : version  - 9.4.1.jre8
 * Jpa : version  - 2.6.2
 * Spring boot valdation : version  - 2.6.1
 * Spring boot redis : version  - 2.6.1
 * Spring boot cache : version  - 2.4.0

## Repository contains:-

* Application Source code
* Postman script
* Redis server package

## Steps to run applications

* Install JDK 11 or latest. 
* Install Microsoft® SQL Server® 2017
* Clone the Project repository into local. 
* Create a database with following name
	* weather_service
* Create database user with following details
	* username : testuser
	* password : testuser@123
	* Please map this user with "weather_service" named db and provide read,write and ddladmin privilages.
* Extract the redis server zip files and run the redis erver.
	* Double click the "redis-server.exe" named file to run the redis server.
* To run the application , open a cmd window under application build folder
	* weather-info-service\target
	* Execute the following command 
		* command - "java -jar weatherService.jar"
* Up on successful application running, the required tables will be created automatically.
* To access the application APIs please open the swagger api doc UI using following URL.
  * http://localhost:8000/weatherService/apidoc
  * Postman script also awaitable in this repository
* To access the weather APIs please create a user using user registration API.


License
-------

    MIT License

    Copyright (c) 2021 Vishnu Viswambharan

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.

