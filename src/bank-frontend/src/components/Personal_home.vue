<template>
<div>
<el-container >
  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
    <el-menu :default-openeds="['1', '3']">
      <el-submenu index="1">
        <template slot="title"><i class="el-icon-message"></i>我的信息</template>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title"><i class="el-icon-menu"></i>我的钱包</template>
           <el-menu-item-group>
          <template slot="title">流水账单</template>
        </el-menu-item-group>
        <el-menu-item-group>
          <template slot="title">基金</template>
          <el-menu-item index="2-1">基金1</el-menu-item>
          <el-menu-item index="2-2">基金2</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group>
          <template slot="title">理财产品</template>
          <el-menu-item index="2-1">理财产品1</el-menu-item>
          <el-menu-item index="2-2">理财产品2</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group>
          <template slot="title">黄金</template>
        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="3">
        <template slot="title"><i class="el-icon-setting"></i>生活服务</template>
        <el-menu-item-group>
          <template slot="title">分组一</template>
          <el-menu-item index="3-1">选项1</el-menu-item>
          <el-menu-item index="3-2">选项2</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="分组2">
          <el-menu-item index="3-3">选项3</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="3-4">
          <template slot="title">选项4</template>
          <el-menu-item index="3-4-1">选项4-1</el-menu-item>
        </el-submenu>
      </el-submenu>
    </el-menu>
  </el-aside>
  
  <el-container>
    <el-header style="text-align: right; font-size: 12px">
      <el-dropdown>
        <i class="el-icon-setting" style="margin-right: 15px"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>查看</el-dropdown-item>
          <el-dropdown-item>新增</el-dropdown-item>
          <el-dropdown-item>删除</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <span>王小虎</span>
    </el-header>
    
    <el-main>
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
    </el-main>
  </el-container>
</el-container>
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
  };
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
