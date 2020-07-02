import Vue from 'vue'
import Router from 'vue-router'

//个人业务界面
 import Personal_home from '@/components/module1/Personal_home'
import Personal_login from '@/components/module1/Personal_login'
import Personal_register from '@/components/module1/Personal_register'
import Personal_life from '@/components/module1/children/Personal_life'
import Personal_info from '@/components/module1/children/Personal_info'
import Personal_wallet from '@/components/module1/children/Personal_wallet'
import Personal_moblilepay from '@/components/module1/children/Personal_mobilepay'
import Personal_manage from '@/components/module1/children/Personal_manage'
import Personal_transfer from '@/components/module1/children/Personal_transfer'

//公司业务界面
import Company_login from '@/components/Company/Company_login.vue'
import Company_home from '@/components/Company/Company_home.vue'
import Company_hello from '../components/Company/Company_hello.vue'
import Company_user from '../components/Company/Company_sub/user.vue'
import Company_expense from '../components/Company/Company_sub/expense.vue'

//管理功能界面
import Login from '@/components/module3/Login'
//import Register from '@/components/module3/Register'
import Home from '@/components/module3/Home'
//import Main from '@/views/Main' 
import User from '@/components/module3/User'
import Check from '@/components/module3/Work/Check'
import Modify from '@/components/module3/Work/Modify'
import Freeze from '@/components/module3/Work/Freeze'
import Lost from '@/components/module3/Work/Lost'
Vue.use(Router)
 
const router = new Router({
  routes: [
    {
      //个人业务
      path: '/',
      name: 'Personal_login',
      component: Personal_login
    },
    {
      path: '/register',
      name: 'Personal_register',
      component: Personal_register
    },
    {
      path: '/personalhome',
      name: 'Personal_home',
      component: Personal_home,
      redirect:'/personal/info',
      children:[
       
        {
          path:'/personal/info',
          component: Personal_info
        },
        {
          path:'/personal/wallet',
          component:Personal_wallet
        },
        {
          path:'/personal/life',
          component:Personal_life
        },
        {
          path:'/personal/mobilepay',
          component:Personal_moblilepay
        },
        {
          path:'/personal/manage',
          component:Personal_manage
        },
        {
          path:'/personal/transfer',
          component:Personal_transfer
        }
      ]
    },


    //公司界面
    {
      path: '/companylogin',
      name: 'cl',
      component: Company_login
    }
    ,
    {
      path: '/companyhome',
      name: 'ch',
      component: Company_home,
      redirect:'/company/hello',
      children:[
        {
          path:'/company/hello',
          component: Company_hello
        },
        {
          path:'/company/user',
          component:Company_user
        },
        {
          path:'/company/expense',
          component:Company_expense
        }
      ]
    }

    //管理功能界面
    ,{
      path: '/Login',
      name: 'Login',
      component: Login
    },
    // {
    //   path: '/register',
    //   name: 'Register',
    //   component: Register
    // },
    {
      path: '/Home',
      name: 'Home',
      component: Home
     },
     {
     path: '/User',
     name: 'user',
     component: User
    },
    //  {
    //   path: '/main',
    //   name: 'Main',
    //   component: Main
    // },
    {
      path: '/Check',
      name: 'Check',
      component: Check
    },
    {
      path: '/Modify',
      name: 'Modify',
      component: Modify
    },
    {
      path: '/Freeze',
      name: 'Freeze',
      component: Freeze
    },
    {
      path: '/Lost',
      name: 'Lost',
      component: Lost
    },
  ],
  mode: "history"
})

// 导航守卫
// 使用 router.beforeEach 注册一个全局前置守卫，判断用户是否登陆
// router.beforeEach((to, from, next) => {
//   if (to.path === '/') {
//     next();
//   } else {
//     let token = localStorage.getItem('Authorization');
 
//     if (token === null || token === '') {
//       next('/');
//     } else {
//       next();
//     }
//   }
// });

export default router;

