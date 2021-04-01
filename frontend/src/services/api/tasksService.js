import { API_URL } from '@/services/api/constants'

async function fetchTasks() {
  try {
    const response = await fetch(API_URL + '/task')
    return await response.json()
  } catch (e) {
    console.error(e)
  }
}

async function addTask(task) {
  try {
    const response = await fetch(API_URL + '/task', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json;charset=utf-8'
      },
      body: JSON.stringify(task)
    })
    return await response.json()
  } catch (e) {
    console.error(e)
  }
}

async function removeTask(id) {
  try {
    await fetch(API_URL + `/task/${id}`, {
      method: 'DELETE'
    })
  } catch (e) {
    console.error(e)
  }
}

async function updateTaskStatus(id, status) {
  try {
    await fetch(API_URL + `/task/${id}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json;charset=utf-8'
      },
      body: JSON.stringify({
        id,
        complete: status
      })
    })
  } catch (e) {
    console.error(e)
  }
}

export {
  fetchTasks,
  addTask,
  removeTask,
  updateTaskStatus
}
