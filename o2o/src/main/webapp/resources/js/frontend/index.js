$(function() {

    var url = '/o2o/frontend/listmainpageinfo';

    //获取数据
    $.getJSON(url, function (data) {
        if (data.success) {
            var headLineList = data.headLineList;
            var swiperHtml = '';
            headLineList.map(function (item, index) {
                swiperHtml += ''
                            + '<div class="swiper-slide img-wrap">'
                            +      '<img class="banner-img" src="'+ item.lineImg +'" alt="'+ item.lineName +'">'
                            + '</div>';
            });
            $('.swiper-wrapper').html(swiperHtml);

            //设置轮播图的属性
            $(".swiper-container").swiper({
                //轮播时间间隔
                autoplay: 3000,
                //用户对轮播图操作是，是否会自动停止
                autoplayDisableOnInteraction: false
            });

            //获取后台传来的商品类别数据
            var shopCategoryList = data.shopCategoryList;
            var categoryHtml = '';
            shopCategoryList.map(function (item, index) {
                categoryHtml += ''
                             +  '<div class="col-50 shop-classify" data-category='+ item.shopCategoryId +'>'
                             +      '<div class="word">'
                             +          '<p class="shop-title">'+ item.shopCategoryName +'</p>'
                             +          '<p class="shop-desc">'+ item.shopCategoryDesc +'</p>'
                             +      '</div>'
                             +      '<div class="shop-classify-img-warp">'
                             +          '<img class="shop-img" src="'+ item.shopCategoryImg +'">'
                             +      '</div>'
                             +  '</div>';
            });
            $('.row').html(categoryHtml);
        }
    });

    $('#me').click(function () {
        $.openPanel('#panel-left-demo');
    });

    $('.row').on('click', '.shop-classify', function (e) {
        var shopCategoryId = e.currentTarget.dataset.category;
        var newUrl = '/o2o/frontend/shoplist?parentId=' + shopCategoryId;
        window.location.href = newUrl;
    });

});
