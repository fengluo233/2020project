<template> 
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