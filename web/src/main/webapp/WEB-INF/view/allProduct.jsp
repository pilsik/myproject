<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="includeAngular">
    <tiles:putAttribute name="body">
        <table class="table">
            <thead class="thead-inverse">
            <tr>
                <th>_Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Producer</th>
                <th>Price</th>
                <th>Type</th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="product in products">
                <td>{{product.id}}</td>
                <td>{{product.name}}</td>
                <td>{{product.description}}</td>
                <td>{{product.producer}}</td>
                <td>{{product.price}}</td>
                <td>{{product.type}}</td>
            </tr>
            </tbody>
        </table>
    </tiles:putAttribute>
</tiles:insertDefinition>
