 <%@ page language="java" contentType="text/html; charset=gb2312"%>
<html>
    <head>
    </head>

    <body>
        <h1 style = "color:blue;text-align:center;font-size = 19px">Query Result For ${name}</h1>
        <div style="background-color:#EEEEEE;width:'100%';color:blue;font-size:16px;">
            <div style="float:left;width:28%; margin:20px 30px" >Available</div>
            <div style="float:left;width:28%; margin:20px 0px">Spended</div>
            <div style="float:left;width:28%; margin:20px 0px">BALANCE</div>
        </div>

        <div style="background-color:#EEEEEE;width:'100%';font-size:14px;">
            <div style="float:left;width:28%; margin:10px 30px" >${available}</div>
            <div style="float:left;width:28%; margin:10px 0px">${spended}</div>
            <div style="float:left;width:28%; margin:10px 0px">${balance}</div>
        </div>
    </body>
</html>