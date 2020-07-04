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
            <el-table-column label="公司名称" prop="name" width="180"></el-table-column>
            <el-table-column label="公司所在地" prop="address" width="180"></el-table-column>
            <el-table-column label="总资产" prop="total_assets" width="180"></el-table-column>
            <el-table-column label="贷款业务" prop="loan" width="180"></el-table-column>

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
            userInfo:[
                {
                    name: 'HXLGYY',
                    address: '湖北省武汉市',
                    total_assets: '1000亿',
                    loan: ''
                }
            ]
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