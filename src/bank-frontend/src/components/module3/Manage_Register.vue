<template>
  <div class="login clearfix" style="margin-top: 11%;">
    <div class="login-wrap">
      <el-row type="flex" justify="center">
        <el-form ref="loginForm" :model="com" status-icon label-width="80px">
          <h3>操作员注册</h3>
          <hr />
          <el-form-item prop="adminame" label="姓名">
            <el-input v-model="com.adminame" placeholder="请输入操作员姓名"></el-input>
          </el-form-item>
          <el-form-item prop="ID" label="工号">
            <el-input v-model="com.ID" placeholder="请输入工号"></el-input>
          </el-form-item>
          <el-form-item prop="password" label="密码">
            <el-input type="password" v-model="com.password" show-password placeholder="请输入密码"></el-input>
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
        adminame: "",
        ID: "",
        password: "",
        number: ""
      }
    };
  },
  created() {
    // console.log($);
    // console.log("1111");
  },

  methods: {
    doRegister() {
      if (!this.com.adminame) {
        this.$message.error("请输入姓名！");
        return;
      } else if (!this.com.ID) {
        this.$message.error("请输入工号！");
        return;
      } else if (!this.com.password) {
        this.$message.error("请输入密码！");
        return;
      } else {
        // this.$router.push({ path: "/" }); //无需向后台提交数据，方便前台调试
        axios
          .post("/administrator", {
            adminame: this.com.adminame,
            password: this.com.password,
            jobnumber: this.com.ID
          })
          .then(res => {
            // console.log("输出response.data", res.data);
            // console.log("输出response.data.status", res.data.status);
            if (res.data.success === true) {
              this.$router.push({ path: "/module3/Manage_Login" });
            } else {
              alert(res.data.error);
            }
          });
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