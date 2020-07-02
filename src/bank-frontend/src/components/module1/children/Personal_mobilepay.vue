<template>
<div>
    <el-button @click="dialog = true" type="primary" style="margin: 35px;">
  手机充值
   </el-button>
   <el-button @click="dialog = true" type="primary" style="margin: 35px;">
  电费充值
   </el-button>
    <el-button @click="dialog = true" type="primary" style="margin: 35px;">
  水费充值
   </el-button>
    <el-button @click="dialog = true" type="primary" style="margin: 35px;">
  有线电视
   </el-button>
    <el-button @click="dialog = true" type="primary" style="margin: 35px;">
  生活缴费
   </el-button>
   <el-button @click="dialog = true" type="primary" style="margin: 35px;">
  城市服务
   </el-button>
   <el-button @click="dialog = true" type="primary" style="margin: 35px;">
  医疗健康
</el-button>
<el-divider><i class="el-icon-mobile-phone"></i></el-divider>
  <el-table :data="tableData">
        <el-table-column prop="date" label="账单日期">
        </el-table-column>
        <el-table-column prop="money" label="账单金额" >
        </el-table-column>
        <el-table-column prop="balance" label="银行卡余额">
        </el-table-column>
        <el-table-column prop="method" label="支付方式">
        </el-table-column>
        <el-table-column prop="details" label="详情">
        </el-table-column>
      </el-table>

<el-drawer
  :before-close="handleClose"
  :visible.sync="dialog"
  custom-class="demo-drawer"
  size="50%"
  ref="drawer"
  >
  <div class="demo-drawer__content">
    <el-form :model="form">
      <el-form-item label="手机号" :label-width="formLabelWidth">
        <el-input v-model="mobile" autocomplete="off"></el-input>
      </el-form-item>
       <el-form-item label="支付金额" :label-width="formLabelWidth">
        <el-input v-model="money" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div class="demo-drawer__footer">
      <el-button @click="cancelForm">取 消</el-button>
      <el-button @click="innerDrawer = true">确定支付</el-button>
        <el-drawer
        :append-to-body="true"
        :before-close="handleClose"
        :visible.sync="innerDrawer">
        <el-form :model="form">
      <el-form-item label="手机号" :label-width="formLabelWidth">
        <el-input v-model="mobile" autocomplete="off"></el-input>
      </el-form-item>
       <el-form-item label="输入密码" :label-width="formLabelWidth">
        <el-input v-model="money" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
      <el-button @click="cancelForm">取 消</el-button>
        <el-button type="primary" @click="$refs.drawer.closeDrawer()" :loading="loading">{{ loading ? '提交中 ...' : '确 定' }}</el-button>
   </el-drawer>
    </div>
  </div>
</el-drawer>

</div>
</template>


<script>
  export default {
  data() {
    return {
      dialog: false,
      loading: false,
      innerDrawer: false,
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
      formLabelWidth: '80px',
      timer: null,
    };
  },
//   methods: {
//     handleClose(done) {
//       if (this.loading) {
//         return;
//       }
//       this.$confirm('确定要提交表单吗？')
//         .then(_ => {
//           this.loading = true;
//           this.timer = setTimeout(() => {
//             done();
//             // 动画关闭需要一定的时间
//             setTimeout(() => {
//               this.loading = false;
//             }, 400);
//           }, 2000);
//         })
//     },
//     cancelForm() {
//       this.loading = false;
//       this.dialog = false;
//       clearTimeout(this.timer);
//     }
//   }
}
</script>