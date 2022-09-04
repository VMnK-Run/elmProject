<template>
    <!-- 总容器 -->
    <div class="wrapper">
        <!-- header部分 -->
        <header>
            <div class="icon-location-box">
                <div class="icon-location"></div>
            </div>
            <div class="location-text">天津大学北洋园校区<i class="fa fa-caret-down"></i></div>
        </header>
        <!--search 部分-->
        <div class="search">
            <div class="search-fixed-top" ref="fixedBox">
                <div class="search-box">
                    <i class="fa fa-search"></i>搜索饿了么商家、商品名称
                </div>
            </div>
        </div>

        <!-- 点餐分类部分 -->
        <ul class="food-type">
            <li @click="toBusinessList(1)">
                <img src="../assets/kfc.png">
                <p>美食</p>
            </li>
            <li @click="toBusinessList(2)">
                <img src="../assets/kfc.png">
                <p>早餐</p>
            </li>
            <li @click="toBusinessList(3)">
                <img src="../assets/kfc.png">
                <p>跑腿代购</p>
            </li>
            <li @click="toBusinessList(4)">
                <img src="../assets/kfc.png">
                <p>汉堡披萨</p>
            </li>
            <li @click="toBusinessList(5)">
                <img src="../assets/kfc.png">
                <p>甜品饮品</p>
            </li>
            <li @click="toBusinessList(6)">
                <img src="../assets/kfc.png">
                <p>速食简餐</p>
            </li>
            <li @click="toBusinessList(7)">
                <img src="../assets/kfc.png">
                <p>地方小吃</p>
            </li>
            <li @click="toBusinessList(8)">
                <img src="../assets/kfc.png">
                <p>米粉面馆</p>
            </li>
            <li @click="toBusinessList(9)">
                <img src="../assets/kfc.png">
                <p>包子粥铺</p>
            </li>
            <li @click="toBusinessList(10)">
                <img src="../assets/kfc.png">
                <p>炸鸡炸串</p>
            </li>
        </ul>

        <!-- 横幅广告部分 -->
        <div class="banner">
            <h3>品质套餐</h3>
            <p>搭配齐全吃得好</p>
            <a>立即抢购 &gt</a>
        </div>

        <!-- 超级会员部分 -->
        <div class="super-member">
            <div class="left">
                <img src="../assets/kfc.png">
                <h3>超级会员</h3>
                <p>&#8226;每月享超级权益</p>
            </div>
            <div class="right">
                立即开通 &gt;
            </div>
        </div>

        <!-- 推荐商家 -->
        <div class="recommend">
            <div class="recommend-line"></div>
            <p>推荐商家</p>
            <div class="recommend-line"></div>
        </div>

        <!-- 推荐方式 -->
        <ul class="recommend-type">
            <li>综合排序<i class="fa fa-caret-down"></i></li>
            <li>距离最近</li>
            <li>销量最高</li>
            <li>筛选<i class="fa fa-filter"></i></li>
        </ul>

        <!-- 商家列表 -->
        <ul class="business">
            <li>
                <img src="../assets/kfc.png">
                <div class="business-info">
                    <div class="business-info-h">
                        <h3>KFC</h3>
                        <div class="business-info-like">&#8226;</div>
                    </div>
                    <div class="business-info-star">
                        <div class="business-info-star-left">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <p>4.9 月售345单</p>
                        </div>
                        <div class="business-info-star-right">
                            蜂鸟专送
                        </div>
                    </div>
                    <div class="business-info-delivery">
                        <p>&#165;15起送 | &#165;3配送</p>
                        <p>100m | 30分钟</p>
                    </div>
                    <div class="business-info-explain">
                        <div>各种垃圾食品</div>
                    </div>
                    <div class="business-info-promotion">
                        <div class="business-info-promotion-left">
                            <div class="business-info-promotion-left-icon">新</div>
                            <p>饿了么新用户首单立减9元</p>
                        </div>
                        <div class="business-info-promotion-right">
                            <p>2个活动</p>
                            <i class="fa fa-caret-down"></i>
                        </div>
                    </div>
                    <div class="business-info-promotion">
                        <div class="business-info-promotion-left">
                            <div class="business-info-promotion-left-icon" style="background-color: #F1884F">特</div>
                            <p>特价商品5元起</p>
                        </div>
                    </div>
                </div>
            </li>

            <li>
                <img src="../assets/kfc.png">
                <div class="business-info">
                    <div class="business-info-h">
                        <h3>KFC</h3>
                        <div class="business-info-like">&#8226;</div>
                    </div>
                    <div class="business-info-star">
                        <div class="business-info-star-left">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <p>4.9 月售345单</p>
                        </div>
                        <div class="business-info-star-right">
                            蜂鸟专送
                        </div>
                    </div>
                    <div class="business-info-delivery">
                        <p>&#165;15起送 | &#165;3配送</p>
                        <p>100m | 30分钟</p>
                    </div>
                    <div class="business-info-explain">
                        <div>各种垃圾食品</div>
                    </div>
                    <div class="business-info-promotion">
                        <div class="business-info-promotion-left">
                            <div class="business-info-promotion-left-icon">新</div>
                            <p>饿了么新用户首单立减9元</p>
                        </div>
                        <div class="business-info-promotion-right">
                            <p>2个活动</p>
                            <i class="fa fa-caret-down"></i>
                        </div>
                    </div>
                    <div class="business-info-promotion">
                        <div class="business-info-promotion-left">
                            <div class="business-info-promotion-left-icon" style="background-color: #F1884F">特</div>
                            <p>特价商品5元起</p>
                        </div>
                    </div>
                </div>
            </li>

            <li>
                <img src="../assets/kfc.png">
                <div class="business-info">
                    <div class="business-info-h">
                        <h3>KFC</h3>
                        <div class="business-info-like">&#8226;</div>
                    </div>
                    <div class="business-info-star">
                        <div class="business-info-star-left">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <p>4.9 月售345单</p>
                        </div>
                        <div class="business-info-star-right">
                            蜂鸟专送
                        </div>
                    </div>
                    <div class="business-info-delivery">
                        <p>&#165;15起送 | &#165;3配送</p>
                        <p>100m | 30分钟</p>
                    </div>
                    <div class="business-info-explain">
                        <div>各种垃圾食品</div>
                    </div>
                    <div class="business-info-promotion">
                        <div class="business-info-promotion-left">
                            <div class="business-info-promotion-left-icon">新</div>
                            <p>饿了么新用户首单立减9元</p>
                        </div>
                        <div class="business-info-promotion-right">
                            <p>2个活动</p>
                            <i class="fa fa-caret-down"></i>
                        </div>
                    </div>
                    <div class="business-info-promotion">
                        <div class="business-info-promotion-left">
                            <div class="business-info-promotion-left-icon" style="background-color: #F1884F">特</div>
                            <p>特价商品5元起</p>
                        </div>
                    </div>
                </div>
            </li>

            <li>
                <img src="../assets/kfc.png">
                <div class="business-info">
                    <div class="business-info-h">
                        <h3>KFC</h3>
                        <div class="business-info-like">&#8226;</div>
                    </div>
                    <div class="business-info-star">
                        <div class="business-info-star-left">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <p>4.9 月售345单</p>
                        </div>
                        <div class="business-info-star-right">
                            蜂鸟专送
                        </div>
                    </div>
                    <div class="business-info-delivery">
                        <p>&#165;15起送 | &#165;3配送</p>
                        <p>100m | 30分钟</p>
                    </div>
                    <div class="business-info-explain">
                        <div>各种垃圾食品</div>
                    </div>
                    <div class="business-info-promotion">
                        <div class="business-info-promotion-left">
                            <div class="business-info-promotion-left-icon">新</div>
                            <p>饿了么新用户首单立减9元</p>
                        </div>
                        <div class="business-info-promotion-right">
                            <p>2个活动</p>
                            <i class="fa fa-caret-down"></i>
                        </div>
                    </div>
                    <div class="business-info-promotion">
                        <div class="business-info-promotion-left">
                            <div class="business-info-promotion-left-icon" style="background-color: #F1884F">特</div>
                            <p>特价商品5元起</p>
                        </div>
                    </div>
                </div>
            </li>
        </ul>

        <Footer></Footer>
    </div>
