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
import Company_login from '../components/module2/Company_login.vue'
import Company_register from '../components/module2/Company_register.vue'
import Company_home from '../components/module2/Company_home.vue'
import Company_hello from '../components/module2/Company_hello.vue'
import Company_user from '../components/module2/Company_sub/user.vue'
import Company_expense from '../components/module2/Company_sub/expense.vue'
import Company_pay from '../components/module2/Company_sub/pay.vue'
import Company_paypage from '../components/module2/Company_sub/paypage.vue'
import Company_succeed from '../components/module2/Company_sub/succeed.vue'
import Company_management from '../components/module2/Company_sub/management.vue'
//管理功能界面
import Manage_Login from '@/components/module3/Manage_Login'
import Manage_Register from '@/components/module3/Manage_Register'
import Manage_Home from '@/components/module3/Manage_Home'
import Manage_Check from '@/components/module3/Manage_Work/Manage_Check'
import Manage_Modify from '@/components/module3/Manage_Work/Manage_Modify'
import Manage_Freeze from '@/components/module3/Manage_Work/Manage_Freeze'
import Manage_Lost from '@/components/module3/Manage_Work/Manage_Lost'

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
    ,{
      path: '/companyregister',
      name: 'cl',
      component: Company_register
    },
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
        },
        {
          path:'/company/pay',
          component:Company_pay
        }
        ,
        {
          path:'/company/paypage',
          component:Company_paypage
        },
        {
          path:'/company/succeed',
          component:Company_succeed
        }
      ]
    }

    //管理功能模块
    ,{
      path: '/module3/Manage_Login',
      name: 'Manage_Login',
      component: Manage_Login
    },
    {
      path: '/module3/Manage_Register',
      name: 'Manage_Register',
      component: Manage_Register
    },
    {
      path: '/module3/Manage_Home',
      name: 'Manage_Home',
      component: Manage_Home
     },
    
    {
      path: '/module3/Manage_Check',
      name: 'Manage_Check',
      component: Manage_Check
    },
    {
      path: '/module3/Manage_Modify',
      name: 'Manage_Modify',
      component: Manage_Modify
    },
    {
      path: '/module3/Manage_Freeze',
      name: 'Manage_Freeze',
      component: Manage_Freeze
    },
    {
      path: '/module3/Manage_Lost',
      name: 'Manage_Lost',
      component: Manage_Lost
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

