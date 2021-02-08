<template>
  <div id="app">
    <!-- <Header /> -->
    <div id="content" class="mainStyle">
        <router-view></router-view>
    </div>
    <Footer/>
  </div>
  
</template>

<script>
// import Header from './components/layout/Header.vue';
import Footer from './components/layout/Footer.vue';

export default {
  name: 'App',
  components: {   //컴포넌트 이름 설정한것은 여기다가 넣어주기!!!
    // Header,
    Footer,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */
}
.mainStyle {
  background-color: rgb(255, 255, 255);
  width : 100%;
  height : 100%;
  /* background-image : url(https://blog.kakaocdn.net/dn/DHa70/btqH7agcbWQ/qbFXl10WKf5T6WmsRVCv60/img.jpg); */
  /* background-size : 125rem 47rem; */
}

</style>
