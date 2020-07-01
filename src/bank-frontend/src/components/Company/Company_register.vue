<template>
  <div class="login clearfix">
    <div class="login-wrap">
      <el-row type="flex" justify="center">
        <el-form ref="loginForm" :model="company" status-icon label-width="80px">
          <h3>企业注册</h3>
          <hr>
          <el-form-item prop="address" label="公司地址">
            <el-input v-model="com.address" placeholder="请输入开户地区"></el-input>
          </el-form-item>
          <el-form-item prop="ID" label="卡号">
            <el-input v-model="com.ID" placeholder="请输入卡号"></el-input>
          </el-form-item>
          <el-form-item prop="password" label="密码">
            <el-input v-model="com.password" show-password placeholder="请输入密码"></el-input>
          </el-form-item>
          <el-form-item prop="number" label="持卡人证件号">
            <el-input v-model="com.number" show-password placeholder="请输入证件号"></el-input>
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
  name: "register",
  data() {
    return {
      com: {
        address: "",
        ID: "",
        password: "",
        number: ""
      },
    };
  },
  created() {
    // console.log($);
    // console.log("1111");
  },
  methods: {
    doRegister() {
      if (!this.com.address) {
        this.$message.error("请输入开户地址！");
        return;
      } else if (!this.com.ID) {
        this.$message.error("请输入卡号！");
        return;
      } else if (!this.com.password) {
          this.$message.error("请输入密码！");
          return;
        }else if (!this.com.number) {
          this.$message.error("请输入证件号！");
          return;
        } else {
          // this.$router.push({ path: "/" }); //无需向后台提交数据，方便前台调试
          axios
            .post("/register/", {
              name: this.user.username,
              email: this.user.email,
              password: this.user.password
            })
            .then(res => {
              // console.log("输出response.data", res.data);
              // console.log("输出response.data.status", res.data.status);
              if (res.data.status === 200) {
                this.$router.push({ path: "/" });
              } else {
                alert("您输入的用户名已存在！");
              }
            });
        }
      }
    }
  }
;
</script>
 
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.login {
  width: 100%;
  height: 740px;
  background: url("../assets/png/logo.png") no-repeat;
  background-size: cover;
  overflow: hidden;
}
.login-wrap {
  background: url("../assets/png/logo.png") no-repeat;
  background-size: cover;
  width: 400px;
  height: 300px;
  margin: 215px auto;
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
