<template>
<div class="topstyle">
     <b-navbar toggleable type="dark" variant="dark">
    <b-navbar-brand href="#">NavBar</b-navbar-brand>

    <b-navbar-toggle target="navbar-toggle-collapse">
      <template #default="{ expanded }">
        <b-icon v-if="expanded" icon="chevron-bar-up"></b-icon>
        <b-icon v-else icon="chevron-bar-down"></b-icon>
      </template>
    </b-navbar-toggle>

    <b-collapse id="navbar-toggle-collapse" is-nav>
      <b-navbar-nav class="ml-auto">
        <b-nav-item href="/">Home page</b-nav-item>
        <b-nav-item href="/num">Image page</b-nav-item>
        <b-nav-item href="/bbs">Bbs page</b-nav-item>
        <b-nav-item href="/test">Test page</b-nav-item>
        <b-nav-item href="#" disabled>Disabled</b-nav-item>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
 </div>
</template>
<script>
export default {
    name: "Header",
};
</script>

<style>
.topstyle{
    z-index: 1;
 }

</style>