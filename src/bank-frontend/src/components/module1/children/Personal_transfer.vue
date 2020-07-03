<template>
  <div>
    <el-form ref="form" :model="form" label-width="200px">
      <el-form-item label="转账金额">
        <el-input v-model="form.money"></el-input>
      </el-form-item>
      <el-form-item label="收款人账号">
        <el-input v-model="form.payee"></el-input>
      </el-form-item>
      <el-form-item label="付款人手机号">
        <el-input v-model="form.payer"></el-input>
      </el-form-item>

      <el-form-item label="详情">
        <el-input v-model="form.details"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit()">转账</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
    <el-dialog title="提示" :visible.sync="dialogVisible" width="30%">
      <el-row type="flex" justify="center">
        <el-form
          ref="loginForm"
          :model="user"
          :rules="rules"
          status-icon
          label-width="80px"
        >
          <el-form-item id="password" prop="password" label="收款人">
            <span>{{this.test.name}}</span>
          </el-form-item>
          

          <el-form-item id="password" prop="password" label="密码">
            <el-input
              v-model="user.password"
              show-password
              placeholder="请输入密码"
            ></el-input>
          </el-form-item>
        </el-form>
      </el-row>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="inspect(), (dialogVisible = false)"
          >确 定</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      //弹出框的显示
      dialogVisible: false,
      //本机用户名密码验证
      user: {
        mobile: "",
        name: "",
        password: "",
      },
      //传递收款人相关信息
      form: {
        money: "",
        payee: "",
        payer: "",
        details: "",
      },
      //得到收款人手机号用于确定验证收款是否正确
      test: {
        name: "",
        cardnum: "",
        mobile: "",
      },
    };
  },
  mounted() {
    //一启动得到本机的手机号和用户名方便后续验证密码
    this.user.name = this.$cookies.get("name");
    this.$cookies.get("name", this.user.name);
    this.form.payer=this.$cookies.get("mobile");
  },

  methods: {
    // handleClose(done) {
    //   this.$confirm('确认关闭？')
    //     .then(_ => {
    //       done();
    //     })
    //     .catch(_ => {});
    // },
    //点确定按钮之后检查密码是否正确
    inspect() {
      console.log(555);
      console.log(this.user);
      if (!this.user.password) {
        this.$message.error("请输入密码！");
        return;
      } else {
        
        //点确定后验证余额是否充足
        axios
          .post("/personal/pay/", {
            mode: "transfer",
            money: this.form.money,
            detail: this.form.details,
            payee: this.form.payee,
            payer: this.form.payer,
            password: this.user.password,
          })
          .then((res) => {
            // console.log('输出response.data.status', res.data.status);
            if (res.data.success === true) {
              var str = "转账成功!您的余额还有：" + res.data.data.balance;
              alert(str);
            } else {
              console.log(res.data)
              alert(res.data.error);
            }
          });
        
      }
    },

    onSubmit() {
      if (!this.form.money) {
        this.$message.error("请输入金额！");
      } else if (!this.form.payee) {
        this.$message.error("请输入收款人账号！");
      } else {
        //弹出对话框，验证手机号的主人和卡号，并且输入密码
        this.dialogVisible = true;
        axios
          .post("/personal/mobile/", {
            mobile: this.form.payee,
          })
          .then((res) => {
            console.log('输出7777',res.data);
            if (res.data.success === true) {

              this.test.name=res.data.data.username;
               
            }
          });

        return;
      }
    },
  },
};
</script>
