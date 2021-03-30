<template>
  <div class="bg-gray-100 h-screen">
    <Container>
      <h1 class="text-center text-4xl font-semibold mb-5">
        Task List
      </h1>
      <CardList />
    </Container>
  </div>
</template>

<script>
import Container from '@/components/ui/Container'
import CardList from '@/components/TaskCardList'

export default {
  name: 'App',
  components: {
    CardList,
    Container
  }
}
</script>
