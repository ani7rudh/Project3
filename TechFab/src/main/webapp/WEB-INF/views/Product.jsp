
  <%@ include file="header.jsp" %>
  
<h2>product</h2>
<div ng-app="app" ng-controller="myController" >
<div class="alert alert-info">
    <p>Search Product: {{ searchProduct }}</p>
    <input type="text" placeholder="Search the product" ng-model="searchProduct">
    
  </div>

    <div class="container">

 <form:form method="POST" modelAttribute="product" action="addProduct" enctype="multipart/form-data">
 
        <div class="form-group row">
        <form:label  path="productId" class="col-sm-2 col-form-label">Product Id</form:label>
                      <div class="col-sm-10">
        
        <form:input type="hidden" path="productId" class="form-control"/>
        </div>
        </div>
   
   
   
            <div class="form-group row">
        <form:label path="productName" class="col-sm-2 col-form-label">Product Name</form:label>
                              <div class="col-sm-10">
        <form:input path="productName" class="form-control" placeholder="Product Name"/>
        <form:errors path="productName" class="form-control" id="inputError"></form:errors>
        </div>
        </div>
        
        
                    <div class="form-group row">
        
        <form:label path="productDescription" class="col-sm-2 col-form-label">product Description</form:label>
                                      <div class="col-sm-10">
        <form:input path="productDescription" class="form-control" placeholder="Product Description"/>
        <form:errors path="productDescription" class="form-control" id="inputError"></form:errors>
        </div>
        </div>
    
    
                        <div class="form-group row">
    
    <form:label path="productQuantity" class="col-sm-2 col-form-label">product Quantity</form:label>
                                          <div class="col-sm-10">
    
        <form:input path="productQuantity" class="form-control" placeholder="Product Quantity"/>
     </div>
        </div>
    
                            <div class="form-group row">
        <form:label path="productPrice" class="col-sm-2 col-form-label">product price</form:label>
                          <div class="col-sm-10">
        <form:input path="productPrice" class="form-control"/>
        </div>
        </div>
    
    
                                <div class="form-group row">
       <form:label path="productDiscount" class="col-sm-2 col-form-label">product discount</form:label>
                                 <div class="col-sm-10">
       <form:input path="productDiscount" class="form-control"/>
    </div>
        </div>
    
    
                                <div class="form-group row">
    <form:label path="productImage" class="col-sm-2 col-form-label">product Image</form:label>
                                     <div class="col-sm-10">
    <label class="custom-file">
    
    <form:input path="productImage" type="file" name="file" class="custom-file-input"></form:input>
    <span class="custom-file-control"></span>
    </label>
</div></div>

    <form:select path="category.categoryName" items="${categoryList}" itemValue="categoryName" itemLabel="categoryName" name="Category" class="form-control"  ></form:select>
    
    <form:select path="subCategory.subCategoryName" items="${subCategoryList}" itemValue="subCategoryName" itemLabel="subCategoryName" name="Subcategory" class="form-control" ></form:select>
    
    <form:select path="brand.brandName" items="${brandList}" itemValue="brandName" itemLabel="brandName" name="Brand" class="form-control" ></form:select>
    
    <form:select path="supplier.supplierName" items="${supplierList}" itemValue="supplierName" itemLabel="supplierName" name="Supplier" class="form-control" ></form:select>
    
    
    <br><br>
             <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
                  <input type="submit" value="addProduct" class="btn btn-primary"/>
      
      </div>
    </div>
      
        
    
 
</form:form>
</div>



<div class="table-responsive">
    <table class="table">  
    <caption>Product List</caption>
    <thead class="thead-default">

        <th>product Id</th>  
        <th>Product Name</th>  
        <th>product description</th>  
        <th>product quantity</th>  
        <th>product price</th>  
        <th>product discount</th>  
        
        <th>Edit product</th>  
        <th>Delete product</th>  
    </thead>    
         <tbody>
     
        <tr ng-repeat="plist in jsonData | orderBy:sortType:sortReverse | filter:searchProduct">  
            <td scope="row">{{plist.productId}}</td>  
            <td>{{plist.productName}}</td>  
            <td>{{plist.productDescription}}</td>  
            <td>{{plist.productQuantity}}</td>  
            <td>{{plist.productPrice}}</td>  
            <td>{{plist.productDiscount}}</td>  
            
            <td><a href="editProduct-{{plist.productId}}" >Edit</a></td>  
           <td><a href="deleteProduct-{{plist.productId}}">Delete</a></td> 
</tr>  
</tbody>
    </table> 
    </div>
    
    <script type="text/javascript">
    var app=angular.module('app',[]);
    app.controller("myController",function($scope){
    	$scope.sortType     = 'productName';
  	  $scope.sortReverse  = false; 
  	  $scope.searchProduct  = ''; 
    	$scope.jsonData=${productList};
    });
    
    </script>
   
    
   
</div>

 <%@ include file="footer.jsp" %>

