import { Component, OnInit } from '@angular/core';
import { PersonDetail, PersonService } from 'src/app/api/adrestore';
import { PersonPreview } from 'src/app/api/adrestore/model/personPreview';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  persons?: PersonPreview[];
  newPerson: PersonDetail;
  detailedPerson?: PersonDetail;

  constructor(private service: PersonService) {
    this.newPerson = {
      firstName: '',
      lastName: '',
      permanentAddress: {

      },
      temporaryAddress: {

      }
    }
  }

  ngOnInit(): void {
    this.persons = [
      {
        id: 1,
        name: "Tester 01"
      },
      {
        id: 2,
        name: "Tester 02"
      },
      {
        id: 3,
        name: "Tester 03"
      }
    ]
  }

  async loadPeople(): Promise<void> {
    let people = await this.service.getAllPersons().toPromise();
    this.persons = people;
  }

  setFirstName(value: string): void {
    console.log("invoked firstname")
    this.newPerson.firstName = value;
    console.log(`firstname <== ${value}`)
  }

  setLastName(value: string): void {
    this.newPerson.lastName = value;
  }

  async saveNewPerson(): Promise<void> {
    console.log(this.newPerson);
    await this.service.createPerson(this.newPerson).toPromise();
    await this.loadPeople();
  }

  async loadPerson(personId: number) {
    this.detailedPerson = await this.service.getPersonById(personId).toPromise();
  }

  async deletePerson(personId: number) {
    await this.service.deletePerson(personId).toPromise();
  }

}
