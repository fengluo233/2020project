import Vue from 'vue'
import Router from 'vue-router'

//个人业务界面
 import Personal_home from '@/components/Personal_home'
import Login from '@/components/Login'
import Register from '@/components/Register'

//公司业务界面
import Company_login from '@/components/Company/Company_login.vue'
import Company_home from '@/components/Company/Company_home.vue'
import Company_hello from '../components/Company/Company_hello.vue'
import Company_user from '../components/Company/Company_sub/user.vue'
import Company_expense from '../components/Company/Company_sub/expense.vue'
import Company_pay from '../components/Company/Company_sub/pay.vue'
import Company_paypage from '../components/Company/Company_sub/paypage.vue'
import Company_succeed from '../components/Company/Company_sub/succeed.vue'


Vue.use(Router)
 
export default new Router({
  routes: [
    {
      //个人业务
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/personalhome',
      name: 'Personal_home',
      component: Personal_home
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
  ],
  mode: "history"
})
