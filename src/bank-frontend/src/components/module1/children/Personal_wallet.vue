<template>
 <div>
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/company/hello' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>查询账单</el-breadcrumb-item>
            <el-breadcrumb-item>查看账单信息</el-breadcrumb-item>
        </el-breadcrumb>

  <el-table :data="tableData">
        <el-table-column prop="date" label="账单日期" width="140">
        </el-table-column>
        <el-table-column prop="money" label="账单金额" width="120">
        </el-table-column>
        <el-table-column prop="balance" label="银行卡余额">
        </el-table-column>
        <el-table-column prop="method" label="支付方式">
        </el-table-column>
        <el-table-column prop="details" label="详情">
        </el-table-column>
      </el-table>
    </div>
</template>

<script>
  export default {
     data() {
      
      const item = {
        date: '2016-05-02',
        money: '200',
        balance: '30021',
        method:'手机支付',
        details:'话费'

      };
      return {
        tableData: Array(20).fill(item)
      }
    }
  }
</script>