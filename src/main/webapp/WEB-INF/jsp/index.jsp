<%-- 
    Document   : index
    Created on : 12.09.2015, 11:59:01
    Author     : Vadim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>${page.description}</title>
        <!--<link href="../resources/css/style.css" type="text/css" rel="stylesheet">-->
        <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>  
    </head>
    <body>
        <div id="descr">
            <p>
                <h1>description:</h1>
                ${page.description}
            </p>
        </div>
    <div id="content">
        <p>${page.content}</p>
    </div>
    
    </body>
</html>
