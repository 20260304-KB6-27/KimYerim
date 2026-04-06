<template>
    <h3>존재하지 않는 경로</h3>
    <p>요청경로 : {{}}</p>
</template>

<script setup>
import { useRoute } from 'vue-router';

const currentRouted = useRoute();
</script>

<style scoped></style>
