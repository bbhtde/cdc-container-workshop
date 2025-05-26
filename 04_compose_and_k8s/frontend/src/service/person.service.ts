import axios from "axios";
import type {CreatePersonDto, PersonDto} from "@/types/Person.ts";

const backend_host = "http://localhost:8080/"

export async function getAllPersons(): Promise<PersonDto[]> {
  return (await axios.get(backend_host + "api/persons")).data
}

export async function getPersonById(id: string): Promise<PersonDto> {
  return (await axios.get(backend_host + "api/persons/" + id)).data
}

export async function createPerson(personToCreate: CreatePersonDto): Promise<PersonDto> {
  return (await axios.post(backend_host + "api/persons/", personToCreate)).data
}
