<script setup lang="ts">
import {ref, type Ref} from "vue";
import type {CreatePersonDto} from "@/types/Person.ts";
import {createPerson} from "@/service/person.service.ts";

const emits = defineEmits(['saved']);
const isLoading: Ref<boolean> = ref(false);
const hasError: Ref<boolean> = ref(false);
const defaultError: string = 'An error occurred while saving...'
const errorMessage: Ref<string> = ref(defaultError)

const formData: Ref<CreatePersonDto> = ref({} as CreatePersonDto)

async function onSubmit() {
  try {
    isLoading.value = true;
    const response = await createPerson(formData.value);
    if (response) {
      isLoading.value = false;
      hasError.value = false;
      emits('saved', response)
    }
  } catch (err) {
    isLoading.value = false;
    hasError.value = true;
    if (err) {
      errorMessage.value = err.message
    } else {
      errorMessage.value = defaultError
    }
  }
}

</script>

<template>
  <v-form :disabled="isLoading" >
    <v-alert variant="tonal" type="error" class="mb-8" v-if="hasError">{{ errorMessage }}</v-alert>
    <v-text-field label="Firstname" prepend-icon="mdi-account" v-model="formData.firstName"></v-text-field>
    <v-text-field label="Lastname" prepend-icon="mdi-account-multiple" v-model="formData.lastname"></v-text-field>
    <v-date-input label="Date of birth" display-format="fullDate" v-model="formData.birthDate"></v-date-input>
    <v-btn prepend-icon="mdi-content-save" color="primary" variant="flat" :loading="isLoading" @click="onSubmit">Save</v-btn>
  </v-form>
</template>

<style scoped>

</style>
