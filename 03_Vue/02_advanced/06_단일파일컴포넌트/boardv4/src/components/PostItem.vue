<template>
    <div>
        <li
            class="post-item"
            @click="viewContent(post)"
            :class="{ active: selectedPost === post }"
        >
            {{ post.no }}. {{ post.title }}
            {{ selectedPost === post ? '▲' : '▼' }}
        </li>

        <li v-if="selectedPost === post" class="post-content">
            <template v-if="editingPost === post">
                <div class="row">
                    <input
                        type="text"
                        :value="editTitle"
                        @input="emit('update:editTitle', $event.target.value)"
                        class="edit-title-input"
                    />
                    <textarea
                        :value="editContent"
                        @input="emit('update:editContent', $event.target.value)"
                        class="edit-content-textarea"
                    ></textarea>
                </div>

                <button @click.stop="emit('save')">저장</button>
                <button @click.stop="emit('cancel')">취소</button>
            </template>

            <template v-else>
                <h2>{{ post.title }}</h2>
                <p>{{ post.content }}</p>
                <button @click.stop="startEdit(post)">수정</button>
                <button @click.stop="deletePost(post.no)">삭제</button>
                <button @click.stop="emit('close')">닫기</button>
            </template>
        </li>
    </div>
</template>

<script setup>
const props = defineProps({
    post: Object,
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
</script>

<style lang="scss" scoped></style>
