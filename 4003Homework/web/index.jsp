<%--
 * Copyright (c) 2002 Sun Microsystems, Inc.  All rights reserved.  U.S. 
 * Government Rights - Commercial software.  Government users are subject 
 * to the Sun Microsystems, Inc. standard license agreement and 
 * applicable provisions of the FAR and its supplements.  Use is subject 
 * to license terms.  
 * 
 * This distribution may include materials developed by third parties. 
 * Sun, Sun Microsystems, the Sun logo, Java and J2EE are trademarks 
 * or registered trademarks of Sun Microsystems, Inc. in the U.S. and 
 * other countries.  
 * 
 * Copyright (c) 2002 Sun Microsystems, Inc. Tous droits reserves.
 * 
 * Droits du gouvernement americain, utilisateurs gouvernementaux - logiciel
 * commercial. Les utilisateurs gouvernementaux sont soumis au contrat de 
 * licence standard de Sun Microsystems, Inc., ainsi qu'aux dispositions 
 * en vigueur de la FAR (Federal Acquisition Regulations) et des 
 * supplements a celles-ci.  Distribue par des licences qui en 
 * restreignent l'utilisation.
 * 
 * Cette distribution peut comprendre des composants developpes par des 
 * tierces parties. Sun, Sun Microsystems, le logo Sun, Java et J2EE 
 * sont des marques de fabrique ou des marques deposees de Sun 
 * Microsystems, Inc. aux Etats-Unis et dans d'autres pays.
 *'
--%>
<%------------------ commented out for now ---------------------------
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
---------------------------------------------------------------------%>
<html>
    <head>
        <title>Hello</title>
        <meta http-equiv="Content-Style-Text" content="text/html" charset=iso-8859-1">
    </head>
    <body>
        
        <img src="duke.waving.gif"> 
        <h2>Hello, my name is Duke.</h2> 
        <h2>My hobby is Golf.</h2>
        <h2>My birthplace is Sun Micosystems.</h2>
        
        <form method="get">
            <h2>Your name? <input type="text" name="username" size="25"></h2>
            <p></p>    
            <h2>Your hobby? <input type="text" name="hobby" size="25"></h2>    
            <p></p>
            <h2>Your birthplace? <input type="text" name="birthplace" size="25"></h2>    
            <p></p>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </form>

        <%
            String username = request.getParameter("username");
            if ( username != null && username.length() > 0 ) {
        %>
        
        <jsp:forward page = "/middle.jsp">
            <jsp:param name="myparam" value="Passion!"></jsp:param>
        </jsp:forward>
        <%
                }
        %>
        
        <%------------ commented out for now ------------
        <c:if test="${fn:length(param.username) > 0}" >
            <%@include file="response.jsp" %>
        </c:if>
        -------------------------------------------------%>
    </body>
</html>
