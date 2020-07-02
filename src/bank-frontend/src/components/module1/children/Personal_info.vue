<template>
<el-row>
  
    <el-card :body-style="{ padding: '0px' }">
      
      <div style="padding: 14px;">
        <span>银行卡号</span>
        <div class="bottom clearfix">
          <time class="time">{{ currentDate }}</time>
          <el-button type="text" class="button">查看详情</el-button>
        </div>
      </div>
    </el-card>
    <el-card :body-style="{ padding: '0px' }">
      
      <div style="padding: 14px;">
        <span>总资产</span>
        <div class="bottom clearfix">
          <time class="time">{{ currentDate }}</time>
          <el-button type="text" class="button">查看详情</el-button>
        </div>
      </div>
      <div style="padding: 14px;">
        <span>基金</span>
        <div class="bottom clearfix">
          <time class="time">{{ currentDate }}</time>
          <el-button type="text" class="button">查看详情</el-button>
        </div>
      </div>
      <div style="padding: 14px;">
        <span>理财产品</span>
        <div class="bottom clearfix">
          <time class="time">{{ currentDate }}</time>
          <el-button type="text" class="button">查看详情</el-button>
        </div>
        <div style="padding: 14px;">
        <span>黄金</span>
        <div class="bottom clearfix">
          <time class="time">{{ currentDate }}</time>
          <el-button type="text" class="button">查看详情</el-button>
        </div>
      </div>
      </div>
    </el-card>
  
</el-row>
</template>

<script>
//import axios from 'axios';
export default {
  data() {
    return {
      user: {
        name: "",
        mobile:"",
        email: "",
        cardnum:"",
        password: ""
      },
    };
  },
}
          // axios
          // .post('/personal/info/', {
          //   mobile: this.user.mobile,
          // })
          // .then(res => {
          //   console.log('输出response.data.status', res.data.status);
           
          // });
</script>

<style>
  .time {
    font-size: 13px;
    color: #999;
  }
  
  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
  
  .clearfix:after {
      clear: both
  }
</style>


