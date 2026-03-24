<template>
    <li><input type="checkbox" :checked="checked" /> {{ name }}</li>
</template>

<!-- setup 사용시 -->
<script setup>
// defineProps : 부모요소에서 전달받은 Props를 정의하는 함수
defineProps(['name', 'checked']);
</script>

<!-- <script>
import { ref } from 'vue';

export default {
    name: 'CheckboxItem',

    setup() {
        const checked = ref(false);

        return {
            checked,
        };
    },
};
</script> -->

<style lang="scss" scoped></style>
