/* eslint-disable vue/valid-v-on */
<template> 
    <el-container class="com_home_container">
        <!-- 头部区域-->
        <el-header>
            <div>
                <span>网上银行公司业务</span>
            </div>
            <el-button type="info" @click="logout">退出</el-button>
        </el-header>
        <!-- 页面主体区域-->
        <el-container>
          <!-- 侧边栏区域-->
          <el-aside width="200px">
              <div class="toggle-button">|||</div>
              <!-- 侧边栏菜单区域-->
            <el-menu
            background-color="#ffffff"
            text-color="#000000"
            active-text-color="#409eff"
            unique-opened="true"
            router="true"
            :default-active="activePath">
            <!-- 一级菜单-->
            <el-submenu index="1">
                <!-- 一级菜单模板区域-->
                <template slot="title">
                <!-- 图标-->
                <i class="el-icon-more"></i>
                <!-- 文本-->
                <span>公司信息</span>
                </template>
                <!-- 二级菜单-->
                <el-menu-item index="user" @click="saveNavState('/user')">
                <template slot="title">
                <!-- 图标-->
                <i class="el-icon-location"></i>
                <!-- 文本-->
                <span>查看公司信息</span>
                </template>
                </el-menu-item>
            </el-submenu>

            <el-submenu index="2">
                <!-- 一级菜单模板区域-->
                <template slot="title">
                <!-- 图标-->
                <i class="el-icon-more"></i>
                <!-- 文本-->
                <span>查询账单</span>
                </template>
                <!-- 二级菜单-->
                <el-menu-item index="expense" @click="saveNavState('/expense')">
                <template slot="title">
                <!-- 图标-->
                <i class="el-icon-location"></i>
                <!-- 文本-->
                <span>查看账单信息</span>
                </template>
                </el-menu-item>
            </el-submenu>

            <el-submenu index="3">
                <!-- 一级菜单模板区域-->
                <template slot="title">
                <!-- 图标-->
                <i class="el-icon-more"></i>
                <!-- 文本-->
                <span>账务管理</span>
                </template>
                <!-- 二级菜单-->
                <el-menu-item index="pay">
                <template slot="title">
                <!-- 图标-->
                <i class="el-icon-location"></i>
                <!-- 文本-->
                <span>缴费</span>
                </template>
                </el-menu-item>
            </el-submenu>
            </el-menu>
          </el-aside>
          <!-- 右侧内容-->
          <el-main>
              <!-- 路由占位符-->
              <router-view></router-view>
          </el-main>
        </el-container>
    </el-container>
</template>

<script>
export default {
    data(){
        return{
            //被激活的链接
            activePath:''
        }
    },
    created(){
        this.activePath=window.sessionStorage.getItem('activePath')
    },
    methods:{
        logout(){
            window.sessionStorage.clear()
            this.$router.push('/')
        },
        //保存链接的激活状态
        saveNavState(activePath){
            window.sessionStorage.setItem('activePath',activePath)
            this.activePath=activePath
        }
    }
}

</script>

<style lang="less" scoped>
.com_home_container{
    height: 100%;
}
.el-header{
    background-color: #000000;
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
</style>
