<template>
    <h1>📌 게시판 목록 v4</h1>

    <!-- 게시글 추가 -->
    <InputPost
        :newTitle="newTitle"
        :newContent="newContent"
        @update:newTitle="updateNewTitle"
        @update:newContent="updateNewContent"
        @add="addPost"
    ></InputPost>

    <!-- 게시글 목록 -->
    <PostList
        :reversedPost="reversedPost"
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
    />
</template>

<script setup>
import InputPost from './components/InputPost.vue';
import PostList from './components/PostList.vue';
import { ref, computed } from 'vue';

const posts = ref([
    {
        no: 1,
        title: 'Vue.js 기초 배우기',
        content:
            'Vue.js는 사용자 인터페이스를 구축하기 위한 프로그레시브 프레임워크입니다.',
    },
    {
        no: 2,
        title: '자바스크립트 ES6 문법',
        content:
            'ES6는 JavaScript의 최신 문법을 포함하며, let/const, 화살표 함수, 구조 분해 할당 등을 제공합니다.',
    },
    {
        no: 3,
        title: 'Node.js와 Express',
        content:
            'Node.js는 서버 측에서 JavaScript를 실행할 수 있도록 하는 런타임이며, Express는 이를 위한 경량 웹 프레임워크입니다.',
    },
    {
        no: 4,
        title: 'MongoDB 기본 개념',
        content:
            'MongoDB는 NoSQL 데이터베이스로 JSON과 유사한 문서 기반 데이터를 저장하고 관리할 수 있습니다.',
    },
    {
        no: 5,
        title: '프론트엔드와 백엔드의 차이',
        content:
            '프론트엔드는 사용자가 보는 부분을 개발하는 것이고, 백엔드는 서버와 데이터베이스를 관리하는 부분입니다.',
    },
    {
        no: 6,
        title: '비동기 프로그래밍',
        content:
            'JavaScript의 비동기 처리 방식에는 콜백, 프로미스, async/await가 있습니다.',
    },
    {
        no: 7,
        title: 'Vue Router 사용법',
        content:
            'Vue Router를 사용하면 Vue.js 애플리케이션에서 페이지 이동을 쉽게 처리할 수 있습니다.',
    },
    {
        no: 8,
        title: '컴포넌트 기반 개발',
        content:
            'Vue.js에서는 컴포넌트를 사용하여 UI를 작은 단위로 쪼개서 관리할 수 있습니다.',
    },
    {
        no: 9,
        title: 'CSS와 SCSS 차이점',
        content:
            'SCSS는 CSS의 확장된 버전으로 변수, 중첩, 믹스인 등을 지원합니다.',
    },
    {
        no: 10,
        title: 'Git과 GitHub 사용법',
        content:
            'Git은 버전 관리 시스템이며, GitHub는 이를 활용한 원격 저장소 플랫폼입니다.',
    },
]);

const newTitle = ref('');
const newContent = ref('');

const selectedPost = ref(null);
const editingPost = ref(null);
const editTitle = ref('');
const editContent = ref('');

const reversedPost = computed(() => {
    return [...posts.value].reverse();
});

const updateNewTitle = (value) => {
    newTitle.value = value;
};

const updateNewContent = (value) => {
    newContent.value = value;
};

const viewContent = (post) => {
    if (selectedPost.value === post) {
        selectedPost.value = null;
        editingPost.value = null;
        return;
    }

    selectedPost.value = post;
    editingPost.value = null;
};

const addPost = () => {
    posts.value.push({
        no: posts.value.length + 1,
        title: newTitle.value,
        content: newContent.value,
    });

    newTitle.value = '';
    newContent.value = '';
};

// 수정
const startEdit = (post) => {
    editingPost.value = post;
    editTitle.value = post.title;
    editContent.value = post.content;
};

const updateEditTitle = (value) => {
    editTitle.value = value;
};

const updateEditContent = (value) => {
    editContent.value = value;
};

const saveEdit = () => {
    if (!editingPost.value) return;

    editingPost.value.title = editTitle.value;
    editingPost.value.content = editContent.value;
    editingPost.value = null;
};

const cancelEdit = () => {
    editingPost.value = null;
    editTitle.value = '';
    editContent.value = '';
};

const closePost = () => {
    selectedPost.value = null;
    editingPost.value = null;
};

// 삭제
const deletePost = (no) => {
    const isDelete = confirm('정말로 삭제하시겠습니까?');

    if (!isDelete) return;

    posts.value = posts.value.filter((post) => post.no !== no);

    posts.value.forEach((post, index) => {
        post.no = index + 1;
    });

    if (selectedPost.value && selectedPost.value.no === no) {
        selectedPost.value = null;
    }

    if (editingPost.value && editingPost.value.no === no) {
        editingPost.value = null;
        editTitle.value = '';
        editContent.value = '';
    }
};
</script>

<style scoped></style>
