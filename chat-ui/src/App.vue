<script setup lang="ts">
import moment from "moment";
import { ref } from "vue";
import { io } from "socket.io-client";

let author = ref("");
let content = ref("");

interface Message {
  content: String;
  author: String;
  receiver: String;
  date: Date;
}

let messages = ref<Message[]>([]);

const socket = io("http://localhost:3002", { transports: ["websocket"] });

socket.on("msgToClient", (message) => {
  messages.value = messages.value.slice(-4);
  messages.value.push(message);
});

function send() {
  const message = {
    author: author.value,
    content: content.value,
    date: new Date().toJSON(),
  };
  content.value = "";
  socket.emit("msgToServer", message);
}
</script>

<template>
  <div class="container">
    <div class="row">
      <div class="col-md-6 offset-md-3 col-sm-12">
        <h1 class="text-center my-3">Not censured chat 💬</h1>
        <div class="input-group">
          <span class="input-group-text">Name</span>
          <input
            type="text"
            v-model="author"
            class="form-control"
            placeholder="Enter name..."
            required
          />
        </div>
        <div v-if="messages.length">
          <div
            class="card mt-3"
            v-for="(message, i) of messages"
            :key="i"
            :class="{ 'bg-primary': author === message.author }"
          >
            <div class="card-body">
              <p class="card-title">
                {{ message.author }},
                {{ moment(message.date).format("DD/MM/YYYY HH:mm") }}
              </p>
              <p class="card-text">
                {{ message.content }}
              </p>
            </div>
          </div>
        </div>
        <form @submit.prevent="send" class="my-3">
          <div class="input-group">
            <input
              type="text"
              class="form-control"
              placeholder="Enter message..."
              v-model="content"
              required
            />
            <div class="input-group-append">
              <input
                class="btn btn-outline-secondary"
                type="submit"
                value="Send"
              />
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>
