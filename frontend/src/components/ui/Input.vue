<template>
  <label>
    <span
      v-if="label"
      class="text-sm text-gray-800 font-medium"
    >
      {{ label }}
    </span>
    <input
      :type="type"
      class="input"
      :value="modelValue"
      :placeholder="placeholder"
      :disabled="disabled"
      :required="required"
      @input="$emit('update:modelValue', $event.target.value)"
    >
  </label>
</template>

<script>
export default {
  name: 'Input',
  props: {
    modelValue: {
      type: [Number, String],
      default: ''
    },
    label: {
      type: String,
      default: null
    },
    type: {
      type: String,
      default: 'text'
    },
    placeholder: {
      type: String,
      default: ''
    },
    disabled: Boolean,
    required: Boolean
  },
  emits: ['update:modelValue']
}
</script>
