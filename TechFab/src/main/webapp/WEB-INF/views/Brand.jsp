  <%@ include file="header.jsp" %>

<h2>Brand</h2>
<div ng-app="app" ng-controller="myController" >

<div class="alert alert-info">
    <p>Search Query: {{ searchBrand }}</p>
    <input type="text" placeholder="Search the brand" ng-model="searchBrand">
    
  </div>

    <div class="container">
<form:form method="POST" modelAttribute="brand" action="addBrand">

        <div class="form-group row">
        <form:label  path="brandId" class="col-sm-2 col-form-label">Brand Id</form:label>
                      <div class="col-sm-10">
       <form:input type="hidden" path="brandId" class="form-control"/>
    </div>
    </div>
        
   
           <div class="form-group row">
<form:label path="brandName" class="col-sm-2 col-form-label">Brand Name</form:label>
                      <div class="col-sm-10">

        <form:input path="brandName" class="form-control" placeholder="Brand Name"/>
                 <form:errors path="brandName" class="form-control" id="inputError"></form:errors>
        </div>
    </div>
    
        
        <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
                  <input type="submit" value="addBrand" class="btn btn-primary"/>
      
      </div>
    </div>
        
         
</form:form>
</div>
 
<div class="table-responsive">

    <table class="table">  
    <caption>Brand List</caption>
    <thead class="thead-default">
     
        <th>brand Id</th>  
        <th>Brand Name</th>  
         <th>Brand Edit</th>         
         <th>Brand Delete</th>         
              </thead> 
    <tbody>
      <tr ng-repeat="blist in jsonData | orderBy:sortType:sortReverse | filter:searchBrand">  
  
            <td scope="row">{{blist.brandId}}</td>  
            <td>{{blist.brandName}}</td>  
            <td><a href="editBrand-{{blist.brandId}}" >Edit</a></td>  
           <td><a href="deleteBrand-{{blist.brandId}}">Delete</a></td> 
</tr>  
</tbody>
    </table> 
    </div>
    <script type="text/javascript">
    var app=angular.module('app',[]);
    app.controller("myController",function($scope){
    	$scope.sortType     = 'brandName';
    	  $scope.sortReverse  = false; 
    	  $scope.searchBrand   = ''; 
    	
    	$scope.jsonData=${brandList};
    });
    
    
    
    </script>
   
   


</div>
 <%@ include file="footer.jsp" %>

