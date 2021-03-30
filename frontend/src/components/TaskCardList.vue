<template>
  <div
    v-for="(section, id) in sections"
    :key="id"
  >
    <div class="my-5 flex justify-between">
      <h2 class="text-lg font-bold">
        {{ section.title }}
      </h2>
      <Button
        v-if="id === 0"
        class="hover:bg-green-200 hover:text-green-700"
        @click="modal = true"
      >
        Add
      </Button>
    </div>
    <div class="flex flex-col space-y-2">
      <TaskCard
        v-for="task in sortTasks(section.filter)"
        :id="task.id"
        :key="task.id"
        :title="task.title"
        :note="task.note"
        :complete="task.complete"
        @update-status="updateTaskStatus"
        @remove-task="removeTask"
      />
      <div
        v-if="!sortTasks(section.filter).length"
        class="text-gray-500 font-medium"
      >
        No tasks here
      </div>
    </div>
  </div>
  <AddTaskModal
    v-if="modal"
    @close="modal = false"
  />
</template>

<script>
import TaskCard from '@/components/TaskCard'
import Button from '@/components/ui/Button'
import AddTaskModal from '@/components/AddTaskModal'

export default {
  name: 'TaskCardList',
  components: {
    AddTaskModal,
    Button,
    TaskCard
  },
  data() {
    return {
      modal: false,
      sections: [
        {
          title: 'To Do',
          filter: i => i.complete === false
        },
        {
          title: 'Done',
          filter: i => i.complete === true
        }
      ],
      tasks: [
        {
          id: 1,
          complete: false,
          title: 'First task',
          note: 'Some text here'
        },
        {
          id: 2,
          complete: true,
          title: 'Second task',
          note: 'Some text here'
        }
      ]
    }
  },
  methods: {
    updateTaskStatus({ id, status }) {
      this.tasks.find(i => i.id === id).complete = status
    },
    sortTasks(filter) {
      return this.tasks.filter(filter)
    },
    removeTask(id) {
      this.tasks = this.tasks.filter(i => i.id !== id)
    }
  }
}
</script>
