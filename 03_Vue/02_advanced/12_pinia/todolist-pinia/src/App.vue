<template>
    <div class="container">
        <Header></Header>
        <router-view></router-view>
        <Loading v-if="isLoading" />
    </div>
</template>

<script setup>
import Header from './components/Header.vue';
import Loading from './components/Loading.vue';
import { computed } from 'vue';
import { useTodoListStore } from './stores/todoList';

const todoListStore = useTodoListStore();
const isLoading = computed(() => todoListStore.isLoading);
const fetchTodoList = todoListStore.fetchTodoList;
fetchTodoList();
</script>

<style scoped></style>
