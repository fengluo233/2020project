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
      <h3 class="lost-title">用户挂失</h3>
      <el-form-item label="用户名" prop="name">
        <el-input type="text" placeholder="请输入要挂失的用户名" v-model="form.name"/>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input type="email" placeholder="请输入邮箱" v-model="form.password"/>
      </el-form-item>
      <el-form-item label="手机号" prop="mobile">
        <el-input type="mobile" placeholder="请输入手机号" v-model="form.password"/>
      </el-form-item>
      <el-form-item label="银行卡号" prop="cardnum">
        <el-input type="cardnum" placeholder="请输入银行卡号" v-model="form.password"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" v-on:click="onSubmit('lostform')">挂失</el-button>
      </el-form-item>
    </el-form>

  </div>
    </el-container>


  
</template>

<script>
import axios  from 'axios'
  export default {
    name: "Login",
    data() {
      return {
        form: {
          name: '',
          email: '',
          mobile:'',
          cardnum:''
        },

        // 表单验证，需要在 el-form-item 元素中增加 prop 属性
        rules: {
          name: [
            {required: true, message: '账号不可为空', trigger: 'blur'}
          ],
          email: [
            {required: true, message: '邮箱不可为空', trigger: 'blur'}
          ],
          mobile: [
            {required: true, message: '手机号不可为空', trigger: 'blur'}
          ],
          cardnum: [
            {required: true, message: '银行卡号不可为空', trigger: 'blur'}
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
        // 为表单绑定验证功能
        this.$refs[formName].validate((valid) => {
          if (valid) {
            // 使用 vue-router 路由到指定页面，该方式称之为编程式导航
            axios
              .post('/api/adminlost',{...this.form})
              .then(res => {
                // console.log('输出response.data.status', res.data.status);
                if (res.data.success === true) {
                    this.$message.success('挂失成功')
                  this.$router.replace("/module3/Manage_Login");
                } else {
                  alert('挂失失败');
                }
              });
            
          } 
        });
      },
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
    margin: 180px auto;
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