</template>

<style scoped>
/*****总容器部分*****/
.wrapper {
    width: 100%;
    height:100%;
}

/********** header *************/
.wrapper header{
    width: 100%;
    height: 12vw;
    background-color: #0097FF;

    display: flex;
    align-items: center;
}
.wrapper header .icon-location-box{
    width: 3.5vw;
    height: 3.5vw;
    margin: 0 1vw 0 3vw;
}
.wrapper header .location-text{
    font-size: 4.5vw;
    font-weight: 700;
    color: white;
}
.wrapper header .location-text .fa-caret-down{
    margin-left: 1vw;
}


/*****************search****************/
.wrapper .search {
    width: 100%;
    height: 13vw;
}
.wrapper .search .search-fixed-top{
    width: 100%;
    height: 13vw;
    background-color: #0097FF;
    display: flex;
    justify-content: center;
    align-items: center;
}
.wrapper .search .search-fixed-top .search-box{
    width: 90%;
    height: 9vw;
    background-color: white;
    border-radius: 2px;

    display: flex;
    justify-content: center;
    align-items: center;

    font-size: 3.5vw;
    color: #AEAEAE;
    font-family: "宋体", serif;

    /*让文本选中状态无效*/
    user-select: none;
}

.wrapper .search .search-fixed-top .search-box .fa-search{
    margin-right: 1vw;
}

