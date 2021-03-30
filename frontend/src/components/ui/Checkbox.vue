<template>
  <div class="checkbox">
    <label
      :for="uniqueId"
    >
      <input
        :id="uniqueId"
        v-model="model"
        type="checkbox"
        :checked="checked !== undefined ? checked : modelValue"
        :disabled="disabled"
      >
      <slot />
    </label>
  </div>
</template>

<script>
import getUniqueId from '@/compositions/uniqueId'

export default {
  name: 'Checkbox',
  props: {
    modelValue: Boolean,
    checked: {
      type: Boolean,
      default: undefined
    },
    disabled: Boolean
  },
  emits: ['update:modelValue'],
  setup() {
    return getUniqueId()
  },
  computed: {
    model: {
      get() {
        return this.modelValue
      },
      set(value) {
        this.$emit('update:modelValue', value)
      }
    }
  }
}
</script>
