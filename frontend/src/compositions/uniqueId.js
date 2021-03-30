import { ref } from 'vue'

export default function getUniqueId() {
  const uniqueId = ref(
    '_' +
    Math.random()
      .toString(36)
      .substr(2, 9)
  )

  return { uniqueId }
}
