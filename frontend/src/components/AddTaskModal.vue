<template>
  <Modal>
    <form method="post">
      <CardBody>
        <h3
          id="modal-title"
          class="text-lg leading-6 font-medium text-gray-900"
        >
          Add task
        </h3>
        <div class="mt-2 flex flex-col space-y-2">
          <Input
            v-model="title"
            label="Title"
            required
          />
          <Input
            v-model="note"
            label="Note"
            required
          />
        </div>
      </CardBody>
      <CardFooter class="flex justify-end space-x-2">
        <Button @click="close">
          Cancel
        </Button>
        <Button
          type="submit"
          class="bg-green-500 text-white hover:bg-green-600"
        >
          Create
        </Button>
      </CardFooter>
    </form>
  </Modal>
</template>

<script>
import Button from '@/components/ui/Button'
import CardFooter from '@/components/ui/card/CardFooter'
import CardBody from '@/components/ui/card/CardBody'
import Modal from '@/components/ui/Modal'
import Input from '@/components/ui/card/Input'

export default {
  name: 'AddTaskModal',
  components: {
    Input,
    Modal,
    Button,
    CardBody,
    CardFooter
  },
  emits: ['close'],
  data() {
    return {
      title: '',
      note: ''
    }
  },
  methods: {
    close() {
      this.$emit('close')
    }
  }
}
</script>
