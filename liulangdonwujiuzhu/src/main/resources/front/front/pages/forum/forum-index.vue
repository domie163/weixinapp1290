<template>
    <mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">

        <view class="uni-padding-wrap">
            <!--header end-->
            <view class="cu-bar bg-white search">
                <view class="search-form round">
                    <text class="cuIcon-search"></text>
                    <input v-model="searchForm.forumName" type="text" placeholder="标题"></input>
                </view>
                <view class="action">
                    <view :style="{width:'40rpx',borderRadius:'40rpx 0 0 40rpx',height:'80rpx',backgroundColor:btnColor[0],borderColor:btnColor[0]}">
                    </view>
                    <view @tap="search" :style="{padding:'0 10rpx',lineHeight:'80rpx',width:'auto',height:'80rpx',fontSize:'28rpx',color:'rgba(239, 239, 239, 1)',backgroundColor:btnColor[0],borderColor:btnColor[0]}">
                        搜索
                    </view>
                    <view :style="{width:'40rpx',borderRadius:'0 40rpx 40rpx 0',height:'80rpx',backgroundColor:btnColor[0],borderColor:btnColor[0]}">
                    </view>
                </view>
            </view>
            <view class="list">
                <uni-drawer ref="showRight" mode="left" :maskClick="true" :width="100" :mask-click="true">
                    <scroll-view scroll-y="true" class="tabView" :style='{"padding":"0","boxShadow":"0 0 12rpx rgba(255,0,0,0)","margin":"10rpx 0 0 ","borderColor":"rgba(0,0,0,1)","borderRadius":"0","borderWidth":"0","borderStyle":"solid","height":"auto"}'>
                        <view style="display: flex;">
                            <view style="display: flex;flex-direction: column;width: 100%;">
                                <view :style='forumTypes===item.codeIndex?sactiveItem:sitem' class="tab"
                                      v-for="(item,index) in forumTypesList" :key="index" :class="forumTypes===item.codeIndex?'tabActive':''"
                                      @tap="forumTypesCategoryClick(item.codeIndex)">
                                    {{item.indexName}}
                                </view>
                            </view>
                        </view>
                    </scroll-view>
                </uni-drawer>

                <view class="flex flex-between flex-align-center pl15 pb30">
                    <text class="f28 col3">论坛专区</text>
                    <!-- <text class="f24 col9">查看全部</text> -->
                </view>
                <view @tap="onDetailTap(item.id)" v-for="(item,index) in list " v-bind:key="index"
                      class="listm flex flex-between">
                    <image src="/static/exam-index/paper.png" mode="widthFix" class="listmpic mt10"></image>
                    <view class="listmr">
                        <view style="float:right;font-size: 25rpx;">
                            <text v-if="item.yonghuId != null">
                                身份：用户
                            </text>
							<text v-if="item.usersId!= null">
                                身份：管理员
                            </text>
                        </view>
                        <view class="col3 f30 elip mb15">{{item.forumName }}</view>
                        <view class="colb f24 lh35" v-html="item.forumContent.length>50?item.forumContent.substring(0,50)+'... ...':item.forumContent"></view>
                        <!-- <rich-text class="colb f24 lh35" :nodes="item.forumContent.length>50?item.forumContent.substring(0,50)+'... ...':item.forumContent"></rich-text> -->
                        <view class="flex flex-align-center mt20">
                            <text class="colb f25">
								<text v-if="item.yonghuId != null">
									发布人：{{item.yonghuName}}（用户）
								</text>
								<text v-if="item.usersId!= null">
                                    发布人：管理员
                                </text>
                            </text>
                        </view>
                        <view class="flex flex-align-center mt20 colb f25">
                            发布时间：{{item.insertTime}}
                        </view>
                    </view>
                </view>
            </view>
            <!--list end-->
        </view>
    </mescroll-uni>
</template>

