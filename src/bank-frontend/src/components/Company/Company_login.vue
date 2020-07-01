<template>
  <div class='login' clearfix>
    <div class='login-wrap'>
      <el-row type='flex' justify='center'>
        <el-form ref='loginForm' :model='company' :rules='rules' status-icon label-width='80px'>
          <h3>企业登录</h3>
          <hr>
          <el-form-item prop='ID' label='卡号'>
            <el-input v-model='com.ID' placeholder='请输入普通卡证书卡号' prefix-icon></el-input>
          </el-form-item>
          <el-form-item id='password' prop='password' label='密码'>
            <el-input v-model='com.password' show-password placeholder='请输入密码'></el-input>
          </el-form-item>
          <router-link to='/'>找回密码   </router-link>
          <router-link to='/register'>注册</router-link>
          <el-form-item>
            <el-button type='primary' icon='el-icon-upload' @click='doLogin()'>登 录</el-button>
          </el-form-item>
        </el-form>
      </el-row>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'login',
  data() {
    return {
      com: {
        ID: '',
        password: ''
      }  
    };
  },
  created() {},
  methods: {
    doLogin() {
      if (!this.com.ID) {
        this.$message.error('请输入卡号！');
        return;
      } else if (!this.com.password) {
        this.$message.error('请输入密码！');
        return;
      } else {
        //校验用户名和密码是否正确;
        // this.$router.push({ path: '/personal' });
        axios
          .post('/companylogin/', {
            name: this.com.ID,
            password: this.com.password
          })
          .then(res => {
            // console.log('输出response.data.status', res.data.status);
            if (res.data.status === 200) {
              this.$router.push({ path: '/company' });
            } else {
              alert('您输入的卡号或密码错误！');
            }
          });
      }
    }
  }
};
</script>
 
<!-- Add 'scoped' attribute to limit CSS to this component only -->
<style scoped>
.login {
  width: 100%;
  height: 740px;

  background-size: cover;
  overflow: hidden;
}
.login-wrap {

  background-size: cover;
  width: 400px;
  height: 300px;
  margin: 215px auto;
  overflow: hidden;
  padding-top: 10px;
  line-height: 40px;
}
#password {
  margin-bottom: 5px;
}
h3 {
  color: #0babeab8;
  font-size: 24px;
}
hr {
  background-color: #444;
  margin: 20px auto;
}
a {
  text-decoration: none;
  color: #aaa;
  font-size: 15px;
}
a:hover {
  color: coral;
}
.el-button {
  width: 80%;
  margin-left: -50px;
}
</style>
