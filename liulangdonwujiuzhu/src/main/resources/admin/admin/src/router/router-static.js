import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import chongwu from '@/views/modules/chongwu/list'
    import chongwuCollection from '@/views/modules/chongwuCollection/list'
    import chongwuLiuyan from '@/views/modules/chongwuLiuyan/list'
    import dictionary from '@/views/modules/dictionary/list'
    import dongwu from '@/views/modules/dongwu/list'
    import dongwuCollection from '@/views/modules/dongwuCollection/list'
    import dongwuLiuyan from '@/views/modules/dongwuLiuyan/list'
    import dongwuYuyue from '@/views/modules/dongwuYuyue/list'
    import forum from '@/views/modules/forum/list'
    import news from '@/views/modules/news/list'
    import yonghu from '@/views/modules/yonghu/list'
    import config from '@/views/modules/config/list'
    import dictionaryChongwu from '@/views/modules/dictionaryChongwu/list'
    import dictionaryChongwuCollection from '@/views/modules/dictionaryChongwuCollection/list'
    import dictionaryDongwu from '@/views/modules/dictionaryDongwu/list'
    import dictionaryDongwuCollection from '@/views/modules/dictionaryDongwuCollection/list'
    import dictionaryDongwuYuyueYesno from '@/views/modules/dictionaryDongwuYuyueYesno/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionaryQiuzhuzhuangtai from '@/views/modules/dictionaryQiuzhuzhuangtai/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryChongwu',
        name: '寻宠类型',
        component: dictionaryChongwu
    }
    ,{
        path: '/dictionaryChongwuCollection',
        name: '收藏表类型',
        component: dictionaryChongwuCollection
    }
    ,{
        path: '/dictionaryDongwu',
        name: '求助类型',
        component: dictionaryDongwu
    }
    ,{
        path: '/dictionaryDongwuCollection',
        name: '收藏表类型',
        component: dictionaryDongwuCollection
    }
    ,{
        path: '/dictionaryDongwuYuyueYesno',
        name: '审核状态',
        component: dictionaryDongwuYuyueYesno
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionaryQiuzhuzhuangtai',
        name: '求助状态',
        component: dictionaryQiuzhuzhuangtai
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/chongwu',
        name: '寻宠',
        component: chongwu
      }
    ,{
        path: '/chongwuCollection',
        name: '寻宠收藏',
        component: chongwuCollection
      }
    ,{
        path: '/chongwuLiuyan',
        name: '寻宠留言',
        component: chongwuLiuyan
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/dongwu',
        name: '动物求助',
        component: dongwu
      }
    ,{
        path: '/dongwuCollection',
        name: '求助收藏',
        component: dongwuCollection
      }
    ,{
        path: '/dongwuLiuyan',
        name: '求助留言',
        component: dongwuLiuyan
      }
    ,{
        path: '/dongwuYuyue',
        name: '领养信息',
        component: dongwuYuyue
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/news',
        name: '公告通知',
        component: news
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
