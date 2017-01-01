  <%@ include file="header.jsp" %>
   
  
  <div align="center"><h2>Registration</h2></div>
  
<!--       <div class="container"> -->
         	  <div class="wrap">	
      
  
    <form:form method="POST" modelAttribute="userDetails" action="addUserDetails">
  
  <div class="form-group row">
        <form:label  path="userId" class="col-sm-2 col-form-label">User Id</form:label>
              <div class="col-sm-10">
        <form:input type="hidden" path="userId" class="form-control"/>
        </div>
    </div>
  
  
  <div class="form-group row">
        <form:label path="userName" class="col-sm-2 col-form-label">user Name</form:label>
              <div class="col-sm-10">
        <form:input path="userName" class="form-control" placeholder="User Name"/>
              </div>
              </div>
    
  
  <div class="form-group row">
        <form:label path="password" class="col-sm-2 col-form-label">Password</form:label>
              <div class="col-sm-10">
        <form:input path="password" type="password" class="form-control" placeholder="Password"/>
              </div>
              </div>
  
  
  <div class="form-group row">
        <form:label path="fname" class="col-sm-2 col-form-label">First Name</form:label>
              <div class="col-sm-10">
        <form:input path="fname" class="form-control" placeholder="first Name"/>
              </div>
              </div>
  
  
  <div class="form-group row">
        <form:label path="lname" class="col-sm-2 col-form-label">last Name</form:label>
              <div class="col-sm-10">
        <form:input path="lname" class="form-control" placeholder="last Name"/>
              </div>
              </div>
  
  
  <div class="form-group row">
        <form:label path="contact" class="col-sm-2 col-form-label">contact</form:label>
              <div class="col-sm-10">
        <form:input path="contact" class="form-control" placeholder="contact"/>
              </div>
              </div>
  
  
  <div class="form-group row">
        <form:label path="email" class="col-sm-2 col-form-label">email</form:label>
              <div class="col-sm-10">
        <form:input path="email" type="email" class="form-control" placeholder="email"/>
              </div>
              </div>
           
           
                        <div align="center"> <h2>Billing Address</h2>   </div>
              
              
     
     <div class="form-group row">
        <form:label path="billingAddress.streetAddress" class="col-sm-2 col-form-label">Street Address</form:label>
              <div class="col-sm-10">
        <form:input path="billingAddress.streetAddress"  class="form-control" placeholder="Street Address"/>
              </div>
              </div>
           
              
       <div class="form-group row">
        <form:label path="billingAddress.flatNo" class="col-sm-2 col-form-label">FlatNO</form:label>
              <div class="col-sm-10">
        <form:input path="billingAddress.flatNo"  class="form-control" placeholder="Flatno"/>
              </div>
              </div>
            
              
              
        <div class="form-group row">
        <form:label path="billingAddress.city" class="col-sm-2 col-form-label">city</form:label>
              <div class="col-sm-10">
        <form:input path="billingAddress.city"  class="form-control" placeholder="city"/>
              </div>
              </div>
             
              
              <div class="form-group row">
        <form:label path="billingAddress.state" class="col-sm-2 col-form-label">State</form:label>
              <div class="col-sm-10">
        <form:input path="billingAddress.state"  class="form-control" placeholder="State"/>
              </div>
              </div>
              
              
              
              
              <div class="form-group row">
        <form:label path="billingAddress.postalCode" class="col-sm-2 col-form-label">postal code</form:label>
              <div class="col-sm-10">
        <form:input path="billingAddress.postalCode"  class="form-control" placeholder="postal code"/>
              </div>
              </div>
              
              
              
                        <div align="center"> <h2>Shipping Address</h2>   </div>
              
              
              
               <div class="form-group row">
        <form:label path="shippingAddress.streetAddress" class="col-sm-2 col-form-label">Street Address</form:label>
              <div class="col-sm-10">
        <form:input path="shippingAddress.streetAddress"  class="form-control" placeholder="Street Address"/>
              </div>
              </div>
           
              
       <div class="form-group row">
        <form:label path="shippingAddress.flatNo" class="col-sm-2 col-form-label">FlatNO</form:label>
              <div class="col-sm-10">
        <form:input path="shippingAddress.flatNo"  class="form-control" placeholder="Flatno"/>
              </div>
              </div>
            
              
              
        <div class="form-group row">
        <form:label path="shippingAddress.city" class="col-sm-2 col-form-label">city</form:label>
              <div class="col-sm-10">
        <form:input path="shippingAddress.city"  class="form-control" placeholder="city"/>
              </div>
              </div>
             
              
              <div class="form-group row">
        <form:label path="shippingAddress.state" class="col-sm-2 col-form-label">State</form:label>
              <div class="col-sm-10">
        <form:input path="shippingAddress.state"  class="form-control" placeholder="State"/>
              </div>
              </div>
              
              
              
              
              <div class="form-group row">
        <form:label path="shippingAddress.postalCode" class="col-sm-2 col-form-label">postal code</form:label>
              <div class="col-sm-10">
        <form:input path="shippingAddress.postalCode"  class="form-control" placeholder="postal code"/>
              </div>
              </div>
    
              
       
       
              
              
              
              
              
              
              
              
              
              
              
               <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
                  <input type="submit" value="addUserDetails" class="btn btn-primary"/>
      
      </div>
    </div>
    
    </form:form>
    
  </div>
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    </div>
      
              
              
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 <%@ include file="footer.jsp" %>
  