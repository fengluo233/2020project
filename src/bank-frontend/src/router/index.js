import Vue from 'vue'
import Router from 'vue-router'
// import Home from '@/page/Home'
import Login from '@/components/Login'
import Register from '@/components/Register'
 
Vue.use(Router)
 
export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    // {
    //   path: '/home',
    //   name: 'Home',
    //   component: Home
    // }
  ],
  mode: "history"
})
