import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
//import store from 'store'
import ElementUI from 'element-ui';
import echarts from 'echarts';
//数据持久化
import VueCookies from 'vue-cookies';
Vue.use(VueCookies)


import'./assets/css/global.css'

Vue.use(ElementUI)

Vue.use(router)

//全局配置
Vue.prototype.$axios = axios
Vue.config.productionTip = false

// axios.defaults.headers.post['Content-Type'] = "application/json"
// axios.defaults.withCredentials = true
// axios.defaults.headers.common['Authorization'] = store.state.token
axios.defaults.baseURL = 'http://localhost:8000/api';


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  echarts,
 // store,
  components: { App },
  template: '<App/>'
})

// // 添加请求拦截器，在请求头中加token
// axios.interceptors.request.use(
//   config => {
//     if (localStorage.getItem('Authorization')) {
//       config.headers.Authorization = localStorage.getItem('Authorization');
//     }
 
//     return config;
//   },
//   error => {
//     return Promise.reject(error);
//   });
 