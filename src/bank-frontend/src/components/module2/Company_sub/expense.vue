<template>
    <div>
        <!--面包屑-->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/company/hello' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>查询账单</el-breadcrumb-item>
            <el-breadcrumb-item>查看账单信息</el-breadcrumb-item>
        </el-breadcrumb>

        <!--卡片视图-->
        <el-card>
        <!-- 搜索      
            <el-row gutter="20">
                <el-col :span="7"><el-input placeholder="请输入内容">
                <el-button slot="append" icon="el-icon-search"></el-button>
                </el-input>
                </el-col>
                <el-col :span="4">
                 <el-button type="primary">添加账单</el-button> 
                </el-col>
            </el-row> -->
        <!--账单-->
        <el-table :data="expenseList">
            <el-table-column label="日期" prop="date" width="80"></el-table-column>
            <el-table-column label="摘要" prop="descrition" width="180"></el-table-column>
            <el-table-column label="金额" prop="money" width="140"></el-table-column>
            <el-table-column label="付款方式" prop="method" width="180"></el-table-column>
            <el-table-column label="借方" prop="debit" width="180"></el-table-column>
            <el-table-column label="贷方" prop="credit" width="180"></el-table-column>
        </el-table>
        </el-card>
    </div>
</template>

<script>
import axios from 'axios';
//import axios from "axios";
export default {
    data(){
            return {
        expenseList: [{
          date: '2020/7/2',
          descrition: '企业贷款',
          money: '20000',
          method: '银行卡',
          debit: 'XXX有限公司',
          credit: 'HXLGYY'
        },
        {
          date: '2020/7/2',
          descrition: '企业服务',
          money: '10000',
          method: 'ATM',
          debit: 'XXX有限公司',
          credit: 'HXLGYY'
        }
        ,
        {
          date: '2020/7/2',
          descrition: '项目投资',
          money: '400000',
          method: '交易',
          debit: 'XXX科技',
          credit: 'HXLGYY'
        },
       {
          date: '2020/7/2',
          descrition: '慈善项目',
          money: '60000',
          method: '银行卡',
          debit: 'XXX基金会',
          credit: 'HXLGYY'
        }]
    }
 },

create(){
    this.getExpenseList();
},
method:{
    getExpenseList(){
    axios
    .get('/api/company/getExpenseList', {
        }).then((response) => {
          console.log(response);
          console.log(response.data);
          this.expenseList = response.data;
        }).catch((error) => {
          // catch 指请求出错的处理
          console.log(error);
        });
      }
}
}
</script>

<style lang="less" scoped>

</style>