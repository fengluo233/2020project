<template>
  <!--为echarts准备一个具备大小的容器dom-->
  <div>
        <div id="echartsDiv" style="width: 48%; height: 430px; float: left;"></div>
   <div id="tableDiv" style="width: 52%;float: left;">
        <el-table :data="tableData"  border row-key="id" style="margin: 0 auto" :row-class-name="getRowClassName">
            <el-table-column fixed type="index" label="序号"   align="center"  show-overflow-tooltip></el-table-column>
            <el-table-column  fixed prop="sourceName" label="投诉方式" align="center"  show-overflow-tooltip></el-table-column>
            <el-table-column prop="totalCount" label="数量"  align="center" show-overflow-tooltip></el-table-column>
            <el-table-column prop="completedPercent" label="百分比"  align="center" show-overflow-tooltip></el-table-column>
            
        </el-table>
    </div>
    </div>
</template>
<script>
  import echarts from 'echarts'
    export default {
        name: 'echartsDiv',
        data () {
            return {
                charts: '',
                opinion:['男','女'],
                opinionData:[
                  {value:335, name:'男'},
                  {value:310, name:'女'},
                
                ]
            }
        },
        methods:{
            drawPie(id){
               this.charts = echarts.init(document.getElementById(id))
               this.charts.setOption({
                 tooltip: {
                   trigger: 'item',
                  
                 },
                 legend: {
        orient: 'vertical',
        left: 10,
        data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
    },
                  series: [
        {
            name: '访问来源',
            type: 'pie',
            radius: ['50%', '70%'],
            avoidLabelOverlap: false,
            label: {
                show: false,
                position: 'center'
            },
            emphasis: {
                label: {
                    show: true,
                    fontSize: '30',
                    fontWeight: 'bold'
                }
            },
            labelLine: {
                show: false
            },
            data: [
                {value: 335, name: '直接访问'},
                {value: 310, name: '邮件营销'},
                {value: 234, name: '联盟广告'},
                {value: 135, name: '视频广告'},
                {value: 1548, name: '搜索引擎'}
            ]
        }
    ]
               })
            }
        },
      //调用
        mounted(){
            this.$nextTick(function() {
                this.drawPie('main')
            })
        }
    }
</script>
<style scoped>
    * {
        margin: 0;
        padding: 0;
        list-style: none;
    }
</style>