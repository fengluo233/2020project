<template>
 <div>
   <el-form ref="form" :model="form" label-width="200px">
  <el-form-item label="转账金额">
    <el-input v-model="form.money"></el-input>
  </el-form-item>
  <el-form-item label="收款人账号">
    <el-input v-model="form.payee"></el-input>
  </el-form-item>
  <!-- <el-form-item label="付款人手机号">
    <el-input v-model="form.payer"></el-input>
  </el-form-item> -->
  
  <el-form-item label="详情">
    <el-input  v-model="form.details"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">转账</el-button>
    <el-button>取消</el-button>
  </el-form-item>
</el-form>
    </div>
</template>

<script>
  export default {
    data() {
      return {
        mobile:{
          name:'',
          cardnum:''
        },
        form: {
          money: '',
          payee: '',
          // payer: '',
          details: '',
        }
      }
    },

    methods: {
     
      onSubmit() {
        
      if (!this.form.money) {
        this.$message.error("请输入金额！");
        return;
      } else if (!this.form.payee) {
        this.$message.error("请输入收款人账号！");
        return;
      }
        this.$message({
          message: '确定收款人姓名：',
          type: 'warning'
        });
        
      }
    
    }

  }
</script>
