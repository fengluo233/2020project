<template>
<div>
 <el-carousel :interval="4000" type="card" width="400px" height="150px">
      <el-carousel-item v-for="item in imagesbox1" :key="item.id">
        <img :src="item.idView" class="image" />
      </el-carousel-item>
    </el-carousel>
  <div class="block">
  <el-timeline>
      <el-timeline-item timestamp="欢迎使用" placement="top">
      <el-card>
        <h4>欢迎使用网上银行公司业务！</h4>
      </el-card>
    </el-timeline-item>
    <el-timeline-item timestamp="货币汇率 2020/7/4" placement="top">
      <el-card >
  <el-table
    :data="tableData"
    stripe
    style="width: 100%"
    height="250px">
    <el-table-column
      prop="date"
      label="币种"
      width="280">
    </el-table-column>
    <el-table-column
      prop="name"
      label="现汇买入"
      width="280">
    </el-table-column>
    <el-table-column
      prop="address"
      label="现汇卖出">
    </el-table-column>
  </el-table>
      </el-card>
    </el-timeline-item>
    
    <el-timeline-item timestamp="最新公告" placement="top">
      <el-card>
        <p>企业银行基本功能实现   2020/7/3</p>
        <p>企业银行开发中.....    2020/6/22</p>
        <p>网上企业银行开始开发    2020/6/22</p>
      </el-card>
    </el-timeline-item>
  </el-timeline>
</div>
</div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
       imagesbox1: [
        { id: 0, idView: require("@/assets/png/行动.png") },
        { id: 1, idView: require("@/assets/png/钱袋子.png") },

        { id: 2, idView: require("@/assets/png/金融知识.png") },
      ],
      user: {
        name: "",
        mobile: "",
        email: "",
        cardnum: "",
        password: "",
        balance: 0.0,
        funds: 0.0,
        money_management: 0.0,
        total_assets: 0.0,
        gold:0.0
      },
        tableData: [{
          date: 'USD',
          name: '7.04780',
          address: '7.09020'
        }, {
          date: 'KRW',
          name: '0.58820',
          address: '0.59300'
        }, {
          date: 'EUR',
          name: '7.91820',
          address: '7.96580'
        }, {
          date: 'JPY',
          name: '6.55790',
          address: '6.59730'
        }]
      }
  },
  mounted() {
    this.user.mobile = this.$cookies.get("mobile")
    this.user.name = this.$cookies.get("name")
    //this.$cookies.get("mobile", this.user.mobile)
    // console.log(this.user.mobile);
    // console.log(333);
    axios
      .post("/personal/info/", {
        mobile: this.user.mobile
      })
      .then(res => {
        console.log("输出response.data.status", res.data.data);
        this.user.email = res.data.data.email;
        this.user.balance = this.numFilter(res.data.data.balance);
        this.user.cardnum = res.data.data.cardnum;
        this.user.funds = this.numFilter(res.data.data.funds);
        this.user.money_management = this.numFilter(res.data.data.money_management);
        this.user.total_assets = this.numFilter(res.data.data.total_assets);
         this.user.gold = this.numFilter(res.data.data.gold);
        this.$cookies.set("email", this.user.email) 
          
        this.$cookies.set("balance", this.user.balance)
        this.$cookies.set("cardnum", this.user.cardnum)
        this.$cookies.set("funds", this.user.funds)
        this.$cookies.set("money_management", this.user.money_management)
        this.$cookies.set("total_assets", this.user.total_assets)
        this.$cookies.set("gold", this.user.gold)

        console.log(res.data.data.email);
      });
  },
  methods:{
    numFilter (value){
    let realVal = ''
    if (!isNaN(value) && value!== '') {
      // 截取当前数据到小数点后两位
      realVal = parseFloat(value).toFixed(2);
    } else {
      realVal = '--'
    }
    return realVal
  }
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


