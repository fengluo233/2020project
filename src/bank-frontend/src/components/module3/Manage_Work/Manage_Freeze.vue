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
       <el-form ref="lostform" :model="form" :rules="rules" label-width="80px" class="lost-box">
      <h3 class="lost-title">用户冻结</h3>
      <el-form-item label="用户名" prop="name">
        <el-input type="text" placeholder="请输入要冻结的账号" v-model="form.name"/>
      </el-form-item>
      <el-form-item label="是否冻结" prop="isfrozen">
        <el-select v-model="form.isfrozen" placeholder="请选择缴费方式">
            <el-option label="否" value="0"></el-option>
            <el-option label="是" value="1"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" v-on:click="onSubmit('frozenform')">冻结</el-button>
      </el-form-item>
    </el-form>
   </div>
    </el-container>
   
</template>

<script>
import axios  from 'axios'
  export default {
    data() {
      return {
        form: {
          name: '',
          isfrozen: ''
        },
        input: '',
        rules: {
          name: [
            {required: true, message: '账号不可为空', trigger: 'blur'}
          ]
        },
      }
    },
    methods: {
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
      onSubmit(formName) {
          this.$refs[formName].validate((valid) => {
          if (valid) {
            // 使用 vue-router 路由到指定页面，该方式称之为编程式导航
            axios
              .post('/api/adminfreeze',{...this.form})
              .then(res => {
                // console.log('输出response.data.status', res.data.status);
                if (res.data.success === true) {
                    this.$message.success('已冻结该账户')
                  this.$router.replace("/module3/Manage_Login");
                } else {
                  alert('冻结失败');
                }
              });
            
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
  .lost-box {
    border: 1px solid #DCDFE6;
    width: 350px;
    margin: 270px auto;
    padding: 35px 35px 15px 35px;
    border-radius: 5px;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    box-shadow: 0 0 25px #909399;
  }

  .lost-title {
    text-align: center;
    margin: 0 auto 40px auto;
    color: #303133;
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