<template>
    <div style="text-align: center">
        <input
            type="text"
            :value="newTitle"
            @input="emit('update:newTitle', $event.target.value)"
            placeholder="새 게시글 제목"
        />
        <input
            type="text"
            :value="newContent"
            @input="emit('update:newContent', $event.target.value)"
            placeholder="새 게시글 내용"
        />
        <button @click="emit('add')">작성</button>
    </div>
</template>

<script setup>
const props = defineProps({
    newTitle: String,
    newContent: String,
});

const emit = defineEmits(['update:newTitle', 'update:newContent', 'add']);
</script>

<style lang="scss" scoped></style>
