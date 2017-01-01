  <%@ include file="header.jsp" %>

<h2>Supplier</h2>
<div ng-app="app" ng-controller="myController" >
<div class="alert alert-info">
    <p>Search Supplier: {{ searchSupplier}}</p>
    <input type="text" placeholder="Search the supplier" ng-model="searchSupplier">
    
  </div>

    <div class="container">
<form:form method="POST" modelAttribute="supplier" action="addSupplier">
  
          <div class="form-group row">
        <form:label  path="supplierId" class="col-sm-2 col-form-label">Supplier Id</form:label>
                      <div class="col-sm-10">
        <form:input type="hidden" path="supplierId" class="form-control"/>
        </div>
    </div>
        
    
   
   
             <div class="form-group row">
        <form:label path="supplierName" class="col-sm-2 col-form-label">Supplier Name</form:label>
                              <div class="col-sm-10">
        
        <form:input path="supplierName" class="form-control" placeholder="Supplier Name"/>
               <form:errors path="supplierName" class="form-control" id="inputError"></form:errors>
               </div>
    </div>
        
                     <div class="form-group row">
        
        <form:label path="supplierAddress" class="col-sm-2 col-form-label">Supplier Address</form:label>
                                      <div class="col-sm-10">
        
        <form:input path="supplierAddress" class="form-control" placeholder="Supplier Address" />
         <form:errors path="supplierAddress" class="form-control" id="inputError"></form:errors>
         </div>
    </div>
         
         
                             <div class="form-group row">
        
        <form:label path="supplierContact" class="col-sm-2 col-form-label">Supplier Contact</form:label>
                                              <div class="col-sm-10">
        
        <form:input path="supplierContact" class="form-control" placeholder="Supplier contact"/>
         <form:errors path="supplierContact" class="form-control" id="inputError"></form:errors>
</div>
    </div>
         
 
 <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
                  <input type="submit" value="addSupplier" class="btn btn-primary"/>
      
      </div>
    </div>
         
</form:form>
</div>

<div class="table-responsive">
    <table class="table">  
    <caption>Supplier List</caption>
    <thead class="thead-default">
     
        <th>Supplier Id</th>  
        <th>Supplier Name</th>  
        <th>Supplier Address</th> 
        <th>Supplier Contact</th> 
         
        <th>Edit supplier</th>  
        <th>Delete supplier</th>  
    </thead>    
         
  <tbody>
      <tr ng-repeat="slist in jsonData | orderBy:sortType:sortReverse | filter:searchSupplier">  
            <td>{{slist.supplierId}}</td>  
            <td>{{slist.supplierName}}</td>  
            <td>{{slist.supplierAddress}}</td>  
             <td>{{slist.supplierContact}}</td>  
            
            <td><a href="editSupplier-{{slist.supplierId}}" >Edit</a></td>  
           <td><a href="deleteSupplier-{{slist.supplierId}}">Delete</a></td> 
</tr>  
</tbody>
    </table>
    </div> 
   <script type="text/javascript">
    var app=angular.module('app',[]);
    app.controller("myController",function($scope){
    	$scope.sortType     = 'supplierName';
  	  $scope.sortReverse  = false; 
  	  $scope.searchSupplier   = ''; 
  	
    	$scope.jsonData=${supplierList};
    });
    
    
    
    </script>
   
   
    
   </div>
   <%@ include file="footer.jsp" %>
  