<template>
<el-container >

  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
    <el-menu   router="true" :default-active="$route.path">
      <el-submenu index="1">
        <template slot="title"><i class="el-icon-message"></i>我的信息</template>
        <el-menu-item-group>
          <el-menu-item index="info" @click="saveNavState('/info')">个人信息</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title"><i class="el-icon-menu"></i>我的钱包</template>
        <el-menu-item-group>
          <el-menu-item index="wallet" @click="saveNavState('/wallet')">我的钱包</el-menu-item>
          <el-menu-item index="life" @click="saveNavState('/life')">流水账单</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="3">
        <template slot="title"><i class="el-icon-setting"></i>生活服务</template>
        <el-menu-item-group>
          <el-menu-item index="mobilepay" @click="saveNavState('/mobilepay')">手机充值</el-menu-item>
          
          <el-menu-item index="transfer" @click="saveNavState('/transfer')">转账业务</el-menu-item>
          <el-menu-item index="manage" @click="saveNavState('/manage')">理财通道</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </el-aside>

  <el-container >
    <el-header style="text-align: right; font-size: 12px">
      <el-dropdown>
        <i class="el-icon-setting" style="margin-right: 30px"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>设置</el-dropdown-item>
          <el-dropdown-item>退出</el-dropdown-item>
          <el-dropdown-item>删除</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <span>王小虎</span>
    </el-header>
  
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</el-container>
</template>
 
<script>
 export default {
   
    }
</script>
 
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
 .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }
  
  .el-aside {
    color: #333;
  }
</style>
