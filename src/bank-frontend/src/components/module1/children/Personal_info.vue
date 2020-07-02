<template>
  <el-row>
    <el-card :body-style="{ padding: '0px' }" shadow="hover">
      <div style="padding: 14px;">
        <span>总资产 : </span>
        <span>{{this.user.total_assets}}</span>
        <div class="bottom clearfix">
          <time class="time">{{ currentDate }}</time>
          <el-button type="text" class="button">查看详情</el-button>
        </div>
      </div>
    </el-card>
    <el-card :body-style="{ padding: '0px' }">
      <div style="padding: 14px;">
        <span>基金 : </span>
        <span>{{this.user.funds}}</span>
        <div class="bottom clearfix">
          <time class="time">{{ currentDate }}</time>
          <el-button type="text" class="button">查看详情</el-button>
        </div>
      </div>
    </el-card>
  </el-row>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      user: {
        name: "",
        mobile: "",
        email: "",
        cardnum: "",
        password: "",
        balance: 0.0,
        funds: 0.0,
        money_management: 0.0,
        total_assets: 0.0
      }
    };
  },
  mounted() {
    this.user.mobile = this.$route.query.mobile;
    this.user.name = this.$route.query.username;
    // console.log(this.user.mobile);
    // console.log(333);
    axios
      .post("/personal/info/", {
        mobile: this.user.mobile
      })
      .then(res => {
        console.log("输出response.data.status", res.data.data);
        this.user.email = res.data.data.email;
        this.user.balance = res.data.data.balance;
        this.user.cardnum = res.data.data.cardnum;
        this.user.funds = res.data.data.funds;
        this.user.money_management = res.data.data.money_management;
        this.user.total_assets = res.data.data.total_assets;
        console.log(res.data.data.email);
      });
  }
};
</script>

<style>
.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both;
}
</style>


