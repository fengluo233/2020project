<template>
    <div>
        <!--面包屑-->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/company/hello' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>公司信息</el-breadcrumb-item>
            <el-breadcrumb-item>查看公司信息</el-breadcrumb-item>
        </el-breadcrumb>
     <!--卡片视图-->
        <el-card>
        <el-table :data="userInfo">
            <el-table-column label="公司名称" prop="name"></el-table-column>
            <el-table-column label="公司所在地" prop="address"></el-table-column>
            <el-table-column label="总资产" prop="total_assets"></el-table-column>
            <el-table-column label="理财产品" prop="money_management"></el-table-column>
            <el-table-column label="贷款业务" prop="loan"></el-table-column>

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
            //公司信息
            userInfo:[]
        }
    },

create(){
    this.getUserInfo();
},
method:{
    getUserInfo(){
    axios
    .get('/api/company/getUserInfo', {
        }).then((response) => {
          console.log(response);
          console.log(response.data);
          this.userInfo = response.data;
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