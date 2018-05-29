<html>
<#include "../common/header.ftl">
<body>

<div class="container">
    <div class="row clearfix-fluid">
        <div id="wrapper" class="toggled">
            <#include "../common/nav.ftl">
            <div id="page-content-wrapper">
        <div class="col-md-12 column">
            <table class="table table-condensed table-bordered table-hover">
                <thead>
                <tr>
                    <th>类目id</th>
                    <th>名字</th>
                    <th>type</th>
                    <th>创建时间</th>
                    <th>修改时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list productCategoryList as categorylist>
                <tr>
                    <td>${categorylist.categoryId}</td>
                    <td>${categorylist.categoryName}</td>
                    <td>${categorylist.categoryType}</td>
                    <td>${categorylist.createTime}</td>
                    <td>${categorylist.updateTime}</td>
                    <td>
                        <a href="/sell/seller/category/index?categoryId=${categorylist.categoryId}&&categoryType=${categorylist.categoryType}">修改</a>
                    </td>
                </tr>
                </#list>

                </tbody>
            </table>
        </div>
        </div>
        </div>
    </div>
</div>

</body>
</html>