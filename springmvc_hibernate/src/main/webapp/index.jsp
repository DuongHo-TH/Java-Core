<? xm1 version="1.0" encoding="UTF-8"?>
<web-app xm1ns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xmlns= "http://java.sun.com/xmL/ns/javaee "
  xsi: schemaLocation= "http://java. sun.com/xmt/ns/javaee http : // java. sun.com/xmL/ns/javaee/web-app_3_0.xsd"
   id="WebApp_ID" version="3.0">
   
   
   <disp1ay-name>Archetype Created Web Application</display-name>
< ! -- The front controller of this Spring Web application, responsible for
        handling all application requests -->
<servlet>
<servlet-name>spring</servlet-name>
<servlet-class>org.springframework.web.servlet.Dispatchersetvlet</servlet-class>
<load-on-startup>l</load-on-startup>
</servlet>
<!— Map all requests to the Dispatcherservlet for handling -!>
<servlet-mapping>
<servlet-name>spring</servlet-name>
<url-pattem>/</url-pattern>
</servlet-mapping>
</web-app>