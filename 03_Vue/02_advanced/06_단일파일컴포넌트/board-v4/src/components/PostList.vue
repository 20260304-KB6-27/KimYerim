<template>
    <PostItem
        v-for="(post, index) in reversedPost"
        :key="post.no"
        :post="post"
        @view="viewContent"
        @start-edit="startEdit"
        @delete="deletePost"
    >
    </PostItem>
</template>

<script setup>
import PostItem from './PostItem.vue';

const props = defineProps({
    reversedPost: Array,
});

const emit = defineEmits([
    'view',
    'save',
    'cancel',
    'start-edit',
    'close',
    'delete',
]);

const viewContent = (post) => {
    emit('view', post);
};

const startEdit = (post) => {
    emit('start-edit', post);
};

const deletePost = (no) => {
    emit('delete', no);
};
</script>

<style lang="scss" scoped></style>
