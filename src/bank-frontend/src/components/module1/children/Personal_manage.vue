<template>
  <div>
    <el-carousel :interval="4000" type="card" height="300px">
      <el-carousel-item v-for="item in imagesbox1" :key="item.id">
        <img :src="item.idView" class="image" />
      </el-carousel-item>
    </el-carousel>

    <el-divider><i class="el-icon-mobile-phone"></i></el-divider>
    <el-carousel :interval="4000" type="card" height="300px">
      <el-carousel-item v-for="item in imagesbox1" :key="item.id">
        <img :src="item.idView" class="image" />
      </el-carousel-item>
    </el-carousel>
    <el-divider><i class="el-icon-mobile-phone"></i></el-divider>
    <el-carousel :interval="4000" type="card" height="300px">
      <el-carousel-item v-for="item in imagesbox1" :key="item.id">
        <img :src="item.idView" class="image" />
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>

export default {
  data() {
    return {
      imagesbox1: [
        { id: 0, idView: require("@/assets/png/基金1.png") },
        { id: 1, idView: require("@/assets//png/基金2.png") },

        { id: 2, idView: require("@/assets/png/基金3.png") },
      ],
    };
  },
  
};
</script>

<style>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>
