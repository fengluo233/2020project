import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import ElementUI from 'element-ui';

import'./assets/css/global.css'

Vue.use(ElementUI)

Vue.use(router)

//全局配置
Vue.prototype.$axios = axios
Vue.config.productionTip = false
 
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
