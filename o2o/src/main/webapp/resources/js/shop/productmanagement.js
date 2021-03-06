$(function () {
    var shopId = getQueryString('shopId');
    //获取此店铺下所有的商品列表的URL
    var listUrl = '/o2o/shopadmin/getproductlistbyshop?pageIndex=0&pageSize=999&shopId=' + shopId;
    //商品下架URL
    var statusUrl = '/o2o/shopadmin/modifyproduct';
    getList();

    function getList() {
        $.getJSON(listUrl, function (data) {
            if (data.success) {
                var productList = data.productList;
                var tempHtml = '';
                productList.map(function (item, index) {
                    var textOp = "下架";
                    var contraryStatus = 0;
                    if (item.enableStatus == 0) {
                        textOp = "上架";
                        contraryStatus = 1;
                    } else {
                        contraryStatus = 0;
                    }
                    tempHtml += '' + '<div class="row row-product">'
                        + '<div class="col-33">'
                        + item.productName
                        + '</div>'
                        + '<div class="col-20">'
                        + item.priority
                        + '</div>'
                        + '<div class="col-40">'
                        + '<a href="javascript:;" class="edit" data-id="'
                        + item.productId
                        + '" data-status="'
                        + item.enableStatus
                        + '">编辑</a>'
                        + '<a href="javascript:;" class="status" data-id="'
                        + item.productId
                        + '" data-status="'
                        + contraryStatus
                        + '">'
                        + textOp
                        + '</a>'
                        + '<a href="javascript:;" class="preview" data-id="'
                        + item.productId
                        + '" data-status="'
                        + item.enableStatus
                        + '">预览</a>'
                        + '</div>'
                        + '</div>';
                });
                $('.product-wrap').html(tempHtml);
            }
        });
    }

    function changeItemStatus(id, enableStatus) {
        //定义一个product的JSON对象
        var product = {};
        product.productId = id;
        product.enableStatus = enableStatus;
        $.confirm('确定么?', function () {
            $.ajax({
                url: statusUrl,
                type: 'POST',
                data: {
                    productStr: JSON.stringify(product),
                    statusChange: true
                },
                dataType: 'json',
                success: function (data) {
                    if (data.success) {
                        $.toast('操作成功！');
                        getList();
                    } else {
                        $.toast('操作失败！');
                    }
                }
            });
        });
    }

    $('.product-wrap')
        .on('click', 'a', function (e) {
            var target = $(e.currentTarget);
            if (target.hasClass('edit')) {
                window.location.href = '/o2o/shopadmin/productoperation?productId='
                    + e.currentTarget.dataset.id;
            } else if (target.hasClass('status')) {
                changeItemStatus(e.currentTarget.dataset.id,
                    e.currentTarget.dataset.status);
            } else if (target.hasClass('preview')) {
                window.location.href = '/o2o/frontend/productdetail?productId='
                    + e.currentTarget.dataset.id;
            }
        });

    $('#new').click(function () {
        window.location.href = '/o2o/shopadmin/productoperation';
    });
});