<script>
    import '@/assets/css/global-restaurant.css'
    import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
    import uniNoticeBar from "@/components/uni-ui/lib/uni-notice-bar/uni-notice-bar.vue"
    export default {
        components: {
            uniIcons,
            uniNoticeBar
        },
        data() {
            return {
                btnColor: ['#67c23a', '#909399', '#e6a23c', '#f56c6c', '#356c6c', '#3498db', '#f093a9',
                    '#a7c23a', '#104eff', '#90f794', '#a21233', '#8e44ad'
                ],
                //轮播
                swiperList: [],
                list: [],
                searchForm: {},
                mescroll: null, //mescroll实例对象
                downOption: {
                    auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
                },
                upOption: {
                    page: {
                        // num: 0, // 当前页码,默认0,回调之前会加1,即callback(page)会从1开始
                        // size: 5 // 每页数据的数量
                    },
                    noMoreSize: 3, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
                    textNoMore: '~ 没有更多了 ~',
                },
                hasNext: true,
                forumTypesList:[],
                forumTypes:0,
                opts: {
                    color: ["#1890FF","#91CB74","#FAC858","#EE6666","#73C0DE","#3CA272","#FC8452","#9A60B4","#ea7ccc"],
                    enableScroll: false,
                    // //柱状图
                    // padding:[15,15,0,5],legend:{},xAxis:{disableGrid:true},yAxis:{data:[{min:0}]},extra:{column:{type:"group",width:30,activeBgColor:"#000000",activeBgOpacity:0.08}},
                    //饼状图
                    extra:{pie:{activeOpacity:0.5,activeRadius:10,offsetAngle:0,labelWidth:15,border:false,borderWidth:3,borderColor:"#FFFFFF"}},
                }

            }
        },
        async onShow() {
            this.hasNext = true

            this.forumTypesSelect()

            // 重新加载数据
            if (this.mescroll) this.mescroll.resetUpScroll()
        },
        methods: {
            async forumTypesSelect(){
                let forumTypes = await this.$api.page('dictionary', {
                    page: 1,
                    limit: 100,
                    dicCode:'forum_types',
                });
                forumTypes.data.list.splice(0, 0, {codeIndex: 0, indexName: '全部'})
                this.forumTypesList = forumTypes.data.list
            },
            forumTypesCategoryClick(categoryName) {
                this.forumTypes = categoryName;
                this.mescroll.resetUpScroll();
            },
            // mescroll组件初始化的回调,可获取到mescroll对象
            mescrollInit(mescroll) {
                this.mescroll = mescroll;
            },
            /*下拉刷新的回调 */
            downCallback(mescroll) {
                this.hasNext = true
                // 重置分页参数页数为1
                mescroll.resetUpScroll()
            },
            /*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
            async upCallback(mescroll) {
                let params = {
                    forumStateTypes: 1,
                    page: mescroll.num,
                    limit: mescroll.size,
                }

                if (this.forumTypes != 0) {
                    params.forumTypes = this.forumTypes
                }

                let res = await this.$api.list("forum", params);
                // 如果是第一页数据置空
                if (mescroll.num == 1) this.list = [];
                this.list = this.list.concat(res.data.list);
                if (res.data.list.length == 0) this.hasNext = false;
                mescroll.endSuccess(mescroll.size, this.hasNext);
            },
            // 详情
            onDetailTap(id) {
                this.$utils.jump(`../forum/forum-detail?id=${id}`)
            },
            //轮播图跳转
            onSwiperTap(e) {

            },
            // 搜索
            async search() {
                let _this = this
                _this.mescroll.num = 1
                // 如果是第一页数据置空
                if (_this.mescroll.num == 1) _this.list = [];
                let params = {
                    forumStateTypes: 1,
                    page: _this.mescroll.num,
                    limit: _this.mescroll.size,
                    forumName: _this.searchForm.forumName
                }
                let res = await _this.$api.list("forum", params);
                _this.list = _this.list.concat(res.data.list);
                if (res.data.list.length == 0) _this.hasNext = false;
                _this.mescroll.endSuccess(_this.mescroll.size, _this.hasNext);
            }
        }
    }
</script>

<style>

    /* 按钮条件查询样式------------------------开始 */
    .tabView {
        display: flex;
        align-items: center;
        justify-content: flex-start;
        height: 60upx;
        margin-bottom: 20upx;
        white-space: nowrap;
        box-shadow: 0px 1px 14px 0px rgba(38, 38, 35, 0.07);
        margin-top: 6upx;
    }
    .tab {
        text-align: center;
        display: inline-block;
        margin: 0 12rpx 8rpx 0;
        padding: 0 10rpx;
        width: auto;
        line-height: 160rpx;
        color: #fff;
        font-size: 28rpx;
        border-radius: 0 40rpx 40rpx 0;
        border-width: 0;
        border-style: solid;
        border-color: rgba(0,0,0,1);
        background-color: var(--publicSubColor);
        box-shadow: 0 0 0px rgba(0,0,0,.3);
    }
    .tabActive{
        margin: 0 12rpx 8rpx 0;
        padding: 0 10rpx;
        width: auto;
        line-height: 160rpx;
        color: #fff;
        font-size: 28rpx;
        border-radius: 0 40rpx 40rpx 0;
        border-width: 0;
        border-style: solid;
        border-color: rgba(0,0,0,1);
        background-color: var(--publicMainColor);
        box-shadow: 0 0 0px rgba(0,0,0,.3);
    }
    /* 按钮条件查询样式------------------------结束 */

    view {
        font-family: '\5FAE\8F6F\96C5\9ED1';
        font-size: 30upx;
    }

    page {
        background: #ededed;
    }

    .header {
        background: #f39800;
        padding: 15upx 20upx 255upx;
        position: relative;
    }

    .ssbox {
        background: rgba(255, 255, 255, 0.35);
        width: 530upx;
        border-radius: 60rpx;
        padding: 10upx 15upx;
        box-sizing: border-box;
    }

    .ss_input {
        border: none;
        width: 450upx;
        font-size: 30upx;
        color: #fff;
        background: none;
        height: 45upx;
        line-break: 45upx;
    }

    .headerb {
        position: absolute;
        left: 0;
        top: 60upx;
        width: 100%;
        box-sizing: border-box;
        padding: 0 20upx;
    }

    .headerb image {
        width: 710upx;
        box-shadow: 0 10upx 10px rgba(0, 0, 0, 0.3);
        border-radius: 40upx;
        position: relative;
        z-index: 10;
    }

    .notice {
        position: relative;
        z-index: 5;
        padding: 0 50upx;
    }

    .noticem {
        background: #fff;
        padding: 55upx 30upx 15upx;
        border-radius: 10upx;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
        margin-top: -45upx;
    }

    .noticer {
        width: 480upx;
        height: 50upx;
    }

    .noticer .swiper-item {
        white-space: nowrap;
        text-overflow: ellipsis;
        overflow: hidden;
        height: 50upx;
        line-height: 50upx;
        font-size: 24upx;
    }

    .list {
        padding: 50upx 20upx 20upx;
    }

    .listm {
        background: #fff;
        border-radius: 15upx;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
        margin-bottom: 20upx;
        padding: 30upx;
    }

    .listmpic {
        border-radius: 10upx;
        width: 166upx;
    }

    .listmr {
        width: 460upx;
        display: inline-block;
    }

    /* #ifdef MP-WEIXIN */
    .noticer .swiper-item {
        margin-top: 5upx;
    }

    /* #endif */
    /* #ifdef MP-BAIDU */
    .noticer .swiper-item {
        margin-top: 3upx;
    }

    /* #endif */
    /* #ifdef MP-ALIPAY */
    .noticer .swiper-item {
        margin-top: 2upx;
    }

    /* #endif */
    /* #ifdef MP-QQ */
    .noticer .swiper-item {
        margin-top: 4upx;
    }

    /* #endif */
    /* #ifdef MP-TOUTIAO */
    .noticer .swiper-item {
        margin-top: 4upx;
    }

    /* #endif */
</style>
