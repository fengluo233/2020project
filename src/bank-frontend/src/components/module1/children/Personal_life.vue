<template>
  <div>
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/company/hello' }"
        >首页</el-breadcrumb-item
      >
      <el-breadcrumb-item>查询账单</el-breadcrumb-item>
      <el-breadcrumb-item>查看账单信息</el-breadcrumb-item>
    </el-breadcrumb>

    <el-table :data="bill_list">
      <el-table-column prop="date" label="账单日期"> </el-table-column>
      <el-table-column prop="money" label="账单金额"> </el-table-column>
      <el-table-column prop="balance" label="银行卡余额"> </el-table-column>
      <el-table-column prop="method" label="支付方式"> </el-table-column>
      <el-table-column prop="details" label="详情"> </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      bill_list: {
        mobile: "",
        name: "",
        date: "",
        money: "",
        method: "",
        details: "",
        balance: 0.0,
      },
    };
  },
  mounted() {
    // this.bill_list.mobile = this.$route.query.mobile;
    // this.bill_list.name = this.$route.query.username;
    // console.log(this.bill_list.mobile);
   console.log(333);
    console.log(this.$cookies.get("mobile"))
    axios
      .post("/personal/wallet/", {
        mobile: this.$cookies.get("mobile")
      })
      .then((res) => {
        console.log(res.data.data);
        var data = [];
        var kind = ["转账汇款","手机支付","理财基金","黄金","转账收入","其他"];
        for(var k =0;k<res.data.data.bill_list.length ;k++){
          var obj ={};
          obj.date=this.dateFilter(res.data.data.bill_list[k].date);
          obj.money=this.numFilter(res.data.data.bill_list[k].money);
          obj.method=kind[res.data.data.bill_list[k].method];
          obj.details=res.data.data.bill_list[k].details;
          obj.balance=this.numFilter(res.data.data.bill_list[k].balance);
          data[res.data.data.bill_list.length - k-1]=obj;
          console.log(k);
        }
        this.bill_list=data;
        // this.bill_list.date = res.data.data.date;
        // this.bill_list.balance = this.numFilter(res.data.data.balance);
        // this.bill_list.money = this.numFilter(res.data.data.money);
        // this.bill_list.method = res.data.data.method;
        // this.bill_list.details = res.data.data.details;
        console.log(res.data.data.email);
     
      });
  },
  methods: {
    numFilter(value) {
      let realVal = "";
      if (!isNaN(value) && value !== "") {
        // 截取当前数据到小数点后两位
        realVal = parseFloat(value).toFixed(2);
      } else {
        realVal = "--";
      }
      return realVal;
    },
    dateFilter(da){
      da = new Date(da);
    var year = da.getFullYear()+'年';
    var month = da.getMonth()+1+'月';
    var date = da.getDate()+'日';
    return ([year,month,date].join('-'));

    }
  },
};
</script>
