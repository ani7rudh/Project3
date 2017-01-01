  <%@ include file="header.jsp" %>

<h2>SubCategory</h2>
<br>
<div ng-app="app" ng-controller="myController" >

<div class="alert alert-info">
    <p>Search Subcategory: {{ searchSubCategory }}</p>
    <input type="text" placeholder="Search the category" ng-model="searchSubCategory">
    
  </div>
  
    <div class="container">
        <form:form modelAttribute="subCategory" action="addSubCategory">
        
                <div class="form-group row">
        <form:label  path="subCategoryId" class="col-sm-2 col-form-label"> SubCategory Id </form:label>
                      <div class="col-sm-10">
        <form:input path="subCategoryId" type="hidden" class="form-control"/>
        </div>
    </div>
        
                        <div class="form-group row">
        <form:label path="subCategoryName" class="col-sm-2 col-form-label">SubCategory Name</form:label>
                              <div class="col-sm-10">
        <form:input path="subCategoryName" class="form-control" placeholder="SubCategory Name"/>
         <form:errors path="subCategoryName" class="form-control" id="inputError"></form:errors>
         </div>
    </div>
       
                                <div class="form-group row">
       <form:label path="subCategoryDescription" class="col-sm-2 col-form-label">SubCategory Description</form:label>
                                     <div class="col-sm-10">
        <form:input path="subCategoryDescription" class="form-control" placeholder="SubCategory Description"/>
        <form:errors path="subCategoryDescription" class="form-control" id="inputError"></form:errors>
        </div>
    </div>
       
        
        <form:select path="category.categoryName" items="${categoryList}" itemValue="categoryName" itemLabel="categoryName" class="form-control"></form:select>
      <br><br>
          <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
                  <input type="submit" value="addSubcategory" class="btn btn-primary"/>
      
      </div>
    </div>
          
        
        </form:form>
        </div>
        
       <div class="table-responsive">
    <table  class="table">  
        <caption>SubCategory List</caption>
        <thead class="thead-default">
    
        <th>subcategory Id</th>  
        <th>subCategory Name</th>  
        <th>subcategory description</th>  
        <th>Edit subcategory</th>  
        <th>Delete subcategory</th>  
       </thead>
        
               <tbody>
        <tr ng-repeat="sclist in jsonData | orderBy:sortType:sortReverse | filter:searchSubCategory">  
            <td scope="row">{{sclist.subCategoryId}}</td>  
            <td>{{sclist.subCategoryName}}</td>  
            <td>{{sclist.subCategoryDescription}}</td>  
            <td><a href="editSubCategory-{{sclist.subCategoryId}}" >Edit</a></td>  
           <td><a href="deleteSubCategory-{{sclist.subCategoryId}}">Delete</a></td> 
</tr>  
</tbody>
    
        </table>
        </div>
    
    <script type="text/javascript">
    var app=angular.module('app',[]);
    app.controller("myController",function($scope){
    	$scope.sortType     = 'subCategoryName';
  	  $scope.sortReverse  = false; 
  	  $scope.searchSubCategory   = ''; 
  	
    	$scope.jsonData=${subCategoryList};
    });
    
    </script>
    
    
    
           </div> 
   
  <%@ include file="footer.jsp" %>
 