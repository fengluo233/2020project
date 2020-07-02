<template>
  <div>
    <!--面包屑-->
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/personal/info' }"
        >首页</el-breadcrumb-item
      >
      <el-breadcrumb-item>我的钱包</el-breadcrumb-item>
      <el-breadcrumb-item>流水账单</el-breadcrumb-item>
    </el-breadcrumb>

    <div id="main" style="width: 50%; height: 300px; float: left;"></div>

    <div id="tableDiv" style="width: 50%;height：430px; float: left;">
      <el-table :data="tableData" show-summary>
        <el-table-column prop="kind" label="种类"> </el-table-column>
        <el-table-column prop="money" label="金额"> </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import echarts from "echarts";
export default {
  name: "",
  data() {
    return {
      charts: "",
      opinion: ["账户余额", "黄金总额","理财产品总额","基金总额"],
      opinionData: [
        { value: this.$cookies.get("balance"), name: "账户余额" },
        { value: this.$cookies.get("gold"), name: "黄金总额" },
        { value: this.$cookies.get("money_management"), name: "理财产品总额" },
        { value: this.$cookies.get("funds"), name: "基金总额" },
      ],
      tableData: [
        {
          kind: "账户余额",
          money: this.$cookies.get("balance"),
        },
        {
          kind: "基金总额",
          money: this.$cookies.get("funds"),
        },
        {
          kind: "理财产品总额",
          money: this.$cookies.get("money_management"),
        },
        {
          kind: "黄金总额",
          money: this.$cookies.get("gold"),
        },
      ],
    };
  },
  mounted() {
    this.$nextTick(function() {
    this.drawPie("main");
    });
    // this.user.mobile = this.$route.query.mobile;
    // this.user.name = this.$route.query.username;

    // console.log(this.user.mobile);
    // console.log(333);

    console.log("输出balance");
    console.log(this.$cookies.get("balance"));
    this.tableData[0].kind = "账户余额";
    this.tableData[0].money = this.$cookies.get("balance");
    this.tableData[1].kind = "基金总额";
    this.tableData[1].money = this.$cookies.get("funds");
    this.tableData[2].kind = "理财产品总额";
    this.tableData[2].money = this.$cookies.get("money_management");
    this.tableData[3].kind = "黄金总额";
    this.tableData[3].money = this.$cookies.get("gold");
    // this.tableData[0].email = this.$cookies.get("email")
    // this.tableData[0].balance = this.$cookies.get("balance")
    // this.tableData[0].cardnum = this.$cookies.get("cardnum")
    // this.tableData[0].funds = this.$cookies.get("funds")
    // this.tableData[0].money_management = this.$cookies.get("money_management")
    // this.tableData[0].total_assets = this.$cookies.get("total_assets")
    // this.tableData[0].gold = this.$cookies.get("gold")
  },
  methods: {
    drawPie(id) {
      this.charts = echarts.init(document.getElementById(id));
      this.charts.setOption({
        tooltip: {
          trigger: "item",
        },
        legend: {
          orient: "vertical",
          x: "left",
          data: this.opinion,
        },
        series: [
          {
            name: "性别",
            type: "pie",
            radius: ["50%", "70%"],
            avoidLabelOverlap: false,
            label: {
              normal: {
                show: false,
                position: "center",
              },
              emphasis: {
                show: true,
                textStyle: {
                  fontSize: "30",
                  fontWeight: "blod",
                },
              },
            },
            labelLine: {
              normal: {
                show: false,
              },
            },
            data: this.opinionData,
          },
        ],
      });
    },
  },
};
</script>

<style lang="less" scoped></style>
