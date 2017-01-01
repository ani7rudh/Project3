  <%@ include file="header.jsp" %>

         	  <div class="wrap">	
         	  <br><br>

    <form method="POST"  action="perform_login">

<div class="form-group row">
        <label name="userName" class="col-sm-2 col-form-label">user Name</label>
              <div class="col-sm-10">
        <input name="userName" class="form-control" placeholder="User Name"/>
              </div>
              </div>
    
  
  <div class="form-group row">
        <label name="password" class="col-sm-2 col-form-label">Password</label>
              <div class="col-sm-10">
        <input name="password" type="password" class="form-control" placeholder="Password"/>
              </div>
              </div>
  
  
  
   <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
                  <input type="submit" value="Login" class="btn btn-primary"/>
                  
                  
      
      </div>
    </div>
  
  </form>
  
  
  </div>
   <%@ include file="footer.jsp" %>
  