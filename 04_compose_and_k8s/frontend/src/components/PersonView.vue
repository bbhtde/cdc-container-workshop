<script setup lang="ts">
import type {PropType} from "vue";
import type {PersonDto} from "@/types/Person.ts";

const props = defineProps({
  inputPerson: {
    type: Object as PropType<PersonDto>,
    required: true
  }
})
</script>

<template>
  <v-card color="primary" class="ma-5 pa-5">
    <v-card-title>{{ props.inputPerson?.firstName }} {{ props.inputPerson?.lastname }}</v-card-title>
    <v-card-text>
      Born: {{ props.inputPerson?.birthDate }}
    </v-card-text>
  </v-card>
</template>

<style scoped>

</style>
