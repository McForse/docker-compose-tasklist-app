<template>
  <button
    type="button"
    class="btn"
    :disabled="disabled"
    @click="$emit('click', $event)"
  >
    <slot>Button</slot>
  </button>
</template>

<script>
export default {
  name: 'Button',
  props: {
    type: {
      type: String,
      default: 'button'
    },
    disabled: Boolean
  },
  emits: ['click']
}
</script>
