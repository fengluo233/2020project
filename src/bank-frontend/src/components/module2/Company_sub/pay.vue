<template>
<div>
<!--面包屑-->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/company/hello' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>账务管理</el-breadcrumb-item>
            <el-breadcrumb-item>缴费</el-breadcrumb-item>
        </el-breadcrumb>
  <el-table
    :data="tableData"
    style="width: 100%"
    :row-class-name="tableRowClassName">
    <el-table-column
      prop="date"
      label="日期"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="缴费项目"
      width="180">
    </el-table-column>
    <el-table-column
      prop="money"
      label="待缴金额"
      width="180">
    </el-table-column>
    <el-table-column label="缴费">
        <el-button @click="onSubmit">立即缴费</el-button>
    </el-table-column>
  </el-table>
</div>
</template>

<style>
  .el-table .warning-row {
    background: oldlace;
  }

  .el-table .success-row {
    background: #f0f9eb;
  }
</style>

<script>
  export default {
    methods: {
      // eslint-disable-next-line no-unused-vars
      tableRowClassName({rowIndex}) {
        if (rowIndex === 1) {
          return 'warning-row';
        } else if (rowIndex === 3) {
          return 'success-row';
        }
        return '';
      },
      onSubmit() {
        window.sessionStorage.clear()
            this.$router.push('/company/paypage')
      }
    },
    data() {
      return {
        tableData: [{
          date: '2020/7/2',
          name: '水费',
          money: '2000',
        },
        {
          date: '2020/7/2',
          name: '电费',
          money: '3000',
        }
        ,
        {
          date: '2020/7/2',
          name: '税款',
          money: '4000',
        },
        {
          date: '2020/7/2',
          name: '电话费',
          money: '400',
        }]
      }
    }
  }
</script>