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
            <el-table-column label="日期" prop="date"></el-table-column>
            <el-table-column label="摘要" prop="descrition"></el-table-column>
            <el-table-column label="票据号" prop="number"></el-table-column>
            <el-table-column label="付款方式" prop="method"></el-table-column>
            <el-table-column label="借方" prop="debit"></el-table-column>
            <el-table-column label="贷方" prop="credit"></el-table-column>
        </el-table>
        </el-card>
    </div>
</template>

<script>
import axios from 'axios';
//import axios from "axios";
export default {
    data(){
        return{
            //账单信息
            expenseList:[]
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