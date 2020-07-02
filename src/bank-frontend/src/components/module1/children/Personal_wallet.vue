<template>
<div>
     <!--面包屑-->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/personal/info' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>我的钱包</el-breadcrumb-item>
            <el-breadcrumb-item>流水账单</el-breadcrumb-item>
        </el-breadcrumb>
   <div id="echartsDiv" style="width: 48%; height: 430px; float: left;">
    </div>
    <div id="tableDiv" style="width: 52%;float: left;">
        <el-table :data="tableData"  border row-key="id" style="margin: 0 auto" :row-class-name="getRowClassName">
            <el-table-column fixed type="index" label="序号"   align="center"  show-overflow-tooltip></el-table-column>
            <el-table-column  fixed prop="sourceName" label="投诉方式" align="center"  show-overflow-tooltip></el-table-column>
            <el-table-column prop="totalCount" label="数量"  align="center" show-overflow-tooltip></el-table-column>
            <el-table-column prop="completedPercent" label="百分比"  align="center" show-overflow-tooltip></el-table-column>
            
        </el-table>
    </div>
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