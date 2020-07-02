<template>
  <div class="login clearfix">
    <div class="login-wrap">
      <el-row type="flex" justify="center">
        <el-form ref="loginForm" :model="user" status-icon label-width="80px">
          <h3>注册</h3>
          <hr>
          <el-form-item prop="username" label="用户名">
            <el-input v-model="user.username" placeholder="请输入用户名"></el-input>
          </el-form-item>
          <el-form-item prop="mobile" label="电话">
            <el-input v-model="user.mobile" placeholder="请输入电话"></el-input>
          </el-form-item>
          <el-form-item prop="email" label="邮箱">
            <el-input v-model="user.email" placeholder="请输入邮箱"></el-input>
          </el-form-item>
          <el-form-item prop="cardnum" label="银行卡号">
            <el-input v-model="user.cardnum" placeholder="请输入银行卡号"></el-input>
          </el-form-item>
          <el-form-item prop="password" label="设置密码">
            <el-input v-model="user.password" show-password placeholder="请输入密码"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon @click="doRegister()">注册账号</el-button>
          </el-form-item>
        </el-form>
      </el-row>
    </div>
  </div>
</template>
 
<script>
import axios from "axios";
export default {
  name: "login",
  data() {
    return {
      user: {
        name: "",
        mobile:"",
        email: "",
        cardnum:"",
        password: ""
      },
    };
  },
  mounted() {
    this.$cookies.config('1d','/');
    axios
      .post("/personal/user/", {
        name: this.user.username,
              mobile: this.user.mobile,
              email: this.user.email,
              cardnum: this.user.cardnum,
              password: this.user.password
      })
      .then(res => {
        console.log("输出response.data.status", res.data.data);
        this.user.email = res.data.data.email;
        this.user.mobile = res.data.data.mobile;
        this.user.cardnum = res.data.data.cardnum;
        this.$cookies.set("email", this.user.email)  
        this.$cookies.set("cardnum", this.user.cardnum)
        this.$cookies.set("mobile", this.user.mobile)
        this.$cookies.set("name", this.user.name)

        console.log(res.data.data.email);
      });
  },
  created() {
    // console.log($);
    // console.log("1111");
  },
  methods: {
    doRegister() {
      if (!this.user.username) {
        this.$message.error("请输入用户名！");
        return;
      } else if (!this.user.mobile) {
          this.$message.error("请输入手机号！");
          return;
        }else if (!this.user.cardnum) {
        this.$message.error("请输入卡号！");
        return;
      } else if (!this.user.email) {
        this.$message.error("请输入邮箱！");
        return;
      } else if (this.user.email != null) {
        var reg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        if (!reg.test(this.user.email)) {
          this.$message.error("请输入有效的邮箱！");
        } else if (!this.user.password) {
          this.$message.error("请输入密码！");
          return;
        } else {
           //this.$router.push({ path: "/" }); //无需向后台提交数据，方便前台调试
          axios
            .post("/personal/user/", {
              name: this.user.username,
              mobile: this.user.mobile,
              email: this.user.email,
              cardnum: this.user.cardnum,
              password: this.user.password
            })
            .then(res => {
              // console.log("输出response.data", res.data);
              // console.log("输出response.data.status", res.data.status);
              console.log(res);
              if (res.data.success === true) {
                alert("注册成功！");
                this.$router.push({ path: "/" });
              } else {
                alert("您输入的用户名已存在！");
              }
            });
        }
      }
    }
  }
};
</script>
 
<!-- Add "scoped" attribute to limit CSS to this component only -->
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
  height: 500px;
  margin: 100px auto;
  overflow: hidden;
  padding-top: 10px;
  line-height: 20px;
}
 
h3 {
  color: #0babeab8;
  font-size: 24px;
}
hr {
  background-color: #444;
  margin: 20px auto;
}
 
.el-button {
  width: 80%;
  margin-left: -50px;
}
</style>
