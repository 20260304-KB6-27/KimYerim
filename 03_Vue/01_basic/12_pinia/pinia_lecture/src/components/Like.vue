<template>
    <h3>좋아요 : {{ like.like }}</h3>
    <h3>5배씩 불려서 좋아요 보기 : {{ like.fivetime }}</h3>
    <button @click="like.increment">좋아요</button>
</template>

<script setup>
// import { useLikeStore } from '@/stores/like';

// const like = useLikeStore();

import { useLikePersistStore } from '@/stores/persist/Persist_like';

const like = useLikePersistStore();
</script>

<style scoped></style>