/***************** 点餐分类部分 ****************/
.wrapper .food-type {
    width: 100%;
    height: 48vw;

    display: flex;
    flex-wrap: wrap;

    justify-content: space-around;
    align-content: center;
}
.wrapper .food-type li{
    width: 18vw;
    height: 20vw;

    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
.wrapper .food-type li img{
    width: 12vw;
    height: 12vw;
}
.wrapper .food-type li p{
    font-size: 3.2vw;
    color: #666;
    user-select: none;
}

/********** 横幅广告部分 *************/
.wrapper .banner{
    width: 95%;
    margin: 0 auto;
    height: 29vw;

    background-image: url("../assets/back.png");
    background-repeat: no-repeat;
    background-size: cover;

    box-sizing: border-box;
    padding: 2vw 6vw;
}
.wrapper .banner h3{
    font-size: 4.2vw;
    margin-bottom: 1.2vw;
}
.wrapper .banner p{
    font-size: 3.4vw;
    color: #666;
    margin-bottom: 2.4vw;
}
.wrapper .banner a{
    font-size: 3vw;
    color: #C79060;
    font-weight: 700;
}

/********** 横幅广告部分 *************/
.wrapper .super-member{
    width: 95%;
    height: 11.5vw;
    background-color: #FEEDC1;
    margin: 1.3vw auto 0;
    border-radius: 2px;
    color: #644F1B;

    display: flex;
    justify-content: space-between;
    align-items: center;
}
.wrapper .super-member .left{
    display: flex;
    align-items: center;
    margin-left: 4vw;
    user-select: none;
}
.wrapper .super-member .left img{
    width: 6vw;
    height: 6vw;
    margin-right: 2vw;
}
.wrapper .super-member .left h3{
    font-size: 4vw;
    margin-right: 2vw;
}
.wrapper .super-member .left p{
    font-size: 3vw;
}
.wrapper .super-member .right{
    font-size: 3vw;
    margin-right: 4vw;
    cursor: pointer;
}

/********** 推荐商家部分 *************/
.wrapper .recommend{
    width: 100%;
    height: 14vw;
    display: flex;
    justify-content: center;
    align-items: center;
}
.wrapper .recommend .recommend-line{
    width: 6vw;
    height: 0.2vw;
    background-color: #888;
}
.wrapper .recommend p{
    font-size: 4vw;
    margin: 0 4vw;
}

/********** 推荐方式部分 *************/
.wrapper .recommend-type{
    width: 100%;
    height: 5vw;
    margin-bottom: 5vw;

    display: flex;
    justify-content: space-around;
    align-items: center;
}
.wrapper .recommend-type li{
    font-size: 3.5vw;
    color: #555;
}

/********** 推荐商家列表 *************/
.wrapper .business{
    width: 100%;
    margin-bottom: 14vw;
    padding-bottom: 14vw;
}
.wrapper .business li{
    width: 100%;
    box-sizing: border-box;
    padding: 2.5vw;
    user-select: none;
    border-bottom: solid 1px #DDD;

    display: flex;
}
.wrapper .business li img{
    width: 18vw;
    height: 18vw;
}
.wrapper .business li .business-info{
    width: 100%;
    box-sizing: border-box;
    padding-left: 3vw;
}
.wrapper .business li .business-info .business-info-h{
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 2vw;
}
.wrapper .business li .business-info .business-info-h h3{
    font-size: 4vw;
    color: #333;
}
.wrapper .business li .business-info .business-info-h .business-info-like{
    width: 1.6vw;
    height: 3.4vw;
    background-color: #666;
    color: white;

    display: flex;
    justify-content: center;
    align-items: center;

    font-size: 4vw;
    margin-right: 4vw;
}
.wrapper .business li .business-info .business-info-star{
    display: flex;
    justify-content: space-between;
    align-items: center;

    margin-bottom: 2vw;
    font-size: 3.1vw;
}
.wrapper .business li .business-info .business-info-star-left{
    display: flex;
    align-items: center;
}
.wrapper .business li .business-info .business-info-star-left .fa-star{
    color: #FEC80E;
    margin-right: 0.5vw;
}
.wrapper .business li .business-info .business-info-star-left p{
    color: #666;
    margin-left: 1vw;
}
.wrapper .business li .business-info .business-info-star-right{
    background-color: #0097FF;
    color: #fff;
    font-size: 2.4vw;
    border-radius: 2px;
    padding: 0 0.6vw;
}
.wrapper .business li .business-info .business-info-delivery{
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 2vw;

    color: #666;
    font-size: 3.1vw;
}
.wrapper .business li .business-info .business-info-explain{
    display: flex;
    align-items: center;
    margin-bottom: 3vw;
}
.wrapper .business li .business-info .business-info-explain div{
    border: solid 1px #DDD;
    font-size: 2.8vw;
    color: #666;
    border-radius: 3px;
    padding: 0 0.1vw ;
}
.wrapper .business li .business-info .business-info-promotion{
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 1.8vw;
}
.wrapper .business li .business-info .business-info-promotion .business-info-promotion-left{
    display: flex;
    align-items: center;
}
.wrapper .business li .business-info .business-info-promotion .business-info-promotion-left .business-info-promotion-left-icon{
    width: 4vw;
    height: 4vw;
    background-color: #70BC46;
    border-radius: 3px;
    font-size: 3vw;
    color: #fff;

    display: flex;
    justify-content: center;
    align-items: center;
}
.wrapper .business li .business-info .business-info-promotion .business-info-promotion-left p{
    color: #666;
    font-size: 3vw;
    margin-left: 2vw;
}
.wrapper .business li .business-info .business-info-promotion .business-info-promotion-right{
    display: flex;
    align-items: center;
    font-size: 2.5vw;
    color: #999;
}
.wrapper .business li .business-info .business-info-promotion .business-info-promotion-right p{
    margin-right: 2vw;
}
</style>

<script>
    // 导入共通组件
    import Footer from "@/components/Footer";

    export default {
        name :'Index',
        mounted() {
            document.onscroll = ()=> {
                // 获取滚动条位置
                let s1 = document.documentElement.scrollTop;
                let s2 = document.body.scrollTop;
                let scroll = s1 === 0 ? s2 : s1;
                // 获取视口宽度
                let width = document.documentElement.clientWidth;
                // 获取顶部固定块
                let search = this.$refs.fixedBox;
                if(scroll > width * 0.12) {
                    search.style.position = 'fixed';
                    search.style.left = '0';
                    search.style.top = '0';
                } else {
                    search.style.position = 'static';
                }
            }
        },
        destroyed() {
            document.onscroll = null;
        },
        components:{
            Footer
        },
        methods:{
            toBusinessList(orderTypeId) {
                this.$router.push({path:'/businessList', query:{orderTypeId:orderTypeId}});
            }
        }
    }

</script>
