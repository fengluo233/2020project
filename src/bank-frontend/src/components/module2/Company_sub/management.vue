<template>
<div>
<!--面包屑-->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/company/hello' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>企业服务</el-breadcrumb-item>
            <el-breadcrumb-item>理财产品</el-breadcrumb-item>
        </el-breadcrumb>
  <el-table
    :data="tableData"
    style="width: 100%"
    :row-class-name="tableRowClassName">
    <el-table-column
      prop="name"
      label="产品名称"
      width="180">
    </el-table-column>
    <el-table-column
      prop="date1"
      label="起始日期"
      width="180">
    </el-table-column>
    <el-table-column
      prop="date2"
      label="终止日期"
      width="180">
    </el-table-column>
    <el-table-column
      prop="kind"
      label="币种"
      width="180">
    </el-table-column>
    <el-table-column
      prop="time"
      label="期限"
      width="180">
    </el-table-column>
    <el-table-column
      prop="rate1"
      label="预期收益率"
      width="180">
    </el-table-column>
    <el-table-column
      prop="rate2"
      label="实际收益率"
      width="180">
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
        tableData: [
          {
            name: '企银财富161号',
            date1: '2020.06.28',
            date2: '2020.07.02',
            kind: 'CNY',
            time: '91天',
            rate1: '2.3%',
            rate2: '3.6%'
          },
          {
            name: '企银财富160号',
            date1: '2020.06.20',
            date2: '2020.07.28',
            kind: 'CNY',
            time: '89天',
            rate1: '2.2%',
            rate2: '3.4%'
          },
          {
            name: '企银财富159号',
            date1: '2020.06.15',
            date2: '2020.06.18',
            kind: 'CNY',
            time: '33天',
            rate1: '2.2%',
            rate2: '3.4%'
          },
          {
            name: '企银财富158号',
            date1: '2020.06.10',
            date2: '2020.06.13',
            kind: 'CNY',
            time: '90天',
            rate1: '2.2%',
            rate2: '1.9%'
          },
          {
            name: '企银财富157号',
            date1: '2020.06.05',
            date2: '2020.06.07',
            kind: 'CNY',
            time: '34天',
            rate1: '3.3%',
            rate2: '2.8%'
          },
          ]
      }
    }
  }
</script>