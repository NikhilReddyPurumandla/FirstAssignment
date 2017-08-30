# FirstAssignment
An assignment for creating a sample webapplication

Prerequisites: EclipseIDE for j2EE, MYSQL, JDK 8.

This web application is done using servlets,html,jsp,mysql.

Execution Flow:

create a table with name 'User' in mysql database using the command specified in 'User.sql' file

execution starts with login.html Here,there are two options available:

a) Login: The existing user can directly login using credentials.These credentials will be authenticated using "LoginServlet.java". The LoginServlet.java creates a session for user if his credentials are correct and then directs user to "Index.jsp" file, if the credentials are incorrect, user will be directed to error page.

b) Registration: The new user can register in the application by clicking on reference link given in login.html file. Once registration is completed, the user will be directed to "login.html" and user can login using credentials.

ProfileServlet.java displays the details of logged in user.

When user clicks logout button, the "LogoutServlet.java" gets executed and then the user's account gets logout and user will be redirected to "Login.html"

After logout,the user cannot be able to see the authorized files by clicking back button of browser. This feature is obtained by using sessions.
