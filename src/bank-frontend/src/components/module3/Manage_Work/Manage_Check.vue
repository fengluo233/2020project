<template> 
<el-container class="com_home_container">
        <!-- 头部区域-->
        <el-header>
            <div>
                <span>操作员处理界面</span>
            </div>
            <el-button type="info" @click="logout">退出</el-button>
        </el-header>
        <!-- 页面主体区域-->
        <el-container>
          <!-- 侧边栏区域-->
         <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
  
  <el-submenu index="2">
    <template slot="title">用户信息</template>
    <el-menu-item index="2-1" @click="checkinfo">查看用户信息</el-menu-item>
    <el-menu-item index="2-2" @click="modifyinfo">修改用户信息</el-menu-item>
  </el-submenu>
  <el-menu-item index="1" @click="freeze">账户冻结</el-menu-item>
  <el-menu-item index="3" @click="lost">用户挂失</el-menu-item>
  
</el-menu>

        </el-container>
        <div>
    <div style="margin-top: 15px;">
        <el-input placeholder="请输入手机号" v-model="mobile">
            <template slot="append"><span @click="search">查看</span></template>
        </el-input>
        <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="email"
        label="用户邮箱"
        width="180">
      </el-table-column>
      <el-table-column
        prop="total_assets"
        label="总资产"
        width="180">
      </el-table-column>
      <el-table-column
        prop="balance"
        label="银行卡余额">
      </el-table-column>
      <el-table-column
        prop="money_management"
        label="理财产品">
      </el-table-column>
      <el-table-column
        prop="cardnum"
        label="银行卡号">
      </el-table-column>
      <el-table-column
        prop="funds"
        label="基金">
      </el-table-column>
      <el-table-column
        prop="gold"
        label="黄金">
      </el-table-column>
    </el-table>
    </div>
   </div>
    </el-container>

  
</template>
<script>
import axios from 'axios'
export default {
    name:'admin-check',
    data(){
        return {
            mobile:'',
            tableData:[]
        }
    },
    methods:{
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
      logout(){
        this.$router.replace({name:'Manage_Login'})
      },
      checkinfo(){
        this.$router.push({name:'Manage_Check'})
      },
      modifyinfo(){
        this.$router.push({name:'Manage_Modify'})
      },
      freeze(){
        this.$router.push({name:'Manage_Freeze'})
      },
      lost(){
        this.$router.push({name:'Manage_Lost'})
      },
        search(){
            if(this.mobile==''){
              return   this.$message.info('请填写手机号')
            }
            axios
              .post('/api/admincheck', {
                mobile:this.mobile
              })
              .then(res => {
                // console.log('输出response.data.status', res.data.status);
                if (res.data.success === true) {
                  this.tableData = res.data.data
                } else {
                  alert(res.data.error);
                }
              });
        }
    }
}
</script>
<style  scoped>
.el-menu.el-menu--horizontal {
    border-bottom:0px !important;
}
.com_home_container{
    height: 100%;
}
.el-header{
    background-color: #808a87;
    display: flex;
    justify-content: space-between;
    align-items: center;
    color: #fff;
    font-size: 20;
}

.el-aside{
    background-color:cadetblue;
}

.el-aside{
    background-color: #eaedf1;
}
.toggle-button{
    background-color: #cccccc;
    font-size: 10px;
    line-height: 24px;
    color: #fff;
    text-align: center;
    letter-spacing: 0.2em;
    cursor: pointer;
}
.el-container {
    display: block!important;
    flex-direction: row;
    flex: 1;
    flex-basis: auto;
    box-sizing: border-box;
    min-width: 0;
}
</style>
