<template>
    <div>
      <!--面包屑-->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/company/hello' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>账务管理</el-breadcrumb-item>
            <el-breadcrumb-item>缴费</el-breadcrumb-item>
        </el-breadcrumb>
        <el-form ref="form" :model="form" label-width="80px">
   <el-form-item label="密码" prop="pass">
    <el-input placeholder="请输入密码" v-model="input" show-password></el-input>
  </el-form-item>
  <el-form-item label="缴费方式">
    <el-select v-model="form.region" placeholder="请选择缴费方式">
      <el-option label="银行卡" value="shanghai"></el-option>
      <el-option label="二维码" value="beijing"></el-option>
    </el-select>
  </el-form-item>

  <el-form-item label="费用说明">
    <el-input type="textarea" v-model="form.desc"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">立即缴费</el-button>
    <el-button @click="cancel">取消</el-button>
  </el-form-item>
</el-form>
    </div>
</template>

<script>
  export default {
    data() {
      return {
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        input: ''
      }
    },
    methods: {
      onSubmit() {
       window.sessionStorage.clear()
            this.$router.push('/company/succeed')
      },
      cancel(){
        window.sessionStorage.clear()
            this.$router.push('/company/pay')
      }
    }
  }
</script>


<style lang="less" scoped>

</style>