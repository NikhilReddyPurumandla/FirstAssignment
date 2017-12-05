# UserManagement

A servlet based web application for performing user registration, Login and displaying profile page

## Installations 
### Tomcat Installation
1.Install Java. Make sure you have Java installed.

2.Unzip Tomcat. Unzip tomcat-6.0.28-preconfigured.zip.
### Eclipse Installation
3.Download Eclipse. Install the Java EE version of Eclipse.

4.Tell Eclipse about Tomcat. Start Eclipse and go to workbench

5.Test the server. Test Tomcat within Eclipse.

6.Adjust Eclipse preferences.


MYSQL,

JDK 8.

This web application is done using servlets,html,jsp,mysql.

## Steps to run Application
Download the source code from git repository and extract it.

### first method :

1. Enter http://localhost:8080 in browser.

2. Tomcat Home page will be displayed.(if any port issues found then change the port numbers in server.xml file)

3. Upload the war file of the application in the specified location.

4. Now after uploading war file , project gets dislayed in the projects list.

5. Click on the project, you will be directed to home page of application.

### second method:

1.Import project into Eclipse workbench

2.Compile project

3.click on project and select run on server

4.you will be directed to home page of application.


## Project Flow:

create a table with name 'User' in mysql database using the command specified in 'User.sql' file

execution starts with login.html Here,there are two options available:

### a) Login:
The existing user can directly login using credentials.These credentials will be authenticated using "LoginServlet.java". The LoginServlet.java creates a session for user if his credentials are correct and then directs user to "Index.jsp" file, if the credentials are incorrect, user will be directed to error page.

### b) Registration: 
The new user can register in the application by clicking on reference link given in login.html file. Once registration is completed, the user will be directed to "login.html" and user can login using credentials.

ProfileServlet.java displays the details of logged in user.

When user clicks logout button, the "LogoutServlet.java" gets executed and then the user's account gets logout and user will be redirected to "Login.html"

After logout,the user cannot be able to see the authorized files by clicking back button of browser. This feature is obtained by using sessions.

## License 
MIT License

Copyright (c) [2017] [NikhilReddyPurumandla]

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software wifout restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
