<template>
    <ul>
        <PostItem
            v-for="(post, index) in reversedPost"
            :key="post.no"
            :post="post"
            :selectedPost="selectedPost"
            :editingPost="editingPost"
            :editTitle="editTitle"
            :editContent="editContent"
            @view="viewContent"
            @start-edit="startEdit"
            @delete="deletePost"
            @save="saveEdit"
            @cancel="cancelEdit"
            @close="closePost"
            @update:editTitle="updateEditTitle"
            @update:editContent="updateEditContent"
        >
        </PostItem>
    </ul>
</template>

<script setup>
import PostItem from './PostItem.vue';

const props = defineProps({
    reversedPost: Array,
    selectedPost: Object,
    editingPost: Object,
    editTitle: String,
    editContent: String,
});

const emit = defineEmits([
    'view',
    'save',
    'cancel',
    'start-edit',
    'close',
    'delete',
    'update:editTitle',
    'update:editContent',
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

const saveEdit = () => {
    emit('save');
};

const cancelEdit = () => {
    emit('cancel');
};

const closePost = () => {
    emit('close');
};

const updateEditTitle = (value) => {
    emit('update:editTitle', value);
};

const updateEditContent = (value) => {
    emit('update:editContent', value);
};
</script>

<style lang="scss" scoped></style>
