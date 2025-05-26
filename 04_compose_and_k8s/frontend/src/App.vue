<template>
  <v-app>
    <v-main>
      <v-container>
        <v-progress-linear color="primary" indeterminate v-if="isLoading"/>
        <v-alert variant="tonal" type="error" v-if="hasError">An unexpected error occurred...</v-alert>
        <div class="text-center pa-4">
          <v-btn variant="text" prepend-icon="mdi-reload" @click="fetchData">Reload data</v-btn>
        </div>
        <div class="text-center pa-4">
          <v-expand-transition>
            <v-btn v-show="!hasError" :disabled="isLoading" @click="isDialogActive = true" prepend-icon="mdi-plus" variant="flat" color="primary">
              Create new Person
            </v-btn>
          </v-expand-transition>

          <v-dialog
            v-model="isDialogActive"
            max-width="600"
          >
            <v-card class="pa-12" title="Create Person">
              <create-person-dialog @saved="onSaved"/>
            </v-card>
          </v-dialog>
        </div>
        <v-expand-transition>
          <v-row no-gutters v-show="!isLoading">
            <v-col cols="6" v-for="person in persons">
              <v-fade-transition>
                <person-view :input-person="person" v-show="!isLoading && persons.length > 0"/>
              </v-fade-transition>
            </v-col>
          </v-row>
        </v-expand-transition>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup lang="ts">
import {ref, type Ref} from "vue";
import type {PersonDto} from "@/types/Person.ts";
import {getAllPersons} from "@/service/person.service.ts";
import PersonView from "@/components/PersonView.vue";
import CreatePersonDialog from "@/components/CreatePersonDialog.vue";

const isDialogActive: Ref<boolean> = ref(false);
const persons: Ref<PersonDto[]> = ref([] as PersonDto[]);

const isLoading: Ref<boolean> = ref(false);
const hasError: Ref<boolean> = ref(false)

fetchData();

async function fetchData() {
  try {
    isLoading.value = true;
    hasError.value = false;
    persons.value = await getAllPersons()
    isLoading.value = false;
  } catch(err) {
    hasError.value = true;
    isLoading.value = false;
  }
}

function onSaved(createdPerson: PersonDto) {
    persons.value.push(createdPerson)
    isDialogActive.value = false;
}
</script>
