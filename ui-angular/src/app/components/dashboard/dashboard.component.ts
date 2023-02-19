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

  async ngOnInit(): Promise<void> {
    //await this.loadPeople();
    this.persons = [
      {
        id: 1,
        name: 'John Doe'
      },
      {
        id: 2,
        name: 'John With Very Long Name'
      },
      {
        id: 3,
        name: 'Xi Lao'
      },
      {
        id: 4,
        name: 'Francis Buttfoukis'
      }
    ];
    this.detailedPerson = {
      id: 1,
      firstName: 'John',
      lastName: 'Doe',
      permanentAddress: {
        id: 20,
        country: 'Hungary',
        town: 'Budapest',
        street: 'Hegyalja út',
        streetNo: 69
      },
      temporaryAddress: {
        id: 20,
        country: 'Hungary',
        town: 'Budapest',
        street: 'Hegyalja út',
        streetNo: 69
      }
    }
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
    if (this.detailedPerson && this.detailedPerson.id! === personId) {
      this.detailedPerson = undefined;
    }
    await this.service.deletePerson(personId).toPromise();
  }

}
