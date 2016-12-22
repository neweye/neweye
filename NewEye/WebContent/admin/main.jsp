<meta charset="utf-8">
<%@ include file="header.jsp"%>
  <div id="wrap">
    <header>      
      <div id="logo">
        <a href="admin/main.jsp"> 
        <img src="../admin/images/bar_01.gif" style="float:left">
        <img src="../admin/images/text.gif">
        </a>
      </div>      
    </header>
    <div class="clear"></div>
    <article>
      <div id="loginform">
      <form name="frm" method="post" action="adminLogin.ne">
      <table>
        <tr>
          <td> ID </td>
          <td> <input type="text" name="workerId" size="10" value="admin"></td>
        </tr>
        <tr>
          <td> Password </td>
          <td> 
            <input type="password" name="workerPassword" size="10" value="admin">
          </td>
        </tr>
        <tr align="center" >
          <td  colspan="2">          
            <input class="btn" type="submit" value="admin login" onclick="return worker_check()"><br><br>
            <h4 style="color:red">${message}</h4>
          </td>
        </tr>
      </table>
      </form>
      </div>
  </div>
<%@ include file="footer.jsp"%>
</body>
</html>