<template>
  <Card>
    <CardBody class="flex space-x-5">
      <Checkbox v-model="checked" />
      <div class="w-full flex flex-col space-y-3">
        <div class="flex justify-between">
          <h1
            class="text-xl font-semibold"
            :class="{'line-through': complete}"
          >
            {{ title }}
          </h1>
          <Button
            class="hover:bg-red-100 hover:text-red-600"
            @click="remove"
          >
            Remove
          </Button>
        </div>
        <p class="text-gray-500 text-base font-medium">
          {{ note }}
        </p>
      </div>
    </CardBody>
  </Card>
</template>

<script>
import Checkbox from '@/components/ui/Checkbox'
import Button from '@/components/ui/Button'
import Card from '@/components/ui/card/Card'
import CardBody from '@/components/ui/card/CardBody'

export default {
  name: 'TaskCard',
  components: {
    CardBody,
    Card,
    Button,
    Checkbox
  },
  props: {
    id: {
      type: Number,
      required: true
    },
    title: {
      type: String,
      required: true
    },
    note: {
      type: String,
      default: null
    },
    complete: Boolean
  },
  emits: ['updateStatus', 'removeTask'],
  data() {
    return {}
  },
  computed: {
    checked: {
      get() {
        return this.complete
      },
      set(value) {
        this.$emit('updateStatus', {
          id: this.id,
          status: value
        })
      }
    }
  },
  methods: {
    remove() {
      this.$emit('removeTask', this.id)
    }
  }
}
</script>
